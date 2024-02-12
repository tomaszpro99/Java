package Zipowanie;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
        Action akcjaDodawania = new Akcja("Dodaj", "Dodaj nowy wpis do archiwum", "ctrl D", new ImageIcon("A15ZipperArchiwizacjaIKompresjaZIP/dodaj.png"));
        Action akcjaUsuwania = new Akcja("Usuń", "Usuń zaznaczony/zaznaczone wpisy z archiwum", "ctrl U", new ImageIcon("A15ZipperArchiwizacjaIKompresjaZIP/usun.png"));
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
                .addComponent(scrollDoLista, 100, 150, Short.MAX_VALUE) //lista + wymiary, rozszerzanie w nieskonczonosc
                .addContainerGap(0, Short.MAX_VALUE) //
                .addGroup( //grupa przyciskow, rownolegle
                layout.createParallelGroup().addComponent(bDodaj).addComponent(bUsun).addComponent(bZip)
                
                )
                );
        
        layout.setVerticalGroup( //pionowy widok
                layout.createParallelGroup() //rownolegle lista i grupa przyciskow
                .addComponent(scrollDoLista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) //rozszerzanie w dol
                .addGroup(layout.createSequentialGroup().addComponent(bDodaj).addComponent(bUsun).addGap(5, 40, Short.MAX_VALUE).addComponent(bZip)) //sekwencja grupy buttonow
                );                                                                                      //przyklejenie ZIP do rogu
        
        this.getContentPane().setLayout(layout); //do ust layoutu
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pack(); //obetnie okienko
    }
    private DefaultListModel modelListy = new DefaultListModel() //tworzymy model listy
    {//rozszerzamy modelListy - klasa anonimowa (klasa anonimowa nie ma nazwy)
        
        @Override
        public void addElement(Object obj) { //rozszerzamy i uzywamy metody z klasy anonimowej zeby podmienic sciezki na same nazwy
            listaArray.add(obj); //dodaj obiekt do listy
            super.addElement(((File)obj).getName());      
        }
        @Override
        public Object get(int index) { //podmieniamy get, get zwroci index - sciezke z tablicy
            return listaArray.get(index); 
        }
        @Override
        public Object remove(int index) { //usuwamy tez sciezki z ArrayList
            listaArray.remove(index);
            return super.remove(index);
        }
        ArrayList listaArray = new ArrayList(); //klasa zachowujaca sie jak DefaultListModel, Lista tablicowa ktora przyjmuje jakiekolwiek elementy i mozna jej uzywac wszedzie
    
    };
    private JList lista = new JList(modelListy/*new String[] {"hej", "asd"}*/); //lista, okienko wybranych w app
    private JFileChooser wybieracz = new JFileChooser(); //okno wyboru
    private JScrollPane scrollDoLista = new JScrollPane(lista); //skrol do Jlist lista
    private JMenuBar pasekMenu = new JMenuBar();
    private JButton bDodaj;
    private JButton bUsun;
    private JButton bZip;
    
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
               
                dodajWpisyDoArchiwum(); //dodawanie cz1 


            else if (e.getActionCommand().equals("Usuń"))
               
                usunwanieWpisowZListy(); //usuwanie cz2

            else if (e.getActionCommand().equals("Zip"))
               
                stworzArchiwumZIP(); //zipowanie cz3
        }
        
        //uzycie dodaj
        private void dodajWpisyDoArchiwum() {
            wybieracz.setCurrentDirectory(new File(System.getProperty("user.dir")+File.separator+"15ZipperArchiwizacjaIKompresjaZIP")); //odpalamy nowe okno wyboru
            wybieracz.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); //bedziemy mogli wybierac pliki i katalogi
            wybieracz.setMultiSelectionEnabled(true); //multi selekcja
            
            int temp = //bedziemy sprawdzac - opcja czy cancel
            wybieracz.showDialog(rootPane, "Dodaj do archiwum asd"); //opcja wybrania pliku, obok cancel
        
            if (temp == JFileChooser.APPROVE_OPTION) {//poprzednie lekcje, jezeli jest 0 - opcja
                
                File[] sciezkiWybranychPlikow = wybieracz.getSelectedFiles(); //co wybrano, tablica sciezek do plikow
            
                for (int i = 0; i < sciezkiWybranychPlikow.length; i++) { //przejdziemy przez wszystkie sciezki
                    if(!czyWpisSiePowtarza(sciezkiWybranychPlikow[i].getPath())) //wykorzystujemy nasza metode sprawdzania powatrzania sciezek, wysylamy sciezke do testow
                        modelListy.addElement(sciezkiWybranychPlikow[i]); //dodajemy do modeluListy wybrane sciezki w JFileChooser wybieracz
                }
            }
        }
        private boolean czyWpisSiePowtarza(String testowanyWpis) { //testowany wpis

            for (int i = 0; i < modelListy.getSize(); i++){ //przejdzie przez cala liste 
                if(((File)modelListy.get(i)).getPath().equals(testowanyWpis)) { 
                //modelListy.wez(i) //zeby sie dostac, rzutowanie (File) 
                //teraz mozemy .getPath() (pobrac sciezke) //equals porownaj z testowanyWpis
                    return true; //jezeli sie powtarza, daj true
                }
            }
            return false; //zwykle zwraca false, jak sie powtorzy zwroci true
        }

        //uczycie usun
        private void usunwanieWpisowZListy() {

            //zbierze tablice zaznaczonych z listy
            int[] temp = lista.getSelectedIndices(); //Indices - zaznaczone wspolczynniki

            for (int i = 0; i < temp.length; i++) {
                //System.out.println(temp[i]); //wydrukuje liczbe zaznaczonych
                modelListy.remove(temp[i]-i); //usunie zaznaczone //-i bo kazdy nast indeks bedzie mniejszy o 1 z powodu wynonania i usuniecia, tablica sie przsuwa bo modyfikacji
            }
        }

        //uczycie stworzenia archiwum
        private void stworzArchiwumZIP() {

            wybieracz.setCurrentDirectory(new File(System.getProperty("user.dir")+File.separator+"A15ZipperArchiwizacjaIKompresjaZIP")); //odpalamy nowe okno wyboru
            wybieracz.setSelectedFile(new File(System.getProperty("user.dir")+File.separator+"A15ZipperArchiwizacjaIKompresjaZIP"+File.separator+"Zipek.zip"));
            int temp =
            wybieracz.showDialog(rootPane, "Zipuj!"); 

            if (temp == JFileChooser.APPROVE_OPTION) { //wybrano opcje

                /* A8ArchiwizacjaDanychZIP */
                byte tempData[] = new byte[BUFFOR];
                try {
                    //nazwa naszego zipa
                    ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(wybieracz.getSelectedFile()),BUFFOR));
                
                    for (int i = 0; i < modelListy.getSize(); i++) { //bedziemy sie poruszac po modeluListy

                        if (!((File)modelListy.get(i)).isDirectory()) { //jezeli zrzutowany modelListy na File, jest Katalogiem
                            
                            Zipuj(zOutS, (File)modelListy.get(i), tempData, ((File)modelListy.get(i)).getPath());
                        } 
                        else {
                            wypiszSciezki((File)modelListy.get(i)); //wypisz sciezki do ArrayList modelSciezki

                            for (int j = 0; j < listaSciezek.size(); j++) {         //kazda ze sciezek
                                Zipuj(zOutS, (File)listaSciezek.get(j), tempData, ((File)modelListy.get(i)).getPath());  //tworzymy
                            }

                            listaSciezek.removeAll(listaSciezek);
                        }

                    }
                    zOutS.close();
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        public static final int BUFFOR = 1024; //temp
        /* A8ArchiwizacjaDanychZIP */

        //tworzymy void Zipuj z /* A8ArchiwizacjaDanychZIP */ zeby zrobic porzadek //musimy dodac co ma przyjmowac
        private void Zipuj(ZipOutputStream zOutS, File sciezkaPliku, byte[] tempData, String SciezkaBazowa) throws IOException {

            //jak sie maja nazywac zipEntery //(modelListy.get(i)) zrzutowane na (File) potem .getPath() sciezka
            //BufferedInputStream inS = new BufferedInputStream(new FileInputStream(((File)modelListy.get(i)).getPath()), BUFFOR);
            BufferedInputStream inS = new BufferedInputStream(new FileInputStream(sciezkaPliku), BUFFOR);     

            //zOutS.putNextEntry(new ZipEntry(((File)modelListy.get(i)).getName()));
            //zOutS.putNextEntry(new ZipEntry(sciezkaPliku.getName()));
            zOutS.putNextEntry(new ZipEntry(sciezkaPliku.getPath().substring(SciezkaBazowa.lastIndexOf(File.separator)+1)));
                                                                    //bedziemy obcinac sciezke po(+1) ostatnim uzyciu file.separatora

            int counter; 

            while ((counter = inS.read(tempData, 0, BUFFOR)) != -1) 
                zOutS.write(tempData, 0, counter);
            
                zOutS.closeEntry();
            inS.close();

        }
        /* A1PikiKatalogi */
        private void wypiszSciezki(File nazwaSciezki) {
            String[] nazwyPlikowIKatalogow = nazwaSciezki.list(); //Tablica z nazwami Plikow i Katalogow
    
            for (int i = 0; i < nazwyPlikowIKatalogow.length; i++) { //petla przechodzaca przez wszystkie pozycje
    
                File p = new File(nazwaSciezki.getPath(), nazwyPlikowIKatalogow[i]); //pobieramy sciezke i dodajemy nazwy plikow, dla wszystikich plikow
                
                if (p.isFile()) //jezeli cos jest plikiem
                    listaSciezek.add(p); //dodajmy do listySciezek ta sciezke
                
                if (p.isDirectory()) //jezeli cos jest folderem
                    wypiszSciezki(new File(p.getPath()));
            }
        }
        /* A1PikiKatalogi */
        ArrayList listaSciezek = new ArrayList(); 
    }
}
