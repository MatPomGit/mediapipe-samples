# MediaPipe Tasks - Demo Klasyfikacji Tekstu na Androidzie

### Przegląd

Ta aplikacja akceptuje tekst wprowadzony do pola tekstowego i klasyfikuje go jako pozytywny lub negatywny, podając wynik pewności klasyfikacji. Obsługiwane modele klasyfikacji to Word Vector i MobileBERT.

**Co to jest klasyfikacja tekstu?**
Klasyfikacja tekstu to proces automatycznego przypisywania kategorii lub etykiet do fragmentów tekstu. W tej aplikacji przeprowadzamy **analizę sentymentu** (sentiment analysis):
- **Pozytywny**: tekst wyraża pozytywne emocje, zadowolenie, radość
- **Negatywny**: tekst wyraża negatywne emocje, niezadowolenie, smutek
- **Pewność**: jak bardzo model jest pewny swojej klasyfikacji (0-1)

**Przykłady:**
- "Uwielbiam tę aplikację!" → POZYTYWNY (pewność: 0.95)
- "To było okropne doświadczenie" → NEGATYWNY (pewność: 0.89)
- "Dzisiaj jest piątek" → NEUTRALNY (niższa pewność)

**Modele dostępne w aplikacji:**
1. **Word Vector**: Szybszy, prostszy model oparty na wektorach słów
2. **MobileBERT**: Bardziej zaawansowany model, dokładniejszy, ale wolniejszy

**Zastosowania klasyfikacji tekstu:**
- **Analiza opinii klientów**: Automatyczne sortowanie recenzji
- **Monitoring mediów społecznościowych**: Wykrywanie negatywnych komentarzy
- **Obsługa klienta**: Priorytetyzacja zgłoszeń
- **Analiza feedbacku**: Zrozumienie satysfakcji użytkowników
- **Filtrowanie treści**: Wykrywanie treści negatywnych lub szkodliwych

**Dla początkujących - jak działa:**
1. Wprowadzasz tekst do pola tekstowego
2. Model analizuje słowa i ich kontekst
3. Przypisuje kategorię (pozytywny/negatywny)
4. Pokazuje wynik z pewnością klasyfikacji

Te instrukcje przeprowadzą Cię przez proces budowania i uruchamiania demo na urządzeniu Android.

**Informacja o modelach**: Pliki modeli są pobierane przez skrypty Gradle podczas budowania i uruchamiania aplikacji. Nie musisz wykonywać żadnych kroków do ręcznego pobierania modeli TFLite do projektu.

![Text Classification Demo](textclassification.gif?raw=true "Text Classification Demo")

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
*   Znajdź i wybierz katalog `mediapipe/examples/text_classification/android`
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
   - "Fantastyczny dzień!"
   - "Jestem bardzo zadowolony"
   - "To było rozczarowujące"
3. Kliknij przycisk klasyfikacji
4. Obserwuj wynik: pozytywny lub negatywny z pewnością klasyfikacji
5. Wypróbuj różne modele i porównaj wyniki!

### Modele używane w aplikacji

Pobieranie, rozpakowywanie i umieszczanie modeli w folderze assets jest zarządzane automatycznie przez plik **download_model.gradle**.