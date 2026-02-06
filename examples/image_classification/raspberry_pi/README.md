# MediaPipe - Przykład Klasyfikacji Obrazów na Raspberry Pi

Ten przykład używa [MediaPipe](https://github.com/google/mediapipe) z Pythonem na Raspberry Pi do wykonywania klasyfikacji obrazów w czasie rzeczywistym, wykorzystując obrazy strumieniowane z kamery.

**Dla początkujących - klasyfikacja obrazów na Raspberry Pi:**

Ten projekt pokazuje, jak zamienić Raspberry Pi w inteligentną kamerę, która rozpoznaje obiekty! To świetny projekt do nauki zarówno Pythona, jak i sztucznej inteligencji.

**Zastosowania na Raspberry Pi:**
- **Edukacja przyrodnicza**: Rozpoznawanie gatunków roślin i zwierząt
- **Automatyka domowa**: Inteligentny system rozpoznający obiekty
- **Sortowanie**: Automatyczna kategoryzacja przedmiotów
- **Monitoring**: Rozpoznawanie produktów na produkcji
- **Projekty hobbystyczne**: Inteligentny karmnik dla ptaków (rozpoznaje gatunki)

## Konfiguracja sprzętu

Przed rozpoczęciem musisz [skonfigurować Raspberry Pi](https://projects.raspberrypi.org/en/projects/raspberry-pi-setting-up) z 64-bitowym Raspberry Pi OS (najlepiej zaktualizowanym do Buster).

**Lista zakupów dla projektu:**
- Raspberry Pi 4 (2GB RAM lub więcej - zalecane)
- Karta microSD (minimum 16GB)
- Zasilacz oficjalny dla Raspberry Pi
- Pi Camera Module v2 LUB kamera USB
- Monitor z kablem HDMI (do oglądania wyników)
- (Opcjonalnie) Obudowa dla Raspberry Pi

Musisz również [podłączyć i skonfigurować Pi Camera](https://www.raspberrypi.org/documentation/configuration/camera.md), jeśli używasz Pi Camera. Ten kod działa również z kamerą USB podłączoną do Raspberry Pi.

**Konfiguracja kamery (Pi Camera):**
1. Wyłącz Raspberry Pi
2. Podłącz wstążkę kabla kamery do portu Camera (obok HDMI)
3. Włącz Raspberry Pi
4. W terminalu wpisz: `sudo raspi-config`
5. Wybierz "Interface Options" → "Legacy Camera" → "Yes"
6. Zrestartuj Pi: `sudo reboot`

Aby zobaczyć wyniki z kamery, potrzebujesz monitora podłączonego do Raspberry Pi. W porządku, jeśli używasz SSH do dostępu do powłoki Pi (nie potrzebujesz klawiatury podłączonej do Pi) - potrzebujesz tylko monitora podłączonego do Pi, aby zobaczyć strumień z kamery.

## Instalacja MediaPipe

Możesz zainstalować wymagane zależności używając skryptu setup.sh dołączonego do tego projektu.

## Pobranie repozytorium przykładów

Najpierw sklonuj to repozytorium Git na swoje Raspberry Pi.

**Jeśli to Twój pierwszy projekt na Raspberry Pi:**
1. Otwórz Terminal (ikona na górnym pasku)
2. Upewnij się, że masz zainstalowany git:
```bash
sudo apt-get update
sudo apt-get install git
```
3. Sklonuj repozytorium

Uruchom ten skrypt, aby zainstalować wymagane zależności i pobrać modele TFLite:

```bash
cd mediapipe/examples/image_classification/raspberry_pi
sh setup.sh
```

**Czas instalacji**: Pierwsza instalacja może potrwać 5-15 minut, w zależności od szybkości Internetu. To normalne - pobieranych jest wiele bibliotek!

## Uruchomienie przykładu

```bash
python3 classify.py
```

**Co zobaczysz:**
- Obraz z kamery na monitorze
- Top 5 najbardziej prawdopodobnych kategorii dla tego, co widzi kamera
- Pewność klasyfikacji dla każdej kategorii (0-100%)
- Liczba klatek na sekundę (FPS) w lewym górnym rogu

**Eksperymentowanie:**
- Pokaż kamerze różne obiekty (kubek, telefon, książkę)
- Zobacz, jak zmienia się klasyfikacja w czasie rzeczywistym
- Sprawdź, jak dobrze model radzi sobie z nietypowymi obiektami
*   You can optionally specify the `model` parameter to set the TensorFlow Lite
    model to be used:
    *   The default value is `classifier.tflite`
    *   TensorFlow Lite image classification models **with metadata**  
        * Models from [TensorFlow Hub](https://tfhub.dev/tensorflow/collections/lite/task-library/image-classifier/1)
        * Models from [MediaPipe Models](https://developers.google.com/mediapipe/solutions/vision/image_classifier/index#models)
        * Models trained with [MediaPipe Model Maker](https://developers.google.com/mediapipe/solutions/customization/image_classifier) are supported.
*   You can optionally specify the `maxResults` parameter to limit the list of
    classification results:
    *   Supported value: A positive integer.
    *   Default value: `3`
*   You can optionally specify the `scoreThreshold` parameter to adjust the
    score threshold of classification results:
    *   Supported value: A floating-point number.
    *   Default value: `0.0`.
*   Example usage:
    ```
    python3 classify.py \
      --model efficientnet_lite0.tflite \
      --maxResults 5 \
      --scoreThreshold 0.5
    ```
