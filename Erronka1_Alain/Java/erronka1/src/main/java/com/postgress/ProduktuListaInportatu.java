package com.postgress;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.atzipenekoak.Csva;
import com.atzipenekoak.Jsona;
import com.atzipenekoak.Xmla;
import com.konexioa.Konexioa;
import com.menua.ProduktuBatenStocka;
import com.pojoak.Produktua;
import com.pojoak.Produktuak;

public class ProduktuListaInportatu {
    public static Scanner in;

    public static Konexioa konexioa = new Konexioa();
    public static Statement st;

    public static void listaInportatu() {
        Produktuak produktuak = new Produktuak();
        in = new Scanner(System.in);
        System.out.print("Fitxategiaren izena (.csv, .xml edo .json formatukoa): ");
        String fitxategia = in.nextLine();
        produktuak = produktuenListaObjetura(fitxategia);
        int kontagailua = 0;
        String izena, deskripzioa, barraKodea, lehentasuna, idAk;
        Float prezioa, bolumena, pisua, kantitatea;
        int idPT = idLortuPT() + 1;
        int idPP = idLortuPP() + 1;
        int idSQ = idLortuSQ() + 1;

        for (Produktua p : produktuak.getProduktuak()) {
                izena = p.getIzena();
                deskripzioa = p.getDeskripzioa();
                barraKodea = p.getBarraKodea();
                prezioa = p.getPrezioa();
                bolumena = p.getBolumena();
                pisua = p.getPisua();
                kantitatea = p.getStocka();
                lehentasuna = p.getLehentasuna();
                idAk = ProduktuBatenStocka.produktuaGehitu(idPT, idPP, idSQ, izena, deskripzioa, barraKodea, prezioa,
                        bolumena, pisua, kantitatea, lehentasuna);
                kontagailua++;
                String[] idArray = idAk.split(";");
                idPT = Integer.parseInt(idArray[0])  + 1;
                idPP = Integer.parseInt(idArray[1])  + 1;
                idSQ = Integer.parseInt(idArray[2])  + 2;
        }
        System.out.println((kontagailua + 1) + " produktu gehitu dira");

    }

    public static Produktuak produktuenListaObjetura(String FileIn) {
        Produktuak produktuak = new Produktuak();
        produktuak = null;
        if (FileIn.contains(".csv")) {
            Csva csva = new Csva("data/importazioak/" + FileIn);
            return produktuak = csva.irakurri();
        }
        if (FileIn.contains(".xml")) {
            Xmla xmla = new Xmla("data/importazioak/" + FileIn);
            return produktuak = xmla.irakurri();
        }
        if (FileIn.contains(".json")) {
            Jsona jsona = new Jsona("data/importazioak/" + FileIn);
            return produktuak = jsona.irakurri();
        } else {
            System.out.println("Sartutako fitxategiaren formatua ez da zuzena .csv, .xml edo .json izan behar da");
        }
        return produktuak;
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

}
