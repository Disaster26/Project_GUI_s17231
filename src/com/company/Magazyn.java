package com.company;

import java.util.ArrayList;

public class Magazyn {
    private String adres;
    private ArrayList<Pomieszczenie> pomieszczenia;

    public Magazyn(String adres){
        this.adres=adres;
        pomieszczenia=new ArrayList<>();
    }

    public String toString() {
        return "Adres: "+ adres+"Pomieszczenia: " + pomieszczenia;
    }
}
