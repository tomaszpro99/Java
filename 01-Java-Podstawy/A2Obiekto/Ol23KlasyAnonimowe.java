package A2Obiekto;

public class Ol23KlasyAnonimowe {
    
    public static void main(String[] args) {
/* 
        ZachowaniePoWcisnieciu z = new ZachowaniePoWcisnieciu() {

            @Override
            public void akcja() {
                System.out.println("klasa anonimowa");
            }
        };  
        z.akcja();
*/
        Przycisk1 x = new Przycisk1();

        x.dodajAkcje(new ZachowaniePoWcisnieciu() {

            @Override
            public void akcja() {
                System.out.println("klasa anonimowa");
            }
        });
    }
}

interface ZachowaniePoWcisnieciu {
    void akcja();
}

class Przycisk1 {
    void dodajAkcje (ZachowaniePoWcisnieciu z) {
        z.akcja();
    }
}

/*class Przycisk1 implements ZachowaniePoWcisnieciu
{
    @Override
    public void akcja() {
        System.out.println("przycisk 1");
    }
}

class Przycisk2 implements ZachowaniePoWcisnieciu
{
    @Override
    public void akcja() {
        System.out.println("przycisk 2");
    }
}*/

//przyklad przycisku
/*  JButton
 *  button.addActionListener (new ActionListener()) {
 *      public void actionPerformed(ActionEvent e)
 *      {
 *          // do something
 *      }
 *  }
 */ 
