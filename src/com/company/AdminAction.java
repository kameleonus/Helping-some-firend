package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class AdminAction {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Bike> bikes;
    {
        try {
            bikes = Main.printBikes();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void AddBike() throws IOException {
        System.out.println("Podaj nazwę: ");
        String name = scanner.next();
        System.out.println("Podaj Producent: ");
        String producer = scanner.next();
        System.out.println("Podaj typ: ");
        String type = scanner.next();
        System.out.println("Podaj kolor: ");
        String color = scanner.next();
        System.out.println("Podaj liczbę przerzutek ");
        String gears = scanner.next();
        System.out.println("Podaj rozmiar koła");
        int tires = scanner.nextInt();

        Bike bike = new Bike(name,producer,type,color,tires,gears);
        bikes.add(bike);
        saveBikes(bikes);
        Main.start();
    }
    public void RemoveBike() throws IOException {
        int f = 1;
        for (Bike bike : bikes) {
            System.out.print(f++);
            System.out.println(' ' + bike.getName() + ' ' + bike.getColor() + ' ' + bike.getProducer() + ' ' + bike.getType() + ' ' + bike.getGears() + ' ' + bike.getTires() + '"');
        }
        System.out.println("Który rower usunąć z sklepu?");
        int delete = scanner.nextInt();
        bikes.remove(delete-1);
        saveBikes(bikes);
        Main.start();
    }
    public void EditBike() throws IOException {
        int f = 1;
        for (Bike bike : bikes) {
            System.out.print(f++);
            System.out.println(' ' + bike.getName() + ' ' + bike.getColor() + ' ' + bike.getProducer() + ' ' + bike.getType() + ' ' + bike.getGears() + ' ' + bike.getTires() + '"');
        }
        System.out.println("Który rower edytować?");
        int update = scanner.nextInt();
        System.out.println("Co edtyować:\n 1.Nazwa \n 2.Producent \n 3.Typ\n 4.kolor\n 5.Koła\n 6.Liczba przerzutek");
        int Wupdate = scanner.nextInt();
        System.out.println("Na co zmienić?");
        String Endupdate = scanner.next();
        switch (Wupdate){
            case 1:bikes.get(update-1).setName(Endupdate);  break;
            case 2:bikes.get(update-1).setProducer(Endupdate);  break;
            case 3:bikes.get(update-1).setType(Endupdate);  break;
            case 4:bikes.get(update-1).setColor(Endupdate);  break;
            case 5:bikes.get(update-1).setTires(Integer.parseInt(Endupdate));  break;
            case 6:bikes.get(update-1).setGears(Endupdate); break;
            default:
                throw new IllegalStateException("Unexpected value: " + Wupdate);
        }
        System.out.println("Kontynuować ? 1. Tak  2.Nie");
        int kon = scanner.nextInt();
        if (kon==1) EditBike();
        saveBikes(bikes);
        Main.start();
    }
    public void saveBikes( ArrayList<Bike> bikes) throws IOException {
        PrintWriter pw = new PrintWriter("src/bikes.txt");
        pw.close();
        File file = new File("src/bikes.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Bike bike:bikes
             ) {
            bufferedWriter.append(bike.getName()+"\n");
            bufferedWriter.append(bike.getProducer()+"\n");
            bufferedWriter.append(bike.getType()+"\n");
            bufferedWriter.append(bike.getColor()+"\n");
            bufferedWriter.append(bike.getTires()+"\n" );
            bufferedWriter.append(bike.getGears()+"\n");
        }
        bufferedWriter.close();
    }
}
