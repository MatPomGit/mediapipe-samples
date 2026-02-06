
# MediaPipe Tasks - Demo Rozpoznawania Gestów na Androidzie

### Przegląd

To jest aplikacja kamerowa, która w sposób ciągły wykrywa punkty charakterystyczne dłoni i klasyfikuje gesty (nazwa gestu i poziom pewności) z klatek wideo widzianych przez przednią kamerę urządzenia, z obrazu lub filmu z galerii urządzenia. Wykorzystuje specjalny plik **task** (zadania).

**Co to jest rozpoznawanie gestów?**
Rozpoznawanie gestów to proces identyfikowania znaczących ruchów dłoni. Aplikacja łączy dwie technologie:
1. **Wykrywanie punktów charakterystycznych dłoni**: Znajduje 21 punktów na dłoni
2. **Klasyfikacja gestów**: Na podstawie układu punktów rozpoznaje gest

**Standardowe gesty rozpoznawane przez aplikację:**
- ✊ **Closed Fist** (Zaciśnięta pięść)
- ✋ **Open Palm** (Otwarta dłoń)
- 👍 **Thumb Up** (Kciuk w górę)
- 👎 **Thumb Down** (Kciuk w dół)
- ✌️ **Victory** (Znak V)
- 👉 **Pointing Up** (Wskazywanie palcem)
- I wiele innych!

**Zastosowania rozpoznawania gestów:**
- Sterowanie grami bez dotykania ekranu
- Interakcja z aplikacjami AR/VR
- Systemy dla osób niesłyszących (język migowy)
- Sterowanie prezentacjami
- Bezobsługowe interfejsy użytkownika

**Informacja o pliku task**: Plik zadania jest automatycznie pobierany przez skrypt Gradle podczas budowania i uruchamiania aplikacji. Nie musisz wykonywać dodatkowych kroków, aby pobrać pliki zadań do projektu, chyba że chcesz użyć własnego niestandardowego zadania rozpoznawania gestów. Jeśli użyjesz własnego pliku zadania, umieść go w katalogu *assets* aplikacji.

**Wymagania sprzętowe**: Ta aplikacja powinna być uruchamiana na fizycznym urządzeniu Android, aby wykorzystać kamerę.

![gesture recognition demo](gesturerec.gif?raw=true "Gesture Recognition Demo")


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
    
    Proces może się różnić w zależności od producenta urządzenia.

### Budowanie aplikacji - Szczegółowe kroki

**Krok 1: Otwórz projekt w Android Studio**

*   Uruchom Android Studio
*   Na ekranie powitalnym wybierz "Open an existing Android Studio project" (Otwórz istniejący projekt Android Studio)

**Krok 2: Wybierz katalog projektu**

*   W oknie "Open File or Project", które się pojawi, przejdź do lokalizacji, gdzie sklonowałeś repozytorium
*   Znajdź i wybierz katalog `mediapipe/examples/gesture_recognizer/android`
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
1. Uruchom aplikację i pozwól na dostęp do kamery
2. Umieść dłoń przed kamerą (na odległość około 30-50 cm)
3. Spróbuj pokazać różne gesty:
   - Zaciśnij pięść
   - Pokaż kciuk w górę
   - Zrób znak V
4. Obserwuj, jak aplikacja rozpoznaje i wyświetla nazwę gestu z pewnością detekcji

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze *assets* jest zarządzane automatycznie przez plik **download.gradle**. Nie musisz martwić się o ręczne pobieranie modeli - wszystko dzieje się w tle podczas procesu budowania.