package ramka;

import javax.swing.*;  //pakiet ktory pozwala wyrysowac ramki, javatextfiltr, ctrl c ctrl v, pozwala uruchamiac program na wielu systemach
//import java.awt.*; //awt - abstract window toolkit
 
public class App extends JFrame {

    public App() { //tworzymy konstruktor publiczny

/*         JFrame frame = new JFrame("DabieGarageGame"); //tworzymy ramke aplikacji
//        frame.setTitle("Tytul ramki"); //tytul ramki

//        frame.setSize(new Dimension(640,480)); //tworzymy nowy obiekt o rozmiarach, dimension znajduje sie w awt
//        frame.setSize(640,480);

//        frame.setLocation(new Point(100,50)); //lokalizacja - odleglosc od lewego gornego rogu
//        frame.setLocation(100,50);

        frame.setBounds(100, 50, 640, 480); //rozmiar i lokalizacja, awt     //Bounds - granice

        frame.setResizable(false); //mozliwosc powiekszenia ramki, maksymalizacji, domyslnie true

        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill proces podczas zamkniecia ramki
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //to samo 
        frame.setDefaultCloseOperation(3); //to samo //public static final int EXIT_ON_CLOSE = 3;

        frame.setVisible(true); //ustawiamy widocznosc ramki */

// tera uzylismy "extends JFrame" i mozemy latwiej pisac uzywajac this

        super("DabieGarageGame");

        this.setBounds(100, 50, 640, 480);
        this.setDefaultCloseOperation(3);

//        this.pack(); //powinno byc zawsze - pozwala wszystkim komponenta zeby pozstaly skatalogowane szybciej

    }

    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);; //tworzymy objekt za pomoca konstruktora App

    }
}
