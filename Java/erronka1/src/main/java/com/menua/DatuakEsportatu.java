package com.menua;

import com.atzipenekoak.Csva;
import com.atzipenekoak.Jsona;
import com.atzipenekoak.Xmla;
import com.pojoak.Produktuak;
import com.postgress.ProduktuakJavaObjetura;

public class DatuakEsportatu {

    public static void produktuakImprimatu() { // Kontsolan imprimatzen ditu datuak
        try {
            System.out.println("Datuen egitura -> Produktua[id, izena, deskripzioa, prezioa, stocka, bolumena, pisua, barraKodea, lehentasuna]");
            System.out.print(ProduktuakJavaObjetura.produktuenJavaObjetua()); // Produktuak lortu eta imprimatu
        } catch (Exception e) {
            System.out.println("Arazoren bat egon da datuak irakurtzeko orduan, edo hutsik dago");
        }

    }

    public static void produktuakCsvra() { // CSV/TXT bezala esportatzen du
        try {
            Produktuak produktuak = new Produktuak();
            produktuak = ProduktuakJavaObjetura.produktuenJavaObjetua();
            Csva csva = new Csva(produktuak, "data/exportazioak/Produktuak.csv");
            csva.idatzi();
            System.out.println("Datuak ondo esportatu dira");
        } catch (Exception e) {
            System.out.println("Arazoren bat egon da datuak esportatzeko orduan. Begiratu taulak ez daudela hutsik");
        }

    }

    public static void produktuakXmlra() { // XML bezala esportatzen du
        try {
            Produktuak produktuak = new Produktuak();
            produktuak = ProduktuakJavaObjetura.produktuenJavaObjetua();
            Xmla xmla = new Xmla(produktuak, "data/exportazioak/Produktuak.xml");
            xmla.idatzi();
            System.out.println("Datuak ondo esportatu dira");
        } catch (Exception e) {
            System.out.println("Arazoren bat egon da datuak esportatzeko orduan. Begiratu taulak ez daudela hutsik");
        }

    }

    public static void produktuakJsonera() { // JSON bezala esportatzen du
        try {
            Produktuak produktuak = new Produktuak();
            produktuak = ProduktuakJavaObjetura.produktuenJavaObjetua();
            Jsona jsona = new Jsona(produktuak, "data/exportazioak/Produktuak.json");
            jsona.idatzi();
            System.out.println("Datuak ondo esportatu dira");
        } catch (Exception e) {
            System.out.println("Arazoren bat egon da datuak esportatzeko orduan. Begiratu taulak ez daudela hutsik");
        }

    }

    public static void produktuakDenetara(){
        try {
            Produktuak produktuak = new Produktuak();
            produktuak = ProduktuakJavaObjetura.produktuenJavaObjetua();
            Csva csva = new Csva(produktuak, "data/exportazioak/Produktuak.csv");
            csva.idatzi();
            Xmla xmla = new Xmla(produktuak, "data/exportazioak/Produktuak.xml");
            xmla.idatzi();
            Jsona jsona = new Jsona(produktuak, "data/exportazioak/Produktuak.json");
            jsona.idatzi();
            System.out.println("Datuak ondo esportatu dira");
        } catch (Exception e) {
            System.out.println("Arazoren bat egon da datuak esportatzeko orduan. Begiratu taulak ez daudela hutsik");
        }
    }

}
