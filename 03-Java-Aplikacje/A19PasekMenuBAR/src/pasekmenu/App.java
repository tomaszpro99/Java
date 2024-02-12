package pasekmenu;

import javax.swing.*;
import java.awt.event.*;

public class App extends JFrame
{
    public App()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Pasek Menu");
        this.setBounds(300, 300, 300, 200);
        this.setJMenuBar(pasekMenu);
        
        JMenu menuPlik = pasekMenu.add(new JMenu("Plik")); //pierwsza zakladka
        
        JMenuItem podMenuNowy = menuPlik.add(new JMenuItem("Nowy"));
        podMenuNowy.addActionListener(new ActionListener() { //Przedmiot zakladki ktory ma wykonuje Event po wybraniu

            public void actionPerformed(ActionEvent e) {
                System.out.println("Tu jest kod, który tworzy nowy plik");
            }
        });
        menuPlik.addSeparator(); //odstep w menu
        final JMenuItem podMenuZapisz = menuPlik.add(new JMenuItem("Zapisz"));
        menuPlik.add(new JMenuItem("Wczytaj")); //dodajemy do 1 zakldaki
        menuPlik.addSeparator(); //odstep w menu
        JMenu menuOpcje = new JMenu("Opcje"); //dodajemy do 1 zakldaki
        menuPlik.add(menuOpcje); //dodajemy zakladki w zakladce
        
        menuOpcje.add(new JMenuItem("Opcja 1")); //dodajemy w zakladce w zakladce
        menuOpcje.add(new JMenuItem("Opcja 2"));
        menuOpcje.add(tylkoDoOdczytu); 
        
        tylkoDoOdczytu.addActionListener(new ActionListener() { //Po aktywacji checkBox tylkoDoOdczutu
                                                        //zostanie wykonany event false dostepu do Zapisz
            public void actionPerformed(ActionEvent e)
            {
               if (tylkoDoOdczytu.isSelected())
                   podMenuZapisz.setEnabled(false);
               else 
                   podMenuZapisz.setEnabled(true);
            }
        });
        
        JMenu menuPomoc = pasekMenu.add(new JMenu("Pomoc")); //druga zakladka
        
        menuPomoc.add(new JMenuItem("FAQ")); //dodajemy do 2 zakldaki
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private JMenuBar pasekMenu = new JMenuBar(); // 1 Tworzymy pasek menu
    private JCheckBoxMenuItem tylkoDoOdczytu = new JCheckBoxMenuItem("Tylko do odczytu"); //checkbox tylkoDoOdczytu
    //private JRadioButtonMenuItem radio;
    public static void main(String[] args)
    {
        new App().setVisible(true);
    }
    

}

