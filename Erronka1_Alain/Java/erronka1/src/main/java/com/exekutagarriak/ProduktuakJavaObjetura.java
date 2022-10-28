package com.exekutagarriak;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.konexioa.Konekzioa;
import com.pojoak.Produktua;
import com.pojoak.Produktuak;

import com.atzipenekoak.Csva;
import com.atzipenekoak.Jsona;
import com.atzipenekoak.Xmla;

public class ProduktuakJavaObjetura {

    ProduktuakJavaObjetura(){

    }

    public static Produktuak ProduktuenJavaObjetua(){

        ArrayList<String> product_template = new ArrayList<String>(); // Produktuen informazioa gordeko den Arraylist-a
                                                                      // sortu, String bezala gordetzen da informazioa
        ArrayList<String> stock_quant = new ArrayList<String>(); // Stock-aren informazioa gordeko den Arraylist-a
                                                                 // sortu, String bezala gordetzen da informazioa

        String id;
        product_template = irakurriTaulaP("product_template"); // product_template taula irakurri, eta bere datuak
                                                               // product_template deitzen den Arraylist-ean gorde
        stock_quant = irakurriTaulaS("stock_quant"); // stock_quant taula irakurri, eta bere datuak stock_quant deitzen
                                                     // den Arraylist-ean gorde
        
        Produktuak produktuak = new Produktuak(); // Produktua objetuak edukiko duen ArrayList-a sortu
        // Objetua sortu
        for (String string : product_template) { // product_template ArrayList-eko elementu bakoitzeko egin hurrengoa
            
                                       // Konparaketa gutxiago egiteko erabiliko dugu
            
                String[] zatiak = string.split(";"); // Datuen String-a zatietan banatu datu bakoitza banatuta
                                                     // edukitzeko
                id = zatiak[0]; // Produktuaren ID-a lortu
                for (String string2 : stock_quant) {
                    String[] zatiak2 = string2.split(";");
                    if (zatiak2[0].equals(id)) {
                        Produktua produktua = new Produktua(); // produktua objetu bat sortu
                        produktua.setId(Integer.parseInt(id)); // ID-a ezarri
                        produktua.setIzena(zatiak[1]); // zatiak[1] posizioan produktuaren izena dago
                        produktua.setStocka(Integer.parseInt(zatiak2[1])); // zatiak2[1] posizioan stock-a dago gordeta
                        produktua.setPrezioa(Integer.parseInt(zatiak[2])); // zatiak[2] posizioan prezioa dago gordeta
                        produktuak.add(produktua);}
                }
            
        }
        // Orain nahi dugun formatuan ahal dugu esportatu
        return produktuak;

    }

    public static ArrayList<String> irakurriTaulaP(String taula) {
        Konekzioa konekzioa = new Konekzioa();
        String sql = "SELECT * FROM public.\"" + taula + "\"";
        ArrayList<String> modelo = new ArrayList<String>();
        Statement st;
        try {
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.add(rs.getString("id") + ";" + rs.getString("name") + ";"
                        + Integer.toString(rs.getShort("list_price"))); // id, izena eta prezioa lortu, taula onetan ez dago stock-aren datua
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
        return modelo;
    }

    public static ArrayList<String> irakurriTaulaS(String taula) {
        Konekzioa konekzioa = new Konekzioa();
        String sql = "SELECT * FROM public.\"" + taula + "\" WHERE location_id = 8"; /*
                                                                                      * Produktu bakoitza bi aldiz
                                                                                      * agertzen da location id ezberdin
                                                                                      * batekin, batean 8 balioa dauka
                                                                                      * eta bestean 14. 8 bada stock-ean
                                                                                      * dagoen balioa zuzena da, 14 bada
                                                                                      * stock-eko balioa zuzena da,
                                                                                      * baina negatiboa agertzen da
                                                                                      */
        ArrayList<String> modelo = new ArrayList<String>();
        Statement st;
        try {
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.add(rs.getString("product_id") + ";" + Integer.toString(rs.getShort("quantity"))); /*
                                                                                                           * produktuaren
                                                                                                           * ID-a eta
                                                                                                           * stock-a
                                                                                                           * lortzen da
                                                                                                           */

            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
        return modelo;
    }

}
