package com.company;

import java.util.ArrayList;

public class Magazyn {
    private String adres;
    private ArrayList<Pomieszczenie> pomieszczenia;

    public ArrayList<Pomieszczenie> getPomieszczenia() {
        return pomieszczenia;
    }

    public Magazyn(String adres , ArrayList<Pomieszczenie> tab){
        this.adres=adres;
        pomieszczenia=tab;
    }

    @Override
    public String toString() {
        return "Magazyn{" +
                "adres='" + adres + '\'' +
                '}';
    }
}
