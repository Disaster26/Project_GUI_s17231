package com.company;


import java.util.Date;

public class Osoba  {

    private String imie;
    private String nazwisko;
    private String pesel;
    private String adres_zamieszkania;
    private String data_urodzenia;
    private Date first_rent;

    public Date getFirst_rent() throws NeverRentException {
        if(first_rent.equals(null))
            throw new NeverRentException("Ta osoba nigdy nie wynajmowała pomieszczenia");
        else
            return first_rent;
    }

    public Osoba(String imie, String nazwisko, String pesel, String adres_zamieszkania, String data_urodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel=pesel;
        this.adres_zamieszkania=adres_zamieszkania;
        this.data_urodzenia=data_urodzenia;
    }


    @Override
    public String toString() {
        try {
            return "Osoba{" +
                    "imie='" + imie + '\'' +
                    ", nazwisko='" + nazwisko + '\'' +
                    ", pesel='" + pesel + '\'' +
                    ", adres_zamieszkania='" + adres_zamieszkania + '\'' +
                    ", data_urodzenia='" + data_urodzenia + '\'' +
                    ", first_rent=" + getFirst_rent() +
                    '}';
        } catch (NeverRentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getImie() {
        return imie;
    }
}

