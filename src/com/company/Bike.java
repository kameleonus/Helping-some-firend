package com.company;

public class Bike {


    String nazwa;
    String marka;
    String rodzaj;
    String kolor;
    int opony;
    Boolean przerzutki;

    public Bike(String nazwa,String marka,String rodzaj, String kolor, int opony, Boolean przerzutki) {
        this.nazwa= nazwa;
        this.marka = marka;
        this.rodzaj=rodzaj;
        this.kolor = kolor;
        this.opony = opony;
        this.przerzutki = przerzutki;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public int getOpony() {
        return opony;
    }

    public void setOpony(int opony) {
        this.opony = opony;
    }

    public Boolean getPrzerzutki() {
        return przerzutki;
    }

    public void setPrzerzutki(Boolean przerzutki) {
        this.przerzutki = przerzutki;
    }
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getRodzaj() {
        return rodzaj;}
    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;}
}
