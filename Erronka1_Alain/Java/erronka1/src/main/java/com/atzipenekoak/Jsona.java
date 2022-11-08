package com.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import java.io.FileReader;

import com.pojoak.Produktua;
import com.pojoak.Produktuak;

public class Jsona {

    public Produktuak produktuak;
    public String strFileOut;
    private String strFileIn;

    public Jsona(String strFileIn) {
        this.strFileIn = strFileIn;
    }

    public Jsona(Produktuak produktuak, String strFileOut) {
        this.produktuak = produktuak;
        this.strFileOut = strFileOut;
    }


    public Produktuak irakurri() {
        Produktuak produktuak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            produktuak = new Produktuak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Produktua produktua = new Produktua();
                produktua.setId(jsonobj.getInt("id"));
                produktua.setIzena(jsonobj.getString("izena"));
                produktua.setStocka(jsonobj.getInt("stocka"));
                produktua.setPrezioa(jsonobj.getInt("prezioa"));
                produktuak.add(produktua);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan.");
        }
        return produktuak;
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
