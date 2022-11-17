package com.postgress.delete;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.konexioa.Konexioa;
import com.postgress.ProduktuakJavaObjetura;
import com.postgress.update.ProduktuBatAldatu;

public class ProduktuBatEzabatu {
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
        System.out.print(ProduktuakJavaObjetura.produktuenJavaObjetua());
        do {
            System.out.print("Aukeratu produktu bat bere ID-a idazten: ");
            idPT = in.nextInt();
            System.out.println("Ziur zaude " + izenaLortu(idPT) + " produktua nahi duzula ezabatu? (Bai/Ez)");
            erantzuna = in.next().toLowerCase();
            if (erantzuna.equals("bai") || erantzuna.equals("b")) {
                produktuaEzabatu(idPT);
                System.out.println("Hemen produktu guztien lista berria:");
                System.out.println(
                        "Produktua[id, izena, deskripzioa, prezioa, stocka, bolumena, pisua, barraKodea, lehentasuna]");
                System.out.print(ProduktuakJavaObjetura.produktuenJavaObjetua());
            }
            System.out.println("Nahi duzu beste produktu bat ezabatu? (Bai/Ez)");
            erantzuna = in.next().toLowerCase();
            in.nextLine();
            if (erantzuna.equals("bai") || erantzuna.equals("b")) {
                bestebat = true;
            } else {
                bestebat = false;
            }
        } while (bestebat);
        ProduktuBatAldatu.garbitu();
    }

    public static void produktuaEzabatu(int idPT) {
        int idPP = 0;
        String sql = "SELECT id FROM public.product_product where product_tmpl_id = " + idPT;
        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idPP = rs.getInt(1);
            }
        } catch (Exception ex) {
            //System.out.println("Exception (PP): " + ex);
        }

        sql = "delete from public.stock_quant where product_id = " + idPP;
        exekutatu(sql);

        sql = "delete from public.product_product where id = " + idPP;
        exekutatu(sql);

        sql = "delete from public.product_template where id = " + idPT;
        exekutatu(sql);
        
        ProduktuBatAldatu.garbitu();
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
            //System.out.println("Exception (TP id): " + ex);
        }
        return izena;

    }

    public static void exekutatu(String sql) {
        try {
            st = konexioa.connectDatabase().createStatement();
            st.executeQuery(sql);
        } catch (Exception ex) {
            //System.out.println(ex);
        }
    }
}
