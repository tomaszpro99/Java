package ToolBarCursorColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {
    public App() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Pasek Narzędzi");
        this.setBounds(300, 300, 300, 200);
        pasekNarzedzi.add(new KolorowyButton(
                new ActionColor("Zmieniam kolor na zielony", new ImageIcon("zielony.gif"), Color.GREEN)));
        pasekNarzedzi.add(new KolorowyButton(
                new ActionColor("Zmieniam kolor na niebieski", new ImageIcon("niebieski.gif"), Color.BLUE)));
        pasekNarzedzi.add(new KolorowyButton(
                new ActionColor("Zmieniam kolor na czerwony", new ImageIcon("czerwony.gif"), Color.RED)));
        pasekNarzedzi.add(button);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //wyklacz kursor po wylaczeniu malowania
                aktywny = null;
            }
        });

        panel.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) { //nacisniecie
                if (aktywny != null) //jezeli jest inny niz null
                    panel.setBackground((Color) aktywny.getAction().getValue("kolor")); //zamiana koloru bacground panelu
            }
        });
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(pasekNarzedzi); // 1. dodajemy pasek narzedzi
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JToolBar pasekNarzedzi = new JToolBar("Nazwa Nowej ramki");
    private JButton button = new JButton("Wyłącz malowanie"); // button
    private JPanel panel = new JPanel();
    private KolorowyButton aktywny = null;

    private class ActionColor extends AbstractAction {
        public ActionColor(String toolTip, Icon icon, Color colour) {
            this.putValue(Action.SHORT_DESCRIPTION, toolTip);
            this.putValue(Action.SMALL_ICON, icon);
            this.putValue("kolor", colour);
        }

        public void actionPerformed(ActionEvent e) // jezeli ktos kliknie
        {
            aktywny = (KolorowyButton) e.getSource();
        }
    }

    private class KolorowyButton extends JButton {
        public KolorowyButton(final ActionColor actionColor) {
            super(actionColor);

            this.addActionListener(new ActionListener() { //ustawiamy mozliwosc wyboru 1 koloru

                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < pasekNarzedzi.getComponentCount(); i++) { //petla bedzie sie wykona dla wszystkich componentow
                        if (pasekNarzedzi.getComponent(i) instanceof KolorowyButton) { //jezeli Component paskaNarzedzi jest instancja Kolorowy Button, zeby robilo tylko kolory klawiszy i nie ruszalo: "Wylacz malowanie"
                            KolorowyButton tmp = (KolorowyButton) pasekNarzedzi.getComponent(i); //pobieramy komponent paska narzedzi, rzutujemy na Kolorowy button i przypisujemy do temp
                            tmp.setBackground(Color.WHITE);
                            tmp.setZaznaczony(false);
                            //rootPane.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));  //kursor krzyzak
                            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor( //kursor tylko w panelu, toolkit do customcursor
                                    new ImageIcon("ToolBarCursorColor/kursorek.png").getImage(), new Point(0, 0), "Nasz kursorek"));//kordy - pkt 0 kursora
                        }
                    }
                    ten.setBackground((Color) actionColor.getValue("kolor"));
                    ten.setZaznaczony(true);
                }
            });
        }

        public void setZaznaczony(boolean zazn) { //metoda zmieniajaca flage
            this.zaznaczony = zazn;
        }

        KolorowyButton ten = this;
        boolean zaznaczony = false; //flaga
    }

    public static void main(String[] args) {
        new App().setVisible(true);
    }

}
