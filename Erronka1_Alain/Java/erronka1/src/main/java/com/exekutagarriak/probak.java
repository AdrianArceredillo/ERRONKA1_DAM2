package com.exekutagarriak;

import java.sql.Statement;

import com.konexioa.Konexioa;

public class probak {
    public static void main(String[] args) {
        garbitu();
        insertAsko();
    }

    public static void insertAsko(){
        String sql = "INSERT INTO public.\"AAAAAAAAA\" VALUES('Proba','16',NULL, true, NULL), ('Proba','17',NULL, true, NULL);";
        Konexioa konekzioa = new Konexioa();
        Statement st;
        try{
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            System.out.println(st.executeQuery(sql)); 
        } catch(Exception ex){
            System.out.println("Exception: " + ex);
        } 
    }
    

    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
