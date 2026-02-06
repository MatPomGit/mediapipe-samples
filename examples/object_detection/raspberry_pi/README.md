# MediaPipe - Przykład Detekcji Obiektów na Raspberry Pi

Ten przykład używa [MediaPipe](https://github.com/google/mediapipe) z Pythonem na Raspberry Pi do wykonywania detekcji obiektów w czasie rzeczywistym, wykorzystując obraz strumieniowany z Pi Camera. Rysuje ramkę ograniczającą wokół każdego wykrytego obiektu w podglądzie kamery (gdy wynik obiektu przekracza zadany próg).

**Dla początkujących - MediaPipe na Raspberry Pi:**

Raspberry Pi to mały, niedrogi komputer idealny do nauki programowania i projektów IoT (Internet of Things). Ten przykład pokazuje, jak uruchomić zaawansowane uczenie maszynowe na niewielkim urządzeniu!

**Dlaczego Raspberry Pi?**
- 💰 Tani (około 200-300 zł)
- 🔌 Niskie zużycie energii
- 📦 Kompaktowy rozmiar
- 🐍 Świetny do nauki Pythona
- 🤖 Idealny do projektów robotyki i automatyki

**Zastosowania detekcji obiektów na Raspberry Pi:**
- Inteligentny dzwonek do drzwi (wykrywanie osób)
- System bezpieczeństwa domowego
- Automatyczne karmienie zwierząt (wykrywanie pupila)
- Licznik osób w pomieszczeniu
- Sortowanie obiektów w automatyce
- Projekty edukacyjne z robotyki

## Konfiguracja sprzętu

Przed rozpoczęciem musisz [skonfigurować Raspberry Pi](https://projects.raspberrypi.org/en/projects/raspberry-pi-setting-up) z 64-bitowym Raspberry Pi OS (najlepiej zaktualizowanym do Buster).

**Wymagania sprzętowe:**
- Raspberry Pi 4 (zalecane) lub Pi 3B+ 
- Karta microSD (minimum 16GB, zalecane 32GB)
- Zasilacz USB-C (dla Pi 4) lub micro-USB (dla Pi 3)
- Pi Camera lub kamera USB
- Monitor z kablem HDMI
- (Opcjonalnie) Klawiatura i mysz

Musisz również [podłączyć i skonfigurować Pi Camera](https://www.raspberrypi.org/documentation/configuration/camera.md), jeśli używasz Pi Camera. Ten kod działa również z kamerą USB podłączoną do Raspberry Pi.

**Konfiguracja kamery:**
1. Podłącz Pi Camera do portu Camera na Raspberry Pi
2. Uruchom `sudo raspi-config`
3. Przejdź do "Interface Options" → "Camera"
4. Włącz kamerę i zrestartuj Pi

Aby zobaczyć wyniki z kamery, potrzebujesz monitora podłączonego do Raspberry Pi. W porządku, jeśli używasz SSH do dostępu do powłoki Pi (nie potrzebujesz klawiatury podłączonej do Pi) - potrzebujesz tylko monitora podłączonego do Pi, aby zobaczyć strumień z kamery.

## Instalacja MediaPipe

Możesz zainstalować wymagane zależności używając skryptu setup.sh dołączonego do tego projektu.

**Co robi skrypt setup.sh:**
- Instaluje Python i wymagane biblioteki
- Pobiera modele TFLite
- Konfiguruje środowisko

## Pobranie repozytorium przykładów

Najpierw sklonuj to repozytorium Git na swoje Raspberry Pi.

**Jeśli dopiero zaczynasz z Raspberry Pi:**
1. Otwórz terminal na Raspberry Pi
2. Upewnij się, że masz zainstalowany git: `sudo apt-get install git`
3. Sklonuj repozytorium

Uruchom ten skrypt, aby zainstalować wymagane zależności i pobrać modele TFLite:

```bash
cd mediapipe/examples/object_detection/raspberry_pi
sh setup.sh
```

**Co się dzieje podczas instalacji:**
- Pobierane są biblioteki Python (numpy, opencv, itp.)
- Pobierane są modele detekcji obiektów
- Konfigurowane jest środowisko wirtualne Python

## Uruchomienie przykładu

```bash
python3 detect.py \
  --model efficientdet_lite0.tflite
```

**Oczekiwane rezultaty:**

Powinieneś zobaczyć obraz z kamery pojawiający się na monitorze podłączonym do Raspberry Pi. Umieść kilka obiektów przed kamerą, takie jak kubek do kawy lub klawiaturę, a zobaczysz ramki narysowane wokół tych, które model rozpozna, wraz z etykietą i wynikiem dla każdego. W lewym górnym rogu ekranu wyświetla się również liczba klatek na sekundę (FPS). 

**Wydajność:**
Ponieważ pipeline zawiera procesy inne niż tylko wnioskowanie modelu, w tym wizualizację wyników detekcji, możesz
expect a higher FPS if your inference pipeline runs in headless mode without
visualization.

*   You can optionally specify the `model` parameter to set the TensorFlow Lite
    model to be used:
    *   The default value is `efficientdet_lite0.tflite`
    *   TensorFlow Lite object detection models **with metadata**  
        * Models from [MediaPipe Models](https://developers.google.com/mediapipe/solutions/vision/object_detector/index#models)
        * Models trained with [MediaPipe Model Maker](https://developers.google.com/mediapipe/solutions/customization/object_detector) are supported.
*   You can optionally specify the `maxResults` parameter to limit the list of
    detection results:
    *   Supported value: A positive integer.
    *   Default value: `5`
*   You can optionally specify the `scoreThreshold` parameter to adjust the
    score threshold of detection results:
    *   Supported value: A floating-point number.
    *   Default value: `0.25`.
*   Example usage:
    ```
    python3 detect.py \
      --model efficientdet_lite0.tflite \
      --maxResults 5 \
      --scoreThreshold 0.3
    ```
