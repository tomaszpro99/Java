package EtykietyProstyZegarek;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

//Etykieta - nazwa dla jakiegos komponentu, uzytkowalna

public class App extends JFrame {

    public App() {

        super("Zegarek");
        this.setBounds(200, 200, 250, 100);

        initComponents();

        this.setDefaultCloseOperation(3);

    }

    public void initComponents() {

        panel.add(etykieta);
        panel.add(etykieta2);

        //czas.setText("czas");
        ActionListener stoper = new Zegar();
        Timer zegar = new Timer(1000, stoper); //(czas odswiezenia w ms = 1s, )
        zegar.start();

        this.getContentPane().add(panel);
    }

    JPanel panel = new JPanel();
    JLabel etykieta = new JLabel("Czas: ");
    JLabel etykieta2 = new JLabel(pobierzCzas());

    private class Zegar implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

            etykieta2.setText(pobierzCzas());
        }
    }
    static int i = 1; //statyczna zeby byla zawsze taka sama, bez zmiany przy tworzeniu nowego obiektu

    public String pobierzCzas() //stworzona aby usunac laga przy starcie
    {
        GregorianCalendar kalendarz = new GregorianCalendar();

            //zapisujemy wartosci w String
            String hour = ""+kalendarz.get(Calendar.HOUR_OF_DAY);
            String min = ""+kalendarz.get(Calendar.MINUTE);
            String sec = ""+kalendarz.get(Calendar.SECOND);

            // dodanie zera przed pojedyncza cyfra
            // Integer.parseInt() - przemiana String na Int
            if (Integer.parseInt(hour) < 10)
                hour = "0" + hour;
            if (Integer.parseInt(min) < 10)
                min = "0" + min;
            if (Integer.parseInt(sec) < 10)
                sec = "0" + sec;

        return hour + " : " + min + " : " + sec;
    }

    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);
    }
}
