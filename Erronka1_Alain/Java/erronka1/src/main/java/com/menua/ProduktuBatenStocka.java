package com.menua;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.konexioa.Konexioa;

public class ProduktuBatenStocka {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;

    public static String produktuaGehitu(int idPT, int idPP, int idSQ, String izena, String deskripzioa, String barraKodea, Float prezioa,
            Float bolumena, Float pisua, Float kantitatea, String lehentasuna) {
        garbitu();
        // int idPT = idLortuPT() + 1;
        // int idPP = idLortuPP() + 1;
        // int idSQ = idLortuSQ() + 1;
        String timeStamp;
        timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date());

        String sqlPT = "INSERT INTO public.product_template VALUES"; // sqlPT -> SQL agiandua Product_Template
                                                                     // taularentzako
        sqlPT += " ( " + idPT + ", NULL,'" + izena + "',1,'<p>" + deskripzioa
                + "</p>',NULL,NULL,'product','product',1,"
                + prezioa + "," + bolumena + "," + pisua + ",true,true,1,1,NULL,true,NULL,NULL,false,false, '"+lehentasuna+"',2,'"
                + timeStamp
                + "',2,'"
                + timeStamp
                + "',0,'none',NULL,NULL,NULL,'receive','no-message',NULL,'manual','no-message',NULL,'no','order',false)";
        exekuzioa(sqlPT, "PT");

        String sqlPP = "INSERT INTO public.product_product VALUES"; // sqlPP -> SQL agindua Product_Product
                                                                    // taularentzako
        sqlPP += "(" + idPP + ", null, null, true, " + idPT + ", '" + barraKodea + "', '', null, null, false, 2, '"
                + timeStamp
                + "', 2, '" + timeStamp + "')";
        exekuzioa(sqlPP, "PP");

        String sqlSQ = "INSERT INTO public.stock_quant VALUES"; // sqlSQ -> SQL agindua Stock_Quant taularentzako
        sqlSQ += "(" + idSQ + "      , " + idPP + ", 1,  8, null, null, null, " + kantitatea + "       , 0, '"
                + timeStamp
                + "',    0,                  0, '2022-12-31',  true, null, 2, '" + timeStamp + "', 2, '" + timeStamp
                + "', null)";
        exekuzioa(sqlSQ, "SQ");

        sqlSQ = "INSERT INTO public.stock_quant VALUES"; // Bigarren agindua taula berdinarentzako, zeren taula honetan,
                                                         // produktu bakoitzeko 2 ilara idazten dira
        sqlSQ += "(" + (idSQ + 1) + ", " + idPP + ", 1, 14, null, null, null, " + (kantitatea * -1) + ", 0, '"
                + timeStamp
                + "', null, " + kantitatea + ", null        , false, null, 2, '" + timeStamp + "', 2, '" + timeStamp
                + "', null)";
        exekuzioa(sqlSQ, "SQ");

        return idPT + ";" + idPP + ";" + idSQ;
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
