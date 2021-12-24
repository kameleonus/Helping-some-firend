package com.company;

public class Accounts {

    String login;
    String Name;
    String Surname;
    String CardNumber;
    String Password;

    public Accounts(String login, String name, String surname, String cardNumber, String password) {
        this.login = login;
        Name = name;
        Surname = surname;
        CardNumber = cardNumber;
        Password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
