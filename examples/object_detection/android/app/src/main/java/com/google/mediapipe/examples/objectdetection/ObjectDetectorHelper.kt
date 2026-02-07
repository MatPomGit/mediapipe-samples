/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.mediapipe.examples.objectdetection

import android.content.Context
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.SystemClock
import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.camera.core.ImageProxy
import com.google.mediapipe.framework.image.BitmapImageBuilder
import com.google.mediapipe.framework.image.MPImage
import com.google.mediapipe.tasks.core.BaseOptions
import com.google.mediapipe.tasks.core.Delegate
import com.google.mediapipe.tasks.vision.core.ImageProcessingOptions
import com.google.mediapipe.tasks.vision.core.RunningMode
import com.google.mediapipe.tasks.vision.objectdetector.ObjectDetector
import com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectorResult

/**
 * ObjectDetectorHelper - Klasa pomocnicza do wykrywania obiektów
 * 
 * Ta klasa jest sercem aplikacji detekcji obiektów. Zarządza modelem MediaPipe
 * i wykonuje detekcję obiektów na obrazach, wideo i strumieniu z kamery.
 * 
 * Dla studentów: To jest wzorzec projektowy "Helper" (Pomocnik). Oddziela logikę
 * detekcji od logiki interfejsu użytkownika, co ułatwia testowanie i utrzymanie kodu.
 * 
 * @param threshold - Próg pewności (0.0 - 1.0). Tylko obiekty z wyższą pewnością będą wykrywane
 * @param maxResults - Maksymalna liczba wyników do zwrócenia (np. 5 = max 5 obiektów naraz)
 * @param currentDelegate - Sprzęt do użycia: CPU (wolniejszy, uniwersalny) lub GPU (szybszy)
 * @param currentModel - Który model użyć: EfficientDet-Lite0 (szybszy) lub Lite2 (dokładniejszy)
 * @param runningMode - Tryb działania: IMAGE (pojedynczy obraz), VIDEO (film) lub LIVE_STREAM (kamera na żywo)
 * @param context - Kontekst Android (dostęp do zasobów aplikacji)
 * @param objectDetectorListener - Słuchacz wyników (tylko dla trybu LIVE_STREAM)
 */
