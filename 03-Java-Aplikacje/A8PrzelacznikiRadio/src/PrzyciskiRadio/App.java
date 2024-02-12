package PrzyciskiRadio;

import javax.swing.*;

import java.awt.*;
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Font.*;

public class App extends JFrame {

    public App() {

        initComponents();

    }

    public void initComponents() {

        this.setTitle("Grupa przelacznikow Radio");
        this.setBounds(200, 200, 300, 200);
        panel2.add(etykieta);

        // JRadioButton malyPrzelacznik = new JRadioButton("Mały",true); //domyslnie odznaczony
        // JRadioButton sredniPrzelacznik = new JRadioButton("Średni",false);

        // malyPrzelacznik.addActionListener(new ActionListener() {
            
        //     public void actionPerformed(ActionEvent e) {

        //         etykieta.setFont(new Font("Monospaces", Font.BOLD, 15));
        //     }
        // });
        // groupSize.add(malyPrzelacznik);
        // groupSize.add(sredniPrzelacznik);

        // panel.add(malyPrzelacznik);
        // panel.add(sredniPrzelacznik);

        zbudujPrzelacznikRozmiar("Mały", 15);
        zbudujPrzelacznikRozmiar("Średni", 25);
        zbudujPrzelacznikRozmiar("Duży", 35);

        zbudujPrzelacznikKolor("Czerwony", Color.RED);
        zbudujPrzelacznikKolor("Zielony", Color.GREEN);
        zbudujPrzelacznikKolor("Niebieski", Color.BLUE);

        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(panel3, BorderLayout.CENTER);
        this.getContentPane().add(panel2, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(3);
    }

    public void zbudujPrzelacznikRozmiar(String nazwa, final int rozmiar) {
        JRadioButton przelacznik = new JRadioButton(nazwa);

        przelacznik.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {

                etykieta.setFont(new Font("Monospaces", Font.PLAIN, rozmiar));
            }
        });
        groupColor.add(przelacznik);
        panel.add(przelacznik);
    }
    public void zbudujPrzelacznikKolor(String nazwa, final Color kolor) {
        JRadioButton przelacznik = new JRadioButton(nazwa); //tworzymy przelacznik
        //dodajemy do niego sluchacza //no i tworzymy anonimowa klase
        przelacznik.addActionListener(new ActionListener() { // metoda abstrakcyjna
                
            public void actionPerformed(ActionEvent e) {

                etykieta.setForeground(kolor);
            }
        });
        groupSize.add(przelacznik);
        panel3.add(przelacznik);
    }


    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel etykieta = new JLabel("Coś");
    ButtonGroup groupSize = new ButtonGroup();
    ButtonGroup groupColor = new ButtonGroup();

    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);
    }
}
