# Segmentacja tła za pomocą MediaPipe Image Segmentation Task

## Wprowadzenie

MediaPipe Segmentation Task dostarcza potężne i łatwe w użyciu API do segmentacji obrazów na filmach i zdjęciach przy użyciu JavaScript. Dzięki backendowi WebAssembly, funkcje `segmentForVideo` (dla filmów) i `segment` (dla obrazów) mogą szybko (niemal w czasie rzeczywistym) klasyfikować każdy piksel obrazu do wielu klas, takich jak ludzie, psy, koty, krowy itp.

**Dla początkujących - co to jest segmentacja obrazu?**

Segmentacja obrazu to proces dzielenia obrazu na części (segmenty) na podstawie tego, co każdy piksel reprezentuje. W przeciwieństwie do:
- **Klasyfikacji**: "Co to jest?" - jedna odpowiedź dla całego obrazu
- **Detekcji**: "Gdzie to jest?" - prostokąty wokół obiektów
- **Segmentacja**: "Który piksel należy do którego obiektu?" - precyzyjna maska dla każdego piksela

**Jak to działa w tym demo:**

W tym przykładzie API zostało użyte do oddzielenia tła od pierwszego planu (osoby), tworząc efekt podobny do tego stosowanego w narzędziach do komunikacji wideo, takich jak Google Meet i Zoom.

**Zastosowania:**
- Rozmycie tła w wideokonferencjach
- Wymiana tła na wirtualne (efekt "green screen" bez fizycznego green screena!)
- Usuwanie tła ze zdjęć
- Efekty artystyczne (różne style dla tła i pierwszego planu)
- Edukacja - nauka o przetwarzaniu obrazów

**Technologie:**
- MediaPipe Segmentation API
- WebAssembly (szybkie wykonywanie w przeglądarce)
- JavaScript (HTML5 API dla kamery)

# Jak uruchomić aplikację webową?

Aby uruchomić to demo, otwórz plik `index.html` w przeglądarce. Ponieważ MediaPipe Segmentation API działa po stronie frontendu, nie jest wymagany żaden backend (serwer).

**Krok po kroku:**
1. Pobierz lub sklonuj repozytorium
2. Przejdź do folderu `tutorials/background_segmenter`
3. Otwórz plik `index.html` w przeglądarce (Chrome, Firefox, Safari)
4. Zezwól na dostęp do kamery
5. Zobacz segmentację tła w czasie rzeczywistym!

**Wymagania:**
- Nowoczesna przeglądarka z obsługą WebAssembly
- Kamera internetowa (do trybu wideo na żywo)
- Połączenie internetowe (przy pierwszym uruchomieniu, do pobrania modelu)

# Układ projektu

Cały kod tego demo znajduje się w folderze `code`.

**Struktura plików:**

- **`index.html`** - Punkt wejścia aplikacji, zawiera wszystkie wizualne elementy strony internetowej (elementy DOM). Tu definiujemy interfejs użytkownika.

- **`index.js`** - W tym pliku znajduje się cały kod wykorzystujący MediaPipe Image Segmentation API do wykonywania segmentacji. To serce aplikacji - tutaj dzieje się magia!

- **`camera.js`** - Ta klasa służy do interakcji i manipulacji kamerą internetową przy użyciu HTML5 API. Obsługuje dostęp do kamery, przechwytywanie klatek, itp.

- **`utils.js`** - Funkcje pomocnicze, takie jak `downloadImage` (pobieranie obrazu) i `scaleImageData` (skalowanie danych obrazu), zostały zaimplementowane tutaj.

**Dla studentów - struktura kodu:**

Kod jest podzielony na moduły (pliki), gdzie każdy ma określoną odpowiedzialność:
- **Prezentacja** (index.html): Jak to wygląda
- **Logika** (index.js): Jak to działa
- **Kamera** (camera.js): Skąd bierze dane
- **Narzędzia** (utils.js): Funkcje pomocnicze

To dobra praktyka programistyczna zwana "separation of concerns" (rozdzielenie obaw).

# Interfejs webowy

![picture](assets/ui.png)

**Elementy interfejsu:**
- Podgląd kamery na żywo
- Kontrolki do włączania/wyłączania efektu
- Opcje wyboru typu segmentacji
- Możliwość załadowania własnego obrazu
