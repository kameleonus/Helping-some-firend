package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Bike> rowery = wypiszRowery();
        ArrayList<Accounts> konta =  pobierzDane();
        start();

    }

    private static void start() throws FileNotFoundException {
        System.out.println("|| Wypożyczalnia rowerów online ||\n");
        System.out.println("1. Logowanie");
        System.out.println("2. Rejestracja");
        System.out.println("3. Wyjście");
        System.out.println();
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
        ArrayList<Accounts> konta =  pobierzDane();
        Scanner scanner = new Scanner(System.in);
        String login="";
        String haslo="";
        System.out.println("Naciśnij 1 aby przejść do logowania lub 2 aby wrócić");
        if(scanner.nextInt()==1){
            System.out.print("Login: ");
            login= scanner.next();
            System.out.print("Haslo: ");
            haslo= scanner.next();
           }
        else start();
        for (Accounts k:konta) {
            if(k.getLogin().equals(login) && k.getHaslo().equals(haslo)){
                System.out.println("Zalogowano do konta "+login);
            }
            else{
                System.out.println("Podany login lub haslo jest niepoprawne");//Your username or password may be incorrect
                logowanie();
            }
        }
        scanner.close();
    }

    private static ArrayList<Accounts> pobierzDane() throws FileNotFoundException {
        ArrayList<Accounts> konta = new ArrayList<>();
        File file = new File("src/accounts.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            Accounts konto = new Accounts(scanner.next(),scanner.next(),scanner.next(), scanner.next(), scanner.next());
            konta.add(konto);
        }
        scanner.close();
        return konta;
    }
    public static ArrayList<Bike>  wypiszRowery() throws FileNotFoundException {
        File file = new File("src/bikes.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Bike> rowers = new ArrayList<>();
        while(scanner.hasNext()) {
            Bike pobierzRowerZPliku = new Bike(scanner.next(),scanner.next(),scanner.next(), scanner.next(), scanner.nextInt(),
                    scanner.nextBoolean());
            rowers.add(pobierzRowerZPliku);
        }
        scanner.close();
        return rowers;
    }
}
