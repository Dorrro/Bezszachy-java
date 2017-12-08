# Instrukcje

Bezszachy sa wariantem gry w szachy. Gra prowadzona jest przez dwoch graczy, nazywanych dalej bialym i czarnym, na szachownicy 8 na 8, za pomoca bierek szachowych.

Poczatkowe ustawienie figur na szachownicy jest takie samo, jak w zwyklych szachach. Pionkow w bezszachach nie uzywa sie.

Gracze wykonuja na przemian po jednym ruchu, zaczynajac od gracza bialego.

Figury bezszachowe poruszaja sie po szachownicy tak samo, jak szachowe.

W bezszachach, w odroznieniu od szachow, nie istnieja pojecia szachu i mata. Zabicie krola nie powoduje zakonczenia gry.

Gra konczy sie zwyciestwem jednego z graczy, gdy uda mu sie zabic wszystkie bierki przeciwnika. 
Gra konczy sie remisem, gdy gracz nie moze wykonac zadnego legalnego ruchu, choc pozostaly mu bierki. Remis oglaszamy rowniez, gdy gracze wykonaja 1000 ruchow.

Napisz w Pythonie program, ktory przeprowadzi losowa partie bezszachow. 
Program powinien wykonywac ruchy za obu graczy, za kazdym razem wybierajac losowo jeden sposrod dozwolonych w danej chwili ruchow. Wybor kazdego z legalnych ruchow powinien byc rownie prawdopodobny.

Program powinien, po kazdym ruchu, wypisywac na wyjscie stan szachownicy. Na zakonczenie partii nalezy wypisac informacje o wyniku - kto wygral, czy byl remis.

Program nalezy napisac obiektowo.

# Informacje dla osob, ktore nie znaja zasad gry w szachy:

Poslugujemy sie piecioma rodzajam figur:

* wieza - moze sie przesuwac po wierszu lub kolumnie szachownicy
* goniec - moze sie przesuwac po przekatnych szachownicy
* hetman - moze wykonywac ruchy takie, jak wieza lub goniec
* krol - moze wykonac ruch na jedno z sasiadnich pol, takze po przekatnej
* skoczek - moze wykonac ruch, zmieniajac numer wiersza o 2 a kolumny o 1 lub na odwrot. Jest jedyna bierka, ktora moze "przeskoczyc" nad innymi.

Jesli na polu, na ktore przestawiamy bierke, jest bierka przeciwnika, zabijamy ja, czyli zdejmujemy z szachownicy.

Poczatkowo na szachownicy w pierwszym wierszu sa figury gracza bialego, kolejno: wieza, skoczek, goniec, hetman, krol, goniec, skoczek, wieza. 
W ostatnim wierszu znajduja sie figury gracza czarnego, w tej samej kolejnosci.
