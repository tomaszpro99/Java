package Zakladki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame
{
    public App()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Zakładki");
        this.setBounds(300, 300, 320, 240);
        
        zakladki.addTab("tab 1", new JLabel("to jest pierwszy")); //tworzymy 1 zakladke
        zakladki.setMnemonicAt(0, KeyEvent.VK_T);     
        
        JPanel panel = new JPanel();
        panel.add(new JButton("tescior"));  //tworzymy panel, dodajemy do niego przycisk i uzyway w tworzeniu zakladki
        zakladki.addTab("to jest drugi tab", new ImageIcon("videokurs.jpg"), panel, "Testowy test"); //tworzymy 2 zakladke
        
        
        zakladki.addTab("Video Kurs", panelTworzenia); //tworzymy 3 zakladke z panelemTworzenia do tworzenia zakladek
        panelTworzenia.add(new JLabel("Stwórz nowy plik o nazwie: ")); 
        final JTextField nazwaNowejZakladki = new JTextField(7);
        panelTworzenia.add(nazwaNowejZakladki);
        JButton stworzZakladke = new JButton("Stwórz");
        panelTworzenia.add(stworzZakladke);
        
        stworzZakladke.addActionListener(new ActionListener() {// Akcja tworzenia zakladek

            public void actionPerformed(ActionEvent e) 
            {
                JPanel panelTekstowy = new JPanel();
                panelTekstowy.setLayout(new GridLayout(1, 1));
                JTextArea obszarTekstowy = new JTextArea();
                panelTekstowy.add(new JScrollPane(obszarTekstowy));
                
                zakladki.addTab(nazwaNowejZakladki.getText()+".txt", panelTekstowy);
                zakladki.setSelectedIndex(zakladki.getTabCount()-1);
                
                obszarTekstowy.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e)
                    {
                        if (!(tytulZakladki+e.getKeyChar()).equals(przedZmianaObszaruTekstowego) && czyToAscii(e.getKeyChar()) && flagaZapisu)
                        {
                            przedZmianaObszaruTekstowego = tytulZakladki+e.getKeyChar(); //edytowany plik, niezapisany  asd.txt*                
                            zakladki.setTitleAt(indeksZakladki, tytulZakladki+"*");
                            flagaZapisu = false;
                            System.out.println("test"); 
                        }
                        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S && !flagaZapisu) //zapisywanie ctrl s
                        {
                            zakladki.setTitleAt(indeksZakladki, tytulZakladki);
                            System.out.println("Zapisujemy");
                            flagaZapisu = true;
                        }
                    
                    }
                    private boolean czyToAscii(char zn)
                    {
                        for (int i = 0; i < 255; i++)
                            if (zn == i)
                                return true;

                        return false;
                    }
                    String przedZmianaObszaruTekstowego = "";
                    int indeksZakladki = zakladki.getSelectedIndex();
                    String tytulZakladki = zakladki.getTitleAt(indeksZakladki);
                    boolean flagaZapisu = true;
                    
                });
                        
            }
        });
        
        zakladki.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT); //scrolowanie zakladek, w poziomie
        this.getContentPane().add(zakladki);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   
    private JTabbedPane zakladki = new JTabbedPane(); //zakladki
    private JPanel panelTworzenia = new JPanel(); //panel tworzenia
    public static void main(String[] args)
    {
        new App().setVisible(true);
    }
    

}

