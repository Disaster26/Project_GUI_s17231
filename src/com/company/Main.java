package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void zapis(Magazyn mag){
        File plik=new File("stanMagazynu.txt");
        try {
            PrintWriter zapis = new PrintWriter(plik);
            zapis.println(mag);
            Collections.sort(mag.getPomieszczenia());
            for(Pomieszczenie temp:mag.getPomieszczenia()) {
                //Collections.sort(temp.getPrzedmioty());
                zapis.println("        " + temp);
            }
            zapis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Pomieszczenie tablica[]={new Pomieszczenie(5,true),new Pomieszczenie(10,true),new Pomieszczenie(15,true),new Pomieszczenie(3,false),new Pomieszczenie(15,false),new Pomieszczenie(20,true),new Pomieszczenie(13.5,true),new Pomieszczenie(1,3,2,true),new Pomieszczenie(10,2,2,false),new Pomieszczenie(10,5,1,true)};
        ArrayList<Pomieszczenie> pomieszczenia= new ArrayList<>(Arrays.asList(tablica));
        Magazyn magazyn = new Magazyn("Warszawa, ul.Koszykowa 86",pomieszczenia);

        Osoba o1=new Osoba("Lesław", "Jasiński","44012959611", "ul. Deszczowa 50, 53-024 Wrocław","January 29, 1944");
        Osoba o2=new Osoba("Franciszek","Duda","69030696951","ul. Orzeszkowej Elizy 53, 42-400 Zawiercie", "March 6, 1969");
        Osoba o3=new Osoba("Marcin", "Kowalczyk", "82040837231", "ul. Poznańska 17, 93-134 Łódź", "April 8, 1982");
        Osoba o4=new Osoba("Alicja", "Nowak", "68021439182", "ul. Andrzeja Małkowskiego 42, 52-241 Wrocław", "February 14, 1968");
        Osoba o5=new Osoba("Basia", "Kaczmarek", "98110589269", "ul. Kątowa 58, 51-124 Wrocław", "November 5, 1998");

        zapis(magazyn);
    }
}
