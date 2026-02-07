# MediaPipe Tasks - Demo Klasyfikacji Audio na Androidzie

### Przegląd

To jest aplikacja audio, która w sposób ciągły klasyfikuje dźwięki obiektów nagrywanych przez mikrofon lub w plikach audio zaimportowanych z biblioteki urządzenia. Wykorzystuje model [Yamnet classification](https://storage.googleapis.com/download.tensorflow.org/models/tflite/task_library/audio_classification/android/lite-model_yamnet_classification_tflite_1.tflite).

**Co to jest klasyfikacja audio?**
Klasyfikacja audio to proces rozpoznawania i kategoryzowania dźwięków. Aplikacja analizuje fale dźwiękowe i identyfikuje:
- **Typ dźwięku**: Co wydaje ten dźwięk (np. szczekanie psa, klakson samochodu, muzyka)
- **Pewność klasyfikacji**: Jak pewny jest model co do rozpoznania (wartość od 0 do 1)

**Model YamNet:**
YamNet to zaawansowany model Google, wytrenowany na setki kategorii dźwięków. Potrafi rozpoznać:
- Dźwięki zwierząt (psy, koty, ptaki)
- Dźwięki pojazdów (samochody, motocykle, pociągi)
- Muzykę i instrumenty
- Mowę ludzką
- Dźwięki otoczenia (dzwonek, alarm, deszcz)
- I wiele innych!

**Zastosowania klasyfikacji audio:**
- **Aplikacje dla niesłyszących**: Powiadomienia o ważnych dźwiękach (dzwonek do drzwi, płacz dziecka)
- **Bezpieczeństwo**: Wykrywanie alarmów, syren, krzyków
- **Monitorowanie**: Detekcja nietypowych dźwięków w przemyśle
- **Katalogowanie**: Automatyczne tagowanie nagrań audio
- **Smart Home**: Reagowanie na konkretne dźwięki (komendy głosowe, szczekanie)
- **Edukacja przyrodnicza**: Rozpoznawanie śpiewu ptaków

**Informacja o modelu**: Pliki modeli są automatycznie pobierane przez skrypt Gradle podczas budowania i uruchamiania aplikacji. Nie musisz wykonywać kroków ręcznego pobierania modeli TFLite do projektu, chyba że chcesz użyć własnych modeli. Jeśli zdecydujesz się na własne modele, umieść je w katalogu *assets* aplikacji.

![Audio Classifier Demo](audioclassifier.png?raw=true "Audio Classifier Demo")

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
    
    Proces może się różnić w zależności od producenta urządzenia. Możesz również użyć emulatora Android, ale z ograniczoną funkcjonalnością (bez dostępu do mikrofonu).

### Budowanie aplikacji - Szczegółowe kroki

**Krok 1: Otwórz projekt w Android Studio**

*   Uruchom Android Studio
*   Na ekranie powitalnym wybierz "Open an existing Android Studio project" (Otwórz istniejący projekt Android Studio)

**Krok 2: Wybierz katalog projektu**

*   W oknie "Open File or Project", które się pojawi, przejdź do lokalizacji, gdzie sklonowałeś repozytorium
*   Znajdź i wybierz katalog `mediapipe/examples/audio_classifier/android`
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

**Jak używać aplikacji - pierwsze kroki:**
1. Uruchom aplikację i pozwól na dostęp do mikrofonu
2. Zrób różne dźwięki (klaskanie, gwizdanie, pukanie)
3. Puść muzykę lub włącz telewizor
4. Obserwuj, jak aplikacja rozpoznaje i klasyfikuje różne dźwięki w czasie rzeczywistym!
5. Możesz też załadować plik audio z biblioteki urządzenia

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze *assets* jest zarządzane automatycznie przez plik **download_models.gradle**. Nie musisz martwić się o ręczne pobieranie modeli - wszystko dzieje się w tle podczas procesu budowania.
