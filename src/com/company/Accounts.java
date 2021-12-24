package com.company;

public class Accounts {

    String login;
    String Imie;
    String Nazwisko;
    String NumerKarty;
    String Haslo;

    public Accounts(String login, String imie, String nazwisko, String numerKarty, String haslo) {
        this.login=login;
        Imie = imie;
        Nazwisko = nazwisko;
        NumerKarty = numerKarty;
        Haslo = haslo;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getNumerKarty() {
        return NumerKarty;
    }

    public void setNumerKarty(String numerKarty) {
        NumerKarty = numerKarty;
    }

    public String getHaslo() {
        return Haslo;
    }

    public void setHaslo(String haslo) {
        Haslo = haslo;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
