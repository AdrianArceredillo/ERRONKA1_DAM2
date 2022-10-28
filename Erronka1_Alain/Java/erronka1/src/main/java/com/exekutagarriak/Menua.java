package com.exekutagarriak;

import java.rmi.StubNotFoundException;
import java.util.Scanner;

public class Menua {
    public static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("HASIERAKO MENUA");
            System.out.println("====================================");
            System.out.println("1.- Datuak irakurri");
            System.out.println("2.- Datuak esportatu");
            System.out.println("3.- Datuak inportatu (egiteko)");
            System.out.println("4.- Irten");
            System.out.println();
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    datuakIrakurri();
                    break;
                case 2:
                    // met2();
                    break;
                case 3:
                    // met3();
                    break;
                case 4:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 4);
        in.next();
    }

    private static void datuakIrakurri() {
        int aukera;
        do {
            System.out.println("\nZe datu nahi duzu irakurri?");
            System.out.println("1.- Produktuen datuak");
            System.out.println("2.- beste datu batzuk (egiteko)");
            System.out.println("3.- Atzera");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    System.out.println();
                    EsportatuCsvra.produktuakImprimatu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 3);

    }
}
