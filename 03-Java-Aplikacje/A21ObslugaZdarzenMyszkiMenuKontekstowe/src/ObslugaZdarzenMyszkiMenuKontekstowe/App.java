package ObslugaZdarzenMyszkiMenuKontekstowe;
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
        this.setTitle("Menu Kontekstowe");
        this.setBounds(300, 300, 320, 240);
        
        final JPopupMenu menuKontekstowe = new JPopupMenu(); //menu kontekstowe
        
        menuKontekstowe.add(new JMenuItem(new AbstractAction("Zamknij") {

            public void actionPerformed(ActionEvent e) { //dzialanie zamknij
                System.exit(0);
            }
        }));
        menuKontekstowe.add(new JMenuItem("Kopiuj"));
        menuKontekstowe.add(new JMenuItem("Wklej"));
        
        
        testowiec.addMouseListener(new MouseAdapter() {
            //metody abstrakcyjne MouseListener
            //public void mouseClicked(MouseEvent e) -> Klick
            //public void mousePressed(MouseEvent e) -> Nacisk
            //public void mouseReleased(MouseEvent e) -> Zwolnienie
            //public void mouseEntered(MouseEvent e) -> Wszedlem
            //public void mouseExited(MouseEvent e) -> Odszedlem

            public void mouseReleased(MouseEvent e) { //-> Zwolnienie
                System.out.println("released");
                
                if (e.getClickCount() == 3 && e.getButton() == MouseEvent.BUTTON1 && e.isShiftDown()) //wykrywa v
                    JOptionPane.showMessageDialog(rootPane, "shift+LPM x3");
                
                if (e.isPopupTrigger())
                    menuKontekstowe.show(e.getComponent(), e.getX(), e.getY());
            }       //wyswietlamy menu kontekstowe, Component ktory wywolal - mysz, wspolrzedne

        });
       
        this.getContentPane().add(testowiec, BorderLayout.CENTER); //pusty panel wypelnia app
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

  
    private JPanel testowiec = new JPanel(); //pusty panel
    public static void main(String[] args)
    {
        new App().setVisible(true);
    }
    

}

