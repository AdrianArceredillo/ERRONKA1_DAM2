package com.postgress;

import java.sql.Statement;

import com.konexioa.Konexioa;

public class GarbituTaulak {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;
    public static void garbitu() {

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
