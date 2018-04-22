package com.company;

public class Motocykl extends Pojazd {
    private boolean homologacja;
    private String marka;

    public Motocykl(double capacity, String nazwa, boolean homologacja, String marka) {
        super(capacity, nazwa);
        this.homologacja=homologacja;
        this.marka=marka;
    }

    public Motocykl(double dlugosc, double szerokosc, double wysokosc, String nazwa, boolean homologacja, String marka) {
        super(dlugosc, szerokosc, wysokosc, nazwa);
        this.homologacja=homologacja;
        this.marka=marka;
    }

    @Override
    public String toString() {
        return "Motocykl{" +
                "homologacja=" + homologacja +
                ", marka='" + marka + '\'' +
                '}';
    }
}
