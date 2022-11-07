
package com.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.pojoak.*;
import com.pojoak.*;


public class SalmentaCsva {
    public Salmentak salmentak;
    private String strFileIn;
    public String strFileOut;

    int salmentaKopurua = 0;
    
    public SalmentaCsva(String strFileIn) {
        this.strFileIn = strFileIn;
    }

    public SalmentaCsva(Salmentak salmentak, String strFileOut) {
        this.salmentak = salmentak;
        this.strFileOut = strFileOut;
    }

    public Salmentak irakurri() {
        Salmentak salmentak = new Salmentak();
        salmentak = null;

        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))) {
            String banatzailea = ";";
            String l;
            salmentak = new Salmentak();
            while ((l = inputStream.readLine()) != null) {
                String[] eremuak = l.split(banatzailea);
                if (!eremuak[0].equals("ID")) {
                    Salmenta salmenta = new Salmenta();
                    salmenta.setId(Integer.parseInt(eremuak[0]));
                    salmenta.setIzena(eremuak[1]);
                    // salmenta.setData(LocalDate.parse(eremuak[2].toString()));
                    salmenta.setData(eremuak[2].toString());
                    salmenta.setBezeroa_Id(Integer.parseInt(eremuak[3]));
                    salmenta.setPrezio_Totala(Float.parseFloat(eremuak[4].substring(0, eremuak[3].length() - 1))); //eliminar símbolo "€"
                    salmentak.add(salmenta);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ez da " + strFileIn + " fitxategia aurkitu.");
        } catch (IOException e) {
            System.out.println("IOsalbuespena gertatu da.");
        }
        return salmentak;
    }
    

    public void idatzi() {
        try (PrintWriter outputStream = new PrintWriter(new FileWriter(this.strFileOut))) {
            for (Salmenta p : this.salmentak.getSalmentak()) {
                if (salmentaKopurua==0){
                    outputStream.println("ID;IZENA;DATA;BEZEROA_ID;PREZIO_TOTALA");
                }
                salmentaKopurua++;
                // "Salmenta["+ id+", "+izena+", "+data+", "+bezeroa_Id+", "+prezio_Totala+"]";
                outputStream.println(
                    p.getId()+";"+
                    p.getIzena()+";"+
                    p.getData()+";"+ 
                    p.getBezeroa_Id()+";"+
                    p.getPrezio_Totala()+"€");
            }
        } catch (IOException e) {
            System.out.println(this.strFileOut + " fitxategiarekin arazoren bat egon da.");
        }
    }
}
