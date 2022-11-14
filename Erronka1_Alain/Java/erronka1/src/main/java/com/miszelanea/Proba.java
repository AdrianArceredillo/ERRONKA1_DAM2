package com.miszelanea;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.konexioa.Konexioa;

public class Proba {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;
    public static void main(String[] args) {
        int idPT = idLortuPT() + 1;
        String izena = "PROBA_05";
        String deskripzioa = "Deskripzioa";
        float prezioa = 0;
        String timeStamp;
        timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date());

        String sqlPT = "INSERT INTO public.product_template VALUES"; // sqlPT -> SQL agiandua Product_Template
                                                                     // taularentzako
        sqlPT += " ( " + idPT + ", NULL,'" + izena + "',1,'<p>" + deskripzioa
                + "</p>',NULL,NULL,'product','product',1,"
                + prezioa + ",10,10,true,true,1,1,NULL,true,NULL,NULL,false,false,0,2,'" + timeStamp
                + "',2,'"
                + timeStamp
                + "',0,'none',NULL,NULL,NULL,'receive','no-message',NULL,'manual','no-message',NULL,'no','order',false)";
        exekuzioa(sqlPT, "PT");
        
    }

    public static void exekuzioa(String sql, String taula) {
        Konexioa konekzioa = new Konexioa();
        Statement st;
        try {
            st = konekzioa.connectDatabase().createStatement();
            System.out.println(st.executeQuery(sql));
        } catch (Exception ex) {
            System.out.println("Exception: (" + taula + ")" + ex);
        }
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

}
