package com.exekutagarriak;

import java.util.Scanner;

public class Menua {
    public static Scanner in;

    public static void main(String[] args) {
        garbitu();
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
                    garbitu();
                    datuakIrakurri();
                    break;
                case 2:
                    garbitu();
                    datuakEsportatu();
                    break;
                case 3:
                    garbitu();
                    // met3();
                    break;
                case 4:
                    garbitu();
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    System.out.println();
                    break;
                default:
                    garbitu();
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 4);
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
                    garbitu();
                    System.out.println();
                    datuakEsportatu.produktuakImprimatu();
                    break;
                case 2:
                    garbitu();
                    break;
                case 3:
                    garbitu();
                    break;
                default:
                    garbitu();
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 3);
    }

    private static void datuakEsportatu() {
        int aukera;
        do {
            System.out.println("\nZe datu nahi duzu esportatu?");
            System.out.println("1.- Produktuen datuak");
            System.out.println("2.- beste datu batzuk (egiteko)");
            System.out.println("3.- Atzera");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    garbitu();
                    datuakEsportatuProduktuak();
                    break;
                case 2:
                    garbitu();
                    break;
                case 3:
                    garbitu();
                    break;
                default:
                    garbitu();
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 3);
    }

    private static void datuakEsportatuProduktuak() {
        int aukera;
        do {
            System.out.println("\nZe formatutara nahi duzu produktuen datuak esportatu?");
            System.out.println("1.- CSV");
            System.out.println("2.- XML");
            System.out.println("3.- JSON");
            System.out.println("4.- Denetara");
            System.out.println("5.- Atzera");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    garbitu();
                    datuakEsportatu.produktuakCsvra();
                    break;
                case 2:
                    garbitu();
                    datuakEsportatu.produktuakXmlra();
                    break;
                case 3:
                    garbitu();
                    datuakEsportatu.produktuakJsonera();
                    break;
                case 4:
                    garbitu();
                    datuakEsportatu.produktuakDenetara();
                    break;
                default:
                    garbitu();
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
    }

    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
