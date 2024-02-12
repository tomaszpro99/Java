package Zipper;
//import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class FileZipper extends JFrame
{
    public FileZipper()
    {
        this.setTitle("Zipper");
        this.setBounds(300, 300, 320, 240);
        this.setJMenuBar(pasekMenu); //ustawiamy pasekMenu jako MenuBar
        
        JMenu menuPlik = pasekMenu.add(new JMenu("Plik")); //tworzymy zakladke menuPlik Plik w masekMenu
             
        //Nasza klasa akcja
        Action akcjaDodawania = new Akcja("Dodaj", "Dodaj nowy wpis do archiwum", "ctrl D", new ImageIcon("A12ZipperInterface/dodaj.png"));
        Action akcjaUsuwania = new Akcja("Usuń", "Usuń zaznaczony/zaznaczone wpisy z archiwum", "ctrl U", new ImageIcon("A12ZipperInterface/usun.png"));
        Action akcjaZipowania = new Akcja("Zip", "Zipuj", "ctrl Z");
        
        JMenuItem menuOtworz = menuPlik.add(akcjaDodawania); //rozwijane Menu
        JMenuItem menuUsun = menuPlik.add(akcjaUsuwania);
        JMenuItem menuZip = menuPlik.add(akcjaZipowania);
        
        bDodaj = new JButton(akcjaDodawania); //dodajemy akcje 
        bUsun = new JButton(akcjaUsuwania);
        bZip = new JButton(akcjaZipowania);
        
        lista.setBorder(BorderFactory.createEtchedBorder()); //dodanie krawedzi
        GroupLayout layout = new GroupLayout(this.getContentPane()); //grupa layoyt
        
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup( //pierw poziomy widok
                layout.createSequentialGroup() //grupa sekwencyjna, od lewej
                .addComponent(lista, 100, 150, Short.MAX_VALUE) //lista + wymiary, rozszerzanie w nieskonczonosc
                .addContainerGap(0, Short.MAX_VALUE) //
                .addGroup( //grupa przyciskow, rownolegle
                layout.createParallelGroup().addComponent(bDodaj).addComponent(bUsun).addComponent(bZip)
                
                )
                );
        
        layout.setVerticalGroup( //pionowy widok
                layout.createParallelGroup() //rownolegle lista i grupa przyciskow
                .addComponent(lista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) //rozszerzanie w dol
                .addGroup(layout.createSequentialGroup().addComponent(bDodaj).addComponent(bUsun).addGap(5, 40, Short.MAX_VALUE).addComponent(bZip)) //sekwencja grupy buttonow
                );                                                                                      //przyklejenie ZIP do rogu
        
        this.getContentPane().setLayout(layout); //do ust layoutu
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pack(); //obetnie okienko
    }
    private JList lista = new JList(/*new String[] {"hej", "asd"}*/);
    private JButton bDodaj;
    private JButton bUsun;
    private JButton bZip;
    private JMenuBar pasekMenu = new JMenuBar();
    
    public static void main(String[] args)
    {
        new FileZipper().setVisible(true);
    }
    
    private class Akcja extends AbstractAction
    {
        public Akcja(String nazwa, String opis, String klawiaturowySkrot)
        {
            this.putValue(Action.NAME, nazwa); //nazwa 
            this.putValue(Action.SHORT_DESCRIPTION, opis); //opis przy najechaniu
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturowySkrot)); //skrot klaw string
        }
        public Akcja(String nazwa, String opis, String klawiaturowySkrot, Icon ikona) //konstruktor +icon
        {
            this(nazwa, opis ,klawiaturowySkrot);
            this.putValue(Action.SMALL_ICON, ikona); // +ikona, bo nie zawsze jest - uniwersalnosc
        }

        public void actionPerformed(ActionEvent e) //Akcje - uzycie klawiszy,
        {
           if (e.getActionCommand().equals("Dodaj")) //jezeli e.getAcionCommand().equals (jest rowny) "Dodaj"
               System.out.println("Dodawanie");             //wykonaj
           else if (e.getActionCommand().equals("Usuń"))
               System.out.println("Usuwanie");
           else if (e.getActionCommand().equals("Zip"))
               System.out.println("Zipowanie");
        }
        
    }
}
