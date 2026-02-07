# MediaPipe Tasks - Demo Osadzania Tekstu (Text Embedder) na Androidzie

### Przegląd

To jest aplikacja porównująca podobieństwo między dwoma tekstami. Wykorzystuje modele [Mobile Bert](https://storage.googleapis.com/mediapipe-tasks/text_embedder/mobilebert_embedding_with_metadata.tflite) lub [Average word-embedding](https://storage.googleapis.com/mediapipe-tasks/text_embedder/regex_embedder_with_metadata.tflite).

**Co to jest osadzanie tekstu (Text Embedding)?**

Osadzanie tekstu to proces przekształcania tekstu w wektor liczb, który reprezentuje jego znaczenie. To jak "odcisk palca semantyczny" tekstu:
- Dwa teksty o podobnym znaczeniu mają podobne wektory
- Dwa teksty o różnym znaczeniu mają różne wektory
- Możemy obliczyć "podobieństwo semantyczne" między tekstami

**Różnica między osadzaniem tekstu a klasyfikacją:**
- **Klasyfikacja tekstu**: "Czy to pozytywne czy negatywne?"
- **Osadzanie tekstu**: "Jak podobne są te teksty semantycznie?"

**Przykłady użycia:**

- **Wyszukiwanie semantyczne**: "Znajdź dokumenty o podobnej treści"
- **Wykrywanie duplikatów**: Czy te dwa opisy mówią o tym samym?
- **Rekomendacje**: Znajdź artykuły podobne do tego, który czytasz
- **Grupowanie**: Automatyczne kategoryzowanie tekstów według tematyki
- **Analiza podobieństwa**: Porównywanie odpowiedzi, recenzji, komentarzy

**Jak działa aplikacja:**
1. Wprowadzasz dwa teksty
2. Model przekształca każdy tekst w wektor (embedding)
3. Oblicza podobieństwo między wektorami (cosinusowe)
4. Wyświetla wynik: 0% (całkowicie różne) do 100% (identyczne znaczenie)

**Modele dostępne:**
- **Mobile BERT**: Zaawansowany model kontekstowy, dokładniejszy
- **Average Word Embedding**: Prostszy model oparty na średniej słów, szybszy

**Ciekawostka - semantyka vs składnia:**
Embeddingi rozumieją znaczenie, nie tylko słowa:
- "Pies szczeka głośno" i "Głośny hałas od psa" → wysokie podobieństwo
- "Pies szczeka głośno" i "Kot miauczy cicho" → niskie podobieństwo

**Informacja o modelach**: Pliki modeli są automatycznie pobierane przez skrypt Gradle podczas budowania i uruchamiania aplikacji. Nie musisz wykonywać kroków ręcznego pobierania modeli TFLite do projektu, chyba że chcesz użyć własnych modeli. Jeśli zdecydujesz się na własne modele, umieść je w katalogu *assets* aplikacji.

**Wymagania sprzętowe**: Ta aplikacja powinna być uruchamiana na fizycznym urządzeniu Android. Możesz jednak użyć emulatora do testowania funkcjonalności galerii (otwieranie lokalnie zapisanych plików).

![Text Embedder Demo](textembedder.png?raw=true "Text Embedder Demo")

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
*   Znajdź i wybierz katalog `mediapipe/examples/text_embedder/android`
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
2. Wpisz pierwszy tekst (np. "Lubię jeść jabłka")
3. Wpisz drugi tekst (np. "Uwielbiam owoce")
4. Zobacz wynik podobieństwa semantycznego
5. Eksperymentuj:
   - Synonimy (wysokie podobieństwo)
   - Antonim (niskie podobieństwo)
   - Parafrazowanie (średnie do wysokiego podobieństwa)

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze *assets* jest zarządzane automatycznie przez plik **download.gradle**. Nie musisz martwić się o ręczne pobieranie modeli - wszystko dzieje się w tle podczas procesu budowania.