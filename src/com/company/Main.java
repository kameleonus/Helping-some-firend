package com.company;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        start();

    }
    public static void start() throws IOException {
        System.out.println("|| Wypożyczalnia rowerów online ||\n");
        System.out.println("1. Logowanie");
        System.out.println("2. Rejestracja");
        System.out.println("3. Wyjście");
        System.out.println();
        System.out.print("Wybierz co chcesz zrobic wariacie: ");
        try{
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
            if (wybor==1){
                logIn();
            }
            else if(wybor==2){
                createAccount();
            }
            else if (wybor==4){
                LogAdmin();
            }
            else{ scanner.close();
                System.exit(0);}}
        catch (InputMismatchException e) {
            start();

        }
    }

    private static void LogAdmin() throws IOException {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Podaj login");
        String Alogin =scanner.next();
        System.out.println("Podaj haslo");
        String Apassword =scanner.next();
        if(Alogin.equals("admin") && Apassword.equals("admin")){
            System.out.println("Witam w panelu zarządania.");
            System.out.println("1. Doadaj rower do bazy.");
            System.out.println("2. Usun rower z bazy.");
            System.out.println("3. Edytuj rower w  bazie.");
            AdminAction adminAction = new AdminAction();
            int task = scanner.nextInt();
            switch (task){
                case 1:adminAction.AddBike();break;
                case 2:adminAction.RemoveBike();break;
                case 3:adminAction.EditBike();break;
            }
            scanner.close();
        }
        else {
            scanner.close();
            start();
        }
    }
    private static void createAccount() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie: ");
        String name = scanner.next();
        System.out.println("Podaj nazwisko: ");
        String surname = scanner.next();
        System.out.println("Podaj login: ");
        String login = scanner.next();
        System.out.println("Podaj hasło: ");
        String password = scanner.next();
        System.out.println("Powtórz hasło: ");
        String password2 = scanner.next();
        System.out.println("Podaj numer konta: ");
        String accountNumber = scanner.next();
        while(!password.equals(password2)){
            System.out.println("Błędne hasła!");
            System.out.println("Podaj hasło: ");
            password = scanner.next();
            System.out.println("Powtórz hasło: ");
            password2 = scanner.next();
        }
        while(loginCheck(login)){
            System.out.println("Podany login jest juz zajęty. Podaj inny: ");
            login = scanner.next();
        }
        scanner.close();
        File file = new File("src/accounts.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append("\n"+login+"\n"+name+"\n"+surname+"\n"+accountNumber+"\n"+password);
        bufferedWriter.close();
    }
    private static void logIn() throws IOException {
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
                menu();

            }
            else{
                System.out.println("Podany login lub haslo jest niepoprawne");//Your username or password may be incorrect
                start();
            }
        }

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
                    scanner.next());
            bikes.add(getBikeFromFile);
        }
        scanner.close();
        return bikes;
    }
    public static boolean loginCheck(String login) throws IOException {
        ArrayList<Accounts> accounts =  getAccountData();
        for (Accounts k:accounts) {
            if (k.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
    public static void menu() throws IOException {
        System.out.println("Dostępne rowery:");
        System.out.println("numer, nazwa, kolor, producent, typ, liczba biegów, rozmiar koła");
        ArrayList<Bike> printBikes = printBikes();
        int f = 1;
        for (int i = 0; i < printBikes().size(); i++) {
            System.out.print(f++);
                System.out.println(' '+printBikes.get(i).getName()+' '+printBikes.get(i).getColor()+' '+printBikes.get(i).getProducer()+' '+printBikes.get(i).getType()+' '+printBikes.get(i).getGears()+' '+printBikes.get(i).getTires()+'"');
        }
        System.out.println("Wpisz numer roweru który cię interesuję");
        Scanner scanner = new Scanner(System.in);
        int bi = scanner.nextInt();
        rent rent = new rent();
        rent.BorrowBike(printBikes,bi);


    }

}
