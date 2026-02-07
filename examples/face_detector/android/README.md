
# MediaPipe Tasks - Demo Wykrywania Twarzy na Androidzie

### Przegląd

To jest aplikacja kamerowa, która w sposób ciągły wykrywa twarz (ramki ograniczające i pewność detekcji) w klatkach wideo widzianych przez przednią kamerę urządzenia, w obrazie zaimportowanym z galerii urządzenia lub w filmie zaimportowanym z galerii urządzenia.

**Co wykrywa ta aplikacja?**
Aplikacja znajduje twarze w obrazie i dla każdej twarzy pokazuje:
- **Ramkę ograniczającą (bounding box)**: prostokąt wokół wykrytej twarzy
- **Pewność detekcji (confidence)**: jak pewny jest model, że wykrył twarz (wartość od 0 do 1)

**Dla początkujących - zastosowania:**
- Wykrywanie twarzy to pierwszy krok w wielu aplikacjach:
  - Aplikacje do selfie z filtrami
  - Systemy bezpieczeństwa
  - Automatyczne tagowanie zdjęć
  - Wykrywanie emocji (wymaga dodatkowych modeli)
  - Rozpoznawanie twarzy (wymaga dodatkowych modeli)

**Informacja o modelu**: Plik modelu jest automatycznie pobierany przez skrypt Gradle podczas budowania i uruchamiania aplikacji. Nie musisz wykonywać kroków ręcznego pobierania modeli TFLite do projektu, chyba że chcesz użyć własnego modelu. Jeśli użyjesz własnego modelu, umieść go w katalogu *assets* aplikacji.

**Wymagania sprzętowe**: Ta aplikacja powinna być uruchamiana na fizycznym urządzeniu Android, aby wykorzystać fizyczną kamerę. Możesz jednak użyć emulatora do testowania funkcjonalności galerii (otwieranie lokalnie zapisanych plików).

![Face Detection Demo](face_detection.png?raw=true "Face Detection Demo")

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
*   Znajdź i wybierz katalog `mediapipe/examples/face_detector/android`
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

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze *assets* jest zarządzane automatycznie przez plik **download.gradle**. Nie musisz martwić się o ręczne pobieranie modeli - wszystko dzieje się w tle podczas procesu budowania.