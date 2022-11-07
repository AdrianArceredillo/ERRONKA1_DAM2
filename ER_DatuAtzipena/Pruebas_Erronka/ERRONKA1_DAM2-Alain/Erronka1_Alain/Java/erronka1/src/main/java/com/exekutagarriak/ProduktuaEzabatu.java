package com.exekutagarriak;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.konexioa.Konexioa;

public class ProduktuaEzabatu {
    public static Scanner in;
    public static void main(String[] args) {
        garbitu();
        System.out.println("Produktuen lista:");
        System.out.println("ID ; IZENA ; PREZIOA");
        produktuenLista();
        produktuaEzabatu();
    }






    private static void produktuaEzabatu() {
        int id;
        System.out.print("Idatzi produktu baten ID-a ezabatzeko: ");
        in = new Scanner(System.in);
        id = in.nextInt();

        Konexioa konekzioa = new Konexioa();
        String sql = "DELETE FROM public.\"product_template\" WHERE id = " + id;
        Statement st;
        try{
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            ResultSet rs = st.executeQuery(sql);
        } catch(Exception ex){
            System.out.println("Exception : "+ex);
        }
    }

    private static void produktuenLista() {
        Konexioa konekzioa = new Konexioa();
        String sql = "SELECT * FROM public.\"product_template\" order by id asc";
        ArrayList <String> modelo = new ArrayList <String> ();
        Statement st;
        try{
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.add(rs.getString("id") + ";" + rs.getString("name") + ";" + Integer.toString(rs.getShort("list_price")));
            }
        } catch(Exception ex){
            System.out.println("Exception : "+ex);
        }
        for (String string : modelo) {
            System.out.println(string);
        }   
    }
    
    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

