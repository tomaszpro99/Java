package powiazanaHashMapaIZbior;

//klucz - wartość 

//y = - x ^ 2

//x =  2, y = -4 //klucz jest niepowtarzalny i przenosi tylko w 1 miejsce
//x = -2, y = -4

// tab['klucz'] = wartosc; //php - Tablica asocjacyjna/skojarzeniowa 
import java.util.*;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args)  {

        //integer ma juz hashCode
        LinkedHashMap<Integer, Pracownik> mapa = new LinkedHashMap(); 
        //LinkedHashMap - elementy beda pokazywane w kolejnosci w jakiej my je dodamy
        //LinkedHashSet - nie mapa a pojedynczy zbior, czyli przyporzadkowanie, reszta zasad dzialania prawie taka sama
        
        Pracownik[] pracownicy = {
          new Pracownik("Agnieszka"),  
          new Pracownik("Bartłomiej"),
          new Pracownik("Aleksander"),
          new Pracownik("Arkadiusz"),
          new Pracownik("Agnieszka"),  
          new Pracownik("Bartłomiej"),
          new Pracownik("Aleksander"),
          new Pracownik("Arkadiusz"),
          new Pracownik("Agnieszka"),  
          new Pracownik("Bartłomiej"),
          new Pracownik("Aleksander"),
          new Pracownik("Arkadiusz"),
          new Pracownik("Agnieszka"),  
          new Pracownik("Bartłomiej"),
          new Pracownik("Aleksander"),
          new Pracownik("Arkadiusz"),
          new Pracownik("Agnieszka"),  
          new Pracownik("Bartłomiej"),
          new Pracownik("Aleksander"),
          new Pracownik("Arkadiusz"),
          new Pracownik("Agnieszka"),  
          new Pracownik("Bartłomiej"),
          new Pracownik("Aleksander"),
          new Pracownik("Arkadiusz"),
          new Pracownik("Agnieszka"),  
          new Pracownik("Bartłomiej"),
          new Pracownik("Aleksander"),
          new Pracownik("Arkadiusz"),
        };
        
        for (Pracownik pracownik : pracownicy) //dla kazdego pracownik, z kolejkcji pracownicy
            mapa.put(pracownik.getID(), pracownik);  //mapa. poloz (ID, STRING imie)
        
        System.out.println(mapa); 
        System.out.println("============================ -3 ");   
        
        mapa.remove(3); //remove
        
        System.out.println(mapa); 
        System.out.println("============================ 4 -> 4 ");    
        
        mapa.put(4, new Pracownik("Asia")); //podmiana
        
        System.out.println(mapa); 
        System.out.println("============================ +3 ");     
        
        mapa.put(3, new Pracownik("Kacper")); //new   
        
        System.out.println(mapa); 
        System.out.println("============================");     
        
        //inna opcja, bez mapy, ladniej, do np tabeli
        for(Entry<Integer, Pracownik> wpis: mapa.entrySet()) { //dla kazdego entry wpis (Integer,Pracownik) z(:) pobranego mapa.entrySet

            System.out.println("ID pracownika: "+wpis.getKey());
            System.out.println("Imię pracownika: "+wpis.getValue().getImie());     
        }
        System.out.println("============================");
        /*
         * A = {4,5,6,7,8} subZbior
         * B = {5,6} podZbior, zbioru A
         * */
        
        TreeMap<Integer, Pracownik> mapaPosortowana = new TreeMap<Integer, Pracownik> (mapa); //dajemy `mapa` LinkedHashMap jako PARAMETR
        Map<Integer, Pracownik> subMapa = mapaPosortowana.subMap(0, 6); // od 1 do x+1 //0,6 wypisze 5ciu
        if (subMapa.isEmpty())
           System.out.println("PUSTO");
        else
        for(Entry<Integer, Pracownik> wpis: subMapa.entrySet()) {
           System.out.println("ID pracownika: "+wpis.getKey());
           System.out.println("Imię pracownika: "+wpis.getValue().getImie());     
        } 
    }
}
class Pracownik { //klasa pracownik
    public Pracownik() { //pracownik ma swoje ID
        i++;
        ID = i;
    }
    public Pracownik(String imie) {
        this();
        this.imie = imie;
    }
    public int getID() {
        return ID;
    }
    public String getImie() {
        return imie;
    }
    @Override
    public String toString() {
        return imie;
    }
    String imie;
    private int ID;
    public static int i = 0;
}