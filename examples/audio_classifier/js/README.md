# MediaPipe - Zadanie Klasyfikacji Audio dla przeglądarki

## Przegląd

Ten przykład webowy klasyfikuje dźwięk audio do jednej z kilku klas. Wykorzystuje model Yamnet.

**Model YamNet:**

Model Yamnet to klasyfikator zdarzeń audio wytrenowany na zbiorze danych [AudioSet](https://research.google.com/audioset/) do przewidywania zdarzeń audio z ontologii AudioSet.

**Co to jest AudioSet?**
AudioSet to ogromna baza danych Google zawierająca miliony nagrań audio oznaczonych setkami kategorii dźwięków ze świata rzeczywistego.

**Jakie dźwięki może rozpoznać YamNet:**
- **Muzyka**: Instrumenty, śpiew, gatunki muzyczne
- **Mowa**: Rozmowy, śmiech, krzyki
- **Zwierzęta**: Szczekanie, miauczenie, śpiew ptaków
- **Pojazdy**: Silniki, klaksony, hamowanie
- **Otoczenie**: Wiatr, deszcz, grzmoty
- **Urządzenia**: Alarmy, dzwonki, klawiatura
- I setki innych!

**Dla początkujących - klasyfikacja audio w przeglądarce:**

Ta aplikacja "słucha" dźwięków przez mikrofon i rozpoznaje, co słyszy - wszystko w czasie rzeczywistym w przeglądarce! Nie trzeba instalować niczego ani wysyłać danych na serwer.

**Zastosowania:**
- **Monitorowanie środowiska**: Rozpoznawanie nietypowych dźwięków
- **Aplikacje dla niesłyszących**: Powiadomienia o ważnych dźwiękach (dzwonek, alarm)
- **Katalogowanie audio**: Automatyczne tagowanie nagrań
- **Bezpieczeństwo**: Wykrywanie alarmów, syren
- **Rozpoznawanie muzyki**: Identyfikacja instrumentów
- **Smart home**: Reagowanie na określone dźwięki

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy
* Mikrofon (do klasyfikacji audio na żywo)

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen.

**Jak używać:**
1. Otwórz demo klikając link
2. Pozwól na dostęp do mikrofonu
3. Zrób różne dźwięki lub włącz muzykę
4. Zobacz, jak aplikacja rozpoznaje i klasyfikuje dźwięki w czasie rzeczywistym!
5. Eksperymentuj:
   - Klaskanie, gwizdanie
   - Muzyka (różne instrumenty)
   - Dźwięki urządzeń (telefon, klawiatura)
   - Dźwięki zwierząt

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/wvxYYmy)

**Dla studentów:**
- Sprawdź kod źródłowy
- Zobacz, jak używać Web Audio API z MediaPipe
- Dodaj wizualizację audio (spektrogram)
- Stwórz aplikację reagującą na konkretne dźwięki
