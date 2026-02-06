# MediaPipe Tasks - Demo Detektora Języka na Androidzie

### Przegląd

Ta aplikacja akceptuje tekst wprowadzony do pola tekstowego i wykrywa język, w którym został napisany, podając wynik pewności detekcji.

**Co to jest detekcja języka?**
Detekcja języka to proces automatycznego rozpoznawania, w jakim języku napisany jest tekst. To bardzo przydatna funkcja w świecie wielojęzycznym:

**Jak to działa:**
1. Wpisujesz tekst w dowolnym języku
2. Model analizuje wzorce słów i znaków
3. Identyfikuje język (np. polski, angielski, niemiecki)
4. Pokazuje pewność detekcji (0-100%)

**Wspierane języki:**
Model może rozpoznać dziesiątki języków, w tym:
- Języki europejskie (polski, angielski, niemiecki, francuski, hiszpański, włoski, itp.)
- Języki azjatyckie (chiński, japoński, koreański, hindi, arabski)
- Języki słowiańskie (rosyjski, czeski, ukraiński)
- I wiele innych!

**Zastosowania detekcji języka:**
- **Automatyczne tłumaczenie**: Wykryj język przed tłumaczeniem
- **Filtrowanie treści**: Sortuj teksty według języka
- **Analiza dokumentów**: Identyfikuj język dokumentu
- **Chatboty**: Odpowiadaj w języku użytkownika
- **Moderacja treści**: Kieruj komentarze do odpowiednich moderatorów
- **Statystyki**: Analiza języków używanych przez użytkowników
- **Dostępność**: Automatyczne przekierowanie do wersji językowej strony

**Dla początkujących - przykłady:**
- "Hello world" → Angielski (pewność: 99%)
- "Witaj świecie" → Polski (pewność: 98%)
- "Hola mundo" → Hiszpański (pewność: 97%)
- "123456" → Nieokreślony (niska pewność - to nie jest język)

**Ciekawostki:**
- Model może wykryć język nawet z krótkiego tekstu (kilka słów)
- Im dłuższy tekst, tym dokładniejsza detekcja
- Niektóre języki są do siebie bardzo podobne (np. czeski i słowacki)

Te instrukcje przeprowadzą Cię przez proces budowania i uruchamiania demo na urządzeniu Android.

**Informacja o modelu**: Plik modelu jest pobierany przez skrypty Gradle podczas budowania i uruchamiania aplikacji. Nie musisz wykonywać żadnych kroków do ręcznego pobierania modeli TFLite do projektu.

![Language Detector Demo](language_detector.png?raw=true "Language Detector Demo")

## Budowanie demo w Android Studio - Instrukcja krok po kroku

### Wymagania wstępne (co musisz mieć przed rozpoczęciem)

*   **[Android Studio](https://developer.android.com/studio/index.html)** - zintegrowane środowisko programistyczne (IDE) do tworzenia aplikacji Android. Ten przykład został przetestowany na Android Studio Chipmunk.

*   **Fizyczne lub emulowane urządzenie Android** z minimalną wersją systemu SDK 21 (Android 5.0) z włączonym trybem programisty. 
    
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
*   Znajdź i wybierz katalog `mediapipe/examples/language_detector/android`
*   Kliknij OK

**Krok 3: Synchronizacja Gradle**

*   Android Studio może poprosić o wykonanie Gradle Sync (synchronizacji zależności projektu)
*   Jeśli zobaczysz takie pytanie, kliknij OK
*   Poczekaj, aż Gradle pobierze wszystkie wymagane biblioteki

**Krok 4: Uruchom aplikację**

*   Podłącz swoje urządzenie Android do komputera kablem USB (lub uruchom emulator)
*   Upewnij się, że tryb programisty i debugowanie USB są włączone
*   Gdy urządzenie zostanie wykryte przez Android Studio, kliknij zieloną strzałkę "Run" (Uruchom) na górnym pasku narzędzi
*   Aplikacja zostanie skompilowana i zainstalowana na Twoim urządzeniu

**Jak używać aplikacji - pierwsze kroki:**
1. Uruchom aplikację
2. Wpisz tekst w polu tekstowym, na przykład:
   - "Dzień dobry, jak się masz?" (Polski)
   - "Hello, how are you?" (Angielski)
   - "Bonjour, comment allez-vous?" (Francuski)
   - "Guten Tag, wie geht es Ihnen?" (Niemiecki)
3. Kliknij przycisk detekcji
4. Zobacz wykryty język z pewnością detekcji
5. Wypróbuj różne języki i długości tekstu!

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze assets jest zarządzane automatycznie przez plik **download_model.gradle**.