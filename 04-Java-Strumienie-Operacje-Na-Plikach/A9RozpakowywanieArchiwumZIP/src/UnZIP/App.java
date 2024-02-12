package UnZIP;

import java.io.*;
import java.util.zip.*; //rzeczy do zip

public class App {

    public static final int BUFFOR = 1024; //temp

    public static void main(String[] args) {
        
        File katalog = new File(System.getProperty("user.dir")+File.separator+"A9RozpakowywanieArchiwumZIP/rozpakowanaPaczka");
        ZipEntry wpis = null;
        byte[] tempData = new byte[1024];

        try {

            if(!katalog.exists()) //jezli katalog nie istnieje
                katalog.mkdir(); //to go stwórz
        
            //otwieramy ZIPa za pomoca wejscia //czytanie danych
            ZipInputStream zInS = new ZipInputStream(new BufferedInputStream(new FileInputStream("A9RozpakowywanieArchiwumZIP/paczka.zip"),BUFFOR)); //z buffor szybciej - bufferedInputStream

            //pobierz nast wpis
            //zInS.getNextEntry(); //bedzie zwracac wpis zipowy, zwraca null jezeli nie ma juz zadnego entry
            while ((wpis = zInS.getNextEntry()) != null) {//podczas gdy wpis = przypisujemy do ZipEntry, jezeli rozne od null czyli cos jest w wpisie jest ok

                BufferedOutputStream fOutS = new BufferedOutputStream(new FileOutputStream(katalog+File.separator+wpis.getName()),BUFFOR); 
                //Tworzy puste pliki z nazwami
                //tera trzeba skopiowac wnetrze pliku

                int counter;
                while ((counter = zInS.read(tempData, 0, BUFFOR)) != -1) { //czytamy z zInS, tempData od 0 do Buffora rozne od -1
                    fOutS.write(tempData, 0, counter); //wpisujemy do fOutS tempData od 0 do countera
                }
            
                fOutS.close();
                zInS.closeEntry();
            }

            zInS.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

