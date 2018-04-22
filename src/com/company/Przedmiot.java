package com.company;

public class Przedmiot {
    private String nazwa;
    private int volume;

    public Przedmiot(int capacity, String nazwa){
        this.volume=capacity;
    }

    public Przedmiot(int dlugosc, int szerokosc, int wysokosc, String nazwa){
        this.volume=dlugosc*szerokosc*wysokosc;
    }
}
