package com.company;

public class Pomieszczenie {
    private int id;
    private int capacity;
    private static int id_nadawane=1;
    private String owner;
    private String data_rozp;
    private int dni_wynajmu;

    public Pomieszczenie(int capacity){
        this.capacity=capacity;
        id_nadawane=this.id;
        id_nadawane++;
    }

    public Pomieszczenie(int dlugosc, int szerokosc, int wysokosc){
        this.capacity=dlugosc*szerokosc*wysokosc;
        id_nadawane=this.id;
        id_nadawane++;
    }

}
