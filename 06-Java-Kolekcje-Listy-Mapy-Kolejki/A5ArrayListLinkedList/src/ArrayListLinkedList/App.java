package ArrayListLinkedList;

import java.util.ArrayList; 
// PLUS: SZYBKI DOSTĘP DO ZAWARTOSCI!
// MINUS: BARDZO WOLNA PRZY DODAWANIU NOWYCH ELMENTOW ORAZ USUWANIU ICH
import java.util.LinkedList; //linked - powiazana
// MINUS: WOLNE pobieranie WARTOSCI, wolne przeszukiwanie
// PLUS: BARDZO SZYBKA MOZLIWOSC DODAWANIA ORAZ USUWANIA ELEMENTOW 
//               - czyli tablica/kolekcja bedzie sie zmieniac

/* ArrayList;
 * PLUS: SZYBKI DOSTĘP DO ZAWARTOSCI!
 * MINUS: BARDZO WOLNA PRZY DODAWANIU NOWYCH ELMENTOW ORAZ USUWANIU ICH
 * -----
 * | 1  |
 * |    |
 * -----
 * -----
 * |    |
 * |  2 |
 * -----
 * -----
 * |    |
 * | 3  |
 * -----
 * -----
 * |    |
 * |  4 |
 * -----
 * -----
 * |  5 |
 * |    |
 * -----
 * -----
 * |    |
 * |  6 |
 * -----  ArrayList listaTablicowa = new ArrayList(6);
 * 
 * INNY OBIEKT
 * -----
 * |    |
 * |  7 |
 * -----
 
 *
 * LINKED LIST 
 * MINUS: WOLNE pobieranie WARTOSCI, wolne przeszukiwanie
 * PLUS: BARDZO SZYBKA MOZLIWOSC DODAWANIA ORAZ USUWANIA ELEMENTOW
 * 
 * -----
 * | 1  |
 * |    |
 * -----
 * 
 * INNY OBIEKT
 * -----
 * | 1  |
 * |    |
 * -----
 * 
 * INNY OBIEKT
 * -----
 * | 1  |
 * |    |
 * -----
 * 
 * 
 * -----
 * | 1  |
 * |    |
 * -----
 * 
 * INNY OBIEKT
 * INNY OBIEKTINNY OBIEKTINNY OBIEKTINNY OBIEKTINNY OBIEKTINNY OBIEKTINNY OBIEKTINNY OBIEKT
 * -----
 * | 20 |
 * |    |
 * -----
 * 
 * INNE OBIEKTY jest ich 400
 * ------
 * | 420 |
 * |     |
 * ------
 * */
class ListaPolaczona
{
    int wartosc;
    ListaPolaczona nastepna; //klasa rekurencyjna przez te wartosci
    ListaPolaczona poprzedni;
}

public class App
{
    public static void main(String[] args) 
    {
        ArrayList listaTablicowa = new ArrayList(6);
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        ListaPolaczona listaPolaczona = new ListaPolaczona();
        
        listaPolaczona.wartosc = 10; //ten na tego, ten na tego, jak LinkedList
        
        listaPolaczona.nastepna = new ListaPolaczona();
        listaPolaczona.nastepna.wartosc = 20;
        
        listaPolaczona.nastepna.nastepna = new ListaPolaczona();
        listaPolaczona.nastepna.nastepna.wartosc = 30;
        
        System.out.println(listaPolaczona.wartosc);
        System.out.println(listaPolaczona.nastepna.wartosc);
        System.out.println(listaPolaczona.nastepna.nastepna.wartosc);
    }
}
