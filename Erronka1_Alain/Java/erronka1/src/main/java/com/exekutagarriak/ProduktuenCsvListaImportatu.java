package com.exekutagarriak;

import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.atzipenekoak.Csva;
import com.konexioa.Konexioa;
import com.pojoak.Produktua;
import com.pojoak.Produktuak;

public class ProduktuenCsvListaImportatu {
    public static Scanner in;

    public static Konexioa konexioa = new Konexioa();
    public static Statement st;

    public static void main(String[] args) {
        garbitu();
        Produktuak produktuak = new Produktuak();

        produktuak = produktuenListaObjetura();

        String sql = "INSERT INTO public.product_template VALUES";

        int produktuKopurua = 0;

        int id = idLortu();
        String izena = "";
        String deskripzioa = "";
        float prezioa = 0;
        String timeStamp;

        int n = 0;
        boolean bukatuta = false;

        while (!bukatuta) { // Produktuen lista ez badago bukatuta, egin hurrengoa
            sql = "INSERT INTO public.product_template VALUES";
            for (int i = 0; i < 10; i++) { // 10 produktuko insert-a prestatzen da

                try {

                    Produktua p = produktuak.getProduktuak().get(n + i); // n+i Array listean dagoen elementu kopurua
                                                                         // baino
                                                                         // handiagoa bada, erroreak egingo du salto eta
                                                                         // catch-ean sartuko da
                    id += 1;
                    izena = p.getIzena();
                    deskripzioa = "<p><br><p>";
                    prezioa = p.getPrezioa();
                    timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date());

                    sql += " ( " + id + ", NULL,'" + izena + "',1,'<p>" + deskripzioa
                            + "</p>',NULL,NULL,'product','product',1,"
                            + prezioa + ",10,10,true,true,1,1,NULL,true,NULL,NULL,false,false,0,2,'" + timeStamp
                            + "',2,'"
                            + timeStamp
                            + "',0,'none',NULL,NULL,NULL,'receive','no-message',NULL,'manual','no-message',NULL,'no','order',false)";
                    sql += ",";

                    produktuKopurua++;
                } catch (Exception e) { // Catch honetan sartzen bada, nahi du esan ez dagoela beste produkturik
                                        // gehitzeko sql aginduan, orduan azkenengo agindua da urrengoa. Horregatik
                                        // bukatuta = true baliora aldatuko da
                    bukatuta = true;
                    sql = sqlaBukatu(sql);
                    exekuzioa(sql, n);

                }
            }
            if (!bukatuta) { // Produktuen lista ez badago bukatuta, egin hurrengoa
                sql = sqlaBukatu(sql);
                exekuzioa(sql, n);
            }
            n += 10; 
        }
        System.out.println("\n" + produktuKopurua + " produktu gehitu dira datu basera");
    }

    public static String sqlaBukatu(String sql) { // Sql agindua ',' batekin amaitzen da. ',' hori ';' batekin aldatu
                                                  // behar da
        sql = sql.substring(0, sql.length() - 1);
        sql += ";";
        return sql;
    }

    public static void exekuzioa(String sql, int n) {
        try {
            st = konexioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            st.executeQuery(sql);
        } catch (Exception ex) {
            if(n % 200 == 0 && !bukatuta){
                System.out.println("Produktuak importatzen, mesedez itxaron... ( " + n + " produktu inportatuta)");
            }
        }
    }

    public static Produktuak produktuenListaObjetura() {
        in = new Scanner(System.in);
        System.out.print("Fitxategiaren izena: ");
        String fitxategia = in.nextLine();
        Csva csva = new Csva("data/importazioak/" + fitxategia);

        Produktuak produktuak = new Produktuak();

        produktuak = csva.irakurri();
        return produktuak;

    }

    public static int idLortu() {
        String sql = "SELECT id FROM public.\"product_template\" ORDER BY id DESC LIMIT 1";
        int id = 0;
        try {
            st = konexioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
        return id;
    }

    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
