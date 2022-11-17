package com.postgress.delete;

import java.sql.Statement;
import java.util.Scanner;

import com.konexioa.Konexioa;

public class GarbituTaulak {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;
    public static Scanner in;

    public static void garbitu() {
        String erantzuna;
        System.out.println("Ziur zaude produktu guztiak ezabatu nahi dituzula? (Bai/Ez)");
        in = new Scanner(System.in);
        erantzuna = in.nextLine();
        erantzuna = erantzuna.toLowerCase();
        if (erantzuna.equals("bai") || erantzuna.equals("b")) {
            garbiketa();
        }

    }

    public static void garbiketa() {
        String sql = "delete from public.stock_quant";
        try {
            st = konexioa.connectDatabase().createStatement();
            st.executeQuery(sql);
        } catch (Exception ex) {
            //System.out.println(ex);
        }

        sql = "delete from public.product_product";
        try {
            st = konexioa.connectDatabase().createStatement();
            st.executeQuery(sql);
        } catch (Exception ex) {
            //System.out.println(ex);
        }

        sql = "delete from public.product_template";
        try {
            st = konexioa.connectDatabase().createStatement();
            st.executeQuery(sql);
        } catch (Exception ex) {
            //System.out.println(ex);
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
