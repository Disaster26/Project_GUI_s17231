package com.company;

import java.util.Scanner;

public class Rower extends Pojazd {
    private int liczba_przerzutek;
    private String typ_hamulca;
    private boolean amortyzacja;
    private int liczba_amortyzatorow;

    public Rower(double capacity, String nazwa, int liczba_przerzutek, String typ_hamulca, boolean amortyzacja, int liczba_amortyzatorow) {
        super(capacity, nazwa);
        this.liczba_przerzutek = liczba_przerzutek;
        this.typ_hamulca = typ_hamulca;
        this.amortyzacja = amortyzacja;
        if(amortyzacja)
            this.liczba_amortyzatorow = liczba_amortyzatorow;
        else
            this.liczba_amortyzatorow=0;
    }

    public Rower(double dlugosc, double szerokosc, double wysokosc, String nazwa, int liczba_przerzutek, String typ_hamulca, boolean amortyzacja, int liczba_amortyzatorow) {
        super(dlugosc, szerokosc, wysokosc, nazwa);
        this.liczba_przerzutek = liczba_przerzutek;
        this.typ_hamulca = typ_hamulca;
        this.amortyzacja = amortyzacja;
        if(amortyzacja)
            this.liczba_amortyzatorow = liczba_amortyzatorow;
        else
            this.liczba_amortyzatorow=0;
    }

    @Override
    public String toString() {
        return "Rower{" +
                "liczba_przerzutek=" + liczba_przerzutek +
                ", typ_hamulca='" + typ_hamulca + '\'' +
                ", amortyzacja=" + amortyzacja +
                ", liczba_amortyzatorow=" + liczba_amortyzatorow +
                '}';
    }

}
