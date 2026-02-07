# MediaPipe - Zadanie Klasyfikacji Obrazów dla przeglądarki internetowej

## Przegląd

Ten przykład webowy klasyfikuje obrazy i klatki wideo. Możesz użyć jednego z dostarczonych obrazów lub klatek z kamery internetowej swojego urządzenia, aby uzyskać klasyfikacje.

**Dla początkujących - klasyfikacja obrazów w przeglądarce:**

Ta aplikacja rozpoznaje, co znajduje się na obrazie i przypisuje mu kategorię. Wszystko dzieje się w przeglądarce, bez wysyłania danych do serwera!

**Model i dane treningowe:**
Model został wytrenowany na [ImageNet dataset](https://www.image-net.org/) - jednym z największych zbiorów danych obrazów w świecie. ImageNet zawiera miliony obrazów podzielonych na tysiące kategorii.

**Co może rozpoznać:**
Aplikacja potrafi rozpoznać tysiące kategorii obiektów! Zobacz [pełną listę](https://storage.googleapis.com/mediapipe-tasks/image_classifier/labels.txt) obsługiwanych kategorii, w tym:
- Zwierzęta (setki ras psów, kotów, ptaków)
- Rośliny i kwiaty
- Pojazdy różnych typów
- Narzędzia i urządzenia
- Jedzenie i napoje
- Budynki i struktury
- Przedmioty codziennego użytku

**Różnica między klasyfikacją a detekcją:**
- **Klasyfikacja**: "Co to jest?" - jedna kategoria dla całego obrazu
- **Detekcja**: "Gdzie to jest?" - wiele obiektów z lokalizacjami

**Przykłady użycia:**
- Katalogowanie zdjęć (automatyczne tagowanie)
- Rozpoznawanie gatunków roślin i zwierząt
- Sortowanie obrazów według kategorii
- Edukacja - nauka nazw obiektów

## Wymagania wstępne

* Urządzenie z dostępem do internetu i przeglądarką Chrome, Firefox lub Safari
* Dla urządzeń iOS: iOS 16 lub nowszy
* Kamera internetowa (opcjonalnie, do klasyfikacji na żywo)

## Uruchomienie demo

Demo na żywo i kod są dostępne na Codepen.

**Jak korzystać z demo:**
1. Kliknij link poniżej, aby otworzyć demo
2. Wybierz jeden z przykładowych obrazów
3. Lub prześlij własny obraz
4. Lub włącz kamerę, aby klasyfikować obiekty przed kamerą
5. Zobacz wyniki - aplikacja pokaże top 5 najbardziej prawdopodobnych kategorii z pewnością klasyfikacji!

[Zobacz przykład na Codepen](https://codepen.io/mediapipe-preview/pen/BaVZejK)

**Dla studentów - eksperymentuj:**
- Spróbuj różnych obrazów (zwierzęta, pojazdy, rośliny)
- Porównaj wyniki dla podobnych obiektów
- Zobacz, jak pewność klasyfikacji zmienia się dla niejednoznacznych obrazów
- Naucz się, jak integrować klasyfikator ze swoją stroną internetową
