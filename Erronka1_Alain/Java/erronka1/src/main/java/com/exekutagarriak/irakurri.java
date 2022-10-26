package com.exekutagarriak;



import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dambi.konexioa.Konekzioa;




/**
 * Gure aplikazioaren Main klasea
 *
 */
public class irakurri 
{
    public static void main( String[] args )
    {
        
        ArrayList <String> modelo = new ArrayList <String> ();
        modelo = irakurriTaula("product_template");
        for(int j = 0; j < modelo.size(); j++){
            String[] parts = modelo.get(j).split(";");
            System.out.print(j+1 + ":");
            System.out.print("Izena: " + parts[0] + "  Datua(1): " + parts[1] + "  Datua(2): " + parts[2] + "  Datua(3): " + parts[3] + "  Prezioa: " + (Integer.parseInt(parts[4]) + 10) + "\n");
            
        }
    }
    public static ArrayList <String> irakurriTaula(String taula){
        Konekzioa konekzioa = new Konekzioa();
        String sql = "SELECT * FROM public.\"" + taula +"\"";
        ArrayList <String> modelo = new ArrayList <String> ();
        Statement st;
        try{
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.add(rs.getString(3) + ";" + "Proba1" + ";" +  "Proba2" + ";" + "Proba3" + ";" + Integer.toString(rs.getShort(11)));
            }
        } catch(Exception ex){
            System.out.println("Exception : "+ex);
        }
        return modelo;
    }
}
