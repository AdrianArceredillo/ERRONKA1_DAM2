package com.postgress.update;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.konexioa.Konexioa;
import com.postgress.ProduktuakJavaObjetura;

public class produktuBatAldatu {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;
    public static Scanner in;

    public static void produktuaEzabatu() {
        int idPT;
        String erantzuna;
        boolean bestebat;
        in = new Scanner(System.in);
        System.out.println("Hemen produktu guztien lista:");
        System.out.println(
                "Produktua[ id, izena, deskripzioa, prezioa, stocka, bolumena, pisua, barraKodea, lehentasuna]");
        System.out.print(ProduktuakJavaObjetura.ProduktuenJavaObjetua());
        do {
            System.out.print("Aukeratu produktu bat bere ID-a idazten: ");
            idPT = in.nextInt();
            System.out.println("Ziur zaude " + izenaLortu(idPT) + " produktua nahi duzula editatu? (Bai/Ez)");
            erantzuna = in.next().toLowerCase();
            if (erantzuna.equals("bai") || erantzuna.equals("b")) {
                produktuaEditatu(idPT);

                ///////////////////////////////////////////////////////////
                System.out.println("Hemen produktu guztien lista berria:");
                System.out.println(
                        "Produktua[id, izena, deskripzioa, prezioa, stocka, bolumena, pisua, barraKodea, lehentasuna]");
                System.out.print(ProduktuakJavaObjetura.ProduktuenJavaObjetua());
            }
            System.out.println("Nahi duzu beste produktu bat editatu? (Bai/Ez)");
            erantzuna = in.next().toLowerCase();
            in.nextLine();
            if (erantzuna.equals("bai") || erantzuna.equals("b")) {
                bestebat = true;
            } else {
                bestebat = false;
            }
        } while (bestebat);
    }

    public static void produktuaEditatu(int idPT) {
        // UPDATE public.product_template SET name = 'update-a', description =
        // '<p>deskripzio berria</p>' WHERE id = 1;
        // ID;IZENA;DESKRIPZIOA;PREZIOA;KANTITATEA;BOLUMENA;PISUA;BARRAKODEA;LEHENTASUNA
        String name, description, barcode, priority;
        float list_price, quantity, volume, weight;

        int idPP = 0;

        String sql = "SELECT id FROM public.product_product where product_tmpl_id = " + idPT;
        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idPP = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("Exception (PP): " + ex);
        }
        String[] datuakPT = irakurriTaulaPT(idPT).get(0).split(";");
        // id
        name = datuakPT[1];
        description = datuakPT[2];
        list_price = Float.parseFloat(datuakPT[3]);
        quantity = irakurriTaulaSQ(idPP);
        volume = Float.parseFloat(datuakPT[4]);
        weight = Float.parseFloat(datuakPT[5]);
        barcode = irakurriTaulaPP(idPP);
        priority = datuakPT[6];
        System.out.println("Datuak:");
        System.out.println("ID-a: " + idPT);
        System.out.println("Izena: " + name);
        System.out.println("Deskripzioa: " + description);
        System.out.println("Prezioa: " + list_price);
        System.out.println("Kantitatea: " + quantity);
        System.out.println("Bolumena: " + volume);
        System.out.println("Pisua: " + weight);
        System.out.println("Barra kodea: " + barcode);
        System.out.println("Lehentasuna: " + priority);

        System.out.println(
                "Ze datu nahi duzu aldatu? (izena/deskripzioa/prezioa/kantitatea/bolumena/pisua/barrakodea/lehentasuna)");
        in = new Scanner(System.in);
        String erantzuna = in.nextLine().toLowerCase();
        switch (erantzuna) {
            case "izena":
            izenaAldatu();
                break;
            case "deskripzioa":
            deskripzioaAldatu();
                break;
            case "prezioa":
            prezioaAldatu();
                break;
            case "kantitatea":
            kantitateaAldatu();
                break;
            case "bolumena":
            bolumenaAldatu();
                break;
            case "pisua":
            pisuaAldatu();
                break;
            case "barrakodea":
            barraKodeaAldatu();
                break;
            case "lehentasuna":
            lehentasunaAldatu();
                break;
            default:
                System.out.println("Aukera okerra. Saiatu berriz.");
        }

    }


    private static void izenaAldatu() {
    }

    private static void deskripzioaAldatu() {
    }

    private static void prezioaAldatu() {
    }

    private static void kantitateaAldatu() {
    }

    private static void bolumenaAldatu() {
    }

    private static void pisuaAldatu() {
    }

    private static void barraKodeaAldatu() {
    }

    private static void lehentasunaAldatu() {
    }

    public static String izenaLortu(int id) {

        String sql = "SELECT name FROM public.product_template where id = " + id;
        String izena = "";
        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                izena = rs.getString(1);
            }
        } catch (Exception ex) {
            System.out.println("Exception (TP id): " + ex);
        }
        return izena;

    }

    public static ArrayList<String> irakurriTaulaPT(int id) {
        String sql = "SELECT * FROM public.product_template where id = " + id;
        ArrayList<String> datuak = new ArrayList<String>();
        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datuak.add(rs.getString("id") + ";" + rs.getString("name") + ";" + rs.getString("description") + ";"
                        + Float.toString(rs.getFloat("list_price")) + ";" + Float.toString(rs.getFloat("volume")) + ";"
                        + Float.toString(rs.getFloat("weight")) + ";" + rs.getString("priority"));
            }
        } catch (Exception ex) {
            System.out.println("Exception (PT): " + ex);
        }
        return datuak;
    }

    public static String irakurriTaulaPP(int id) {
        String sql = "SELECT barcode FROM public.product_product where id = " + id;
        String barrakodea = "";
        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                barrakodea = rs.getString("barcode");
            }
        } catch (Exception ex) {
            System.out.println("Exception (PP): " + ex);
        }
        return barrakodea;
    }

    public static float irakurriTaulaSQ(int id) {
        String sql = "SELECT quantity FROM public.stock_quant where product_id = " + id + " and location_id = 8";
        float quant = 0;
        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                quant = rs.getFloat("quantity");
            }
        } catch (Exception ex) {
            System.out.println("Exception (SQ): " + ex);
        }
        return quant;
    }

}
