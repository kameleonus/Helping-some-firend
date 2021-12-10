package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Rower> rowery = wypiszRowery();
        ArrayList<Konta> konta =  pobierzDane();
        start();

    }

    private static void start() throws FileNotFoundException {
        System.out.println("1. Logowanie");
        System.out.println("2. Rejestracja");
        System.out.println("3. Wyjscie");
        System.out.print("Wybierz co chcesz zrobic wariacie: ");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
        if (wybor==1){
            logowanie();
        }
        else if(wybor==2){
            rejestrcja();
        }
        else{
            System.exit(0);}
    }

    private static void rejestrcja() {

    }

    private static void logowanie() throws FileNotFoundException {
        ArrayList<Konta> konta =  pobierzDane();
        Scanner scanner = new Scanner(System.in);
        String login="";
        String haslo="";
        System.out.println("Naciśnij 1 aby przejść do logowanie lub 2 aby wrócić");
        if(scanner.nextInt()==1){
            System.out.print("Podaj login: ");
            login= scanner.next();
            System.out.print("Podaj haslo: ");
            haslo= scanner.next();
           }
        else start();
        for (Konta k:konta) {
            if(k.getLogin().equals(login) && k.getHaslo().equals(haslo)){
                System.out.println("Gejtuaslcka");
            }//Popraw to
            else{
                System.out.println("Błędne dane");
                logowanie();
            }
        }
        scanner.close();
    }

    private static ArrayList<Konta> pobierzDane() throws FileNotFoundException {
        ArrayList<Konta> konta = new ArrayList<>();
        File file = new File("src/konta.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            Konta konto = new Konta(scanner.next(),scanner.next(),scanner.next(), scanner.next(), scanner.next());
            konta.add(konto);
        }
        scanner.close();
        return konta;
    }
    public static ArrayList<Rower>  wypiszRowery() throws FileNotFoundException {
        File file = new File("src/rowery.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Rower> rowers = new ArrayList<>();
        while(scanner.hasNext()) {
            Rower pobierzRowerZPliku = new Rower(scanner.next(),scanner.next(),scanner.next(), scanner.next(), scanner.nextInt(),
                    scanner.nextBoolean());
            rowers.add(pobierzRowerZPliku);
        }
        scanner.close();
        return rowers;
    }
}
