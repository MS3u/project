System Zarządzania Serwisem

Jest to system skierowany do firmy zajmujących się serwisowaniem sprzętu komputerowego. Wdrożenie tego systemu pozwoli usprawnić procesy przyjmowania zlecenia od klienta, naprawy i wydawania naprawionego sprzętu
Moduły z rozbiciem na funkcjonalności:

1. Zlecenia

    Przyjmowanie nowych zleceń       
    Generowanie protokołu w PDF

2. Magazyn

    Przeglądanie stanu magazynowego
    Dodawanie nowych przedmiotów
    Korekta stanu obecnych przedmiotów

3. Administracja

    Dodanie nowego użytkownika
    Aktualizacja danych użytkownika
    Zmiana hasła użytkownika
    Zmiana uprawnień użytkownika
    
 4. Serwis
    Przypisywanie serwisnata do zlecenia

Grupy uprawnień:

    Zlecenia
    Serwis
    Magazyn
    Administrator

Narzędzia i technologie:

    JavaFX
    MySQL
    IntelliJ
    GitHub
    Trello

Diagramy:
   * Diagram Aktywności
    ![diagram aktywnosci](https://github.com/MS3u/project/blob/master/UML/Activity%20Diagram1.jpg)
    * Diagram Klas
    ![diagram klas](https://github.com/MS3u/project/blob/master/UML/Class%20Diagram1.jpg)
    * Diagram Sekwencji
    ![diagram sekwecnji](https://github.com/MS3u/project/blob/master/UML/Diagram%20Sekwencji.jpg)
    * Diagram Przypadków Użycia
    ![diagram przypadków użycia](https://github.com/MS3u/project/blob/master/UML/useCaseDiagram.jpg)
Autorzy:

    Bartłomiej Kołodziej
    Damian Fryc
    Grzegorz Jagodziński
    Mateusz Szuwarowski
    Tomasz Kapuściński
    
## Omówienie aplikacji

Program do obługi serwisu komputerowego. 

* Logowanie
Pierwsze okno to ekran logowania, wpisujemu tutaj odpowiednie dane według opisu pol tekstowych, domyslny użytkownik to admin i haslo admin,
posiada on uprawnienia do przegladania całości

![Logowanie](https://github.com/MS3u/project/blob/new/src/main/PodrecznikPNG/login.png)

* Rejestracja
W przypadku nowego użytkownika możemy zarejestrować się, administrator weryfikuje daną osobe.


![Rejestracja](https://github.com/MS3u/project/blob/new/src/main/PodrecznikPNG/rejestracja.png)

* Panel Główny
Zalogowany użytkownik widzi panel główny programu, po weryfikacji dostępne jest boczne menu z wyborem odpowiedznich zakladek aministrator ma dostęp do wszystkich zasobów.
Poszczególne panele dostępne są dla pracowników z odpowidenim poziomem dostępu.

![Panel Główny](https://github.com/MS3u/project/blob/new/src/main/PodrecznikPNG/dashboard.png)

* Zlecenia
W tym oknie dokonujemy przyjecia zleceń,edycji,usuwania a także możemy wygenerować dokument pdf z zestawieniem zleceń.

![Zlecenia](https://github.com/MS3u/project/blob/new/src/main/PodrecznikPNG/Zlecenia.png)

* Administracja

Administrator sprawdza zarejestrowanych użytkowników, edytuje lub usuwa.

![Administracja](https://github.com/MS3u/project/blob/new/src/main/PodrecznikPNG/Administracja.png)

* Magazyn

W magazynie wprowadzamy nowy towar sprawdzamy stan modifikujemy stan badź usuwamy przedmioty.
![Magazyn](https://github.com/MS3u/project/blob/new/src/main/PodrecznikPNG/Magazyn.png)

* Serwis
Serwisant przypisuje do zlecenia odpowiedni sprzet z magazynu ustawia status dla danego zlecenia.
![Serwis](https://github.com/MS3u/project/blob/new/src/main/PodrecznikPNG/Serwis.png)











