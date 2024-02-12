package animacjaWielowatkowaPlikuGraf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextHitInfo;
import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.*;

public class App extends JFrame //wielowatkowosc - zadanie wykonywane z innymi zadaniami //watek - zad
{
    public App() {
        this.setTitle("Animacja Pliku");
        this.setBounds(300, 300, 320, 240);
        panelAnimacji.setBackground(Color.GRAY); //zmiana koloru ekranu zeby byl widoczny
        
        JButton bStart = (JButton)panelButtonow.add(new JButton("Start")); //dodajemy przycisk rzutowany na JBuuton 
        bStart.addActionListener(new ActionListener() { //akcja - start animacji
            public void actionPerformed(ActionEvent e) //metoda abstract
            {
                startAnimation(); //wywolaj animacje
            }
        });

        JButton bStop = (JButton)panelButtonow.add(new JButton("Stop")); //dodajemy przycisk rzutowany na JBuuton
        bStop.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            {
                stopAnimation(); 
            }
        });
        
        this.getContentPane().add(panelAnimacji); //ekran
        this.getContentPane().add(panelButtonow, BorderLayout.SOUTH); //panel z przyciskiem na dole
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void startAnimation() {
        panelAnimacji.addPlikGraf(); //dodaj do ekranu PlikGraf
    }
    public void stopAnimation() {
        panelAnimacji.deletePlikGraf(); //dodaj do ekranu PlikGraf
    }
    private JPanel panelButtonow = new JPanel(); //przycisk
    private PanelAnimacji panelAnimacji = new PanelAnimacji(); //ekran
    public static void main(String[] args) 
    {
        new App().setVisible(true);
    }
    
    class PanelAnimacji extends JPanel //klasa zewnetrzna
    {
        public void addPlikGraf() {//wykonanie po nacisnieciu
            listaPlikowGraf.add(new PlikGraf()); //dodaj PlikGraf do listyPlikowGraf, teraz kazdy PlikGraf bedzie osobnym watkiem
                                            //podajemy cel watku
            watek = new Thread(grupaWatkow, new PlikGrafRunnable((PlikGraf)listaPlikowGraf.get(listaPlikowGraf.size()-1)) );
          /*Thread watek = new Thread(new Runnable() { //stworzymy klase wewnetrzna aby program byl przejrzystrzy 
                public void run() { //wykonaj
                    System.out.println("zostalem wywolany");
                }
            }); */
            watek.start();
            grupaWatkow.list();
        }
        public void deletePlikGraf() {
            grupaWatkow.interrupt(); //teraz przez dodanie grupy zatrzymamy wszystkie watki
        }

        @Override
        public void paintComponent(Graphics g) //paintComponent przyjmujacy grafike
        {
            super.paintComponent(g); //wywolywanie tego co bylo wyzej
            
            for (int i = 0; i < listaPlikowGraf.size(); i++) //dla wszystkich pozycji z listy
            {
                g.drawImage(PlikGraf.getImg(), ((PlikGraf)listaPlikowGraf.get(i)).x, ((PlikGraf)listaPlikowGraf.get(i)).y, null);
            }   //rysowanie PlikowGraf
        }
        ArrayList listaPlikowGraf = new ArrayList(); //lista przechowujaca PlikuGraf
        JPanel ten = this;
        Thread watek; //tworzymy tu watek aby byl dostepny wszedzie, zmienna lokalna
        ThreadGroup grupaWatkow = new ThreadGroup("Grupa PlikowGraficznych");
        public class PlikGrafRunnable implements Runnable {

            public PlikGrafRunnable(PlikGraf tempPlikGraf) {
                this.tempPlikGraf = tempPlikGraf;
            }


            @Override
            public void run() { //wykonywana podczas watek.start
                //listaPlikowGraf.add(new PlikGraf()); //dodaj PlikGraf do listyPlikowGraf //Teraz konstruktor przyjmuje watki PlikowGraf
                //for (int i = 0; i < 500; i++) {//wykona sie 2500 razy
                    //for(int j = 0; j < listaPlikowGraf.size(); j++) { //Teraz kazdy PlikGraf to osobny watek, nie robimy juz dla listy
                        //((PlikGraf)listaPlikowGraf.get(j)).ruszPlikGraf(ten); //pobiera PlikGraf i nia rusza(this - w jakim panelu)
                try {       
                    while(!Thread.currentThread().isInterrupted()) { //TERAZ bedzie wykonywac sie w nieskonczonosc dopoki watek nie zwroci bledu - czyli przepelni sie sleep
                    this.tempPlikGraf.ruszPlikGraf(ten);
                    repaint(); //taka sama metoda, mozemy skorzystac dzieki app wielowatkowej //bedzie odrysowywala
                        
                    Thread.sleep(1); //uspienie watku na 1milisek
                    }
                }
                catch (InterruptedException ex) { //error - przeszkodzenie watkowi
                    System.out.println(ex.getMessage());
                    listaPlikowGraf.clear(); //teraz EX czysci liste PlikowGraf
                    repaint(); //odswiez
                }
            } //mozemy stworzyc int i dodac go do while zeby np ograniczyc zywotnosc PlikuGraf
            PlikGraf tempPlikGraf;
        }
    }
}
class PlikGraf //klasa reprezentujaca PlikuGraf
{
    public static Image getImg() //pobiera Image
    {
        return PlikGraf.plikGraf; //zwraca z PlikGraf PlikGraf
    }
    public void ruszPlikGraf(JPanel pojemnik) //poruszanie PlikuGraf
    {
        Rectangle granicePanelu = pojemnik.getBounds(); //pobieramy granice pojemnika //zapisane przy pomocy Rectangle Prostokata
        x += dx; //o tyle bedzie poryszana  //szer, w prawo
        y += dy;                            //wys, w dol
        
        if (y + yPlikuGraf >= granicePanelu.getMaxY()) //czy y i yImg jest wieksza lub rowna max wysokosci panelu//czyli jak dotknie dolnej krawedzi
        {                                             
            y = (int)(granicePanelu.getMaxY()-yPlikuGraf);  //cofamy o wielkosc PlikuGraf, zeby grafika nie przeszla za granice, bo wspolrzedne to lewy gorny rog
            dy = -dy; //zmieniamy znak dla zmiany y i bedzie malec zamiast rosnac
        }      
        if (x + xPlikuGraf >= granicePanelu.getMaxX()) //czy x i xImg jest wieksza lub rowna max szerokosci panelu//czyli jak dotknie prawej krawedzi
        {
            x = (int)(granicePanelu.getMaxX()-xPlikuGraf); //cofamy o wielkosc PlikuGraf, zeby grafika nie przeszla za granice, bo wspolrzedne to lewy gorny rog
            dx = -dx; //zmieniamy znak dla zmiany x i bedzie malec zamiast rosnac
        }
        if (y < granicePanelu.getMinY()) //jezeli y bedzie mniejsze od zera
        {
            y = (int)granicePanelu.getMinY(); //ustaw y na najwyzszy piksel, na gorze
            dy = -dy; //odwroc znak
        }
        
        if (x < granicePanelu.getMinX()) //jezeli x bedzie mniejsze od zera
        {
            x = (int)granicePanelu.getMinX(); //ustaw x na pierwszy piksel, od lewej
            dx = -dx; //odwroc znak
        }
            
}
public static Image plikGraf = new ImageIcon("A3animacjaWielowatkowaPlikuGraf/kropelka.gif").getImage(); //przechowywanie PlikuGraf
    
int x = 0; //startowa pozycja PlikuGraf
int y = 0;
int dx = 1; //zmiana, o tyle bedzie sie zmienial x/y
int dy = 1;
int xPlikuGraf = plikGraf.getWidth(null); //rozmiar PlikuGraf, pobrany .get
int yPlikuGraf = plikGraf.getHeight(null); //x rosnie w prawo, y rosnie w dol
}

