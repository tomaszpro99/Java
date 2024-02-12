package xxx;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public App() {

        initComponents();

    }

    public void initComponents() {

        this.setTitle("App");
        this.setBounds(200, 200, 320, 240);


        this.setDefaultCloseOperation(3);
    }




    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);
    }
}


// import javax.swing.*;
// import java.awt.*;

// public class App extends JFrame {

//     public App() {

//         super("App");
//         this.setBounds(200, 200, 640, 480);

//         initComponents();

//         this.setDefaultCloseOperation(3);

//     }

//     public void initComponents() {

//     }

//     JButton button1 = new JButton("Button 1");
//     JButton button2 = new JButton("Button 2");
//     JButton button3 = new JButton("Button 3");
//     JButton button4 = new JButton("Button 4");



//     public static void main(String[] args) throws Exception {
        
//         new App().setVisible(true);
//     }
// }
