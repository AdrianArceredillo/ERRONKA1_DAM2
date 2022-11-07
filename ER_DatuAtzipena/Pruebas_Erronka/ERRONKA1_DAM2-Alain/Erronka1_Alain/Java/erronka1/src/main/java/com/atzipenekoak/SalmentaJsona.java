package com.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonWriter;

import com.pojoak.Salmenta;
import com.pojoak.Salmentak;

public class SalmentaJsona {

    public Salmentak salmentak;
    public String strFileOut;


    public SalmentaJsona(Salmentak salmentak, String strFileOut) {
        this.salmentak = salmentak;
        this.strFileOut = strFileOut;
    }


    public void idatzi() {
        //int salmentaKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Salmenta s : this.salmentak.getSalmentak()) {
            jab.add(Json.createObjectBuilder()
                    .add("id", s.getId())
                    .add("izena", s.getIzena())
                    .add("data", s.getData())
                    .add("bezeroa_Id", s.getBezeroa_Id())
                    .add("prezio_Totala", s.getPrezio_Totala())
                    .build());
            //salmentaKopurua++;
        }
        model=jab.build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(this.strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }

    }
}
