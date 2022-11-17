package com.postgress.update;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.konexioa.Konexioa;
import com.postgress.ProduktuakJavaObjetura;

public class ProduktuListaAldatu {
    public static Konexioa konexioa = new Konexioa();
    public static Statement st;
    public static Scanner in;

    public static void produktuListaAldatu() {
        String erantzuna, erantzunaKonfirmazioa;
        boolean bestebat;
        in = new Scanner(System.in);
        System.out.println("Hemen produktu guztien lista:");
        System.out.println(
                "Produktua[ id, izena, deskripzioa, prezioa, stocka, bolumena, pisua, barraKodea, lehentasuna]");
        System.out.print(ProduktuakJavaObjetura.produktuenJavaObjetua());
        do {
            System.out.print("Aukeratu ze datu nahi duzun aldatu (prezioa/stocka/lehentasuna): ");
            erantzuna = in.nextLine().toLowerCase();
            if (erantzuna.equals("prezioa") || erantzuna.equals("stocka") || erantzuna.equals("lehentasuna")) {
                System.out.println("Ziur zaude " + erantzuna + " nahi duzula editatu? (Bai/Ez)");
                erantzunaKonfirmazioa = in.next().toLowerCase();
                if (erantzunaKonfirmazioa.equals("bai") || erantzunaKonfirmazioa.equals("b")) {
                    switch (erantzuna) {
                        case "prezioa":
                            garbitu();
                            listaAldatuPrezioa();
                            break;
                        case "stocka":
                            garbitu();
                            listaAldatuStocka();
                            break;
                        case "lehentasuna":
                            garbitu();
                            listaAldatuLehentasuna();
                            break;
                        default:
                            break;
                    }
                    garbitu();
                    System.out.println("Hemen produktu guztien lista berria:");
                    System.out.println(
                            "Produktua[id, izena, deskripzioa, prezioa, stocka, bolumena, pisua, barraKodea, lehentasuna]");
                    System.out.print(ProduktuakJavaObjetura.produktuenJavaObjetua());
                }
            }
            System.out.println("Nahi duzu beste zerbait editatu? (Bai/Ez)");
            erantzuna = in.next().toLowerCase();
            in.nextLine();
            if (erantzuna.equals("bai") || erantzuna.equals("b")) {
                bestebat = true;
            } else {
                bestebat = false;
            }
        } while (bestebat);
        garbitu();
    }

    public static void listaAldatuPrezioa() {
        System.out.println("Ze nahi duzu egin prezioarekin? (gehitu/biderkatu)");
        in = new Scanner(System.in);
        String erantzuna = in.nextLine().toLowerCase();
        switch (erantzuna) {
            case "gehitu":
                listaAldatuPrezioaGehitu();
                break;
            case "biderkatu":
                listaAldatuPrezioaBiderkatu();
                break;

            default:
                break;
        }
    }

