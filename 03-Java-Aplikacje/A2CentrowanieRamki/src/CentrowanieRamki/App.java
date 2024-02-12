package CentrowanieRamki;

import javax.swing.*;

import java.awt.*;

public class App extends JFrame {
    public App() { 
        super("App");

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        //System.out.println(width + " " + height);
        setSize(width/2, height/2); // 1/4 ekranu
        
        //setLocation(width/4, height/4); //srodek ekranu
        
        int widthRamki = this.getSize().width; //pewniak, zawsze bedzie na srodku ekranu
        int heightRamki = this.getSize().height;
        setLocation((width-widthRamki)/2, (height-heightRamki)/2);

        this.setDefaultCloseOperation(3);
    }


    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);



    }
}
