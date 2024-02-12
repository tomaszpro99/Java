package kolejkizdarzen; //Event Queue

//poprostu przechowuje zdarzenia

import java.awt.*;
import javax.swing.*;

public class App extends JFrame { 
    public App() {
        this.setTitle("Event Queue");
        this.setSize(300, 300);
       
        this.getContentPane().add(combo, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) 
    {
        new App().setVisible(true);
        new Thread(new BezpiecznyWatekSwing()).start(); //dodatkowy watek z zewnatrz
    }
    final static JComboBox combo = new JComboBox();
}
class BezpiecznyWatekSwing implements Runnable {

    int i =  0;
    public void run() {
        while(i < 1000) {
            bezpiecznaEdycjaComboBoxa();
            
            try {
                Thread.sleep(1);
            } 
            catch (InterruptedException ex) { } //nic nie rob
        }
    }
    public void bezpiecznaEdycjaComboBoxa() {
        EventQueue.invokeLater(new Runnable() { //jezli edytujemy cos w interface z zewnatrz (dodatkowy watek) to uzywamy
        //EventQueue.invokeLater - wywolaj pozniej --tera dziala elegancko

            public void run() 
            {
                App.combo.insertItemAt("No."+i, 0);
                i++;
            }
        });
    }
}

