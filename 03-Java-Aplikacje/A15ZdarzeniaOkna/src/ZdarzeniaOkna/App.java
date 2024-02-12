package ZdarzeniaOkna;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener; //Wylaczone WindowListener

public class App extends JFrame /*implements WindowListener */ {
//wylaczamy metody i tylko metoda witaj z implementacji

    public App() {
        initComponents();
    }

    public void initComponents() {

        this.setTitle("App");
        this.setBounds(200, 200, 320, 240);

        //this.addWindowListener(this); //dodajemy sluchacza(this - metody masz w tej klasie)
        //dodajemy windowAdapter() zaimpelentowane metody z WindowsListener
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) { //TUTAJ WITA TYLKO
                JOptionPane.showMessageDialog(rootPane,"witaj");
            }

        });

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //nic nie rob przy zamknieciu, przeba Confirm zaaceptowac  
    }

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JLabel etykieta = new JLabel("asd");


    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);
    }

    public void windowOpened(WindowEvent e) { // wywolane gdy zostanie otwarte okno
        JOptionPane.showMessageDialog(rootPane,"witaj");
    }

    
    public void windowClosing(WindowEvent e) { // wywolane gdy zamykamy okno
        int opcja = JOptionPane.showConfirmDialog(rootPane,"Chcesz zamknac?");
        
        //opcje showConfirmDialog w Definicji
        if(opcja == 0) /*yes*/ {this.dispose();} //zamknij

    }

    
    //metody abstrakcyjne //wylaczone bo wylaczone implements WindowListener

    public void windowClosed(WindowEvent e) { //ostatnie przed zamknieciem
        System.out.println("zapis danych");
    }


    public void windowIconified(WindowEvent e) {
        System.out.println("Minimalizacja");
    }

    
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Maksymalizacja");
    }

    
    public void windowActivated(WindowEvent e) {
        System.out.println("Okno aktywne");
    }

    
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Okno nieaktywne");
    }
}