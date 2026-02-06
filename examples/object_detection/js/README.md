# MediaPipe - Zadanie Detekcji Obiektów dla przeglądarki internetowej

## Przegląd

Ten przykład webowy wykrywa obiekty na obrazach i w klatkach wideo. Obiekty mogą być wykrywane na jednym z dostarczonych obrazów lub z klatek wideo z kamery internetowej Twojego urządzenia.

**Dla początkujących - detekcja obiektów w przeglądarce:**

To demo pokazuje, jak można uruchomić sztuczną inteligencję bezpośrednio w przeglądarce internetowej, bez potrzeby serwera! Wszystkie obliczenia dzieją się lokalnie na Twoim komputerze, co oznacza:
- **Prywatność**: Twoje zdjęcia nie są wysyłane do żadnego serwera
- **Szybkość**: Brak opóźnień sieciowych
- **Dostępność**: Działa offline po pierwszym załadowaniu

**Klasy obiektów:**
Aplikacja może rozpoznać obiekty z [COCO dataset](https://cocodataset.org/) (Common Objects in Context), który zawiera 80 popularnych kategorii, takich jak:
- Ludzie
- Pojazdy (samochody, motocykle, autobusy)
- Zwierzęta (psy, koty, ptaki, konie)
- Przedmioty codziennego użytku (telefony, laptopy, butelki)
- Meble (krzesła, stoły, sofy)
- I wiele innych!

**Technologie używane:**
- **MediaPipe**: Biblioteka Google do zadań ML
- **WebAssembly (WASM)**: Umożliwia uruchamianie szybkiego kodu w przeglądarce
- **JavaScript**: Język programowania przeglądarki

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy
* Kamera internetowa (jeśli chcesz testować detekcję na żywo)

**Zalecane przeglądarki:**
- Chrome 90+ (najlepsza wydajność)
- Firefox 88+
- Safari 14+ (macOS/iOS)

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen - platformie do testowania i udostępniania kodu webowego.

**Jak korzystać z demo:**
1. Kliknij link poniżej, aby otworzyć demo
2. Wybierz obraz z listy lub użyj własnego
3. Lub włącz kamerę internetową, aby testować detekcję na żywo
4. Obserwuj, jak aplikacja rysuje ramki wokół wykrytych obiektów i pokazuje ich nazwy!

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/vYrWvNg)

**Dla studentów programowania:**
Na Codepen możesz:
- Zobaczyć cały kod źródłowy
- Modyfikować kod i natychmiast widzieć wyniki
- Eksperymentować z parametrami detekcji
- Uczyć się, jak zintegrować MediaPipe ze swoją stroną internetową
