# MediaPipe - Zadanie Rozpoznawania Gestów dla przeglądarki

## Przegląd

Ten przykład webowy wykrywa punkty charakterystyczne dłoni na obrazach i w klatkach wideo oraz klasyfikuje gesty (nazwa gestu i poziom pewności). Gesty są wykrywane na jednym z dostarczonych obrazów lub z klatek wideo z kamery internetowej Twojego urządzenia.

**Dla początkujących - rozpoznawanie gestów w przeglądarce:**

To demo łączy dwie potężne technologie:
1. **Wykrywanie punktów dłoni**: Znajduje 21 punktów na dłoni
2. **Klasyfikacja gestów**: Rozpoznaje znaczenie układu punktów

Wszystko dzieje się w czasie rzeczywistym, bezpośrednio w przeglądarce!

**Jakie gesty można rozpoznać:**

Aplikacja rozpoznaje standardowe gesty, takie jak:
- ✊ Zamknięta pięść
- ✋ Otwarta dłoń  
- 👍 Kciuk w górę
- 👎 Kciuk w dół
- ✌️ Znak V (Victory/Peace)
- 👉 Wskazywanie palcem
- 🤟 "I love you" (język migowy)
- I więcej!

**Zastosowania w świecie rzeczywistym:**

- **Gry bez kontrolera**: Steruj grą ruchem dłoni
- **Prezentacje**: Zmień slajd gestem
- **Aplikacje edukacyjne**: Nauka języka migowego
- **Interfejsy bezdotykowe**: Higiena w miejscach publicznych
- **Dostępność**: Sterowanie dla osób z ograniczeniami fizycznymi
- **Rozrywka**: Filtry i efekty AR reagujące na gesty

**Technologia:**
- Wykrywanie działające w 60 FPS (płynny ruch!)
- Niskie opóźnienie (<100ms)
- Działa offline po pierwszym załadowaniu
- Prywatność - wszystko lokalne, bez wysyłania danych

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy
* Kamera internetowa (do rozpoznawania gestów na żywo)

**Wskazówki dla najlepszej dokładności:**
- Dobre, równomierne oświetlenie
- Jednolite tło (kontrast z dłonią)
- Trzymaj dłoń w centrum kadru
- Wyraźne, pewne gesty (nie pośrednie pozycje)

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen.

**Jak korzystać:**
1. Otwórz demo klikając link poniżej
2. Pozwól na dostęp do kamery
3. Pokaż dłoń przed kamerą
4. Wykonaj różne gesty i obserwuj rozpoznawanie!
5. Zobacz nazwę gestu i pewność klasyfikacji (0-100%)

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/zYamdVd)

**Dla studentów - nauka i eksperymentowanie:**
- Przejrzyj kod źródłowy na Codepen
- Zobacz, jak API wykrywa punkty i klasyfikuje gesty
- Dodaj własne gesty (wymaga wytrenowania modelu)
- Użyj rozpoznanych gestów do sterowania aplikacją
- Zintegruj z własnym projektem webowym
