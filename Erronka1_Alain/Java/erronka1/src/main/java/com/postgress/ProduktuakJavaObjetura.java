package com.postgress;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.konexioa.Konexioa;
import com.pojoak.Produktua;
import com.pojoak.Produktuak;

public class ProduktuakJavaObjetura {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;

    public static Produktuak ProduktuenJavaObjetua() {

        ArrayList<String> product_template = new ArrayList<String>(); // Produktuen informazioa gordeko den Arraylist-a
                                                                      // sortu, String bezala gordetzen da informazioa

        ArrayList<String> product_product = new ArrayList<String>(); // Product_Product taulan barra kodea lortu behar
                                                                     // da

        ArrayList<String> stock_quant = new ArrayList<String>(); // Stock-aren informazioa gordeko den Arraylist-a
                                                                 // sortu, String bezala gordetzen da informazioa

        product_template = irakurriTaulaPT("product_template"); // product_template taula irakurri, eta bere datuak
                                                                // product_template deitzen den Arraylist-ean gorde

        product_product = irakurriTaulaPP("product_product"); // Product_product taula irakurri eta datuak lortu

        stock_quant = irakurriTaulaSQ("stock_quant"); // stock_quant taula irakurri, eta bere datuak stock_quant deitzen
                                                      // den Arraylist-ean gorde

        Produktuak produktuak = new Produktuak(); // Produktua objetuak edukiko duen ArrayList-a sortu

        boolean aurkitua = false;
        String idpt, idpp, idpppt, idsqpp; // id-> Product_template, product_product, product_product
                                           // (product_template),
                                           // stock_quant (product_product)
        String izena, deskripzioa, barrakodea, lehentasuna;
        float prezioa, stocka, bolumena, pisua;

        for (String ppString : product_product) {
            if (!aurkitua) {
                String[] ppZatiak = ppString.split(";");
                idpp = ppZatiak[0];
                idpppt = ppZatiak[1];
                for (String ptString : product_template) {
                    String[] ptZatiak = ptString.split(";");
                    idpt = ptZatiak[0];
                    if (idpt.equals(idpppt)) { // Product_Product taulan dagoen product_template id-ak bat egiten
                                               // badu
                                               // product_template taularen id-arekin
                        for (String sqString : stock_quant) {
                            if (!aurkitua) {
                                String[] sqZatiak = sqString.split(";");
                                idsqpp = sqZatiak[0];
                                if (idpp.equals(idsqpp)) {

                                    izena = ptZatiak[1];
                                    deskripzioa = ptZatiak[2];
                                    barrakodea = ppZatiak[2];
                                    prezioa = Float.parseFloat(ptZatiak[3]);
                                    stocka = Float.parseFloat(sqZatiak[1]);
                                    bolumena = Float.parseFloat(ptZatiak[4]);
                                    pisua = Float.parseFloat(ptZatiak[5]);
                                    lehentasuna = ptZatiak[6];

                                    aurkitua = true;
                                    Produktua produktua = new Produktua(); // ID;IZENA;DESKRIPZIOA;PREZIOA;stocka;BOLUMENA;PISUA;BARRAKODEA;LEHENTASUNA
                                    produktua.setId(Integer.parseInt(idpt));
                                    produktua.setIzena(izena);
                                    produktua.setDeskripzioa(deskripzioa);
                                    produktua.setPrezioa(prezioa);
                                    produktua.setStocka(stocka);
                                    produktua.setBolumena(bolumena);
                                    produktua.setPisua(pisua);
                                    produktua.setBarraKodea(barrakodea);
                                    produktua.setLehentasuna(lehentasuna);
                                    produktuak.add(produktua);

                                }
                            }
                        }
                    }
                }
            }
            aurkitua = false;
        }
        // Produktuak Arraylist-a prestatu ondoren, nahi dugun formatura ahal dugu
        // esportatu

        return produktuak;
    }

    public static ArrayList<String> irakurriTaulaPT(String taula) {
        String sql = "SELECT * FROM public.\"" + taula + "\" order by id asc"; // sql agindua nahi dugun taulako
                                                                               // informazio guztia agertzeko
        ArrayList<String> datuak = new ArrayList<String>(); // Datuak gordetzeko Arraylist bat sortu
        try {
            st = konexioa.connectDatabase().createStatement(); // konektatu
            ResultSet rs = st.executeQuery(sql); // sql exekutatu
            while (rs.next()) { // Taulan informazioa dagoen bitartean egin hurrengoa
                datuak.add(rs.getString("id") + ";" + rs.getString("name") + ";" + rs.getString("description") + ";"
                        + Float.toString(rs.getFloat("list_price")) + ";" + Float.toString(rs.getFloat("volume")) + ";"
                        + Float.toString(rs.getFloat("weight")) + ";" + rs.getString("priority"));
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
        return datuak; // Lortutako datuen Arraylist-a bueltatu
    }

    public static ArrayList<String> irakurriTaulaPP(String taula) {
        String sql = "SELECT * FROM public.\"" + taula + "\" order by id asc"; // sql agindua nahi dugun taulako
                                                                               // informazio guztia agertzeko
        ArrayList<String> datuak = new ArrayList<String>(); // Datuak gordetzeko Arraylist bat sortu
        try {
            st = konexioa.connectDatabase().createStatement(); // konektatu
            ResultSet rs = st.executeQuery(sql); // sql exekutatu
            while (rs.next()) { // Taulan informazioa dagoen bitartean egin hurrengoa
                datuak.add(rs.getString("id") + ";" + rs.getString("product_tmpl_id") + ";" + rs.getString("barcode")); // id,
                                                                                                                        // product_product
                                                                                                                        // id
                                                                                                                        // eta
                                                                                                                        // barra
                                                                                                                        // kodea
                                                                                                                        // lortu
                                                                                                                        // eta
                                                                                                                        // datuak
                // Arraylist-ean gorde
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
        return datuak; // Lortutako datuen Arraylist-a bueltatu
    }

    public static ArrayList<String> irakurriTaulaSQ(String taula) {
        String sql = "SELECT * FROM public.\"" + taula + "\" WHERE location_id = 8 order by id asc"; /*
                                                                                                      * Produktu
                                                                                                      * bakoitza bi
                                                                                                      * aldiz
                                                                                                      * agertzen da
                                                                                                      * stock_quant
                                                                                                      * taulan,
                                                                                                      * location id
                                                                                                      * ezberdin
                                                                                                      * batekin,
                                                                                                      * batean 8 balioa
                                                                                                      * dauka
                                                                                                      * eta bestean 14.
                                                                                                      * 8 bada stock-ean
                                                                                                      * dagoen balioa
                                                                                                      * zuzena da, 14
                                                                                                      * bada
                                                                                                      * stock-eko balioa
                                                                                                      * zuzena da,
                                                                                                      * baina negatiboa
                                                                                                      * agertzen da
                                                                                                      */
        ArrayList<String> datuak = new ArrayList<String>();
        try {
            st = konexioa.connectDatabase().createStatement();
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
