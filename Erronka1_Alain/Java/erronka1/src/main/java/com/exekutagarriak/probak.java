package com.exekutagarriak;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.konexioa.Konexioa;

public class probak {
    public static void main(String[] args) { //Konpondu programa
        garbitu();
        int id = idLortu() + 1;
        String izena = "PROBA_01";
        String deskripzioa = "Deskripzioa";
        float prezioa = 0;
        String timeStamp;
        timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date());

        String sqlPT = "INSERT INTO public.product_template VALUES";
        sqlPT += " ( " + id + ", NULL,'" + izena + "',1,'<p>" + deskripzioa
        + "</p>',NULL,NULL,'product','product',1,"
        + prezioa + ",10,10,true,true,1,1,NULL,true,NULL,NULL,false,false,0,2,'" + timeStamp
        + "',2,'"
        + timeStamp
        + "',0,'none',NULL,NULL,NULL,'receive','no-message',NULL,'manual','no-message',NULL,'no','order',false)";
        exekuzioa(sqlPT);
        String sqlPP = "INSERT INTO public.product_template VALUES";
        sqlPP += "(15, null, null, true, " + id + ", null, '', null, null, false, 2, " + timeStamp + ", 2, " + timeStamp;
        exekuzioa(sqlPP);        
    }

    public static void exekuzioa(String sql) {
        Konexioa konekzioa = new Konexioa();
        Statement st;
        try {
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            System.out.println(st.executeQuery(sql));
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    public static int idLortu() {
        String sql = "SELECT id FROM public.\"product_template\" ORDER BY id DESC LIMIT 1";
        int id = 0;
        try {
            st = konexioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
        return id;
    }

    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
