import javax.swing.JFrame;

public class NowaRamka extends JFrame {

    public NowaRamka(JFrame parent) { //nasz kostruktor bedzie przyjmowal JFrame rodzica App.java (ramki wyzej)
        //mozemy sprawdzic jakie wielkosci ma rodzic
        initComponents();

        //Nowa ramka stworzy sie w srodku rodzica
        int width = (int)parent.getBounds().getWidth(); //pobieramy rozmiar rodzica, szerokosc - App.java
        int height = (int)parent.getBounds().getHeight();
        //kod z A2CentrowanieRamki
        //int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        //int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        //setSize(width/2, height/2); // 1/4 ekranu

        int widthRamki = this.getSize().width; //pewniak, zawsze bedzie na srodku ekranu
        int heightRamki = this.getSize().height;
        //
        setLocation(parent.getBounds().x+(width-widthRamki)/2, parent.getBounds().y+(height-heightRamki)/2);
    }

    private void initComponents() {

        this.setTitle("New App: "+(++i));
        this.setBounds(200, 200, 270, 190);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    //stworzymy statyczna zmienna - ktora zawsze istnieje
    static int i = 0;

//     public static void main(String[] args) throws Exception {
//         new App().setVisible(true);
//     }
}

