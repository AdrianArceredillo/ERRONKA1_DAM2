package com.exekutagarriak;

import java.sql.Statement;

import com.konexioa.Konekzioa;


/**
 * Gure aplikazioaren Main klasea
 *
 */
public class idatzi 
{
    public static void main( String[] args )
    {
        

        //insertTaula("AAAAAAAAA");
        //insertTaula("product_template");
        insertTaula("product_product");
    }
    public static void insertTaula(String taula){
        //String sql = "INSERT INTO public.\"" + taula +"\" VALUES('Proba','12',NULL, true);"; // AAAAAAAAA taulan sartzeko datuak
        //String sql = "INSERT INTO public.\"" + taula +"\" VALUES(NULL, NULL, 'Proba_Izena', 1, '<p><br></p>', NULL, NULL, 'product', 'product', 1, 420, 10, 10, true, 1, 1, NULL, true, NULL, NULL, false, false, 0, 2, '2022-10-26 08:32:55.509688', 0, 'none', NULL, NULL, NULL, 'receive', 'no-message', NULL, 'manual', 'no-message', NULL, 'no', 'order', NULL);";
        String sql = "INSERT INTO public.\"" + taula +"\" VALUES();"; // AAAAAAAAA taulan sartzeko datuak
        Konekzioa konekzioa = new Konekzioa();
        Statement st;
        try{
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            System.out.println(st.executeQuery(sql)); 
        } catch(Exception ex){} //Cath-ean sartzen da, baina arazorik gabe exekutatzen du sql-a
    }
}
