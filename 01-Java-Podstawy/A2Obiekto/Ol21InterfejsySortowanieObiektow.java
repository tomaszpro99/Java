package A2Obiekto;

import java.util.Arrays;
import java.util.Collections;
import java.lang.Comparable;

public class Ol21InterfejsySortowanieObiektow {
//interface - jak klasa ale wszystkie METODY sa abstrakcyjne i publiczne, a wszystkie WLASCIWOSCI publiczne, finalne i statyczne    
// roznca: interfejsy sie implementuje

    public static void main(String[] args) {
    
        System.out.println(nazwaInterface.PI);

        //nazwaInterface x = new Worker(); //wylacz konstruktor z double w klasie Worker

        //x.getItem(); //nie dziala, trzeba zrobic rzutowanie:
        //((Worker)x).getItem(); //wylacz konstruktor z double w klasie Worker

        int[] Tablic = new int[3];
        Tablic[0] = 3; Tablic[1] = -4; Tablic[2] = 23;
        
        Arrays.sort(Tablic); //sortowanie!
        System.out.println(Tablic[0]); //wyswietli -4!!!

        /// inny przyklad arrays + compareTo //sortowanie tablicy pracownikow wg danej wartosci

        Workerzy[] worker = new Workerzy[3];

        worker[0] = new Workerzy(10);
        worker[1] = new Workerzy(1);
        worker[2] = new Workerzy(2);

        for (Workerzy W: worker)
        {
            System.out.println("przed sortem: " + W.getItem());
        }

        System.out.println(worker[1].compareTo(worker[2])); //WYNIK -1
        //Arrays.sort(worker);
        Arrays.sort(worker, Collections.reverseOrder()); //odwrocone sortowanie!

        for (Workerzy W: worker)
        {
            System.out.println("po sorcie: " + W.getItem());
        }
    }
}

interface nazwaInterface //nie moze byc publiczny, chyba ze jest konstruktorem pliku jak tutaj void main
{
    double PI = 3.14; // public static final
    void metodax(); //public abstract //metoda
}

interface drugiInterface {
}

class Workerzy implements nazwaInterface, drugiInterface, /*jedynie interface mozna Wielo-dziedziczyc*/ Comparable
{
    @Override
    public void metodax() {
    }
/* wylacz dla 1 przykladu*/
    Workerzy(double item) {
        this.item = item;
    }
/* */
    public double getItem() {
        return this.item;
    }
    private double item; 

    @Override //dla 2 przykladu arrays
    public int compareTo(Object o) {

        Workerzy drugi = (Workerzy)o;
                // 1 < 2
        if (this.item < drugi.item)
            return -1;  

        if (this.item > drugi.item)
            return 1;

        return 0;
    }
}
/* 
FAQ do lekcji "interfejsy oraz sortowanie obiektów"
Wiem że w kursie powiedziałeś sporo na temat Compare To , ale mam rozumieć ze ma to służyć do porównywania wartości które się znajdują np. w tabeli tak jak w wyżej pokazanym przez ciebie przykładzie? Czy są jeszcze jakieś inne tego zastosowania? Jeśli rozumiem to źle to mógłbyś mnie nakierować ?

Ogólnie idea polega na tym, że np. Człowiek którego obierzemy w klasę ma wiele cech(właściwości) i nie wiadomo jak komputer ma porównywać wartości.

My jako programiści decydujemy, czy chcemy porównywać po imieniu/wzroście/dacie urodzin etc. i robimy to w compareTo.

A robimy to w compareTo, aby pisać w standardzie, który będzie zrozumiany przez każdego programistę. No bo w sumie równie dobrze mógłbyś sobie zrobić sam funckje sortowania i stworzyć własne metody do porównań, jednak jak ktoś chciałby skorzystać z Twojego kodu to musiałby uczyć się wszystkie na nowo. A tak to piszesz w standardzie.

Tak więc kiedy korzystać z compareTo? Wtedy, gdy zaistnieje potrzeba porównywania/sortowania wartości. W programowaniu raczej nie staraj się myśleć na zasadzie: "compareTo stosujemy, gdy a) ... b)... c)... i koniec kropka" Zastanów się po co coś zostało stworzone. Gdy zrozumiesz po co to zostało stworzone to po prostu zastosujesz to, gdy poczujesz taką potrzebę :P
*/