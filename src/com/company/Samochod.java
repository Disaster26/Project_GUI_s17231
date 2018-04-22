package com.company;

public class Samochod extends Pojazd {
    private String marka;
    private String engine;
    public Samochod(double capacity, String nazwa, String marka, String engine) {
        super(capacity, nazwa);
        this.marka=marka;
        this.engine=engine;
    }

    public Samochod(double dlugosc, double szerokosc, double wysokosc, String nazwa, String marka, String engine) {
        super(dlugosc, szerokosc, wysokosc, nazwa);
        this.marka=marka;
        this.engine=engine;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "marka='" + marka + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
