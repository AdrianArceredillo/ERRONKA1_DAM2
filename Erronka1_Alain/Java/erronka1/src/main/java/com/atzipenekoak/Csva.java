
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
    public String strFileOut;



    public Csva(Produktuak produktuak, String strFileOut) {
        this.produktuak = produktuak;
        this.strFileOut = strFileOut;
    }
    int produktuKopurua = 0;

    public void idatzi() {
        try (PrintWriter outputStream = new PrintWriter(new FileWriter(this.strFileOut))) {
            for (Produktua p : this.produktuak.getProduktuak()) {
                if (produktuKopurua==0){
                    outputStream.println("ID; IZENA; STOCKA; PREZIOA");
                }
                produktuKopurua++;
                // "Produktua["+ id+", "+izena+", "+stocka+", "+prezioa+"]";
                outputStream.println(p.getId()+"; "+p.getIzena()+"; "+p.getStocka()+"; "+p.getPrezioa()+"€");
            }
        } catch (IOException e) {
            System.out.println(this.strFileOut + " fitxategiarekin arazoren bat egon da.");
        }
    }
}

