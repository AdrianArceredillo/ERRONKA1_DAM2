package com.menua;

import java.util.Scanner;

import com.postgress.delete.GarbituTaulak;
import com.postgress.delete.ProduktuBatEzabatu;
import com.postgress.insert.ProduktuBatInportatu;
import com.postgress.insert.ProduktuListaInportatu;
import com.postgress.update.ProduktuBatAldatu;
import com.postgress.update.ProduktuListaAldatu;

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
            System.out.println("1.- Produktuen lista");
            System.out.println("2.- Datuak esportatu");
            System.out.println("3.- Datuak inportatu");
            System.out.println("4.- Produktuak editatu");
            System.out.println("5.- Produktuak ezabatu");
            System.out.println("6.- Irten");
            System.out.println();
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    garbitu();
                    DatuakEsportatu.produktuakImprimatu();
                    break;
                case 2:
                    garbitu();
                    datuakEsportatu();
                    break;
                case 3:
                    garbitu();
                    datuakInportatu();
                    break;
                case 4:
                    garbitu();
                    prodtuktuakEditatu();
                    break;
                case 5:
                    garbitu();
                    produktuakEzabatu();
                    break;
                case 6:
                    garbitu();
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    System.out.println();
                    break;
                default:
                    garbitu();
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 6);
    }

    private static void datuakEsportatu() {
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
                    DatuakEsportatu.produktuakCsvra();
                    break;
                case 2:
                    garbitu();
                    DatuakEsportatu.produktuakXmlra();
                    break;
                case 3:
                    garbitu();
                    DatuakEsportatu.produktuakJsonera();
                    break;
                case 4:
                    garbitu();
                    DatuakEsportatu.produktuakDenetara();
                    break;
                default:
                    garbitu();
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
    }

    private static void datuakInportatu() {
        int aukera;
        do {
            System.out.println("\nZer nahi duzu inportatu?");
            System.out.println("1.- Produktu bat");
            System.out.println("2.- Produktu lista");
            System.out.println("3.- Atzera");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    garbitu();
                    ProduktuBatInportatu.produktuaInportatu();
                    break;
                case 2:
                    garbitu();
                    ProduktuListaInportatu.listaInportatu();
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

    private static void prodtuktuakEditatu() {
        int aukera;
        do {
            System.out.println("\nZer nahi duzu editatu?");
            System.out.println("1.- Produktu bat");
            System.out.println("2.- Produktu denak");
            System.out.println("3.- Atzera");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    garbitu();
                    ProduktuBatAldatu.produktuaAldatu();
                    break;
                case 2:
                    garbitu();
                    ProduktuListaAldatu.produktuListaAldatu();
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

    private static void produktuakEzabatu() {
        int aukera;
        do {
            System.out.println("\nZer nahi duzu ezabatu?");
            System.out.println("1.- Produktu bat");
            System.out.println("2.- Produktu denak");
            System.out.println("3.- Atzera");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    garbitu();
                    ProduktuBatEzabatu.produktuaEzabatu();
                    break;
                case 2:
                    garbitu();
                    GarbituTaulak.garbitu();
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

    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
