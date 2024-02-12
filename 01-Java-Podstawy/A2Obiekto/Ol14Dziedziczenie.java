package A2Obiekto;

import F1Dziedziczenie.Potwor;
import F1Dziedziczenie.Szkielet;
import F1Dziedziczenie.Zombie;


public class Ol14Dziedziczenie { // Potwor -> zombie, szkielet
    
    public static void main(String[] args) {
        
        Potwor P = new Potwor(10,100);
        System.out.println(P.SPEED);
        
        Szkielet S = new Szkielet(20,50,"Łuk");
        System.out.println(S.SPEED);
        Zombie Z = new Zombie();
        System.out.println(Z.HP);
    }
}
