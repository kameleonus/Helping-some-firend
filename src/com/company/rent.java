package com.company;

import javafx.util.converter.LocalDateStringConverter;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class rent  {
    String date;
    String BorrowLogin;

    public void BorrowBike(ArrayList<Bike> PrintBike, int index) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Czy chcesz wypożyczyć rower 1 - TAK, 2 - NIE: ");
        int x = scanner.nextInt();
        if (x == 1) {
            System.out.println("Na ile");
            int karakan = scanner.nextInt();
            LocalDate BorrowDate = LocalDate.now();
            LocalDate ReturnDate = BorrowDate.plusDays(karakan);
            File file = new File("src/rent.txt");
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(PrintBike.get(index).getName());
            bufferedWriter.append(PrintBike.get(index).getProducer());
            bufferedWriter.append(PrintBike.get(index).getType());
            bufferedWriter.append(String.valueOf(PrintBike.get(index).getTires()) );
            bufferedWriter.append(PrintBike.get(index).getGears());
            bufferedWriter.append(BorrowDate.toString());
            bufferedWriter.append(ReturnDate.toString());
            bufferedWriter.close();
            scanner.close();
            System.exit(1);
        }
        else if(x == 2){
            Main.printBikes();
        }
        else{
            System.out.println("System error");
            Main.menu();
        }


    }
}
