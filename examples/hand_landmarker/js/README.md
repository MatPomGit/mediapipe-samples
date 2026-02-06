# MediaPipe - Zadanie Wykrywania Punktów Charakterystycznych Dłoni dla przeglądarki

## Przegląd

Ten przykład webowy wykrywa punkty charakterystyczne dłoni na obrazach i w klatkach wideo. Punkty są wykrywane na jednym z dostarczonych obrazów lub z klatek wideo z kamery internetowej Twojego urządzenia.

**Dla początkujących - wykrywanie dłoni w przeglądarce:**

Ta aplikacja znajduje i śledzi 21 punktów charakterystycznych na każdej dłoni w czasie rzeczywistym! Wszystko dzieje się lokalnie w przeglądarce - Twoje zdjęcia nigdy nie opuszczają komputera.

**21 punktów charakterystycznych dłoni:**
Aplikacja wykrywa dokładne pozycje:
- 5 czubków palców
- 4 stawy na każdym palcu (16 punktów)
- Podstawa dłoni
- Nadgarstek

**Co możesz zbudować z tym API:**
- **Interaktywne gry**: Sterowanie bez kontrolera, tylko ruchem dłoni
- **Wirtualne instrumenty**: Graj na pianinie w powietrzu
- **Edukacja języka migowego**: Rozpoznawanie gestów
- **Aplikacje AR**: Nakładanie wirtualnych przedmiotów na dłoń
- **Ćwiczenia rehabilitacyjne**: Monitorowanie zakresu ruchu palców
- **Interaktywne prezentacje**: Sterowanie slajdami gestem

**Zalety działania w przeglądarce:**
- Nie trzeba instalować aplikacji
- Działa na komputerach, tabletach i telefonach
- Łatwy dostęp przez link
- Kod można łatwo modyfikować i testować

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy
* Kamera internetowa (do wykrywania dłoni na żywo)

**Wskazówki dla najlepszych wyników:**
- Dobre oświetlenie (światło z przodu, nie z tyłu)
- Jednolite tło (lepiej, gdy dłoń kontrastuje z tłem)
- Całą dłoń w kadrze
- Odległość około 30-60 cm od kamery

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen.

**Jak korzystać z demo:**
1. Kliknij link poniżej, aby otworzyć demo
2. Pozwól na dostęp do kamery
3. Umieść dłoń przed kamerą
4. Zobacz 21 punktów rysowanych na Twojej dłoni w czasie rzeczywistym!
5. Porusz palcami, zaciśnij pięść, pokaż różne gesty

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/gOKBGPN)

**Dla studentów - naucz się więcej:**
- Zobacz kod źródłowy na Codepen
- Zmodyfikuj kolory punktów i linii
- Dodaj własną logikę rozpoznawania gestów
- Użyj współrzędnych punktów do stworzenia interaktywnej aplikacji
- Eksperymentuj z parametrami wykrywania
