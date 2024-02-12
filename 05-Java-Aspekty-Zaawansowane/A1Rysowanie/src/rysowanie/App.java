package rysowanie;

import java.awt.*;
import javax.swing.*;

public class App extends JFrame
{
    public App()
    {
        this.setTitle("Rysowanie");
        this.setBounds(250, 300, 300, 250);
        
        this.getContentPane().add(panelDoRysowania);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) 
    {
        new App().setVisible(true);
    }
  
    private PanelRysowiak panelDoRysowania = new PanelRysowiak();
}
class PanelRysowiak extends JPanel
{
    public PanelRysowiak()
    {
        super();
        
        this.add(new JButton("Test"){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        });
    }  
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawString("Napis", 0, 8);
        
        g.drawImage(new ImageIcon("A1Rysowanie/kropelka.gif").getImage(), 140, 80, null);
        g.drawImage(new ImageIcon("A1Rysowanie/red.jpg").getImage(), 150, 100, null);
        
        g.drawRect(40, 40, 100, 100); //prostokat
        
        g.drawLine(60, 60, 180, 180); //linia, jeden i drugi punkt
        
        Graphics2D g2 = (Graphics2D)g;
        System.out.println(g2); //warning

        System.out.println(i++);
    } 
    public static int i = 0;
}
