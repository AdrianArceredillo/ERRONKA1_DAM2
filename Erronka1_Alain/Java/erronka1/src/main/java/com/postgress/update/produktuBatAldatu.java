package com.postgress.update;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.konexioa.Konexioa;
import com.postgress.ProduktuakJavaObjetura;

public class ProduktuBatAldatu {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;
    public static Scanner in;

    public static void produktuaAldatu() {
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
        // ID;IZENA;DESKRIPZIOA;PREZIOA;STOCKA;BOLUMENA;PISUA;BARRAKODEA;LEHENTASUNA
        String name, description, barcode, priority;
        float list_price, quantity, volume, weight;

        int idPP = 0;
        boolean egin = true;
        do {
            garbitu();
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
            System.out.println("Stocka: " + quantity);
            System.out.println("Bolumena (m\u00B3): " + volume);
            System.out.println("Pisua (Kg): " + weight);
            System.out.println("Barra kodea: " + barcode);
            if (priority.equals("1")){
                System.out.println("Lehentasuna: Bai");
            } else {
                System.out.println("Lehentasuna: Ez");
            }
            

            System.out.println(
                    "Ze datu nahi duzu aldatu? (izena/deskripzioa/prezioa/stocka/bolumena/pisua/barrakodea/lehentasuna)(irten)");
            in = new Scanner(System.in);
            String erantzuna = in.nextLine().toLowerCase();
            switch (erantzuna) {
                case "izena":
                    izenaAldatu(name, idPT);
                    break;
                case "deskripzioa":
                    deskripzioaAldatu(description, idPT);
                    break;
                case "prezioa":
                    prezioaAldatu(list_price, idPT);
                    break;
                case "stocka":
                    stockaAldatu(quantity, idPP);
                    break;
                case "bolumena":
                    bolumenaAldatu(volume, idPT);
                    break;
                case "pisua":
                    pisuaAldatu(weight, idPT);
                    break;
                case "barrakodea":
                    barraKodeaAldatu(barcode, idPP);
                    break;
                case "lehentasuna":
                    lehentasunaAldatu(priority, idPT);
                    break;
                case "irten":
                    egin = false;
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (egin);

    }

    public static void izenaAldatu(String name, int id) {

        String nameBerria;
        System.out.println("Aurreko izena: " + name);
        System.out.print("Izen berria: ");
        in = new Scanner(System.in);
        nameBerria = in.nextLine();
        String sql = "UPDATE public.product_template SET name = '" + nameBerria + "' WHERE id = " + id;
        exekutatu(sql);

    }

    public static void deskripzioaAldatu(String description, int id) {
        String descriptionBerria;
        System.out.println("Aurreko deskripzioa: " + description);
        System.out.print("Deskripzio berria: ");
        in = new Scanner(System.in);
        descriptionBerria = in.nextLine();
        String sql = "UPDATE public.product_template SET description = '<p>" + descriptionBerria + "</p>' WHERE id = " + id;
        exekutatu(sql);
    }

    public static void prezioaAldatu(float list_price, int id) {
        float list_priceBerria;
        System.out.println("Aurreko prezioa: " + list_price);
        System.out.print("Prezio berria: ");
        in = new Scanner(System.in);
        list_priceBerria = in.nextFloat();
        String sql = "UPDATE public.product_template SET list_price = " + list_priceBerria + " WHERE id = " + id;
        exekutatu(sql);
    }

    public static void stockaAldatu(float quant, int id) {
        float quantBerria;
        System.out.println("Aurreko stocka: " + quant);
        System.out.print("Stock berria: ");
        in = new Scanner(System.in);
        quantBerria = in.nextFloat();
        String sql = "UPDATE public.stock_quant SET quantity = " + quantBerria + " WHERE product_id = " + id + " and location_id = 8";
        exekutatu(sql);
        sql = "UPDATE public.stock_quant SET quantity = " + (quantBerria*-1) + " WHERE product_id = " + id + " and location_id = 14";
        exekutatu(sql);
    }

    public static void bolumenaAldatu(float volume, int id) {
        float volumeBerria;
        System.out.println("Aurreko bolumena (m\u00B3): " + volume);
        System.out.print("Bolumen berria (m\u00B3): ");
        in = new Scanner(System.in);
        volumeBerria = in.nextFloat();
        String sql = "UPDATE public.product_template SET volume = " + volumeBerria + " WHERE id = " + id;
        exekutatu(sql);
    }

    public static void pisuaAldatu(float weight, int id) {
        float weightBerria;
        System.out.println("Aurreko pisua (Kg): " + weight);
        System.out.print("Pisu berria (Kg): ");
        in = new Scanner(System.in);
        weightBerria = in.nextFloat();
        String sql = "UPDATE public.product_template SET weight = " + weightBerria + " WHERE id = " + id;
        exekutatu(sql);
    }

    public static void barraKodeaAldatu(String barcode, int id) {
        String barcodeBerria;
        System.out.println("Aurreko barra kodea: " + barcode);
        System.out.print("Barra kode berria (ezin da izan beste barra kode baten berdina): ");
        in = new Scanner(System.in);
        barcodeBerria = in.nextLine();
        String sql = "UPDATE public.product_product SET barcode = '" + barcodeBerria + "' WHERE id = " + id;
        exekutatu(sql);
    }

    public static void lehentasunaAldatu(String priority, int id) {
        String priorityBerria;
        if(priority.equals("1")){
            priority = "Bai";
        }else{
            priority = "Ez";
        }
        System.out.println("Aurreko lehentasuna: " + priority);
        System.out.print("Lehentasun berria (Bai/Ez): ");
        in = new Scanner(System.in);
        priorityBerria = in.nextLine().toLowerCase();
        if(priorityBerria.equals("bai") || priorityBerria.equals("b") || priorityBerria.equals("1")){
            priorityBerria = "1";
        }else{
            priorityBerria = "0";
        }
        String sql = "UPDATE public.product_template SET priority = '" + priorityBerria + "' WHERE id = " + id;
        exekutatu(sql);
    }

    public static void exekutatu(String sql) {
        try {
            st = konexioa.connectDatabase().createStatement();
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex);
        }
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

    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
