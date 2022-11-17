package com.postgress.insert;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.konexioa.Konexioa;

public class InsertProduktua {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;

    public static String produktuaGehitu(int idPT, int idPP, int idSQ, String izena, String deskripzioa, String barraKodea, Float prezioa,
            Float bolumena, Float pisua, Float stocka, String lehentasuna) {
        garbitu();
        if(lehentasuna.toLowerCase().equals("bai") || lehentasuna.toLowerCase().equals("b") || lehentasuna.equals("1")){
            lehentasuna = "1";
        } else {
            lehentasuna = "0";
        }
        String timeStamp;
        timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date());
/*
        INSERT INTO
        public."product_template"(id, name, description, list_price, volume, weight, priority, create_date, write_date, message_main_attachment_id, sequence, description_purchase, description_sale, detailed_type, type, categ_id, sale_ok, purchase_ok, uom_id, uom_po_id, company_id, active, color, default_code, can_image_1024_be_zoomed, has_configurable_attributes, create_uid, write_uid, sale_delay, tracking, description_picking, description_pickingout, description_pickingin, purchase_method, purchase_line_warn, purchase_line_warn_msg, service_type, sale_line_warn, sale_line_warn_msg, expense_policy, invoice_policy, service_to_purchase)
        values (7, 'izena', 'deskripzioa', 123, 123, 123, '1', '2022-11-15 19:19:18.631', '2022-11-15 19:19:18.631', null, 1, null, null, 'product', 'product', 1, true, true, 1, 1, null, true, null, null, false, false, 2, 2, 0, 'none', null, null, null, 'receive', 'no-message', null, 'manual', 'no-message', null, 'no', 'order', false)
 */

        String sqlPT = "INSERT INTO public.product_template VALUES"; // sqlPT -> SQL agiandua Product_Template
                                                                     // taularentzako
        sqlPT += " ( " + idPT + ", NULL,'" + izena + "',1,'" + deskripzioa
                + "',NULL,NULL,'product','product',1,"
                + prezioa + "," + bolumena + "," + pisua + ",true,true,1,1,NULL,true,NULL,NULL,false,false, '"+lehentasuna+"',2,'"
                + timeStamp
                + "',2,'"
                + timeStamp
                + "','manual', 'no-message', null, 'no', 'order', 0, 'none', null, null, null, 'receive', 'no-message', null, false)";
        exekuzioa(sqlPT, "PT");

        String sqlPP = "INSERT INTO public.product_product VALUES"; // sqlPP -> SQL agindua Product_Product
                                                                    // taularentzako
        sqlPP += "(" + idPP + ", null, null, true, " + idPT + ", '" + barraKodea + "', '', null, null, false, 2, '"
                + timeStamp
                + "', 2, '" + timeStamp + "')";
        exekuzioa(sqlPP, "PP");

        String sqlSQ = "INSERT INTO public.stock_quant VALUES"; // sqlSQ -> SQL agindua Stock_Quant taularentzako
        sqlSQ += "(" + idSQ + "      , " + idPP + ", 1,  8, null, null, null, " + stocka + "       , 0, '"
                + timeStamp
                + "',   null,                  0, '2022-12-31',  true, null, 2, '" + timeStamp + "', 7, '" + timeStamp
                + "', null)";
        exekuzioa(sqlSQ, "SQ");
            //id, idPP, 1, 8, null, null, null, stocka, 0, timeStamp, null, 0, '2022-12-31', true, null, 2, timeStamp, 7, timeStamp, null
        sqlSQ = "INSERT INTO public.stock_quant VALUES"; // Bigarren agindua taula berdinarentzako, zeren taula honetan,
                                                         // produktu bakoitzeko 2 ilara idazten dira
        sqlSQ += "(" + (idSQ + 1) + ", " + idPP + ", 1, 14, null, null, null, " + (stocka * -1) + ", 0, '"
                + timeStamp
                + "', null, " + stocka + ", null        , false, null, 7, '" + timeStamp + "', 7, '" + timeStamp
                + "', null)";
        exekuzioa(sqlSQ, "SQ");
            //id, idPP, 1, 14, null, null, null, stocka*-1, 0, timeStamp, null, stocka, null, false, null, 7, timeStamp, 7, timeStamp, null
        return idPT + ";" + idPP + ";" + idSQ;
    }

    public static void exekuzioa(String sql, String taula) {
        Konexioa konekzioa = new Konexioa();
        Statement st;
        try {
            st = konekzioa.connectDatabase().createStatement();
            System.out.println(st.executeQuery(sql));
        } catch (Exception ex) {
            //System.out.println("Exception: (" + taula + ")" + ex);
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
            //System.out.println("Exception (PT id): " + ex);
        }
        //System.out.println("Lortutako PT id-a: " + id);
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
            //System.out.println("Exception (PP id): " + ex);
        }
        //System.out.println("Lortutako PP id-a: " + id);
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
            //System.out.println("Exception (SQ id): " + ex);
        }
        //System.out.println("Lortutako SQ id-a: " + id);
        return id;
    }

    private static void garbitu() {
        // System.out.print("\033[H\033[2J");
        // System.out.flush();
    }
}
