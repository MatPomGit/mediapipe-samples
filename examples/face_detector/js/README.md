# MediaPipe - Zadanie Wykrywania Twarzy dla przeglądarki

## Przegląd

Ten przykład webowy wykrywa twarze na obrazach i w klatkach wideo. Twarze są wykrywane na jednym z dostarczonych obrazów lub z klatek wideo z kamery internetowej Twojego urządzenia.

**Dla początkujących - wykrywanie twarzy w przeglądarce:**

To demo pokazuje, jak można wykrywać twarze bezpośrednio w przeglądarce internetowej, bez żadnego serwera! MediaPipe używa zaawansowanych algorytmów uczenia maszynowego, aby szybko i precyzyjnie znaleźć twarze w obrazie.

**Co wykrywa aplikacja:**

Dla każdej znalezionej twarzy aplikacja pokazuje:
- **Ramkę ograniczającą**: Prostokąt wokół twarzy
- **Pewność detekcji**: Jak pewny jest model, że to rzeczywiście twarz (0-100%)
- **Liczba wykrytych twarzy**: Może wykryć wiele twarzy jednocześnie!

**Różnica między wykrywaniem a rozpoznawaniem:**
- **Face Detection** (to demo): "Czy to twarz?" + lokalizacja
- **Face Recognition** (inne API): "Czyja to twarz?" + identyfikacja osoby

**Zastosowania wykrywania twarzy:**

- **Fotograficzne**:
  - Autofokus na twarzach w aparatach
  - Automatyczne tagowanie osób na zdjęciach
  - Liczenie osób na zdjęciu grupowym

- **Bezpieczeństwo i kontrola dostępu**:
  - Pierwszy krok do rozpoznawania twarzy
  - Detekcja obecności osoby
  - Monitoring (liczenie osób w pomieszczeniu)

- **Filtry i efekty**:
  - Snapchat/Instagram - podstawa dla filtrów
  - Wirtualny makijaż
  - Efekty AR na twarzy

- **Analiza uwagi**:
  - Czy ktoś patrzy na ekran?
  - Wykrywanie senności kierowcy
  - Analiza reakcji widzów

**Wydajność:**
- Szybkie wykrywanie (<50ms na klatkę)
- Działa w czasie rzeczywistym (30-60 FPS)
- Niska wydajność procesora
- Działa na urządzeniach mobilnych

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy
* Kamera internetowa (opcjonalnie, do wykrywania na żywo)

**Wskazówki dla lepszych wyników:**
- Dobre, frontalne oświetlenie (nie z tyłu!)
- Twarz skierowana w stronę kamery
- Wyraźne rysy twarzy (nie zakryte)
- Odpowiednia odległość (nie za blisko, nie za daleko)

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen.

**Jak używać aplikacji:**
1. Kliknij link poniżej, aby otworzyć demo
2. Wybierz przykładowy obraz LUB
3. Włącz kamerę internetową
4. Zobacz ramki wokół wykrytych twarzy!
5. Spróbuj z wieloma osobami w kadrze

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/OJByWQr)

**Dla studentów programowania:**
- Zobacz kod źródłowy i naucz się, jak używać API
- Eksperymentuj z progiem pewności detekcji
- Dodaj własne funkcje (np. licznik twarzy, zapis zdjęcia)
- Zintegruj wykrywanie twarzy ze swoją aplikacją webową
- Zrozum, jak działa detekcja w czasie rzeczywistym
