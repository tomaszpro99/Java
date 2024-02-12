package LinkedList; //linked - powiazana

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) throws Exception {

        LinkedList<String> listaPowiazana = new LinkedList<String>();

        listaPowiazana.add("1111");
        listaPowiazana.add("2222");
        listaPowiazana.add("3333");
        listaPowiazana.add("4444");

        // for (int i = 0; i < listaPowiazana.size(); i++) {
        //     System.out.println(listaPowiazana.get(i));  //zaczyna droge od poczatku za kazdym razem
        //     //malo efektywne, 0 - 1111 spoko, 1 - 2222 musi zapytac 0 o 1, 2 - 3333 musi zapytac 3 o 2.
        // }

        App.wypiszElementyListy(listaPowiazana);
    
        //Iterator<String> iter = listaPowiazana.iterator();
        ListIterator<String> iter = listaPowiazana.listIterator(listaPowiazana.size());

        //iter.next();
        //iter.remove(); //usuwa poprzednika

        while (iter.hasPrevious()) {
            System.out.println(iter.previous()); //wypisywanie na odwrot
            //iter.set("podmiana wszstkich wartosci na ten tekst");
        }
        //iter.next() //nastpeny
        iter.add("na poczatku, z next() drugi");

        App.wypiszElementyListy(listaPowiazana);

        
    }
    public static void wypiszElementyListy(LinkedList<?> lista) {

        //iterator - urzadzenie ktore skacze miedzy elementami
        Iterator iteratorListy = lista.iterator();
        while(iteratorListy.hasNext())
        System.out.println(iteratorListy.next());
        System.out.println();
    }
}
