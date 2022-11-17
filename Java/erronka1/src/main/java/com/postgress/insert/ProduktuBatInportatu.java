package com.postgress.insert;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.konexioa.Konexioa;

public class ProduktuBatInportatu {
    public static Scanner in;
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;

    public static void produktuaInportatu() {

        String izena = "", deskripzioa = "", barraKodea = "", erantzuna = "", lehentasuna = "";
        float prezioa = 0, bolumena = 0, pisua = 0, stocka = 0;
        boolean besteBat = true;
        in = new Scanner(System.in);
        do {
            garbitu();
            boolean ondo = false;
            while (!ondo){
                try {
                    System.out.println("Produktua gehitzeko sartu hurrengo datuak:");
                    System.out.print("Izena: ");
                    izena = in.nextLine();
                    System.out.print("Deskripzioa: ");
                    deskripzioa = in.nextLine();
                    System.out.print("Prezioa: ");
                    prezioa = in.nextFloat();
                    System.out.print("Stocka: ");
                    stocka = in.nextFloat();
                    System.out.print("Bolumena (m\u00B3): ");
                    bolumena = in.nextFloat();
                    System.out.print("Pisua (Kg): ");
                    pisua = in.nextFloat();
                    System.out.print("Barra-kodea: ");
                    barraKodea = in.next();
                    System.out.print("Lehentasuna (Bai/Ez): ");
                    erantzuna = in.next();
                    if (erantzuna.toLowerCase().equals("bai") || erantzuna.equals("b") || erantzuna.equals("1")) {
                        lehentasuna = "Bai";
                    } else {
                        lehentasuna = "Ez";
                    }
                    ondo = true;
                } catch (Exception e) {
                    garbitu();
                    System.out.println("Datu bat formatu desegokian sartu duzu, saiatu berriro");
                    System.out.println("Zenbakietan erabili ',' eta ez '.'");
                    in.nextLine();
                }
            }
            garbitu();
            System.out.print("Sartutako datuak:\nIzena: " + izena + "\nDeskripzioa: " + deskripzioa + "\nPrezioa: "
                    + prezioa
                    + "\nstocka: " + stocka + "\nBolumena: " + bolumena + "\nPisua: " + pisua
                    + "\nBarra-kodea: "
                    + barraKodea + "\nLehentasuna: " + lehentasuna);
            System.out.println("\nProduktu hau nahi duzu gehitu? (Bai/Ez)");
            erantzuna = in.next();

            if (erantzuna.toLowerCase().equals("bai") || erantzuna.equals("b") || erantzuna.equals("1")) {

                int idPT = idLortuPT() + 1;
                int idPP = idLortuPP() + 1;
                int idSQ = idLortuSQ() + 1;

                InsertProduktua.produktuaGehitu(idPT, idPP, idSQ, izena, deskripzioa, barraKodea, prezioa, bolumena,
                        pisua,
                        stocka, lehentasuna);
                System.out.println("Produktua ondo inportatu da");
            }
            System.out.println("Nahi duzu beste produktu bat inportatu? (Bai/Ez)");
            erantzuna = in.next();
            if (erantzuna.toLowerCase().equals("bai") || erantzuna.toLowerCase().equals("b")) {
                besteBat = true;
            } else {
                besteBat = false;
            }
            in.nextLine();

        } while (besteBat);
        garbitu();
    }

    public static int idLortuPT() {
        String sql = "SELECT id FROM public.product_template ORDER BY id DESC LIMIT 1";
        int id = 0;
        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception ex) {
            // System.out.println("Exception (PT id): " + ex);
        }
        // System.out.println("Lortutako PT id-a: " + id);
        return id;
    }

    public static int idLortuPP() {
        String sql = "SELECT id FROM public.product_product ORDER BY id DESC LIMIT 1";
        int id = 0;
        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception ex) {
            // System.out.println("Exception (PP id): " + ex);
        }
        // System.out.println("Lortutako PP id-a: " + id);
        return id;
    }

    public static int idLortuSQ() {
        String sql = "SELECT id FROM public.stock_quant ORDER BY id DESC LIMIT 1";
        int id = 0;
        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception ex) {
            // System.out.println("Exception (SQ id): " + ex);
        }
        // System.out.println("Lortutako SQ id-a: " + id);
        return id;
    }

    private static void garbitu() {
        // System.out.print("\033[H\033[2J");
        // System.out.flush();
    }

}
