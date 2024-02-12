package MetodyWaitOrazNotifyAll;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        Skrzynka skrzynka = new Skrzynka(); //tworzymy skrzynke
        
        MaszynaProdukujacaPrzedmioty maszyna1 = new MaszynaProdukujacaPrzedmioty(skrzynka); //towrzym watki
        MaszynaZmieniajacaSkrzynki maszyna2 = new MaszynaZmieniajacaSkrzynki(skrzynka);

        //tworzymy watek wzgledem maszyn
        Thread produkcja = new Thread(maszyna1, "Producent");
        Thread zmieniacz = new Thread(maszyna2, "Zmieniacz");

        produkcja.start();
        zmieniacz.start(); //zmieniacz skrzynek bedzie czekal az zapelni sie skrzynka (10) przedmiotow
    }
}
class MaszynaProdukujacaPrzedmioty implements Runnable {

    public MaszynaProdukujacaPrzedmioty(Skrzynka skrzynka) {
        this.skrzynka = skrzynka;
    }

    @Override
    public void run() {
        synchronized(skrzynka) { //synchro zeby wykoncac prorytetowo ten watek
            System.out.println(Thread.currentThread().getName()+": Zaczynam produkowac przedmioty"); //
            while(true) {
                //nie wolno tutaj if
                while(skrzynka.jestPelna()) { //jak skrzynka jest pelna to niech czeka
                    try {
                        System.out.println(Thread.currentThread().getName()+": Informuje ze przeba zmienic skrzynke, skrzynka pelna");
                        skrzynka.wait();
                        System.out.println(Thread.currentThread().getName()+": Nowa skrzynka, dodaje ponownie");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } 
                }
                System.out.println(Thread.currentThread().getName()+": Wyprodukowalem "+(++i)+" przedmiotow");
                skrzynka.dodaj(new Przedmiot()); //jak nie jest pelna, dodaj przedmiot do skrzynki
            
                skrzynka.notifyAll();
            }
        }
    }
    private Skrzynka skrzynka;
    private int i = 0;
}
class MaszynaZmieniajacaSkrzynki implements Runnable {

    public MaszynaZmieniajacaSkrzynki(Skrzynka skrzynka) {
        this.skrzynka = skrzynka;
    }

    @Override
    public void run() {
        synchronized(skrzynka) {
            System.out.println(Thread.currentThread().getName()+": Przygotowuje sie do zmiany skrzynki");
            while(true) {
                System.out.println(Thread.currentThread().getName()+": asd");
                while(!skrzynka.jestPelna()) //gdy skrzynka NIE jest pelna
                    try {
                        System.out.println(Thread.currentThread().getName()+": Skonczylem zmieniac skrzynki");
                        skrzynka.wait();     //zaczekaj
                        System.out.println(Thread.currentThread().getName()+": Powrocilem do zmiany skrzynki");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                skrzynka.pobierzIloscPrzedmiotow();
                skrzynka.zamianaSkrzynek();
                skrzynka.pobierzIloscPrzedmiotow();

                skrzynka.notifyAll(); //poinformuje poprzedni watek ze moze sie wrocic i sprawdzic
            }
        }
    }
    Skrzynka skrzynka;
}

class Skrzynka {

    //sprawdzamy pelna czy pusta
    public synchronized boolean jestPelna() {

        if(listaPrzedmiotow.size() == POJEMNOSC)
            return true;
        return false;
    }
    public synchronized int pobierzIloscPrzedmiotow() {
        System.out.println(Thread.currentThread().getName()+": akturalnie w skrzynce jest: "+this.listaPrzedmiotow.size());
        return this.listaPrzedmiotow.size();
    }
    public synchronized void dodaj(Przedmiot przedmiot){
        listaPrzedmiotow.add(przedmiot);
    }
    public synchronized void zamianaSkrzynek() {
        System.out.println(Thread.currentThread().getName()+": Zamieniam skrzynki");
        listaPrzedmiotow.clear();
    }
    private final int POJEMNOSC = 10; 
    ArrayList listaPrzedmiotow = new ArrayList(POJEMNOSC);
}
class Przedmiot {

}