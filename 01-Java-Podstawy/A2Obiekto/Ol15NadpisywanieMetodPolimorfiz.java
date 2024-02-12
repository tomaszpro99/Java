package A2Obiekto;

import F2NadpisywanieMetodPolimorfizm.Potwor;
import F2NadpisywanieMetodPolimorfizm.Szkielet;
import F2NadpisywanieMetodPolimorfizm.Zombie;

public class Ol15NadpisywanieMetodPolimorfiz { //KOPIA Ol14Dziedziczenie, + Nadpisywanie Metod i Polimorfizm
      
    public static void main(String[] args) {
        
        //Potwor P = new Potwor(10,100);
        //System.out.println(P.SPEED);
        
        //Szkielet S = new Szkielet(20,50,"Łuk");
        //System.out.println(S.SPEED);

        //Zombie Z = new Zombie();
        //System.out.println(Z.HP);

        //Polimorfizm - poli - wiele, morfizm - forma, wiele form        //rodzic moze wskazywac na dziecko
        Potwor P = new Szkielet(20,50,"Łuk"); //Klasa Potwór - rodzic, Klasa Szkielet - dziecko
        Potwor Z = new Zombie();    //Instancja - połączenie klas/metod
        //P.atak(); niedostepne przez protected, dostepne tam gdzie dziedziczenie      
        //System.out.println(Z.HP); niedostepne przez protected, dostepne tam gdzie dziedziczenie  

        //zmien na public - bedzie tu dostepne

                            System.out.println(P +""+ Z); //warning

    }    
    
}
