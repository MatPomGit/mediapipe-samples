

# MediaPipe Tasks - Demo Klasyfikacji Obrazów na Androidzie

### Przegląd

To jest aplikacja kamerowa, która w sposób ciągły klasyfikuje obiekty w klatkach wideo widzianych przez tylną kamerę urządzenia, w obrazie zaimportowanym z galerii urządzenia lub w filmie zaimportowanym z galerii urządzenia. Aplikacja rozpoznaje i wyświetla:
- **Klasy obiektów**: kategorie rozpoznanych przedmiotów (np. pies, kot, samochód, telefon)
- **Pewność klasyfikacji (confidence)**: jak pewny jest model co do przypisanej kategorii

**Czym różni się klasyfikacja od detekcji?**
- **Klasyfikacja**: odpowiada na pytanie "Co to jest?" - przypisuje całemu obrazowi jedną lub więcej kategorii
- **Detekcja**: odpowiada na pytanie "Gdzie to jest?" - znajduje i lokalizuje obiekty w obrazie

Aplikacja oferuje możliwość użycia jednego z modeli:
- [EfficientDet Lite 0](https://storage.googleapis.com/mediapipe-tasks/object_detector/efficientdet_lite0_uint8.tflite) - zbalansowany model
- [EfficientDet Lite2](https://storage.googleapis.com/mediapipe-tasks/object_detector/efficientdet_lite2_uint8.tflite) - dokładniejszy model

**Ważna informacja o modelach**: Pliki modeli są automatycznie pobierane przez skrypt Gradle podczas budowania i uruchamiania aplikacji. Nie musisz ręcznie pobierać modeli TFLite do projektu, chyba że chcesz użyć własnych modeli. Jeśli zdecydujesz się na własne modele, umieść je w katalogu *assets* aplikacji.

**Wymagania sprzętowe**: Ta aplikacja powinna być uruchamiana na fizycznym urządzeniu Android, aby wykorzystać fizyczną kamerę. Możesz jednak użyć emulatora do testowania funkcjonalności galerii (otwieranie lokalnie zapisanych plików).

![Image Classification Demo](imageclassifier.gif?raw=true "Image Classification Demo")

## Budowanie demo w Android Studio - Instrukcja krok po kroku

### Wymagania wstępne (co musisz mieć przed rozpoczęciem)

*   **[Android Studio](https://developer.android.com/studio/index.html)** - zintegrowane środowisko programistyczne (IDE) do tworzenia aplikacji Android. Ten przykład został przetestowany na Android Studio Dolphin. Jeśli nie masz zainstalowanego Android Studio, pobierz je z podanego linku.

*   **Fizyczne urządzenie Android** z minimalną wersją systemu SDK 24 (Android 7.0 - Nougat) z włączonym trybem programisty. 
    
    **Jak włączyć tryb programisty:**
    1. Otwórz Ustawienia na urządzeniu Android
    2. Przejdź do "O telefonie" lub "Informacje o urządzeniu"
    3. Znajdź "Numer kompilacji" i kliknij go 7 razy
    4. Pojawi się komunikat "Jesteś teraz programistą!"
    5. Wróć do głównych ustawień i znajdź nową opcję "Opcje programisty"
    6. Włącz "Debugowanie USB"
    
    Proces może się różnić w zależności od producenta urządzenia. Możesz również użyć emulatora Android, ale z ograniczoną funkcjonalnością (bez dostępu do kamery).

### Budowanie aplikacji - Szczegółowe kroki

**Krok 1: Otwórz projekt w Android Studio**

*   Uruchom Android Studio
*   Na ekranie powitalnym wybierz "Open an existing Android Studio project" (Otwórz istniejący projekt Android Studio)

**Krok 2: Wybierz katalog projektu**

*   W oknie "Open File or Project", które się pojawi, przejdź do lokalizacji, gdzie sklonowałeś repozytorium
*   Znajdź i wybierz katalog `mediapipe/examples/image_classification/android`
*   Kliknij OK
*   Możesz zostać zapytany, czy ufasz projektowi - wybierz "Trust" (Ufam)

**Krok 3: Synchronizacja Gradle**

*   Android Studio może poprosić o wykonanie Gradle Sync (synchronizacji zależności projektu)
*   Jeśli zobaczysz takie pytanie, kliknij OK
*   Poczekaj, aż Gradle pobierze wszystkie wymagane biblioteki - może to potrwać kilka minut przy pierwszym uruchomieniu

**Krok 4: Uruchom aplikację**

*   Podłącz swoje urządzenie Android do komputera kablem USB
*   Upewnij się, że tryb programisty i debugowanie USB są włączone
*   Gdy urządzenie zostanie wykryte przez Android Studio, kliknij zieloną strzałkę "Run" (Uruchom) na górnym pasku narzędzi
*   Aplikacja zostanie skompilowana i zainstalowana na Twoim urządzeniu

**Co się dzieje podczas pierwszego uruchomienia:**
1. Gradle pobiera modele klasyfikacji obrazów (może to potrwać)
2. Aplikacja zostaje skompilowana do pliku APK
3. APK jest instalowany na Twoim urządzeniu
4. Aplikacja uruchamia się automatycznie

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze *assets* jest zarządzane automatycznie przez plik **download.gradle**. Nie musisz martwić się o ręczne pobieranie modeli - wszystko dzieje się w tle podczas procesu budowania.