class ObjectDetectorHelper(
    var threshold: Float = THRESHOLD_DEFAULT,
    var maxResults: Int = MAX_RESULTS_DEFAULT,
    var currentDelegate: Int = DELEGATE_CPU,
    var currentModel: Int = MODEL_EFFICIENTDETV0,
    var runningMode: RunningMode = RunningMode.IMAGE,
    val context: Context,
    // Słuchacz jest używany tylko w trybie RunningMode.LIVE_STREAM
    // Umożliwia asynchroniczne otrzymywanie wyników detekcji
    var objectDetectorListener: DetectorListener? = null
) {

    // Instancja detektora obiektów MediaPipe
    // To musi być var (nie val), ponieważ może być odtwarzany przy zmianie ustawień
    // Dla niezmiennych detektorów lepiej użyć lazy val
    private var objectDetector: ObjectDetector? = null
    
    // Kąt obrotu obrazu (0, 90, 180 lub 270 stopni)
    // Potrzebny, bo kamera może być obrócona względem urządzenia
    private var imageRotation = 0
    
    // Opcje przetwarzania obrazu (zawiera informacje o rotacji)
    private lateinit var imageProcessingOptions: ImageProcessingOptions

    /**
     * Blok inicjalizacyjny - wykonywany przy tworzeniu obiektu
     * Automatycznie konfiguruje detektor obiektów z podanymi parametrami
     */
    init {
        setupObjectDetector()
    }

    /**
     * Czyści i zamyka detektor obiektów
     * 
     * Ważne: Zawsze wywołuj tę funkcję, gdy skończysz używać detektora!
     * Zwalnia zasoby (pamięć, GPU) używane przez model.
     */
    fun clearObjectDetector() {
        objectDetector?.close()
        objectDetector = null
    }

    /**
     * Inicjalizuje detektor obiektów używając bieżących ustawień
     * 
     * WAŻNE dla zaawansowanych: Ta funkcja musi być wywołana na tym samym wątku,
     * który będzie używał detektora:
     * - CPU: Może być utworzony na głównym wątku i używany w tle
     * - GPU: Musi być używany na tym samym wątku, na którym został utworzony
     * 
     * Proces konfiguracji:
     * 1. Wybiera sprzęt (CPU lub GPU)
     * 2. Ładuje odpowiedni plik modelu
     * 3. Ustawia opcje detekcji (próg, maksymalna liczba wyników)
     * 4. Tworzy instancję detektora
     */
    fun setupObjectDetector() {
        // Krok 1: Utwórz builder dla opcji bazowych
        // BaseOptions to konfiguracja podstawowa dla wszystkich zadań MediaPipe
        val baseOptionsBuilder = BaseOptions.builder()

        // Krok 2: Wybierz sprzęt do uruchomienia modelu
        // Delegate to "delegat" - decyduje, gdzie uruchomić model
        when (currentDelegate) {
            DELEGATE_CPU -> {
                // CPU: Wolniejszy, ale działa zawsze i wszędzie
                // Najlepszy do testowania i starszych urządzeń
                baseOptionsBuilder.setDelegate(Delegate.CPU)
            }

            DELEGATE_GPU -> {
                // GPU: Szybszy (nawet 10x!), ale wymaga wsparcia GPU
                // Sprawdź czy urządzenie wspiera GPU przed użyciem
                baseOptionsBuilder.setDelegate(Delegate.GPU)
            }
        }

        // Krok 3: Wybierz plik modelu
        // Każdy model ma inne właściwości (szybkość vs dokładność)
        val modelName = when (currentModel) {
            MODEL_EFFICIENTDETV0 -> "efficientdet-lite0.tflite"  // Szybszy, mniej dokładny
            MODEL_EFFICIENTDETV2 -> "efficientdet-lite2.tflite"  // Wolniejszy, bardziej dokładny
            else -> "efficientdet-lite0.tflite"  // Domyślny model
        }

        // Ustaw ścieżkę do modelu w katalogu assets aplikacji
        baseOptionsBuilder.setModelAssetPath(modelName)

        // Krok 4: Sprawdź poprawność konfiguracji dla trybu LIVE_STREAM
        // W trybie strumieniowym MUSISZ mieć słuchacza do odbierania wyników
        when (runningMode) {
            RunningMode.LIVE_STREAM -> {
                if (objectDetectorListener == null) {
                    throw IllegalStateException(
                        "objectDetectorListener must be set when runningMode is LIVE_STREAM."
                    )
                }
            }

            RunningMode.IMAGE, RunningMode.VIDEO -> {
                // Dla obrazów i wideo nie jest potrzebny słuchacz
                // Wyniki są zwracane synchronicznie
            }
        }

        try {
            val optionsBuilder = ObjectDetector.ObjectDetectorOptions.builder()
                .setBaseOptions(baseOptionsBuilder.build())
                .setScoreThreshold(threshold).setRunningMode(runningMode)
                .setMaxResults(maxResults)

            imageProcessingOptions = ImageProcessingOptions.builder()
                .setRotationDegrees(imageRotation).build()

            when (runningMode) {
                RunningMode.IMAGE, RunningMode.VIDEO -> optionsBuilder.setRunningMode(
                    runningMode
                )

                RunningMode.LIVE_STREAM -> optionsBuilder.setRunningMode(
                    runningMode
                ).setResultListener(this::returnLivestreamResult)
                    .setErrorListener(this::returnLivestreamError)
            }

            val options = optionsBuilder.build()
            objectDetector = ObjectDetector.createFromOptions(context, options)
        } catch (e: IllegalStateException) {
            objectDetectorListener?.onError(
                "Object detector failed to initialize. See error logs for details"
            )
            Log.e(TAG, "TFLite failed to load model with error: " + e.message)
        } catch (e: RuntimeException) {
            objectDetectorListener?.onError(
                "Object detector failed to initialize. See error logs for " + "details",
                GPU_ERROR
            )
            Log.e(
                TAG,
                "Object detector failed to load model with error: " + e.message
            )
        }
    }

    // Return running status of recognizer helper
    fun isClosed(): Boolean {
        return objectDetector == null
    }

    // Accepts the URI for a video file loaded from the user's gallery and attempts to run
    // object detection inference on the video. This process will evaluate every frame in
    // the video and attach the results to a bundle that will be returned.
    fun detectVideoFile(
        videoUri: Uri, inferenceIntervalMs: Long
    ): ResultBundle? {

        if (runningMode != RunningMode.VIDEO) {
            throw IllegalArgumentException(
                "Attempting to call detectVideoFile" + " while not using RunningMode.VIDEO"
            )
        }

        if (objectDetector == null) return null

        // Inference time is the difference between the system time at the start and finish of the
        // process
        val startTime = SystemClock.uptimeMillis()

        var didErrorOccurred = false

        // Load frames from the video and run the object detection model.
        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(context, videoUri)
        val videoLengthMs =
            retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
                ?.toLong()

        // Note: We need to read width/height from frame instead of getting the width/height
        // of the video directly because MediaRetriever returns frames that are smaller than the
        // actual dimension of the video file.
        val firstFrame = retriever.getFrameAtTime(0)
        val width = firstFrame?.width
        val height = firstFrame?.height

        // If the video is invalid, returns a null detection result
        if ((videoLengthMs == null) || (width == null) || (height == null)) return null

        // Next, we'll get one frame every frameInterval ms, then run detection on these frames.
        val resultList = mutableListOf<ObjectDetectorResult>()
        val numberOfFrameToRead = videoLengthMs.div(inferenceIntervalMs)

        for (i in 0..numberOfFrameToRead) {
            val timestampMs = i * inferenceIntervalMs // ms

            retriever.getFrameAtTime(
                timestampMs * 1000, // convert from ms to micro-s
                MediaMetadataRetriever.OPTION_CLOSEST
            )?.let { frame ->
                // Convert the video frame to ARGB_8888 which is required by the MediaPipe
                val argb8888Frame =
                    if (frame.config == Bitmap.Config.ARGB_8888) frame
                    else frame.copy(Bitmap.Config.ARGB_8888, false)

                // Convert the input Bitmap object to an MPImage object to run inference
                val mpImage = BitmapImageBuilder(argb8888Frame).build()

                // Run object detection using MediaPipe Object Detector API
                objectDetector?.detectForVideo(mpImage, timestampMs)
                    ?.let { detectionResult ->
                        resultList.add(detectionResult)
                    } ?: {
                    didErrorOccurred = true
                    objectDetectorListener?.onError(
                        "ResultBundle could not be returned" + " in detectVideoFile"
                    )
                }
            } ?: run {
                didErrorOccurred = true
                objectDetectorListener?.onError(
                    "Frame at specified time could not be" + " retrieved when detecting in video."
                )
            }
        }

        retriever.release()

        val inferenceTimePerFrameMs =
            (SystemClock.uptimeMillis() - startTime).div(numberOfFrameToRead)

        return if (didErrorOccurred) {
            null
        } else {
            ResultBundle(resultList, inferenceTimePerFrameMs, height, width)
        }
    }

    // Runs object detection on live streaming cameras frame-by-frame and returns the results
    // asynchronously to the caller.
    fun detectLivestreamFrame(imageProxy: ImageProxy) {

        if (runningMode != RunningMode.LIVE_STREAM) {
            throw IllegalArgumentException(
                "Attempting to call detectLivestreamFrame" + " while not using RunningMode.LIVE_STREAM"
            )
        }

        val frameTime = SystemClock.uptimeMillis()

        // Copy out RGB bits from the frame to a bitmap buffer
        val bitmapBuffer = Bitmap.createBitmap(
            imageProxy.width, imageProxy.height, Bitmap.Config.ARGB_8888
        )
        imageProxy.use { bitmapBuffer.copyPixelsFromBuffer(imageProxy.planes[0].buffer) }
        imageProxy.close()

        // If the input image rotation is change, stop all detector
        if (imageProxy.imageInfo.rotationDegrees != imageRotation) {
            imageRotation = imageProxy.imageInfo.rotationDegrees
            clearObjectDetector()
            setupObjectDetector()
            return
        }

        // Convert the input Bitmap object to an MPImage object to run inference
        val mpImage = BitmapImageBuilder(bitmapBuffer).build()

        detectAsync(mpImage, frameTime)
    }

    // Run object detection using MediaPipe Object Detector API
    @VisibleForTesting
    fun detectAsync(mpImage: MPImage, frameTime: Long) {
        // As we're using running mode LIVE_STREAM, the detection result will be returned in
        // returnLivestreamResult function
        objectDetector?.detectAsync(mpImage, imageProcessingOptions, frameTime)
    }

    // Return the detection result to this ObjectDetectorHelper's caller
    private fun returnLivestreamResult(
        result: ObjectDetectorResult, input: MPImage
    ) {
        val finishTimeMs = SystemClock.uptimeMillis()
        val inferenceTime = finishTimeMs - result.timestampMs()

        objectDetectorListener?.onResults(
            ResultBundle(
                listOf(result),
                inferenceTime,
                input.height,
                input.width,
                imageRotation
            )
        )
    }

    // Return errors thrown during detection to this ObjectDetectorHelper's caller
    private fun returnLivestreamError(error: RuntimeException) {
        objectDetectorListener?.onError(
            error.message ?: "An unknown error has occurred"
        )
    }

    // Accepted a Bitmap and runs object detection inference on it to return results back
    // to the caller
    fun detectImage(image: Bitmap): ResultBundle? {

        if (runningMode != RunningMode.IMAGE) {
            throw IllegalArgumentException(
                "Attempting to call detectImage" + " while not using RunningMode.IMAGE"
            )
        }

        if (objectDetector == null) return null

        // Inference time is the difference between the system time at the start and finish of the
        // process
        val startTime = SystemClock.uptimeMillis()

        // Convert the input Bitmap object to an MPImage object to run inference
        val mpImage = BitmapImageBuilder(image).build()

        // Run object detection using MediaPipe Object Detector API
        objectDetector?.detect(mpImage)?.also { detectionResult ->
            val inferenceTimeMs = SystemClock.uptimeMillis() - startTime
            return ResultBundle(
                listOf(detectionResult),
                inferenceTimeMs,
                image.height,
                image.width
            )
        }

        // If objectDetector?.detect() returns null, this is likely an error. Returning null
        // to indicate this.
        return null
    }

    // Wraps results from inference, the time it takes for inference to be performed, and
    // the input image and height for properly scaling UI to return back to callers
    data class ResultBundle(
        val results: List<ObjectDetectorResult>,
        val inferenceTime: Long,
        val inputImageHeight: Int,
        val inputImageWidth: Int,
        val inputImageRotation: Int = 0
    )

    companion object {
        const val DELEGATE_CPU = 0
        const val DELEGATE_GPU = 1
        const val MODEL_EFFICIENTDETV0 = 0
        const val MODEL_EFFICIENTDETV2 = 1
        const val MAX_RESULTS_DEFAULT = 3
        const val THRESHOLD_DEFAULT = 0.5F
        const val OTHER_ERROR = 0
        const val GPU_ERROR = 1

        const val TAG = "ObjectDetectorHelper"
    }

    // Used to pass results or errors back to the calling class
    interface DetectorListener {
        fun onError(error: String, errorCode: Int = OTHER_ERROR)
        fun onResults(resultBundle: ResultBundle)
    }
}
