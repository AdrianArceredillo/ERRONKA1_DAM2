package com.postgress.update;

import java.sql.Statement;
import java.util.Scanner;

import com.konexioa.Konexioa;
import com.postgress.ProduktuakJavaObjetura;

public class ProduktuListaAldatu {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;
    public static Scanner in;

    public static void produktuListaAldatu() {
        String erantzuna;
        boolean bestebat;
        in = new Scanner(System.in);
        System.out.println("Hemen produktu guztien lista:");
        System.out.println(
                "Produktua[ id, izena, deskripzioa, prezioa, stocka, bolumena, pisua, barraKodea, lehentasuna]");
        System.out.print(ProduktuakJavaObjetura.ProduktuenJavaObjetua());
        do {
            System.out.print("Aukeratu ze datu nahi duzun aldatu (prezioa/stocka/lehentasuna): ");
            erantzuna = in.nextLine().toLowerCase();
            if (erantzuna.equals("prezioa") || erantzuna.equals("stocka") || erantzuna.equals("lehentasuna")) {
                System.out.println("Ziur zaude " + erantzuna + " nahi duzula editatu? (Bai/Ez)");
                erantzuna = in.next().toLowerCase();
                if (erantzuna.equals("bai") || erantzuna.equals("b")) {
                    switch (erantzuna) {
                        case "prezioa":
                        garbitu();

                            break;
                        case "stocka":
                        garbitu();

                            break;
                        case "lehentasuna":
                        garbitu();

                            break;
                        default:
                            break;
                    }
                    System.out.println("Hemen produktu guztien lista berria:");
                    System.out.println(
                            "Produktua[id, izena, deskripzioa, prezioa, stocka, bolumena, pisua, barraKodea, lehentasuna]");
                    System.out.print(ProduktuakJavaObjetura.ProduktuenJavaObjetua());
                }
            }
            System.out.println("Nahi duzu beste zerbait editatu? (Bai/Ez)");
            erantzuna = in.next().toLowerCase();
            in.nextLine();
            if (erantzuna.equals("bai") || erantzuna.equals("b")) {
                bestebat = true;
            } else {
                bestebat = false;
            }
        } while (bestebat);
    }

    public static void produktuListaEditatu() {

    }
    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
