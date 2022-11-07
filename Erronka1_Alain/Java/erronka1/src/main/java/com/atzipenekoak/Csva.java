
package com.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.pojoak.Produktua;
import com.pojoak.Produktuak;


public class Csva {

    public Produktuak produktuak;
    private String strFileIn;
    public String strFileOut;

    int produktuKopurua = 0;
    
    public Csva(String strFileIn) {
        this.strFileIn = strFileIn;
    }

    public Csva(Produktuak produktuak, String strFileOut) {
        this.produktuak = produktuak;
        this.strFileOut = strFileOut;
    }

    public Produktuak irakurri() {
        Produktuak produktuak = new Produktuak();
        produktuak = null;
        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))) {
            String banatzailea = ";";
            String l;
            produktuak = new Produktuak();
            while ((l = inputStream.readLine()) != null) {
                String[] eremuak = l.split(banatzailea);
                if (!eremuak[0].equals("ID")) {
                    Produktua produktua = new Produktua();
                    produktua.setId(Integer.parseInt(eremuak[0]));
                    produktua.setIzena(eremuak[1]);
                    produktua.setStocka(Integer.parseInt(eremuak[2]));
                    produktua.setPrezioa(Float.parseFloat(eremuak[3])); //€ Simboloa ezabatu
                    produktuak.add(produktua);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ez da " + strFileIn + " fitxategia aurkitu.");
        } catch (IOException e) {
            System.out.println("IOsalbuespena gertatu da.");
        } catch(Exception e){
            System.out.println("Errorea: " + e);
        }
        return produktuak;
    }
    

    public void idatzi() {
        try (PrintWriter outputStream = new PrintWriter(new FileWriter(this.strFileOut))) {
            for (Produktua p : this.produktuak.getProduktuak()) {
                if (produktuKopurua==0){
                    outputStream.println("ID;IZENA;STOCKA;PREZIOA");
                }
                produktuKopurua++;
                // "Produktua["+ id+", "+izena+", "+stocka+", "+prezioa+"]";
                outputStream.println(p.getId()+";"+p.getIzena()+";"+p.getStocka()+";"+p.getPrezioa()+"€");
            }
        } catch (IOException e) {
            System.out.println(this.strFileOut + " fitxategiarekin arazoren bat egon da.");
        }
    }
}

