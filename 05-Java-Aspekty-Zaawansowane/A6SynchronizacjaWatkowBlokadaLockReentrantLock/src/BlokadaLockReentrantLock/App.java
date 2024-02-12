package BlokadaLockReentrantLock;
//poprzednio wszystkie watki wykonywaly sie asynchronicznie

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) throws InterruptedException {

        //Object lock = new Object();
        Lock lock = new ReentrantLock(); //klasa Lock jest interfejsem

        
        Thread watek1 = new Thread(new WypisanieRunnable(lock), "Watek 1"); 
        Thread watek2 = new Thread(new WypisanieRunnable(lock), "Watek 2");

        watek1.start();

        //watek1.join();
        System.out.println(Thread.currentThread().getName());
        System.out.println("print, po skonczonym watku2");
        
        watek2.start();
        
        // Counter licznik = new Counter();
        // Thread watek3 = new Thread(new CounterRunnable(licznik, false),"++");
        // Thread watek4 = new Thread(new CounterRunnable(licznik, true),"--");
        // watek3.start();
        // watek4.start();
    }
}

//program watkowy
class WypisanieRunnable implements Runnable {

    //public WypisanieRunnable(Object lock) { //przysylamy lock do konstruktora
    public WypisanieRunnable(Lock lock) {
        this.lock = lock;
    }
    static String msg[] = {"Synchroniczne wiadomosci start","1","2","3"}; //wiadomosci do synchronicznego wypisania
    
    @Override
    public void run() { //synchroniczne wypisanie tekstu //co rownomierny odstep czasu
        
        display(Thread.currentThread().getName());
    }
    public /*synchronized*/ void display(String threadName) { //synchroniczna!
        
        //synchronized(lock) {
        lock.lock(); //gdy watki wystartuja, watek1 zacznie wykonywac instrukcje, a watek2 musi zaczekac w kolejce bo jest lock
        try {
            for(int i = 0; i < msg.length; i++) {
                System.out.println(threadName+": "+msg[i]);

                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            lock.unlock();
        }
        //}
    }
    //private Object lock;
    private Lock lock;
}

class Counter { //licznik

    public void increaseCounter() { //metoda - powieksz licznik 
        counter++;
        System.out.println(Thread.currentThread().getName()+": "+counter);
    }
    public void decreaseCounter() { //metoda - powieksz licznik 
        counter--;
        System.out.println(Thread.currentThread().getName()+": "+counter);
    }
    private int counter = 50;
}
class CounterRunnable implements Runnable {

    public CounterRunnable(Counter licznik, boolean increase) {
        this.licznik = licznik;
        this.increase = increase;
    }
    public /*synchronized*/ void run() { //powiekszaj lub zmiejszaj licznik
        
        synchronized(licznik) { //teraz jak tu jest syncho - teraz wykonuje sie pierw watek3, potem4, juz sie nie mieszaja!
            for(int i = 0; i < 50; i++) {               //nie pojawi sie blad opisany na dole
                if (increase)
                    licznik.increaseCounter(); //++
                else
                    licznik.decreaseCounter(); //--
                try {
                    Thread.sleep(100);
                }
                catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    boolean increase; //powiekszaj lub zmiejszaj
    Counter licznik;
    
}

/* BRAK SYNCHRO:
 * counter = 5
 * Thread 1 - pobiera wartosc countera
 * Thread 2 - pobiera wartosc countera
 * Thread 1 - powieksza wartosc o 1
 * Thread 2 - pomniejsza wartosc o 1
 * Thread 1 - zapisuje counter 6 -- NIE ZAPAMIETANE!!! tak byc nie moze!
 * Thread 2 - zapisuje w te SAME miejsce counter 4
 * */