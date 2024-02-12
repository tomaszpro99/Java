package A2Obiekto;

import F3AbstrakcyjneKlasyMetody.Potwor; 
import F3AbstrakcyjneKlasyMetody.Szkielet;
import F3AbstrakcyjneKlasyMetody.Zombie;
 
public class Ol16AbstrakcyjneKlasyMetody { //KOPIA Ol14Dziedziczenie, + Nadpisywanie Metod i Polimorfizm
      
    public static void main(String[] args) {
        
        
        Potwor P = new Szkielet(20,50,"Łuk"); //dostepne
        //Potwor Z = new Potwor();    //niedostepne przez klase absrakcyjna

        //Klasa abstrakcyjna = klasa do przesylania innych klas
        //Klasa wymagajaca od innych klas aby odpowiednio sie zachowywaly



        
        Zombie Z = new Zombie(); //warning
        System.out.println(P +""+ Z); //warning
 
    }    
    
}
