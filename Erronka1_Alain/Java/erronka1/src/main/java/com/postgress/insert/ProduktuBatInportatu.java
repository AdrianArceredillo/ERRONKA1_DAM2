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

        String izena, deskripzioa, barraKodea, erantzuna, lehentasuna;
        float prezioa, bolumena, pisua, kantitatea;
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
            if (erantzuna.equals("B") || erantzuna.equals("b") || erantzuna.equals("1")) {
                lehentasuna = "1";
            } else {
                lehentasuna = "0";
            }

            garbitu();
            System.out.print("Sartutako datuak:\nIzena: " + izena + "\nDeskripzioa: " + deskripzioa + "\nPrezioa: "
                    + prezioa
                    + "\nKantitatea: " + kantitatea + "\nBolumena: " + bolumena + "\nPisua: " + pisua
                    + "\nBarra-kodea: "
                    + barraKodea + "\nLehentasuna: ");
            if (lehentasuna.equals("1")) {
                System.out.print("Bai");
            } else {
                System.out.print("Ez");
            }
            System.out.println("\nProduktu hau nahi duzu gehitu? B/E");
            erantzuna = in.next();
            in.nextLine();
            if (erantzuna.equals("B") || erantzuna.equals("b") || erantzuna.equals("1")) {
                ondo = true;
            }
        } while (!ondo);
        in.close();

        int idPT = idLortuPT() + 1;
        int idPP = idLortuPP() + 1;
        int idSQ = idLortuSQ() + 1;

        InsertProduktua.produktuaGehitu(idPT, idPP, idSQ, izena, deskripzioa, barraKodea, prezioa, bolumena, pisua,
                kantitatea, lehentasuna);

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
            System.out.println("Exception (PT id): " + ex);
        }
        System.out.println("Lortutako PT id-a: " + id);
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
            System.out.println("Exception (PP id): " + ex);
        }
        System.out.println("Lortutako PP id-a: " + id);
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
            System.out.println("Exception (SQ id): " + ex);
        }
        System.out.println("Lortutako SQ id-a: " + id);
        return id;
    }

    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
