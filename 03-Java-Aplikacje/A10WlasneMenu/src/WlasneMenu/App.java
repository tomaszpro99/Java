package WlasneMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class App extends JFrame {
    public App() {
        initComponents();
    }

    public void initComponents() {

        this.setTitle("App");
        this.setBounds(200, 200, 320, 240);

        panelMenu.setLayout(new GridLayout(3,1));//siatkowy wiesze kolumny

        panelMenu.add(menu1);
        panelMenu.add(menu2);
        panelMenu.add(menu3);

        kontener.add(panelMenu);
        this.setDefaultCloseOperation(3);
    }


    private Container kontener = this.getContentPane();
    private JPanel panelMenu = new JPanel();
    private MenuButton menu1 = new MenuButton("1. Dodaj");
    private MenuButton menu2 = new MenuButton("2. Usuń");
    private MenuButton menu3 = new MenuButton("3. Edytuj");
    private int i = 0; //przenosimy tutaj i zeby bylo identyczne dla wszystkich buttonow

    //wlasna klasa 
    private class MenuButton extends JButton implements FocusListener, ActionListener { //fokus myszy

        //konstruktor   //("1. Dodaj"); ("2. Usuń"); ("3. Edytuj");
        public MenuButton(String nazwa) {

            super(nazwa); //wywoluje konstruktor wyzej polozony //przesylamy string wyzej

            this.addActionListener(this); //AcionListener this, w tym samym obiekcie MenuButton

            this.addFocusListener(this); //obsluga sluchacza jest w obiekcie
            this.addKeyListener(new KeyAdapter() { //implementujemy wszystkie abstrakcyjne metody
                //dodajemy sluchacz klawiszy 

                //public void keyTyped(KeyEvent e) { // klawisz wcisniety kolejnsc: Prassed, Typed, Released
                //} //nieuzywamy, poniewaz chcemy ustawic jedynie strzalki
                // zmieniamy KeyListener na KeyAdapter zeby jedynie nadpisac klase
    
                @Override //nadpisujemy
                public void keyPressed(KeyEvent e) { // wlasnie naciskany

                    keyPressedHandler(e); //klasa nizej
                }

                //public void keyReleased(KeyEvent e) { // po nacisnieciu
                //}
                
        });
            this.setBackground(kursorFocusDefoult);
        }

        //implementujemy abstrakcyjne metody FokusListener
        public void focusGained(FocusEvent e) {
            this.setBackground(kursorFocusGained);
        }

        public void focusLost(FocusEvent e) {
            this.setBackground(kursorFocusDefoult);
        }

        private Color kursorFocusGained = Color.GRAY;
        private Color kursorFocusDefoult = Color.WHITE;

        private void keyPressedHandler(KeyEvent e) {//jezeli ktos cos nacisnie, cos ma sie stac
        
            int dlugosMenu = panelMenu.getComponentCount(); //pobierz ilosc komponentow

            if (i==0) i = 10*dlugosMenu; //usuniecie bledu: zeby przez strzalkeUP wartosc nie spadla ponizej 0 +10x zapas
            if(e.getKeyCode() == KeyEvent.VK_DOWN) //jezeli przysle nam kod klawisza(getKeyCode) == Virtualnemu Key Dół
            {
                //System.out.println(++i);
                //panel to komponent, pobieramy z niego komponent
                panelMenu.getComponent(++i%dlugosMenu).requestFocus();  //pierwszy 0 - menuButton 1
                // 0%3 = 0, 1%3 = 1, 2%3 = 2, 3%3 = 0, 4%3 = 1
            } 
            else if(e.getKeyCode() == KeyEvent.VK_UP) //jezeli wcistnieta zostala strzalka w gore
            {
                //System.out.println(--i);
                panelMenu.getComponent(--i%dlugosMenu).requestFocus(); 
            }
            else if(e.getKeyCode() == KeyEvent.VK_ENTER) // Enter
            {
                //MenuButton temp = (MenuButton)e.getSource(); //nizej szybciej 
                //pobierz zrodlo, obiekt rzutujac na MenuButton //dostep do obiektu który wywolal keyPressedHandler -> KeyEvent e
                //temp.doClick(); //zasumuluj wcisniecie myszy //nizej szybciej 

                ((MenuButton)e.getSource()).doClick();
                //1. pobieramy kto wywolal e.getSource()
                //2. rzutujemy (MenuButton)
            }   //3. zrzutowana wartosc ((MenuButton)e.getSource()) wywulujemy metode nizej w hierarchi .doClick();
        
        }
        //abstrakcyjna metoda ActionListener
        public void actionPerformed(ActionEvent e) {
            //System.out.println("Akcja");    /okienko
            JOptionPane.showMessageDialog(this, ((MenuButton)e.getSource()).getText()/* "akcja"*/); //statyczna zmienna JoptionPane, ktora wyswietli nam dialog
        } //pobiera text buttona i go wyswietla w okienku
    }

    public static void main(String[] args) {
        
        new App().setVisible(true);
    }
}
