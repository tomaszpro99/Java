package WewnetrzneRamki;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import java.awt.*;

public class App extends JFrame {

    public App() {

        initComponents();

    }

    public void initComponents() {

        this.setTitle("WewnetrzneRamki");
        this.setBounds(200, 200, 320, 240);

        JInternalFrame wewnetrznaRamka = new JInternalFrame("TYTUL",true,true ,true, true);  //WEWNETRZNA RAMKA
        wewnetrznaRamka.add(new JButton("TEST"),BorderLayout.CENTER);
        wewnetrznaRamka.setVisible(true);
        wewnetrznaRamka.pack(); //posortowanie
        //wewnetrznaRamka.setFrameIcon(null);
         
        JInternalFrame wewnetrznaRamka2 = new JInternalFrame("TYTUL2",true,true ,true, true);  //WEWNETRZNA RAMKA
        wewnetrznaRamka2.add(new JLabel("TEST2"),BorderLayout.CENTER);
        wewnetrznaRamka2.setVisible(true);
        wewnetrznaRamka2.pack(); //posortowanie
        //wewnetrznaRamka.setFrameIcon(null);

        wewnetrznaRamka2.addInternalFrameListener(new InternalFrameListener() { //ktos kliknie i zostnie stworzony nowy obiekt ktory bedzie obslugiwany
            public void internalFrameOpened(InternalFrameEvent e){
                System.out.println("Otwarte");
            }
            public void internalFrameClosing(InternalFrameEvent e){ //tworzymy okno dialogowe ktore przyjmuje komendy
                //System.out.println("Zamykanie");
                String odp = JOptionPane.showInternalInputDialog(e.getInternalFrame(), "Wpisz 'zamknij'(okno), lub 'wyjscie'(app)");

                if(odp != null)
                    if(odp.equals("wyjscie"))
                        System.exit(0);
                    else if (odp.equals("zamknij"))
                        e.getInternalFrame().dispose();
            }
            public void internalFrameClosed(InternalFrameEvent e){
                System.out.println("Zamkniecie");
            }
            public void internalFrameIconified(InternalFrameEvent e){
                System.out.println("minimalizacja");
            }
            public void internalFrameDeiconified(InternalFrameEvent e){
                System.out.println("maksymalizacja");
            }
            public void internalFrameActivated(InternalFrameEvent e){
                System.out.println("aktywacja");
            }
            public void internalFrameDeactivated(InternalFrameEvent e){
                System.out.println("dezaktywacja");
            }

        });

        desktopPane.add(wewnetrznaRamka);
        desktopPane.add(wewnetrznaRamka2);
        this.getContentPane().add(desktopPane, BorderLayout.CENTER); // dodajemy szybke z wewnetrzna ramka w desktopPane
        this.setDefaultCloseOperation(3);
    }


    private JDesktopPane desktopPane = new JDesktopPane(); //taka wewnetrzna ramke wklada sie w taki specjalny Pane, JDesktopPane



    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);
    }
}