    public static void listaAldatuPrezioaGehitu() {
        String inputa;
        float prezioa, prezioaGehitu = 0;
        int id;
        System.out.print("Zenbat gaitik nahi duzu gehitu prezioak? ");
        in = new Scanner(System.in);
        boolean ondo = false;
        while (!ondo) {
            try {
                inputa = in.nextLine();
                prezioaGehitu = Float.parseFloat(inputa);
                ondo = true;
            } catch (Exception e) {
                System.out.println("Sartutako datua ez da zuzena. Erabili zenbakiak eta '.'");
                System.out.print("Zenbat gaitik nahi duzu gehitu prezioak? ");
            }
        }

        String sql = "SELECT id, list_price FROM public.product_template order by id asc";
        ArrayList<String> datuak = new ArrayList<String>();

        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datuak.add(rs.getString("id") + ";" + Float.toString(rs.getFloat("list_price")));
            }
        } catch (Exception ex) {
            System.out.println("Exception (PT): " + ex);
        }
        for (String str : datuak) {
            String[] zatiak = str.split(";");
            id = Integer.parseInt(zatiak[0]);
            prezioa = Float.parseFloat(zatiak[1]);
            sql = "UPDATE public.product_template SET list_price = " + (prezioa + prezioaGehitu) + " WHERE id = " + id;
            exekutatu(sql);
        }
    }

    public static void listaAldatuPrezioaBiderkatu() {
        String inputa;
        float prezioa, prezioaBiderkatu = 0;
        int id;
        System.out.print("Zenbat gaitik nahi duzu biderkatu prezioak? ");
        in = new Scanner(System.in);
        boolean ondo = false;
        while (!ondo) {
            try {
                inputa = in.nextLine();
                prezioaBiderkatu = Float.parseFloat(inputa);
                ondo = true;
            } catch (Exception e) {
                System.out.println("Sartutako datua ez da zuzena. Erabili zenbakiak eta '.'");
                System.out.print("Zenbat gaitik nahi duzu biderkatu prezioak? ");
            }
        }

        String sql = "SELECT id, list_price FROM public.product_template order by id asc";
        ArrayList<String> datuak = new ArrayList<String>();

        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datuak.add(rs.getString("id") + ";" + Float.toString(rs.getFloat("list_price")));
            }
        } catch (Exception ex) {
            System.out.println("Exception (PT): " + ex);
        }
        for (String str : datuak) {
            String[] zatiak = str.split(";");
            id = Integer.parseInt(zatiak[0]);
            prezioa = Float.parseFloat(zatiak[1]);
            sql = "UPDATE public.product_template SET list_price = " + (prezioa * prezioaBiderkatu) + " WHERE id = "
                    + id;
            exekutatu(sql);
        }
    }

    public static void listaAldatuStocka() {
        System.out.println("Ze nahi duzu egin stockarekin? (gehitu/biderkatu)");
        in = new Scanner(System.in);
        String erantzuna = in.nextLine().toLowerCase();
        switch (erantzuna) {
            case "gehitu":
                listaAldatuStockaGehitu();
                break;
            case "biderkatu":
                listaAldatuStockaBiderkatu();
                break;

            default:
                break;
        }
    }

    public static void listaAldatuStockaGehitu() {
        String inputa;
        float stocka = 0;
        float stockaGehitu = 0;
        int idPT = 0;
        int idPP = 0;
        System.out.println("Zenbat gaitik nahi duzu gehitu stocka? ");
        in = new Scanner(System.in);
        boolean ondo = false;
        while (!ondo) {
            try {
                inputa = in.nextLine();
                stockaGehitu = Float.parseFloat(inputa);
                ondo = true;
            } catch (Exception e) {
                System.out.println("Sartutako datua ez da zuzena. Erabili zenbakiak eta '.'");
                System.out.println("Zenbat gaitik nahi duzu gehitu stocka? ");
            }
        }

        String sql = "SELECT id FROM public.product_template order by id asc";
        ArrayList<Integer> datuak = new ArrayList<Integer>();

        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datuak.add(rs.getInt("id"));
            }
        } catch (Exception ex) {
            System.out.println("Exception (PT): " + ex);
        }

        for (Integer id : datuak) {
            idPT = id;
            sql = "SELECT id FROM public.product_product WHERE product_tmpl_id = " + idPT;
            try {
                st = konexioa.connectDatabase().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    idPP = rs.getInt("id");
                }
            } catch (Exception ex) {
                System.out.println("Exception (PT): " + ex);
            }

            sql = "SELECT quantity FROM public.stock_quant WHERE product_id = " + idPP + " ORDER BY id ASC LIMIT 1";
            try {
                st = konexioa.connectDatabase().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    stocka = rs.getFloat("quantity");
                }
            } catch (Exception ex) {
                System.out.println("Exception (PT): " + ex);
            }

            sql = "UPDATE public.stock_quant SET quantity = " + (stocka + stockaGehitu) + " WHERE product_id = " + idPP
                    + " and location_id = 8";
            exekutatu(sql);
            sql = "UPDATE public.stock_quant SET quantity = " + ((stocka + stockaGehitu) * -1) + " WHERE product_id = "
                    + idPP + " and location_id = 14";
            exekutatu(sql);
        }
    }

    public static void listaAldatuStockaBiderkatu() {
        String inputa;
        float stocka = 0;
        float stockaBiderkatu = 0;
        int idPT = 0;
        int idPP = 0;
        System.out.println("Zenbat gaitik nahi duzu biderkatu stocka? ");
        in = new Scanner(System.in);
        boolean ondo = false;
        while (!ondo) {
            try {
                inputa = in.nextLine();
                stockaBiderkatu = Float.parseFloat(inputa);
                ondo = true;
            } catch (Exception e) {
                System.out.println("Sartutako datua ez da zuzena. Erabili zenbakiak eta '.'");
                System.out.println("Zenbat gaitik nahi duzu biderkatu stocka? ");
            }
        }

        String sql = "SELECT id FROM public.product_template order by id asc";
        ArrayList<Integer> datuak = new ArrayList<Integer>();

        try {
            st = konexioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datuak.add(rs.getInt("id"));
            }
        } catch (Exception ex) {
            System.out.println("Exception (PT): " + ex);
        }

        for (Integer id : datuak) {
            idPT = id;
            sql = "SELECT id FROM public.product_product WHERE product_tmpl_id = " + idPT;
            try {
                st = konexioa.connectDatabase().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    idPP = rs.getInt("id");
                }
            } catch (Exception ex) {
                System.out.println("Exception (PT): " + ex);
            }

            sql = "SELECT quantity FROM public.stock_quant WHERE product_id = " + idPP + " ORDER BY id ASC LIMIT 1";
            try {
                st = konexioa.connectDatabase().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    stocka = rs.getFloat("quantity");
                }
            } catch (Exception ex) {
                System.out.println("Exception (PT): " + ex);
            }

            sql = "UPDATE public.stock_quant SET quantity = " + (stocka * stockaBiderkatu) + " WHERE product_id = "
                    + idPP + " and location_id = 8";
            exekutatu(sql);
            sql = "UPDATE public.stock_quant SET quantity = " + ((stocka * stockaBiderkatu) * -1)
                    + " WHERE product_id = " + idPP + " and location_id = 14";
            exekutatu(sql);
        }

    }

    public static void listaAldatuLehentasuna() {
        System.out.println("Ze nahi duzu egin lehentasunarekin? (bai/ez)");
        in = new Scanner(System.in);
        String erantzuna = in.nextLine().toLowerCase();
        switch (erantzuna) {
            case "bai":
                listaAldatuLehentasunaBai();
                break;
            case "ez":
                listaAldatuLehentasunaEz();
                break;

            default:
                break;
        }
    }

    public static void listaAldatuLehentasunaBai() {
        String sql = "UPDATE public.product_template SET priority = '1'";
        exekutatu(sql);
    }

    public static void listaAldatuLehentasunaEz() {
        String sql = "UPDATE public.product_template SET priority = '0'";
        exekutatu(sql);
    }

    public static void exekutatu(String sql) {
        try {
            st = konexioa.connectDatabase().createStatement();
            st.executeQuery(sql);
        } catch (Exception ex) {
            // System.out.println(ex);
        }
    }

    private static void garbitu() {
        // System.out.print("\033[H\033[2J");
        // System.out.flush();
    }
}
