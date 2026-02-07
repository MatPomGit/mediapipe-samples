# MediaPipe Tasks - Demo Interaktywnej Segmentacji Obrazu na Androidzie

### Przegląd

To jest aplikacja, która akceptuje obraz i punkt w tym obrazie, a następnie próbuje określić otaczający obszar o znaczeniu.

**Co to jest interaktywna segmentacja obrazu?**

Interaktywna segmentacja to proces wydzielania konkretnego obiektu z obrazu na podstawie wskazania użytkownika. W przeciwieństwie do automatycznej segmentacji, TY decydujesz, co chcesz wyciąć!

**Jak to działa:**
1. Wybierasz obraz
2. Klikasz punkt na obiekcie, który chcesz wydzielić
3. Model automatycznie znajduje granice tego obiektu
4. Otrzymujesz maskę segmentacji - dokładny kontur obiektu

**Różnice między rodzajami segmentacji:**

- **Automatyczna segmentacja**: Model sam decyduje, co segmentować (wszystkie osoby, tło, itp.)
- **Interaktywna segmentacja** (to demo): TY wskazujesz, co segmentować kliknięciem
- **Semantyczna segmentacja**: Klasyfikuje każdy piksel według kategorii
- **Instancyjna segmentacja**: Rozróżnia poszczególne obiekty tej samej klasy

**Zastosowania interaktywnej segmentacji:**

- **Edycja zdjęć**: 
  - Łatwe usuwanie tła jednym kliknięciem
  - Wymiana tła na inne
  - Wycinanie obiektów

- **E-commerce**:
  - Automatyczne tworzenie zdjęć produktów na białym tle
  - Szybka edycja zdjęć katalogowych

- **Aplikacje kreatywne**:
  - Kolaże - łatwe wycinanie elementów
  - Fotomontaże
  - Nakładki i efekty na konkretne obiekty

- **Adnotacje**:
  - Szybkie tworzenie masek treningowych dla ML
  - Oznaczanie obiektów w zbiorach danych

**Zalety interaktywnej segmentacji:**
- ✅ Precyzyjna - dokładny kontur obiektu
- ✅ Szybka - jeden klik zamiast ręcznego rysowania
- ✅ Elastyczna - wybierasz, co chcesz wyciąć
- ✅ Nie wymaga trenowania - działa od razu

**Informacja o modelu**: Pliki modeli są automatycznie pobierane przez skrypt Gradle podczas budowania i uruchamiania aplikacji. Nie musisz wykonywać kroków ręcznego pobierania modeli TFLite do projektu, chyba że chcesz użyć własnych modeli. Jeśli zdecydujesz się na własne modele, umieść je w katalogu *assets* aplikacji.

**Wymagania sprzętowe**: Ta aplikacja powinna być uruchamiana na fizycznym urządzeniu Android, aby wykorzystać fizyczną kamerę. Możesz jednak użyć opcji galerii w emulatorze do otwierania lokalnie zapisanych plików.

![Interactive Segmenter Demo](interactive_segmenter.png?raw=true "Interactive Segmenter Demo")

## Budowanie demo w Android Studio - Instrukcja krok po kroku

### Wymagania wstępne (co musisz mieć przed rozpoczęciem)

*   **[Android Studio](https://developer.android.com/studio/index.html)** - zintegrowane środowisko programistyczne (IDE) do tworzenia aplikacji Android. Ten przykład został przetestowany na Android Studio Dolphin.

*   **Fizyczne urządzenie Android** z minimalną wersją systemu SDK 24 (Android 7.0 - Nougat) z włączonym trybem programisty. 
    
    **Jak włączyć tryb programisty:**
    1. Otwórz Ustawienia na urządzeniu Android
    2. Przejdź do "O telefonie" lub "Informacje o urządzeniu"
    3. Znajdź "Numer kompilacji" i kliknij go 7 razy
    4. Pojawi się komunikat "Jesteś teraz programistą!"
    5. Wróć do głównych ustawień i znajdź nową opcję "Opcje programisty"
    6. Włącz "Debugowanie USB"
    
    Proces może się różnić w zależności od producenta urządzenia. Możesz również użyć emulatora Android, ale z ograniczoną funkcjonalnością.

### Budowanie aplikacji - Szczegółowe kroki

**Krok 1: Otwórz projekt w Android Studio**

*   Uruchom Android Studio
*   Na ekranie powitalnym wybierz "Open an existing Android Studio project" (Otwórz istniejący projekt Android Studio)

**Krok 2: Wybierz katalog projektu**

*   W oknie "Open File or Project", które się pojawi, przejdź do lokalizacji, gdzie sklonowałeś repozytorium
*   Znajdź i wybierz katalog `mediapipe/examples/interactive_segmentation/android`
*   Kliknij OK
*   Możesz zostać zapytany, czy ufasz projektowi - wybierz "Trust" (Ufam)

**Krok 3: Synchronizacja Gradle**

*   Android Studio może poprosić o wykonanie Gradle Sync (synchronizacji zależności projektu)
*   Jeśli zobaczysz takie pytanie, kliknij OK
*   Poczekaj, aż Gradle pobierze wszystkie wymagane biblioteki

**Krok 4: Uruchom aplikację**

*   Podłącz swoje urządzenie Android do komputera kablem USB
*   Upewnij się, że tryb programisty i debugowanie USB są włączone
*   Gdy urządzenie zostanie wykryte przez Android Studio, kliknij zieloną strzałkę "Run" (Uruchom) na górnym pasku narzędzi
*   Aplikacja zostanie skompilowana i zainstalowana na Twoim urządzeniu

**Jak używać aplikacji - pierwsze kroki:**
1. Uruchom aplikację
2. Załaduj obraz z galerii lub zrób zdjęcie
3. Kliknij punkt na obiekcie, który chcesz wydzielić
4. Obserwuj, jak model automatycznie znajduje granice obiektu!
5. Eksperymentuj z różnymi punktami i obiektami:
   - Kliknij osobę, aby wydzielić ją z tła
   - Kliknij konkretny przedmiot
   - Spróbuj różnych lokalizacji punktu na tym samym obiekcie

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze *assets* jest zarządzane automatycznie przez plik **download.gradle**. Nie musisz martwić się o ręczne pobieranie modeli - wszystko dzieje się w tle podczas procesu budowania.
