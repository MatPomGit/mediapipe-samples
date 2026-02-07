# MediaPipe Tasks - Demo Wykrywania Punktów Charakterystycznych Ciała na Androidzie

### Przegląd

To jest aplikacja kamerowa, która wykrywa punkty charakterystyczne na osobie (pose landmarks) z ciągłych klatek wideo widzianych przez tylną kamerę urządzenia, z obrazu lub filmu z galerii urządzenia. Wykorzystuje specjalny plik **task** (zadania).

**Co to są punkty charakterystyczne ciała?**
Punkty charakterystyczne pozy to kluczowe punkty na ciele człowieka, które pozwalają śledzić pozycję i ruch całego ciała. Aplikacja wykrywa:
- **33 punkty charakterystyczne** obejmujące:
  - Twarz (nos, oczy, uszy)
  - Tułów (ramiona, biodra)
  - Ręce (barki, łokcie, nadgarstki, palce)
  - Nogi (biodra, kolana, kostki, stopy)

**Zastosowania wykrywania pozy:**
- **Fitness i sport**: Analiza techniki ćwiczeń, liczenie powtórzeń
- **Gry**: Sterowanie grami ruchem ciała
- **Rehabilitacja**: Monitorowanie postępów w fizjoterapii
- **Taniec**: Nauka choreografii, analiza ruchu
- **Rozszerzona rzeczywistość (AR)**: Nakładanie elementów 3D na ciało
- **Analiza ergonomii**: Ocena postawy w miejscu pracy

**Dla początkujących - jak to działa:**
1. Model najpierw wykrywa osobę w kadrze
2. Następnie lokalizuje 33 punkty na ciele
3. Punkty są połączone liniami tworząc "szkielet"
4. Można śledzić ruch tych punktów w czasie rzeczywistym

**Informacja o pliku task**: Plik zadania jest automatycznie pobierany przez skrypt Gradle podczas budowania i uruchamiania aplikacji. Nie musisz wykonywać dodatkowych kroków, aby pobrać pliki zadań do projektu, chyba że chcesz użyć własnego pliku do wykrywania punktów charakterystycznych. Jeśli użyjesz własnego pliku zadania, umieść go w katalogu *assets* aplikacji.

**Wymagania sprzętowe**: Ta aplikacja powinna być uruchamiana na fizycznym urządzeniu Android, aby wykorzystać kamerę.

![Pose Landmarker Demo](pose_landmarker.png?raw=true "Pose Landmarker Demo")
[Wideo domeny publicznej od Lance Foss](https://www.youtube.com/watch?v=KALIKOd1pbA)

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
*   Znajdź i wybierz katalog `mediapipe/examples/pose_landmarker/android`
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
2. Ustaw urządzenie tak, aby kamera widziała całą sylwetkę
3. Porusz się - zobaczysz 33 punkty i łączące je linie na Twoim ciele
4. Spróbuj różnych pozycji i ruchów!

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze *assets* jest zarządzane automatycznie przez plik **download.gradle**. Nie musisz martwić się o ręczne pobieranie modeli - wszystko dzieje się w tle podczas procesu budowania.