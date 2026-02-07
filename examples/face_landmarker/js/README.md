# MediaPipe - Zadanie Wykrywania Punktów Charakterystycznych Twarzy dla przeglądarki

## Przegląd

Ten przykład webowy wykrywa kluczowe punkty na twarzach w obrazach i klatkach wideo. Twarze są wykrywane na jednym z dostarczonych obrazów lub z klatek wideo z kamery internetowej Twojego urządzenia.

**Dla początkujących - punkty charakterystyczne twarzy w przeglądarce:**

Ta aplikacja znajduje 478 precyzyjnych punktów na każdej twarzy! To niesamowita szczegółowość, która pozwala na zaawansowaną analizę i efekty AR.

**478 punktów charakterystycznych twarzy:**

Aplikacja mapuje każdy szczegół twarzy:
- **Kontur twarzy**: Dokładny obrys (17 punktów)
- **Brwi**: Lewa i prawa, z każdym włoskiem (20 punktów)
- **Oczy**: Powieki, rogówki, źrenice (36 punktów dla obu oczu)
- **Nos**: Grzbiet, skrzydła, dziurki (18 punktów)
- **Usta**: Zewnętrzna i wewnętrzna linia (40 punktów)
- **Iris**: Szczegółowe punkty tęczówki

**Różnica w poziomach detekcji:**
- **Face Detection**: "Czy to twarz?" (1 prostokąt)
- **Face Mesh/Landmarks**: "Dokładnie gdzie są wszystkie cechy?" (478 punktów!)

**Zastosowania w czasie rzeczywistym:**

- **Filtry AR**:
  - Snapchat/Instagram - maski, okulary, makijaż
  - Deformacje twarzy (funny faces)
  - Wymiana twarzy (face swap)

- **Analiza emocji**:
  - Wykrywanie uśmiechu, zmarszczenia brwi
  - Śledzenie mikroekspresji
  - Rozpoznawanie emocji (radość, smutek, gniew)

- **Wirtualna rzeczywistość**:
  - Animacja awatara na podstawie mimiki
  - Przenoszenie wyraz twarzy na postać 3D
  - Kontroler VR sterowany mimiką

- **Analiza medyczna i naukowa**:
  - Badanie symetrii twarzy
  - Diagnoza paraliżu twarzy
  - Pomiar zmęczenia, stresu

- **Bezpieczeństwo**:
  - Wykrywanie "liveness" (czy to żywa osoba)
  - Podstawa dla rozpoznawania twarzy
  - Wykrywanie kierunku patrzenia

**Technologia:**
- 60 FPS na większości urządzeń
- Wysoka precyzja (błąd <2 piksele)
- Działa nawet przy częściowym zasłonięciu twarzy

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy
* Kamera internetowa (do wykrywania na żywo)

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen.

**Jak korzystać:**
1. Otwórz demo klikając link
2. Pozwól na dostęp do kamery
3. Skieruj twarz na kamerę - zobacz 478 punktów!
4. Eksperymentuj z mimiką:
   - Uśmiechnij się - obserwuj punkty ust
   - Zmrużyć oczy - punkty powiek się przesuwają
   - Podnieś brwi - góra twarzy się zmienia
   - Otwórz usta szeroko

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/OJBVQJm)

**Dla studentów - zaawansowane projekty:**
- Stwórz wirtualny makijaż (rysuj na wargach, powiekach)
- Zmierz symetrię twarzy
- Wykryj, czy osoba się uśmiecha
- Zbuduj prostą grę sterowaną mimiką
- Animuj postać 3D używając twarzy
