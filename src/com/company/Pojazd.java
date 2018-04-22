package com.company;

public abstract class Pojazd extends Przedmiot {

    public Pojazd(double capacity, String nazwa) {
        super(capacity, nazwa);
    }

    public Pojazd(double dlugosc, double szerokosc, double wysokosc, String nazwa) {
        super(dlugosc, szerokosc, wysokosc, nazwa);
    }
}
