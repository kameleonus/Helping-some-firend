package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Hyperbook\\Desktop\\RoweryNorbert\\src\\com\\company\\rowery.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Rower> rowers = new ArrayList<>();
        while(scanner.hasNext()) {
            Rower pobierzRowerZPliku = new Rower(scanner.next(),scanner.next(), scanner.next(), scanner.nextInt(),
                    scanner.nextBoolean());
            rowers.add(pobierzRowerZPliku);
        }
        for (Rower r:rowers
             ) {
            System.out.println(r.getNazwa());
            System.out.println(r.getMarka());
            System.out.println(r.getKolor());
            System.out.println(r.getOpony());
            System.out.println(r.getPrzerzutki());
        }
    }
}
