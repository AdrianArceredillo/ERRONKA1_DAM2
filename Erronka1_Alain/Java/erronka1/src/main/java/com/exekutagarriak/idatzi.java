package com.exekutagarriak;

import java.sql.Statement;

import com.konexioa.Konexioa;


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
        String sql = "INSERT INTO public.\"" + taula +"\" VALUES('Proba','12',NULL, true);"; // AAAAAAAAA taulan sartzeko datuak
        /*INSERT INTO public."product_template"
VALUES(
	8,
	NULL,
	'Proba_Izena231478',
	1,
	'<p><br></p>',
	NULL,
	NULL,
	'product',
	'product',
	1,
	420,
	10,
	10,
	true,
	true,
	1,
	1,
	NULL,
	true,
	NULL,
	NULL,
	false,
	false,
	0,
	2,
	'2022-10-26 08:32:55.509688',
	2,
	'2022-10-26 08:32:55.509688',
	0,
	'hgfg',
	NULL,
	NULL,
	NULL,
	'receive',
	'no-message',
	NULL,
	'manual',
	'no-message',
	NULL,
	'no',
	'order',
	false
);*/
        //String sql = "INSERT INTO public.\"" + taula +"\" VALUES();"; 
        Konexioa konekzioa = new Konexioa();
        Statement st;
        try{
            st = konekzioa.connectDatabase().createStatement();
            System.out.println(st.executeQuery(sql)); 
        } catch(Exception ex){} //Cath-ean sartzen da, baina arazorik gabe exekutatzen du sql-a
    }
}
