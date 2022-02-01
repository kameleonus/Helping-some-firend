package com.company;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class rent  {
    public void BorrowBike(ArrayList<Bike> PrintBike, int index) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Czy chcesz wypożyczyć rower 1 - TAK, 2 - NIE: ");
        int x = scanner.nextInt();
        try {
            if (x == 1) {
                System.out.println("Na ile dni?");
                int karakan = scanner.nextInt();
                LocalDate BorrowDate = LocalDate.now();
                LocalDate ReturnDate = BorrowDate.plusDays(karakan);
                File file = new File("src/rent.txt");
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.append(PrintBike.get(index).getName() + "\n");
                bufferedWriter.append(PrintBike.get(index).getProducer() + "\n");
                bufferedWriter.append(PrintBike.get(index).getType() + "\n");
                bufferedWriter.append(PrintBike.get(index).getColor() + "\n");
                bufferedWriter.append(PrintBike.get(index).getTires() + "\n");
                bufferedWriter.append(PrintBike.get(index).getGears() + "\n");
                bufferedWriter.append(BorrowDate.toString() + "\n");
                bufferedWriter.append(ReturnDate.toString() + "\n");
                bufferedWriter.close();
                scanner.close();
                PrintBike.remove(index);
                AdminAction adminAction = new AdminAction();
                adminAction.saveBikes(PrintBike);
                System.exit(1);
            } else if (x == 2) {
                Main.printBikes();
            }
        }
        catch (InputMismatchException e){
            System.out.println("System error");
            Main.menu();
        }


    }
}
