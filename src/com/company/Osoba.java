package com.company;


public class Osoba  {

    private String imie;
    private String nazwisko;
    private String pesel;
    private String adres_zamieszkania;
    private String data_urodzenia;
    private String first_rent;

    public Osoba(String imie, String nazwisko,String pesel,String adres_zamieszkania,String data_urodzenia,String first_rent) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel=pesel;
        this.adres_zamieszkania=adres_zamieszkania;
        this.data_urodzenia=data_urodzenia;
        this.first_rent=first_rent;
    }


    public String toString() {
        return imie + " " + nazwisko+ " "+ "PESEL: "+ pesel+ "Adres zamieszkania: "+ adres_zamieszkania+ "Data urodzenia: "+ data_urodzenia+"Data pierwszego najmu: "+ first_rent;
    }

    public String getImie() {
        return imie;
    }
}

