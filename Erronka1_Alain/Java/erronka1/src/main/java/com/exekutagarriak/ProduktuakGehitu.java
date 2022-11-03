package com.exekutagarriak;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.konexioa.Konexioa;

public class ProduktuakGehitu {
    public static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);

        int id = idLortu() + 1;

        String izena, deskripzioa;
        float prezioa;

        System.out.println("produktuaren id-a urrengoa izango da: "+id);
        System.out.print("Izena: ");
        izena = in.next();
        System.out.print("Deskripzioa: ");
        deskripzioa = in.next();
        System.out.print("Prezioa: ");
        prezioa = in.nextFloat();
        produktuaGehitu(id, izena, deskripzioa, prezioa);
        irakurriProduktua("product_template", id);

    }

    public static void produktuaGehitu (int id, String izena, String deskripzioa, float prezioa) { 
        Konexioa konexioa = new Konexioa(); 

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date());;
         
        String sql = "INSERT INTO public.product_template VALUES( "+id+", NULL,'"+izena+"',1,'<p>"+deskripzioa+"</p>',NULL,NULL,'product','product',1,"+prezioa+",10,10,true,true,1,1,NULL,true,NULL,NULL,false,false,0,2,'"+timeStamp+"',2,'"+timeStamp+"',0,'none',NULL,NULL,NULL,'receive','no-message',NULL,'manual','no-message',NULL,'no','order',false);"; 
        Statement st;
        try {
            st = konexioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement(); // konektatu
            st.executeQuery(sql); 
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
    }

    public static void irakurriProduktua(String taula, int id){
        Konexioa konekzioa = new Konexioa();
        String sql = "SELECT * FROM public.\"" + taula +"\" where id = "+id+"";
        ArrayList <String> modelo = new ArrayList <String> ();
        Statement st;
        try{
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.add(rs.getString("id") + ";" + rs.getString("name") +  ";" + rs.getString("description") + ";" + Integer.toString(rs.getShort("list_price")));
            }
        } catch(Exception ex){
            System.out.println("Exception : "+ex);
        }
        String[] Zatiak = modelo.get(0).split(";");
        for (String string : Zatiak) {
            System.out.println(string);            
        }        
    }

    public static int idLortu(){
        Konexioa konekzioa = new Konexioa();
        String sql = "SELECT id FROM public.\"product_template\" ORDER BY id DESC LIMIT 1";
        int id = 0;
        Statement st;
        try{
            st = konekzioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt(1);
            }
        } catch(Exception ex){
            System.out.println("Exception : "+ex);
        }        
        return id;
    }

}
