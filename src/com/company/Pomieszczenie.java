package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Pomieszczenie implements Comparable<Pomieszczenie> {
    private int id;
    private double capacity;
    private static int id_nadawane=1;
    private Osoba owner;
    private boolean is_available;
    private boolean czywynajete;
    private Date data_rozp;
    private int dni_wynajmu;

    private ArrayList<Przedmiot> przedmioty;

    public Pomieszczenie(double capacity, boolean is_available){
        this.capacity=capacity;
        this.is_available=is_available;
        this.dni_wynajmu=0;
        przedmioty=new ArrayList<>();
        czywynajete=false;
        id=id_nadawane;
        id_nadawane++;
    }

    public ArrayList<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void setCzywynajete(boolean czywynajete) {
        this.czywynajete = czywynajete;
    }

    public Pomieszczenie(double dlugosc, double szerokosc, double wysokosc, boolean is_available){
        this.capacity=dlugosc*szerokosc*wysokosc;
        this.is_available=is_available;
        this.dni_wynajmu=0;

        przedmioty=new ArrayList<>();
        czywynajete=false;
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

    public void setOwner(Osoba owner) {
        this.owner = owner;
    }

    public void setData_rozp(Date data_rozp) {
        this.data_rozp = data_rozp;
    }

    public void setDni_wynajmu(int dni_wynajmu) {
        this.dni_wynajmu = dni_wynajmu;
    }

    public void setPrzedmioty(ArrayList<Przedmiot> przedmioty) {

        this.przedmioty = przedmioty;
    }

    public double getCapacity() {

        return capacity;
    }

    public Osoba getOwner() {
        return owner;
    }

    public Date getData_rozp() {

        return data_rozp;
    }

    public int getDni_wynajmu() {
        return dni_wynajmu;
    }

    public boolean isCzywynajete() {
        return czywynajete;
    }

    public void wynajmij(Osoba os, int dni){
        data_rozp=new Date();
        dni_wynajmu=dni;

        if(is_available){
            if(owner==null) {
                owner = os;
                czywynajete = true;
            }

            else
                System.out.println("To pomieszczenie jest już wynajmowane");
        }
        else
            System.out.println("To pomieszczenie jest aktualnie w remoncie");
            System.out.println("");
    }

    @Override
    public int compareTo(Pomieszczenie o) {
        return Double.compare(this.capacity,o.capacity);
    }
}
