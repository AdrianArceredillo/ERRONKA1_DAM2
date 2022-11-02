package com.pojoak;



import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "id", "izena", "stocka", "prezioa" })
@XmlRootElement(name = "Produktua")

public class Produktua {

    int id = 0;
    String izena;
    int stocka;
    int prezioa;


    @XmlElement(name = "Id")
    public int getId(){
       return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @XmlElement(name = "Izena")
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }

    @XmlElement(name = "Stocka")
    public int getStocka() {
        return stocka;
    }    
    public void setStocka(int stocka) {
        this.stocka = stocka;
    }

    @XmlElement(name = "Prezioa")
    public int getPrezioa() {
        return prezioa;
    }    
    public void setPrezioa(int prezioa) {
        this.prezioa = prezioa;
    }


    @Override
    public String toString() {
        return "Produktua["+ id+", "+izena+", "+stocka+", "+prezioa+"]";
    }

}
