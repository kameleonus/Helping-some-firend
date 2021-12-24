package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Bike> bikes = printBikes();
        ArrayList<Accounts> accounts =  getAccountData();
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
            logIn();
        }
        else if(wybor==2){
            createAccount();
        }
        else{
            System.exit(0);}
    }

    private static void createAccount() {

    }

    private static void logIn() throws FileNotFoundException {
        ArrayList<Accounts> accounts =  getAccountData();
        Scanner scanner = new Scanner(System.in);
        String login="";
        String password="";
        System.out.println("Naciśnij 1 aby przejść do logowania lub 2 aby wrócić");
        if(scanner.nextInt()==1){
            System.out.print("Login: ");
            login= scanner.next();
            System.out.print("Haslo: ");
            password= scanner.next();
           }
        else start();
        for (Accounts k:accounts) {
            if(k.getLogin().equals(login) && k.getPassword().equals(password)){
                System.out.println("Zalogowano do konta "+login);
            }
            else{
                System.out.println("Podany login lub haslo jest niepoprawne");//Your username or password may be incorrect
                logIn();
            }
        }
        scanner.close();
    }

    private static ArrayList<Accounts> getAccountData() throws FileNotFoundException {
        ArrayList<Accounts> accounts = new ArrayList<>();
        File file = new File("src/accounts.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            Accounts account = new Accounts(scanner.next(),scanner.next(),scanner.next(), scanner.next(),
                    scanner.next());
            accounts.add(account);
        }
        scanner.close();
        return accounts;
    }
    public static ArrayList<Bike>  printBikes() throws FileNotFoundException {
        File file = new File("src/bikes.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Bike> bikes = new ArrayList<>();
        while(scanner.hasNext()) {
            Bike getBikeFromFile = new Bike(scanner.next(),scanner.next(),scanner.next(), scanner.next(),
                    scanner.nextInt(),
                    scanner.nextBoolean());
            bikes.add(getBikeFromFile);
        }
        scanner.close();
        return bikes;
    }
}
