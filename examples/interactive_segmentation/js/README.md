# MediaPipe - Zadanie Interaktywnej Segmentacji dla przeglądarki

## Przegląd

Ten przykład webowy segmentuje obiekty na obrazach. Kliknij jeden z dostarczonych obrazów lub użyj własnych obrazów, aby zsegmentować obiekt w miejscu, które klikniesz.

**Model MagicTouch:**

Wykorzystuje MagicTouch - model głębokiego uczenia, który może segmentować obiekty w wybranym regionie zainteresowania z obrazu wejściowego.

**Dla początkujących - interaktywna segmentacja w przeglądarce:**

To jak magiczna różdżka do wycinania obiektów! Klikasz w dowolny obiekt na zdjęciu, a aplikacja automatycznie znajduje jego dokładny kontur. Wszystko dzieje się natychmiast w przeglądarce!

**Jak działa MagicTouch:**
1. Klikasz punkt na obiekcie, który chcesz wyciąć
2. Model analizuje obraz wokół tego punktu
3. Automatycznie znajduje granice obiektu
4. Zwraca precyzyjną maskę segmentacji

**Zalety interaktywnej segmentacji:**
- ✅ **Kontrola**: TY decydujesz, co wyciąć
- ✅ **Szybkość**: Jeden klik zamiast ręcznego rysowania
- ✅ **Precyzja**: Dokładne kontury obiektów
- ✅ **Uniwersalność**: Działa z dowolnymi obiektami

**Zastosowania praktyczne:**

- **Edycja zdjęć**:
  - Łatwe wycinanie obiektów jednym kliknięciem
  - Usuwanie tła z produktów (e-commerce)
  - Tworzenie kolaży

- **E-commerce**:
  - Automatyczne zdjęcia produktów na białym tle
  - Szybka edycja katalogów
  - Przygotowanie materiałów marketingowych

- **Kreatywne projekty**:
  - Fotomontaże
  - Nakładki graficzne
  - Efekty specjalne

- **Adnotacje danych**:
  - Szybkie tworzenie masek dla ML
  - Oznaczanie obiektów w zbiorach treningowych
  - Weryfikacja detekcji

**Dlaczego "interaktywna"?**

W przeciwieństwie do automatycznej segmentacji (która segmentuje wszystko sama), TY decydujesz, co jest ważne. To połączenie mocy AI z kontrolą człowieka!

**Technologia:**
- Natychmiastowe wyniki (<100ms)
- Działa offline po załadowaniu
- Prywatność - zdjęcia nie opuszczają urządzenia

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen.

**Jak używać - tutorial krok po kroku:**
1. Otwórz demo klikając link poniżej
2. Wybierz obraz z galerii LUB załaduj własne zdjęcie
3. Kliknij na obiekt, który chcesz wyciąć
4. Obserwuj magię - aplikacja automatycznie znajdzie kontur!
5. Eksperymentuj:
   - Kliknij różne obiekty na tym samym zdjęciu
   - Spróbuj z różnymi punktami tego samego obiektu
   - Zobacz, jak radzi sobie z trudnymi kształtami
   - Przetestuj na swoich zdjęciach

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/ZEqzpRg)

**Dla studentów - projekty do zbudowania:**
- Dodaj funkcję zapisu wycięte obiektu
- Stwórz edytor kolaży
- Zbuduj aplikację do usuwania tła
- Dodaj opcję "inteligentnej gumy" do edycji
- Integruj z systemem adnotacji danych
