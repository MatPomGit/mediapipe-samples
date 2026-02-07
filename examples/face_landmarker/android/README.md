# MediaPipe Tasks - Demo Wykrywania Punktów Charakterystycznych Twarzy na Androidzie

### Przegląd

To jest aplikacja kamerowa, która wykrywa punkty charakterystyczne twarzy (face landmarks) z ciągłych klatek wideo widzianych przez przednią kamerę urządzenia, z obrazu lub filmu z galerii urządzenia. Wykorzystuje specjalny plik **task** (zadania).

**Co to są punkty charakterystyczne twarzy?**
Punkty charakterystyczne twarzy to precyzyjnie określone punkty na twarzy, które pozwalają na szczegółową analizę rysów twarzy. Aplikacja wykrywa setki punktów obejmujących:

**Wykrywane elementy twarzy:**
- **Kontury twarzy**: Kształt i obrys twarzy
- **Brwi**: Lewa i prawa brew (po kilka punktów na każdą)
- **Oczy**: Kontur każdego oka, rogówka
- **Nos**: Grzbiet nosa, dziurki nosowe
- **Usta**: Zewnętrzna i wewnętrzna linia ust
- **Źrenice**: Pozycja źrenic

**Różnica między wykrywaniem a punktami charakterystycznymi:**
- **Face Detection**: "Czy to twarz?" + prostokąt wokół twarzy
- **Face Landmarks**: "Gdzie dokładnie są oczy, nos, usta?" + setki precyzyjnych punktów

**Zastosowania wykrywania punktów twarzy:**
- **Filtry AR**: Snapchat, Instagram - nakładanie masek i efektów
- **Śledzenie spojrzenia**: Gdzie patrzy użytkownik
- **Wykrywanie emocji**: Analiza ekspresji twarzy
- **Animacja awatarów**: Przenoszenie mimiki na postać 3D
- **Wirtualny makijaż**: Aplikacje do testowania kosmetyków
- **Rozpoznawanie twarzy**: Identyfikacja na podstawie cech geometrycznych
- **Analiza uwagi**: Czy osoba patrzy na ekran

**Dla początkujących - jak to działa:**
1. Model najpierw wykrywa twarz w kadrze
2. Następnie znajduje kluczowe punkty na twarzy (478 punktów!)
3. Punkty są aktualizowane w czasie rzeczywistym przy ruchu
4. Można śledzić mikroruchy i ekspresje

**Informacja o pliku task**: Plik zadania jest automatycznie pobierany przez skrypt Gradle podczas budowania i uruchamiania aplikacji. Nie musisz wykonywać dodatkowych kroków, aby pobrać pliki zadań do projektu, chyba że chcesz użyć własnego pliku do wykrywania punktów charakterystycznych. Jeśli użyjesz własnego pliku zadania, umieść go w katalogu *assets* aplikacji.

**Wymagania sprzętowe**: Ta aplikacja powinna być uruchamiana na fizycznym urządzeniu Android, aby wykorzystać kamerę.

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
*   Znajdź i wybierz katalog `mediapipe/examples/face_landmarker/android`
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
2. Skieruj twarz w stronę kamery (przedniej)
3. Zobaczysz setki małych punktów na swojej twarzy
4. Porusz głową, zmień mimikę - punkty będą śledzić Twoje ruchy!
5. Spróbuj uśmiechnąć się, zmrużyć oczy, otworzyć usta

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze *assets* jest zarządzane automatycznie przez plik **download.gradle**. Nie musisz martwić się o ręczne pobieranie modeli - wszystko dzieje się w tle podczas procesu budowania.