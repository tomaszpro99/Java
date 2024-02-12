package metodygeneryczne;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sound.sampled.AudioFileFormat.Type;

class Edytor {

    public static void wypisz(List<? extends Figura> lista) { //bedzie mogla miec w sobie roznego rodzaju typy
        for (Figura figura : lista) //: z kolejki, listy, tablicy "lista"
            System.out.println(figura.pobierzNazwe());

        lista.add(null);

        System.out.println("-----------------------");

        for (Figura figura : lista) { //: z kolejki, listy, tablicy "lista"
            
            if (figura == null) {
                
                System.out.println("null");
                break;
    
            } 
            System.out.println(figura.pobierzNazwe());
        }
    } 
    public static <T extends Figura> void wypisz2(List<T> lista) { //bedzie mogla miec w sobie roznego rodzaju typy
        for (T figura : lista) //: z kolejki, listy, tablicy "lista"
            System.out.println(figura.pobierzNazwe());

        //dodajemy cos rozszerzonego z figura:
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());

        lista.add(null);

        System.out.println("-----------------------");

        for (T figura : lista) { //: z kolejki, listy, tablicy "lista"
            
            if (figura == null) {
                
                System.out.println("null");
                break;
    
            } 
            System.out.println(figura.pobierzNazwe());
        }
    }
    public static <Type,K> void przepiszTabliceDoKolekcji(Type[] tab, Collection<Type> c) {
        
        for(Type nazwa: tab)
            c.add(nazwa);
    }
}

class Figura <K> {

    K zmienna;
    public String pobierzNazwe() {
        return nazwa;
    }
    String nazwa = "";
}
class Kolo extends Figura {

    public Kolo() {
        super.nazwa = "Kolo";
    }
}
class Kwadrat extends Figura {

    public Kwadrat() {
        super.nazwa = "Kwadrat";
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        
        Figura figura1 = new Kolo();
        Figura figura2 = new Kwadrat();

        List<Figura> listaFigur = new ArrayList<Figura>();
        listaFigur.add(figura1);
        listaFigur.add(figura2);

        Edytor.wypisz2(listaFigur);
    
        Float[] fl = new Float[50];
        Integer[] in = new Integer[50];
        Number[] nu = new Number[50];
        Collection<Number> cn = new ArrayList<Number>();

        Edytor.przepiszTabliceDoKolekcji(fl, cn);

    }
}
