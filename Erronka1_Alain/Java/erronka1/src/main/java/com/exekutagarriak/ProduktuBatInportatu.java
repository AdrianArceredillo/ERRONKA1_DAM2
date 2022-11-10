package com.exekutagarriak;

import java.sql.Statement;
import java.util.Scanner;

import com.konexioa.Konexioa;

public class ProduktuBatInportatu {
    public static Scanner in;
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;

    public static void produktuBatGehitu() {
        
        
        String izena, deskripzioa, barraKodea, erantzuna;
        float prezioa, bolumena, pisua, kantitatea;
        int lehentasuna;
        boolean ondo = false;
        in = new Scanner(System.in);
        do {
        garbitu();
        System.out.println("Produktua gehitzeko sartu hurrengo datuak:");
            System.out.print("Izena: ");
            izena = in.nextLine();
            System.out.print("Deskripzioa: ");
            deskripzioa = in.nextLine();
            System.out.print("Prezioa: ");
            prezioa = in.nextFloat();
            System.out.print("Kantitatea: ");
            kantitatea = in.nextFloat();
            System.out.print("Bolumena (m\u00B3): ");
            bolumena = in.nextFloat();
            System.out.print("Pisua (Kg): ");
            pisua = in.nextFloat();
            System.out.print("Barra-kodea: ");
            barraKodea = in.next();
            System.out.print("Lehentasuna (B/E): ");
            erantzuna = in.next();
            if(erantzuna.equals("B") || erantzuna.equals("b") || erantzuna.equals("1")){
                lehentasuna = 1;
            } else{
                lehentasuna = 0;
            }
            

            garbitu();
            System.out.print("Sartutako datuak:\nIzena: " + izena + "\nDeskripzioa: " + deskripzioa + "\nPrezioa: "
                    + prezioa
                    + "\nKantitatea: " + kantitatea + "\nBolumena: " + bolumena + "\nPisua: " + pisua
                    + "\nBarra-kodea: "
                    + barraKodea + "\nLehentasuna: ");
            if(lehentasuna == 1){
                System.out.print("Bai");
            } else{
                System.out.print("Ez");
            }
            System.out.println("\nProduktu hau nahi duzu gehitu? B/E");
            erantzuna = in.next();
            in.nextLine();
            if(erantzuna.equals("B") || erantzuna.equals("b") || erantzuna.equals("1")){
                ondo = true;
            }
        } while (!ondo);
        in.close();
        ProduktuBatenStocka.produktuaGehitu(izena, deskripzioa, barraKodea, prezioa, bolumena, pisua, kantitatea, lehentasuna);

    }

    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
