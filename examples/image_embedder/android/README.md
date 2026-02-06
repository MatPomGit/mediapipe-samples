# MediaPipe Tasks - Demo Osadzania Obrazów (Image Embedder) na Androidzie

### Przegląd

To jest aplikacja porównująca podobieństwo między dwoma obrazami zaimportowanymi z galerii urządzenia. Wykorzystuje modele [Mobilenet V3 Small](https://storage.googleapis.com/mediapipe-tasks/image_embedder/mobilenet_v3_small_075_224_embedder.tflite) lub [Mobilenet V3 Large](https://storage.googleapis.com/mediapipe-tasks/image_embedder/mobilenet_v3_large_075_224_embedder.tflite).

**Co to jest osadzanie obrazów (Image Embedding)?**
Osadzanie obrazów to proces przekształcania obrazu w wektor liczb (embedding), który reprezentuje jego cechy. To jak "odcisk palca" obrazu:
- Dwa podobne obrazy mają podobne wektory
- Dwa różne obrazy mają różne wektory
- Możemy obliczyć "odległość" między wektorami = podobieństwo obrazów

**Różnica między klasyfikacją a osadzaniem:**
- **Klasyfikacja**: "Co to jest?" (pies, kot, samochód)
- **Osadzanie**: "Jak podobne są te obrazy?" (80% podobieństwa)

**Przykłady użycia:**
- **Wyszukiwanie podobnych obrazów**: "Znajdź zdjęcia podobne do tego"
- **Porównanie produktów**: Czy to ta sama rzecz na różnych zdjęciach?
- **Wykrywanie duplikatów**: Znajdowanie powtarzających się zdjęć
- **Weryfikacja**: Czy to ta sama osoba/obiekt?
- **Grupowanie zdjęć**: Automatyczne albumy ze zdjęciami podobnego typu

**Jak działa aplikacja:**
1. Wybierasz dwa obrazy z galerii
2. Model przekształca każdy obraz w wektor (embedding)
3. Oblicza podobieństwo między wektorami (0-100%)
4. Wyświetla wynik: np. "Obrazy są podobne w 85%"

**Modele dostępne:**
- **MobileNet V3 Small**: Szybszy, mniejszy model
- **MobileNet V3 Large**: Dokładniejszy, ale wolniejszy model

**Informacja o modelach**: Pliki modeli są automatycznie pobierane przez skrypt Gradle podczas budowania i uruchamiania aplikacji. Nie musisz wykonywać kroków ręcznego pobierania modeli TFLite do projektu, chyba że chcesz użyć własnych modeli. Jeśli zdecydujesz się na własne modele, umieść je w katalogu *assets* aplikacji.

**Wymagania sprzętowe**: Ta aplikacja powinna być uruchamiana na fizycznym urządzeniu Android, aby wykorzystać fizyczną kamerę. Możesz jednak użyć emulatora do testowania funkcjonalności galerii (otwieranie lokalnie zapisanych plików).

![Image Embedder Demo](imageembedder.png?raw=true "Image Embedder Demo")

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
*   Znajdź i wybierz katalog `mediapipe/examples/image_embedder/android`
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
2. Wybierz pierwszy obraz z galerii (kliknij lewe pole)
3. Wybierz drugi obraz z galerii (kliknij prawe pole)
4. Aplikacja automatycznie obliczy podobieństwo
5. Zobacz wynik - im wyższa wartość, tym bardziej podobne obrazy
6. Eksperymentuj:
   - Dwa zdjęcia tego samego obiektu (wysokie podobieństwo)
   - Dwa zupełnie różne zdjęcia (niskie podobieństwo)
   - Zdjęcia podobnych obiektów (średnie podobieństwo)

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze *assets* jest zarządzane automatycznie przez plik **download.gradle**. Nie musisz martwić się o ręczne pobieranie modeli - wszystko dzieje się w tle podczas procesu budowania.