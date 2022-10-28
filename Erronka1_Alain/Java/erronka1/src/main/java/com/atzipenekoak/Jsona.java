package com.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonWriter;

import com.pojoak.Produktua;
import com.pojoak.Produktuak;

public class Jsona {

    public Produktuak produktuak;
    public String strFileOut;


    public Jsona(Produktuak produktuak, String strFileOut) {
        this.produktuak = produktuak;
        this.strFileOut = strFileOut;
    }


    public void idatzi() {
        //int produktuKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Produktua p : this.produktuak.getProduktuak()) {
            jab.add(Json.createObjectBuilder()
            // "Produktua["+ id+", "+izena+", "+stocka+", "+prezioa+"]";
                    .add("id", p.getId())
                    .add("izena", p.getIzena())
                    .add("stocka", p.getStocka())
                    .add("prezioa", p.getPrezioa())
                    .build());
            //produktuKopurua++;
        }
        model=jab.build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(this.strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }

    }
}
