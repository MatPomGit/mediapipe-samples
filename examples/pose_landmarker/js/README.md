# MediaPipe - Zadanie Wykrywania Punktów Charakterystycznych Pozy dla przeglądarki

## Przegląd

Ten przykład webowy wykrywa punkty charakterystyczne pozy (ciała) na obrazach i w klatkach wideo. Punkty są wykrywane na jednym z dostarczonych obrazów lub z klatek wideo z kamery internetowej Twojego urządzenia.

**Dla początkujących - wykrywanie pozy w przeglądarce:**

Ta aplikacja śledzi 33 punkty na ludzkim ciele w czasie rzeczywistym, bezpośrednio w przeglądarce! Możesz obserwować, jak AI "widzi" Twój ruch i pozycję.

**33 punkty charakterystyczne ciała:**

Aplikacja wykrywa punkty na:
- **Twarz**: Nos, oczy, uszy (5 punktów)
- **Tułów**: Ramiona, biodra (4 punkty)
- **Ręce**: Barki, łokcie, nadgarstki, palce (10 punktów)
- **Nogi**: Biodra, kolana, kostki, stopy (14 punktów)

**Zastosowania wykrywania pozy w przeglądarce:**

- **Fitness online**:
  - Aplikacje do ćwiczeń z wideo
  - Liczenie powtórzeń (przysiady, pompki)
  - Korekcja techniki ćwiczeń w czasie rzeczywistym

- **Gry i rozrywka**:
  - Gry sterowane ruchem ciała (Just Dance style)
  - Interaktywne doświadczenia AR
  - Wirtualne studio tańca

- **Edukacja i sport**:
  - Nauka jogi - sprawdzanie pozycji asany
  - Trening sportowy - analiza techniki
  - Fizjoterapia online - monitoring ćwiczeń

- **Komunikacja**:
  - Język migowy w czasie rzeczywistym
  - Gesty całym ciałem dla komunikacji

- **Kreatywne aplikacje**:
  - Kontroler muzyczny sterowany ciałem
  - Interaktywne instalacje artystyczne
  - Motion capture dla animacji

**Technologia:**
- Działa w 30-60 FPS (płynny ruch)
- Wykrywa pozę nawet gdy część ciała jest zasłonięta
- Działa w różnym oświetleniu
- Nie wymaga specjalnego sprzętu - tylko kamera!

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy
* Kamera internetowa (do wykrywania pozy na żywo)

**Wskazówki dla najlepszych wyników:**
- Cała sylwetka widoczna w kadrze
- Dobre, równomierne oświetlenie
- Jednolite tło (łatwiej dla modelu)
- Odległość 1.5-3 metry od kamery

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen.

**Jak korzystać:**
1. Otwórz demo klikając link poniżej
2. Pozwól na dostęp do kamery
3. Cofnij się tak, aby cała sylwetka była widoczna
4. Porusz się - zobacz 33 punkty śledzące Twoje ruchy!
5. Spróbuj różnych pozycji:
   - Przysiady
   - Skłony
   - Pozycje jogi
   - Taniec

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/abRLMxN)

**Dla studentów - eksperymentuj:**
- Zobacz kod źródłowy i naucz się, jak używać API
- Dodaj licznik powtórzeń dla ćwiczeń
- Stwórz prostą grę sterowaną ruchem
- Użyj współrzędnych punktów do analizy postawy
- Zbuduj aplikację fitness z osobistym trenerem AI