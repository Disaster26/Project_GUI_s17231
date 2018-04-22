package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Pomieszczenie implements Comparable<Pomieszczenie> {
    private int id;
    private double capacity;
    private static int id_nadawane=1;
    private Osoba owner;
    private boolean is_available;
    private Date data_rozp;
    private int dni_wynajmu;

    private ArrayList<Przedmiot> przedmioty;

    public Pomieszczenie(double capacity, boolean is_available){
        this.capacity=capacity;
        this.is_available=is_available;
        id=id_nadawane;
        id_nadawane++;
    }

    public ArrayList<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public Pomieszczenie(double dlugosc, double szerokosc, double wysokosc, boolean is_available){
        this.capacity=dlugosc*szerokosc*wysokosc;
        this.is_available=is_available;
        id=id_nadawane;

        id_nadawane++;
    }

    @Override
    public String toString() {
        return "Pomieszczenie{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", owner=" + owner +
                ", is_available=" + is_available +
                ", data_rozp=" + data_rozp +
                ", dni_wynajmu=" + dni_wynajmu +
                '}';
    }

    public void putPrzedmiot(Przedmiot p) throws TooManyThingsException {
        double obj=0;
        for(Przedmiot temp:przedmioty)
            obj+=temp.getVolume();
        if(capacity-obj<p.getVolume())
            throw new TooManyThingsException("Ten przedmiot nie zmieści się w magazynie");
        else
            przedmioty.add(p);
    }

    public void wyjmijPrzedmiot(int i){
        if(i-1>=0&&i<=przedmioty.size())
        przedmioty.remove(i-1);
    }

    public void wynajmij(Osoba os, int dni){
        data_rozp=new Date();
        dni_wynajmu=dni;
        if(is_available){
            if(owner.equals(null))
                owner=os;
            else
                System.out.println("To pomieszczenie jest już wynajmowane");
        }
        else
            System.out.println("To pomieszczenie jest aktualnie w remoncie");
    }

    @Override
    public int compareTo(Pomieszczenie o) {
        return Double.compare(this.capacity,o.capacity);
    }
}
