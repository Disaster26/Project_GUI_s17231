package com.company;

import java.util.Scanner;

public class Przedmiot implements Comparable<Przedmiot> {
    private String nazwa;
    private double volume;

    public Przedmiot(double capacity, String nazwa){
        this.volume=capacity;
        this.nazwa=nazwa;
    }

    public Przedmiot(double dlugosc, double szerokosc, double wysokosc, String nazwa){
        this.volume=dlugosc*szerokosc*wysokosc;
        this.nazwa=nazwa;
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "nazwa='" + nazwa + '\'' +
                ", volume=" + volume +
                '}';
    }

    public void zmienObjetosc(){
        Scanner czyt=new Scanner(System.in);
        System.out.println("Wprowadź nową objętość przedmiotu: ");
        volume=czyt.nextDouble();
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public int compareTo(Przedmiot o) {
        int wynik=Double.compare(this.volume,o.volume);
        if(Double.compare(this.volume,o.volume)==0)
            return this.nazwa.compareTo(o.nazwa);
        else
            return wynik;
    }
}
