package com.dambi;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.print.event.PrintEvent;


/**
 * Gure aplikazioaren Main klasea
 *
 */
public class idatzi 
{
    public static void main( String[] args )
    {
        
        ArrayList <String> modelo = new ArrayList <String> ();

         insertTaula("AAAAAAAAA");

    }
    public static void insertTaula(String taula){
        String sql = "INSERT INTO public.\"" + taula +"\" VALUES('Proba','4','123456');";
        Konekzioa konekzioa = new Konekzioa();
        Statement st;
        try{
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            st.executeQuery(sql);
        } catch(Exception ex){
            System.out.println("errore bat egon da, baina ez");
        }
    }
}
