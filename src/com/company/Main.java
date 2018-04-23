package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    final static long MILISEC_A_DAY=86400000;

    public static void zapis(Magazyn mag){
        File plik=new File("stanMagazynu.txt");
        try {
            PrintWriter zapis = new PrintWriter(plik);
            zapis.println(mag);
            Collections.sort(mag.getPomieszczenia());
            for(Pomieszczenie temp:mag.getPomieszczenia()) {
                Collections.sort(temp.getPrzedmioty());
                zapis.println("        " + temp);
                for(Przedmiot p:temp.getPrzedmioty()){
                    zapis.println("                "+p);
                }
            }
            zapis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void checkexp(Magazyn mag){
        double waga=0;
        for(Pomieszczenie temp:mag.getPomieszczenia()) {
            if (temp.isCzywynajete()) {
                if (temp.getDni_wynajmu() != 0) {
                    for (Przedmiot p : temp.getPrzedmioty())
                        waga += p.getVolume();
                    if (temp.getData_rozp().getTime() + (temp.getDni_wynajmu() * MILISEC_A_DAY) < new Date().getTime()) {
                        for (Pomieszczenie check : mag.getPomieszczenia()) {
                            if (check.isCzywynajete()) {
                                if (check.getOwner().equals(temp.getOwner()) && check.getCapacity() >= waga)
                                    check.setPrzedmioty(temp.getPrzedmioty());
                            }
                        }
                        temp.setOwner(null);
                        temp.setCzywynajete(false);
                        temp.setDni_wynajmu(0);
                        temp.getPrzedmioty().clear();
                        temp.setData_rozp(null);
                    }
                }
            }
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
        LinkedList<Osoba> lista_os=new LinkedList<>();
        lista_os.add(o1);
        lista_os.add(o2);
        lista_os.add(o3);
        lista_os.add(o4);
        lista_os.add(o5);

        Przedmiot rower = new Rower(5,"Rowerek",5,"Tarczowy",true, 2);
        Przedmiot car= new Samochod(10,"Samochodzik" ,"BMW", "Diesel");
        Przedmiot pilka=new Przedmiot(2,"Piłka");
        Przedmiot motocykl=new Motocykl(7, "Motorek", true, "Harley");

        ArrayList<Przedmiot> przedmioty = new ArrayList<>();
        przedmioty.add(rower);
        przedmioty.add(car);
        przedmioty.add(pilka);
        przedmioty.add(motocykl);

        //START APLIKACJI
        Scanner czyt=new Scanner(System.in);
        int check_option=11;
        Osoba login=null;

        do{
            System.out.println("Witaj w programie obsługi magazynów. Dostęp do poszczególnych opcji nastepuje przez wpisanie odpowieniej cyfry i zatwierdzenie opcji ENTEREM");
            System.out.println("Aby wyjść z programu wybierz 0");
            System.out.println("Dostępne opcje: ");
            System.out.println("1. Zaloguj się na konto");
            System.out.println("2. Wyświetl wolne pomieszczenia");
            System.out.println("3. Pokaż wszystkie pomieszczenia");
            System.out.println("4. Wyświetl dane swojego konta");
            System.out.println("5. Zapisz stan magazynu do pliku");
            System.out.println("6. Włóż przedmiot do magazynu");
            System.out.println("7. Wyjmij z magazynu");
            try {
                check_option = czyt.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Wpisales zla opcje, konczymy na dzis");
                System.exit(1);
            }
            checkexp(magazyn); //SPRAWDZANIE UPLWYU CZASU WYNAJMU
            switch (check_option) {
                case 1:
                    if(login==null) {
                        int i = 1;
                        System.out.println("Wybierz swojego użytkowanika: ");
                        for (Osoba os : lista_os) {
                            System.out.println(i + ". " + os.getImie() + " " + os.getNazwisko());
                            i++;
                        }
                        check_option = czyt.nextInt();
                        if (check_option>0 && check_option < lista_os.size())
                            login = lista_os.get(check_option - 1);
                        else {
                            System.out.println("Wybrałeś złą opcje, logowanie na pierwszego użytkownika");
                            login = lista_os.get(0);
                        }
                    }
                    else
                        System.out.println("Wybrałeś już użytkownika");
                        System.out.println("");
                    break;
                case 2:
                    int i=1;
                    System.out.println("Dostępne pomieszczenia: ");
                    for(Pomieszczenie temp:pomieszczenia) {
                        if(!temp.isCzywynajete()){
                            System.out.println(i+". "+temp);
                        }
                        i++;

                    }
                    System.out.println("Aby wynająć, wybierz interesujące cię pomieszczenie i na ile dni chcesz wynająć:  ");
                    check_option=czyt.nextInt();
                    if(check_option>0&&check_option<=i) {
                        if (login == null)
                            System.out.println("Nie wybrałeś użytkownika");
                        else {
                            i=check_option;
                            System.out.println("Na ile dni chcesz wynająć: ");
                            check_option = czyt.nextInt();
                            if(check_option>0)
                                pomieszczenia.get(i - 1).wynajmij(login, check_option);
                            else
                                pomieszczenia.get(i - 1).wynajmij(login, 10);
                        }
                    }
                    break;
                case 3:
                    int j=1;
                    System.out.println("Pomieszczenia: ");
                    for(Pomieszczenie temp:pomieszczenia) {
                            System.out.println(j+". "+temp);
                        j++;
                    }
                    System.out.println("Wybierz aby wyświetlić: ");
                    check_option=czyt.nextInt();
                    if(check_option>0&&check_option<=j) {
                        System.out.println(pomieszczenia.get(check_option-1).getPrzedmioty());
                    }
                    break;
                case 4:
                    if(login==null) {
                        System.out.println("Nie zalogowałeś się na żadne konto");
                    }
                    else{
                        System.out.println(login);
                        for(Pomieszczenie temp:pomieszczenia) {
                            if(temp.isCzywynajete())
                            if (temp.getOwner().equals(login))
                                System.out.println(temp);
                        }
                    }
                    System.out.println("");
                    break;
                case 5:
                    zapis(magazyn);
                    System.out.println("Zapis wykonany pomyślnie");
                    System.out.println("");
                    break;
                case 6:
                    i=1;
                    Przedmiot temp=null;
                    boolean if_have=false;
                    if(login==null)
                        System.out.println("Nie zalogowałeś się na żadne konto");
                    else {
                        System.out.println("Dostępne przedmioty: ");
                        for(Przedmiot p:przedmioty) {
                            System.out.println(i + ". " + p);
                            i++;
                        }
                        System.out.println("Wybierz przedmiot: ");
                        check_option=czyt.nextInt();
                        if(check_option>0&&check_option<i) {
                            temp=przedmioty.get(check_option-1);
                            przedmioty.remove(check_option-1);
                        }
                        else {
                            System.out.println("Nie ma takiego przedmiotu");
                            break;
                        }
                        System.out.println("Wybierz pomieszczenie: ");
                        i=1;
                        for(Pomieszczenie temp1:pomieszczenia) {
                            if(temp1.isCzywynajete())
                                if (temp1.getOwner().equals(login)) {
                                    System.out.println(i + ". " + temp1);
                                    if_have=true;
                                }
                            i++;
                        }
                        if(if_have) {
                            check_option = czyt.nextInt();
                            try {
                                pomieszczenia.get(check_option - 1).putPrzedmiot(temp);
                            } catch (TooManyThingsException e) {

                            }
                        }
                        else
                            System.out.println("Nie masz żadnych wynajętych pomieszczeń");
                        System.out.println("");
                    }
                    break;
                case 7:
                    i=1;
                    if_have=false;
                    if(login==null)
                        System.out.println("Nie zalogowałeś się na żadne konto");
                    else{
                        System.out.println("Wybierz pomieszczenie: ");
                        for(Pomieszczenie p:pomieszczenia) {
                            if(p.isCzywynajete())
                                if (p.getOwner().equals(login)) {
                                    System.out.println(i + ". " + p);
                                    if_have=true;
                                }
                            i++;
                        }
                        if(if_have) {
                            check_option = czyt.nextInt();
                            i = check_option;
                            System.out.println("Wybierz przedmiot: ");
                            System.out.println(pomieszczenia.get(check_option - 1).getPrzedmioty());
                            check_option = czyt.nextInt();
                            pomieszczenia.get(i - 1).wyjmijPrzedmiot(check_option);
                        }
                        else
                            System.out.println("Nie masz żadnych wynajętych pomieszczeń");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Wybrałeś niepoprawną opcje");
                    System.out.println("");
                    break;

            }
        }
        while(check_option!=0);

    }
}
