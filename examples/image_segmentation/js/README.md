# MediaPipe - Zadanie Segmentacji Obrazu dla przeglądarki

## Przegląd

Ten przykład webowy segmentuje obiekty na obrazach i w klatkach wideo. Obiekty są segmentowane na jednym z dostarczonych obrazów lub z klatek wideo z kamery internetowej Twojego urządzenia.

**Model DeepLabV3:**

Wykorzystuje [DeepLabV3](https://arxiv.org/abs/1706.05587), semantyczną segmentację obrazu, gdzie celem jest przypisanie etykiet semantycznych (np. osoba, pies, kot) do każdego piksela w obrazie wejściowym.

**Co to jest semantyczna segmentacja?**

Segmentacja semantyczna dzieli obraz na regiony i przypisuje każdemu pikselowi kategorię. W przeciwieństwie do detekcji obiektów (prostokąty), segmentacja daje dokładny kształt każdego obiektu.

**Różnice między typami segmentacji:**
- **Semantyczna** (to demo): Każdy piksel ma kategorię (osoba, tło, zwierzę)
- **Instancyjna**: Rozróżnia poszczególne obiekty tej samej klasy (osoba #1, osoba #2)
- **Interaktywna**: Użytkownik wskazuje, co segmentować

**Kategorie rozpoznawane przez DeepLabV3:**
- Ludzie
- Zwierzęta (psy, koty, konie, owce, krowy)
- Pojazdy (samochody, motocykle, autobusy, pociągi, samoloty)
- Obiekty (butelki, krzesła, stoły, rośliny)
- I wiele innych!

**Zastosowania semantycznej segmentacji:**

- **Edycja zdjęć**:
  - Automatyczne rozmycie tła (efekt bokeh)
  - Wymiana tła na inne
  - Usuwanie tła (zielony ekran bez zielonego ekranu!)

- **Rozszerzona rzeczywistość (AR)**:
  - Efekty tylko na określonych obiektach
  - Wirtualne tło w wideokonferencjach
  - Interakcja obiektów 3D z rzeczywistym światem

- **Autonomiczne pojazdy**:
  - Rozpoznawanie drogi, chodnika, przeszkód
  - Wykrywanie pieszych i innych pojazdów
  - Planowanie trasy

- **Analiza medyczna**:
  - Segmentacja narządów na obrazach medycznych
  - Wykrywanie zmian patologicznych

- **Monitoring i bezpieczeństwo**:
  - Zliczanie osób w tłumie
  - Wykrywanie intruzów
  - Analiza ruchu

**Technologia w przeglądarce:**
- Działa w czasie rzeczywistym (30 FPS)
- Pełna prywatność - bez wysyłania danych
- Nie wymaga instalacji

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy
* Kamera internetowa (opcjonalnie, do segmentacji na żywo)

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen.

**Jak używać:**
1. Otwórz demo klikając link
2. Wybierz obraz LUB włącz kamerę
3. Zobacz, jak każdy piksel jest kolorowany według kategorii!
4. Eksperymentuj:
   - Spróbuj obrazów z wieloma obiektami
   - Zobacz, jak model radzi sobie z różnymi scenami
   - Zmień kolory dla różnych kategorii

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/xxJNjbN)

**Dla studentów - pogłębianie wiedzy:**
- Przejrzyj kod i zobacz, jak działa segmentacja
- Dodaj wizualizację różnych trybów (maska, overlay)
- Policz procent obrazu zajęty przez daną kategorię
- Stwórz aplikację do automatycznego usuwania tła
- Zbuduj prosty editor zdjęć z segmentacją
