package com.postgress;

import java.sql.Statement;
import java.util.Scanner;

import com.konexioa.Konexioa;

public class GarbituTaulak {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;
    public static Scanner in;

    public static void garbitu() {
        boolean ezabatu;
        String erantzuna;
        System.out.println("Ziur zaude produktu guztiak ezabatu nahi dituzula? (Bai/Ez)");
        in = new Scanner(System.in);
        erantzuna = in.nextLine();
        in.next();
        erantzuna = erantzuna.toLowerCase();
        if (erantzuna.equals("bai") || erantzuna.equals("b")) {

            String sql = "delete from public.stock_quant";
            try {
                st = konexioa.connectDatabase().createStatement();
                st.executeQuery(sql);
            } catch (Exception ex) {
                System.out.println(ex);
            }

            sql = "delete from public.product_product";
            try {
                st = konexioa.connectDatabase().createStatement();
                st.executeQuery(sql);
            } catch (Exception ex) {
                System.out.println(ex);
            }

            sql = "delete from public.product_template";
            try {
                st = konexioa.connectDatabase().createStatement();
                st.executeQuery(sql);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } 

    }
}
