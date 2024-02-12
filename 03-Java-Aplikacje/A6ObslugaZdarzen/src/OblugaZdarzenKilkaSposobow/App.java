package OblugaZdarzenKilkaSposobow;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*; //do oblugi zdarzen

public class App extends JFrame implements ActionListener { 
    //implements ActionListener - teraz implementujemy wszystkie abstrakcyjne metody

    public App() {

        super("App");
        this.setBounds(200, 200, 640, 480);

        initComponents();

        this.setDefaultCloseOperation(3);

    }

    public void initComponents() {

        kolorCzerwony = new JButton("Czerwony");
        kolorZielony = new JButton("Zielony");
        kolorCzarny = new JButton("Czarny");
        kolorBialy = new JButton("Bialy"); //implements ActionListener do App
        
        //zrodlo wywolujace zdarzenie, nasluchiwane przez wskazanego sluchacza
        kolorCzerwony.addActionListener(new sluchaczKolorow(Color.RED)); //dodaj sluchacz akcji
        kolorZielony.addActionListener(new sluchaczKolorow(Color.GREEN));

        //implements ActionListener do App
        kolorBialy.addActionListener(this); //jezeli podalismy this, podalismy obiekt "public class App extends JFrame implements ActionListener"
        // czyli bedzie oblugiwany przez metode na dole "public void actionPerformed(ActionEvent e)"

        panel.add(kolorCzerwony);
        panel.add(kolorZielony);
        budujButton("nie wiem po co ta nazwa", Color.BLUE);
        panel.add(kolorCzarny);
        panel.add(kolorBialy);

        kolorCzarny.addActionListener(new ActionListener() { //przyklad "na szybko"
            public void actionPerformed(ActionEvent e) { 
                panel.setBackground(Color.BLACK);
            }
        });

        this.getContentPane().add(panel);
    }

    JPanel panel = new JPanel();
    JButton kolorCzerwony; //komponent, zrodlo zdarzenia, od niego to powstalo, kazde zrodlo moze byc oblugiwane przez sluchacze
    JButton kolorZielony;
    JButton kolorCzarny;
    JButton kolorBialy; //implements ActionListener do App

    public void budujButton(String nazwa, Color k) { //rekomendowany sposob

        JButton przycisk = new JButton("Niebieski");
        //przycisk.addActionListener(new sluchaczKolorow(k));
        przycisk.addActionListener(new ActionListener() { // < klasa anonimowa
            
            public void actionPerformed(ActionEvent e) {

                panel.setBackground(k);
            }
        });

        panel.add(przycisk);
    }


    //sluchasz - obiekt ktory implementuej interface ktory ma dane zdarzenie
    class sluchaczKolorow implements ActionListener {

        public sluchaczKolorow(Color k) {
            this.kolor = k; //naszemu kolor zostanie przypisany k ktore bedzie przyslane
        }
        public void actionPerformed(ActionEvent e) {
            System.out.println("click");

            panel.setBackground(kolor);
        }

        Color kolor;
    }

    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);
    }

    //implements ActionListener - teraz implementujemy wszystkie abstrakcyjne metody
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == kolorBialy) //jezeli zrodlo jest rowne buttonowi kolorBialy
            panel.setBackground(Color.WHITE); //to zmien kolortla na bialy
        //else if dla nast koloru //ale tu tracimy na obiektowosci
    }
}
