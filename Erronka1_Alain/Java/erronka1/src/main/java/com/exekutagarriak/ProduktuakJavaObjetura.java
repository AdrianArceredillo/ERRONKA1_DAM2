package com.exekutagarriak;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.konexioa.Konexioa;
import com.pojoak.Produktua;
import com.pojoak.Produktuak;

public class ProduktuakJavaObjetura {

    public static Produktuak ProduktuenJavaObjetua() {

        ArrayList<String> product_template = new ArrayList<String>(); // Produktuen informazioa gordeko den Arraylist-a
                                                                      // sortu, String bezala gordetzen da informazioa
        ArrayList<String> stock_quant = new ArrayList<String>(); // Stock-aren informazioa gordeko den Arraylist-a
                                                                 // sortu, String bezala gordetzen da informazioa

        String id; // Product eta stock tauletan, produktuak id bat edukitzen du. Aldagai hau bi
                   // tauletako produktuaren id-a konparatzeko erabiliko da

        product_template = irakurriTaulaP("product_template"); // product_template taula irakurri, eta bere datuak
                                                               // product_template deitzen den Arraylist-ean gorde

        stock_quant = irakurriTaulaS("stock_quant"); // stock_quant taula irakurri, eta bere datuak stock_quant deitzen
                                                     // den Arraylist-ean gorde

        Produktuak produktuak = new Produktuak(); // Produktua objetuak edukiko duen ArrayList-a sortu

        for (String pString : product_template) { // product_template ArrayList-eko elementuak String-ak dira. Elementu
                                                  // bakoitzeko egin hurrengoa

            String[] pZatiak = pString.split(";"); // Produktuaren string-a zatietan banatu, eta pZatiak izeneko Array bat sortu
            id = pZatiak[0]; // Produktuaren ID-a lortu
            for (String sString : stock_quant) { // stock_quant ArrayList-eko elementuak String-ak dira. Elementu
                                                 // bakoitzeko egin hurrengoa
                String[] sZatiak = sString.split(";"); // Stock-aren string-a zatietan banatu, eta sZatiak izeneko Array bat sortu
                if (sZatiak[0].equals(id)) {
                    Produktua produktua = new Produktua(); // produktua objetu bat sortu
                    produktua.setId(Integer.parseInt(id)); // ID-a ezarri
                    produktua.setIzena(pZatiak[1]); // pZatiak[1] posizioan produktuaren izena dago
                    produktua.setStocka(Integer.parseInt(sZatiak[1])); // sZatiak2[1] posizioan stock-a dago gordeta
                    produktua.setPrezioa(Integer.parseInt(pZatiak[2])); // pZatiak[2] posizioan prezioa dago gordeta
                    produktuak.add(produktua); // Aurreko datuak lortuta, produktuak objetua prest dago.
                                               // Orain produktuak Arraylist-era gehituko dugu
                }
            }
        }
        // Produktuak Arraylist-a prestatu ondoren, nahi dugun formatura ahal dugu esportatu
        return produktuak;
    }

    public static ArrayList<String> irakurriTaulaP(String taula) {
        Konexioa konexioa = new Konexioa(); // Konexio motako objetu berri bat sortu
        String sql = "SELECT * FROM public.\"" + taula + "\""; // sql agindua nahi dugun taulako informazio guztia agertzeko
        ArrayList<String> datuak = new ArrayList<String>(); // Datuak gordetzeko Arraylist bat sortu
        Statement st;
        try {
            st = konexioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement(); // konektatu
            ResultSet rs = st.executeQuery(sql); // sql exekutatu
            while (rs.next()) { // Taulan informazioa dagoen bitartean egin hurrengoa
                datuak.add(rs.getString("id") + ";" + rs.getString("name") + ";"
                        + Integer.toString(rs.getShort("list_price"))); // id, izena eta prezioa lortu eta datuak Arraylist-ean gorde
                                                                                    // Taula onetan ez dago stock-aren datua
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
        return datuak; // Lortutako datuen Arraylist-a bueltatu
    }

    public static ArrayList<String> irakurriTaulaS(String taula) {
        Konexioa konexioa = new Konexioa();
        String sql = "SELECT * FROM public.\"" + taula + "\" WHERE location_id = 8"; /*
                                                                                      * Produktu bakoitza bi aldiz
                                                                                      * agertzen da stock_quant taulan,
                                                                                      * location id ezberdin batekin,
                                                                                      * batean 8 balioa dauka
                                                                                      * eta bestean 14. 8 bada stock-ean
                                                                                      * dagoen balioa zuzena da, 14 bada
                                                                                      * stock-eko balioa zuzena da,
                                                                                      * baina negatiboa agertzen da
                                                                                      */
        ArrayList<String> datuak = new ArrayList<String>();
        Statement st;
        try {
            st = konexioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datuak.add(rs.getString("product_id") + ";" + Integer.toString(rs.getShort("quantity")));
                // produktuaren ID-a eta stock-a lortzen da
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
        return datuak;
    }

}
