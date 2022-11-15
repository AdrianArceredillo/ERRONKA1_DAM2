package com.pojoak;



import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

//ID;IZENA;DESKRIPZIOA;PREZIOA;STOCKA;BOLUMENA;PISUA;BARRAKODEA;LEHENTASUNA
@XmlType(propOrder = { "id", "izena", "deskripzioa", "prezioa", "stocka", "bolumena", "pisua", "barraKodea", "lehentasuna"})
@XmlRootElement(name = "Produktua")

public class Produktua {

    int id = 0;
    String izena, deskripzioa, barraKodea, lehentasuna;
    float stocka, prezioa, bolumena, pisua;

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

    @XmlElement(name = "Deskripzioa")
    public String getDeskripzioa() {
        return deskripzioa;
    }
    public void setDeskripzioa(String deskripzioa) {
        this.deskripzioa = deskripzioa;
    }

    @XmlElement(name = "Barra_Kodea")
    public String getBarraKodea() {
        return barraKodea;
    }
    public void setBarraKodea(String barraKodea) {
        this.barraKodea = barraKodea;
    }

    @XmlElement(name = "Stocka")
    public float getStocka() {
        return stocka;
    }
    public void setStocka(float stocka) {
        this.stocka = stocka;
    }

    @XmlElement(name = "Prezioa")
    public float getPrezioa() {
        return prezioa;
    }    
    public void setPrezioa(float prezioa) {
        this.prezioa = prezioa;
    }

    @XmlElement(name = "Bolumena")
    public float getBolumena() {
        return bolumena;
    }    
    public void setBolumena(float bolumena) {
        this.bolumena = bolumena;
    }

    @XmlElement(name = "Pisua")
    public float getPisua() {
        return prezioa;
    }    
    public void setPisua(float pisua) {
        this.pisua = pisua;
    }

    @XmlElement(name = "Lehentasuna")
    public String getLehentasuna() {
        return lehentasuna;
    }    
    public void setLehentasuna(String lehentasuna) {
        this.lehentasuna = lehentasuna;
    }



    @Override
    public String toString() { // ID;IZENA;DESKRIPZIOA;PREZIOA;STOCKA;BOLUMENA;PISUA;BARRAKODEA;LEHENTASUNA
        return "Produktua["+ id+", "+izena+", "+deskripzioa+", "+prezioa+", "+stocka+", "+bolumena+", "+pisua+", "+barraKodea+", "+lehentasuna+"]";
    }

}
