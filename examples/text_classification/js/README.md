# MediaPipe - Zadanie Klasyfikacji Tekstu dla przeglądarki

## Przegląd

Ten przykład webowy klasyfikuje tekst jako pozytywny lub negatywny w sentymencie. Podaj własny tekst lub wypełnij pole tekstowe domyślnym tekstem.

**Analiza sentymentu (sentiment analysis):**

To proces automatycznego określania, czy tekst wyraża pozytywne czy negatywne emocje. Jest to jedna z najpopularniejszych aplikacji przetwarzania języka naturalnego (NLP).

**Model używany w demo:**

Model został wytrenowany na zbiorze danych [SST-2 (Stanford Sentiment Treebank)](https://nlp.stanford.edu/sentiment/index.html) - jednym z najbardziej znanych zbiorów danych do analizy sentymentu.

**Co to jest SST-2?**
SST-2 zawiera tysiące zdań z recenzji filmów, gdzie każde zdanie jest oznaczone jako pozytywne lub negatywne. Model nauczył się rozpoznawać wzorce językowe wyrażające emocje.

**Dla początkujących - analiza sentymentu w przeglądarce:**

Ta aplikacja czyta tekst i określa, czy wyraża on pozytywne czy negatywne uczucia. Wszystko dzieje się lokalnie w przeglądarce - Twój tekst nigdzie nie jest wysyłany!

**Przykłady:**
- "Uwielbiam tę książkę!" → POZYTYWNY
- "To było okropne" → NEGATYWNY  
- "Film był całkiem dobry" → POZYTYWNY
- "Nie polecam tego produktu" → NEGATYWNY

**Zastosowania analizy sentymentu:**

- **E-commerce**:
  - Automatyczna analiza recenzji produktów
  - Filtrowanie negatywnych opinii
  - Monitoring satysfakcji klientów

- **Media społecznościowe**:
  - Analiza komentarzy i postów
  - Wykrywanie negatywnych reakcji
  - Monitoring marki (brand monitoring)

- **Obsługa klienta**:
  - Priorytetyzacja negatywnych zgłoszeń
  - Automatyczna eskalacja problemów
  - Analiza feedbacku

- **Badania rynku**:
  - Analiza opinii o produktach
  - Badanie nastrojów społecznych
  - Testowanie kampanii marketingowych

**Technologia:**
- Działa całkowicie offline (po pierwszym załadowaniu)
- Natychmiastowe wyniki
- Prywatność - tekst pozostaje lokalnie

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen.

**Jak używać:**
1. Otwórz demo klikając link
2. Wpisz własny tekst LUB użyj przykładowego
3. Zobacz klasyfikację: pozytywny/negatywny z pewnością
4. Eksperymentuj z różnymi tekstami:
   - Pozytywne: Komplementy, pochwały, entuzjastyczne opinie
   - Negatywne: Krytyka, skargi, rozczarowanie
   - Neutralne: Fakty bez emocji (model może mieć trudności)

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/wvXebMW)

**Dla studentów - nauka i praktyka:**
- Przejrzyj kod źródłowy
- Przetestuj granice modelu - kiedy się myli?
- Dodaj wizualizację pewności klasyfikacji
- Stwórz analizator wielu tekstów naraz
- Zintegruj z formularzem feedback na stronie
