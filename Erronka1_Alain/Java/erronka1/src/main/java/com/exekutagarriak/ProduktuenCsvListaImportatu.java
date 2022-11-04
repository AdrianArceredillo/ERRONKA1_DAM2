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
        public static void main(String[] args) {
            Produktuak produktuak = new Produktuak();

            produktuak = produktuenListaObjetura();

            String sql = "INSERT INTO public.product_template VALUES";

            int produktuKopurua = 0;

            int id=idLortu();
            String izena ="";
            String deskripzioa ="";
            float prezioa = 0;
            String timeStamp;

            for (Produktua p : produktuak.getProduktuak()) {
                if (produktuKopurua==0){
                    produktuKopurua++;
                }
                id += 1;        
                izena = p.getIzena();
                deskripzioa = "<p><br><p>";
                prezioa = p.getPrezioa();
                timeStamp =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date());
                
                sql += "( "+id+", NULL,'"+izena+"',1,'<p>"+deskripzioa+"</p>',NULL,NULL,'product','product',1,"+prezioa+",10,10,true,true,1,1,NULL,true,NULL,NULL,false,false,0,2,'"+timeStamp+"',2,'"+timeStamp+"',0,'none',NULL,NULL,NULL,'receive','no-message',NULL,'manual','no-message',NULL,'no','order',false)";
                sql += ", ";
            }
            sql = sql.substring(0, sql.length() - 2);
            sql += ";";

            Konexioa konexioa = new Konexioa();
            Statement st;
            try {
                st = konexioa.connectDatabase("localhost", "5432", "proba_erronka", "admin", "admin123").createStatement(); 
                st.executeQuery(sql); 
            } catch (Exception ex) {
                System.out.println("Exception : " + ex);
            }
                        
            


    }
    public static Produktuak produktuenListaObjetura(){
        in = new Scanner(System.in);
        System.out.print("Fitxategiaren izena: ");
        //String fitxategia = in.nextLine();
        String fitxategia = "produktuakR.csv";
        Csva csva= new Csva("data/importazioak/" + fitxategia);
        Produktuak produktuak = new Produktuak();
        return produktuak = csva.irakurri();
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
