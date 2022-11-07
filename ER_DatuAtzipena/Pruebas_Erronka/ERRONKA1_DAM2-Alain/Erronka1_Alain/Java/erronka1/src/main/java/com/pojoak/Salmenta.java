package com.pojoak;

//import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

//postgreSQL table -> "sale_order"

@XmlType(propOrder = {
        "id", // Id
        "izena", // name
        "data", // create_date
        "bezeroa_id", // partner_Id
        "prezio_Totala" // amount_total
})
@XmlRootElement(name = "Salmenta")

public class Salmenta {
    int id;
    String izena;
    String data;    //LocalDate
    int bezeroa_Id;
    float prezio_Totala;

    // id
    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //izena (name)
    @XmlElement(name = "izena")
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }

    //data (create_date)
    @XmlElement(name = "data")
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    // bezeroa_Id (partner_Id)
    @XmlElement(name = "bezeroa_Id")
    public int getBezeroa_Id() {
        return bezeroa_Id;
    }
    public void setBezeroa_Id(int bezeroa_Id) {
        this.bezeroa_Id = bezeroa_Id;
    }

    // prezio_Totala (amount_total)
    @XmlElement(name = "prezio_Totala")
    public float getPrezio_Totala() {
        return prezio_Totala;
    }
    public void setPrezio_Totala(float prezio_Totala) {
        this.prezio_Totala = prezio_Totala;
    }


    @Override
    public String toString() {
        return "Salmenta[Salmenta ID: " + id + ", \n" + 
            "Izena: " + izena + ", \n" +
            "Data: " + data + "]" + 
            "Bezeroa ID: " + bezeroa_Id + ", \n" + 
            "Totala: " + prezio_Totala + ", \n";
    }

}

