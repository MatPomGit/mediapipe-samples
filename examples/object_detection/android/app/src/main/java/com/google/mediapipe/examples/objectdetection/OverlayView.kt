/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.mediapipe.examples.objectdetection

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.google.mediapipe.tasks.vision.core.RunningMode
import com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectorResult
import kotlin.math.max
import kotlin.math.min

/**
 * OverlayView - Widok nakładki do rysowania wyników detekcji obiektów
 * 
 * Ta klasa jest odpowiedzialna za wizualizację wyników detekcji obiektów.
 * Rysuje prostokąty (ramki ograniczające) wokół wykrytych obiektów oraz 
 * wyświetla nazwy obiektów i pewność detekcji.
 * 
 * Dla studentów: To jest niestandardowy widok (Custom View) w Androidzie.
 * Dziedziczy po klasie View i nadpisuje metodę draw() aby rysować własną grafikę.
 */
class OverlayView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    // Przechowuje wyniki detekcji obiektów z MediaPipe
    private var results: ObjectDetectorResult? = null
    
    // Paint do rysowania ramek wokół obiektów (prostokąty)
    private var boxPaint = Paint()
    
    // Paint do rysowania tła pod tekstem (czarne tło dla lepszej czytelności)
    private var textBackgroundPaint = Paint()
    
    // Paint do rysowania tekstu z nazwą obiektu i pewnością detekcji
    private var textPaint = Paint()
    
    // Współczynnik skalowania - używany do dopasowania rozmiaru ramek do ekranu
    private var scaleFactor: Float = 1f
    
    // Prostokąt używany do obliczania rozmiaru tekstu
    private var bounds = Rect()
    
    // Szerokość i wysokość obrazu wejściowego
    private var outputWidth = 0
    private var outputHeight = 0
    
    // Rotacja obrazu (0, 90, 180 lub 270 stopni)
    private var outputRotate = 0
    
    // Tryb działania: obraz statyczny, wideo lub strumień na żywo z kamery
    private var runningMode: RunningMode = RunningMode.IMAGE

    /**
     * Inicjalizacja - wywoływana przy tworzeniu widoku
     * Ustawia domyślne style rysowania
     */
    init {
        initPaints()
    }

    /**
     * Czyści widok - usuwa wszystkie wyniki detekcji i resetuje ustawienia rysowania
     * Wywołaj tę funkcję gdy chcesz zacząć od nowa
     */
    fun clear() {
        results = null
        textPaint.reset()
        textBackgroundPaint.reset()
        boxPaint.reset()
        invalidate() // Mówi systemowi Android, że widok musi zostać przerysowany
        initPaints()
    }

    /**
     * Ustawia tryb działania aplikacji (obraz, wideo lub live stream)
     * To wpływa na sposób skalowania ramek ograniczających
     */
    fun setRunningMode(runningMode: RunningMode) {
        this.runningMode = runningMode
    }

    /**
     * Inicjalizuje obiekty Paint (pędzle) używane do rysowania
     * 
     * Paint to obiekt w Androidzie, który definiuje jak rysować:
     * - kolor
     * - grubość linii
     * - styl (wypełnienie czy obrys)
     * - rozmiar tekstu
     */
    private fun initPaints() {
        // Ustawienie pędzla dla tła tekstu (czarne wypełnienie)
        textBackgroundPaint.color = Color.BLACK
        textBackgroundPaint.style = Paint.Style.FILL // Wypełnienie (nie tylko obrys)
        textBackgroundPaint.textSize = 50f

        // Ustawienie pędzla dla tekstu (biały tekst na czarnym tle)
        textPaint.color = Color.WHITE
        textPaint.style = Paint.Style.FILL
        textPaint.textSize = 50f

        // Ustawienie pędzla dla ramki wokół obiektu
        boxPaint.color = ContextCompat.getColor(context!!, R.color.mp_primary)
        boxPaint.strokeWidth = 8F // Grubość linii ramki
        boxPaint.style = Paint.Style.STROKE // Tylko obrys (bez wypełnienia)
    }

    /**
     * Główna metoda rysująca - wywoływana automatycznie przez system Android
     * 
     * Ta metoda jest sercem wizualizacji. Jest wywoływana za każdym razem,
     * gdy widok musi zostać przerysowany (np. po otrzymaniu nowych wyników detekcji).
     * 
     * Proces rysowania:
     * 1. Pobiera wykryte obiekty z wyników
     * 2. Dla każdego obiektu oblicza pozycję ramki ograniczającej
     * 3. Stosuje transformacje (rotacja, skalowanie)
     * 4. Rysuje prostokąt wokół obiektu
     * 5. Rysuje etykietę z nazwą i pewnością detekcji
     */
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        
        // Mapuje każdą detekcję na prostokąt z zastosowanymi transformacjami
        results?.detections()?.map {
            // Tworzymy prostokąt z współrzędnych ramki ograniczającej
            val boxRect = RectF(
                it.boundingBox().left,
                it.boundingBox().top,
                it.boundingBox().right,
                it.boundingBox().bottom
            )
            
            // Matrix to obiekt używany do transformacji geometrycznych (obroty, przesunięcia)
            val matrix = Matrix()
            
            // Przesuń środek układu współrzędnych do centrum obrazu
            // (potrzebne do prawidłowego obrotu)
            matrix.postTranslate(-outputWidth / 2f, -outputHeight / 2f)

            // Obróć ramkę o odpowiedni kąt
            // Rotacja jest potrzebna, bo kamera może być obrócona
            matrix.postRotate(outputRotate.toFloat())

            // Jeśli obrót to 90 lub 270 stopni, wymiary obrazu są zamienione
            // (szerokość staje się wysokością i odwrotnie)
            // Dlatego przesunięcie musi być skorygowane
            if (outputRotate == 90 || outputRotate == 270) {
                matrix.postTranslate(outputHeight / 2f, outputWidth / 2f)
            } else {
                matrix.postTranslate(outputWidth / 2f, outputHeight / 2f)
            }
            
            // Zastosuj wszystkie transformacje do prostokąta
            matrix.mapRect(boxRect)
            boxRect
        }?.forEachIndexed { index, floats ->
            // Dla każdego przetworzonego prostokąta:

            // Przeskaluj współrzędne do rozmiaru widoku
            val top = floats.top * scaleFactor
            val bottom = floats.bottom * scaleFactor
            val left = floats.left * scaleFactor
            val right = floats.right * scaleFactor

            // Narysuj ramkę ograniczającą wokół wykrytego obiektu
            val drawableRect = RectF(left, top, right, bottom)
            canvas.drawRect(drawableRect, boxPaint)

            // Pobierz informacje o kategorii wykrytego obiektu
            // categories()[0] to kategoria z najwyższą pewnością
            val category = results?.detections()!![index].categories()[0]
            
            // Utwórz tekst do wyświetlenia: "nazwa_obiektu pewność"
            // Przykład: "osoba 0.95" (95% pewności)
            val drawableText =
                category.categoryName() + " " + String.format(
                    "%.2f", // Format: dwie cyfry po przecinku
                    category.score()
                )

            // Oblicz rozmiar tekstu (potrzebne do narysowania tła)
            textBackgroundPaint.getTextBounds(
                drawableText,
                0,
                drawableText.length,
                bounds
            )
            val textWidth = bounds.width()
            val textHeight = bounds.height()
            
            // Narysuj czarny prostokąt jako tło dla tekstu
            // (aby tekst był czytelny niezależnie od koloru obiektu)
            canvas.drawRect(
                left,
                top,
                left + textWidth + BOUNDING_RECT_TEXT_PADDING,
                top + textHeight + BOUNDING_RECT_TEXT_PADDING,
                textBackgroundPaint
            )

            // Narysuj biały tekst na czarnym tle
            canvas.drawText(
                drawableText,
                left,
                top + bounds.height(),
                textPaint
            )
        }
    }

    /**
     * Ustawia nowe wyniki detekcji i parametry obrazu
     * 
     * Ta metoda jest wywoływana po każdym procesie detekcji obiektów.
     * Otrzymuje:
     * @param detectionResults - wyniki detekcji z MediaPipe (wykryte obiekty)
     * @param outputHeight - wysokość obrazu wejściowego
     * @param outputWidth - szerokość obrazu wejściowego  
     * @param imageRotation - kąt obrotu obrazu (0, 90, 180, 270)
     * 
     * Funkcja oblicza odpowiedni współczynnik skalowania i wymusza 
     * przerysowanie widoku (wywołanie metody draw).
     */
    fun setResults(
        detectionResults: ObjectDetectorResult,
        outputHeight: Int,
        outputWidth: Int,
        imageRotation: Int
    ) {
        results = detectionResults
        this.outputWidth = outputWidth
        this.outputHeight = outputHeight
        this.outputRotate = imageRotation

        // Oblicza nowe wymiary obrazu po obróceniu
        // 
        // Jeśli obrót to 0 lub 180 stopni: wymiary pozostają takie same
        // Jeśli obrót to 90 lub 270 stopni: szerokość i wysokość są zamienione
        // 
        // Przykład: obraz 1920x1080 obrócony o 90° staje się 1080x1920
        val rotatedWidthHeight = when (imageRotation) {
            0, 180 -> Pair(outputWidth, outputHeight)
            90, 270 -> Pair(outputHeight, outputWidth)
            else -> return // Nieprawidłowy kąt - wyjdź z funkcji
        }

        // Oblicz współczynnik skalowania
        //
        // Różne tryby wymagają różnego skalowania:
        // - IMAGE i VIDEO: tryb FIT_START - obraz musi zmieścić się w widoku
        //   używamy min() aby cały obraz był widoczny
        // - LIVE_STREAM: tryb FILL_START - obraz wypełnia cały widok
        //   używamy max() aby nie było czarnych pasów
        scaleFactor = when (runningMode) {
            RunningMode.IMAGE,
            RunningMode.VIDEO -> {
                min(
                    width * 1f / rotatedWidthHeight.first,
                    height * 1f / rotatedWidthHeight.second
                )
            }

            RunningMode.LIVE_STREAM -> {
                max(
                    width * 1f / rotatedWidthHeight.first,
                    height * 1f / rotatedWidthHeight.second
                )
            }
        }

        // Wymusza przerysowanie widoku z nowymi wynikami
        invalidate()
    }

    companion object {
        // Padding (odstęp) między tekstem a krawędziami prostokąta tła
        // Sprawia, że tekst nie przylega bezpośrednio do krawędzi
        private const val BOUNDING_RECT_TEXT_PADDING = 8
    }
}
