package com.pojoak;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

//postgreSQL table -> "sale_order_line"

@XmlType(propOrder = { "id", "order_Id", "izena", "prezio_Unitatea", "prezio_Subtotala", "prezio_Totala", "product_id",
        "product_Kantitatea", "bezeroa_Id", "data" })
@XmlRootElement(name = "SalmentaLerroa")

public class SalmentaLerroa {
    int id;
    int order_Id;
    String izena;
    float prezio_Unitatea;
    float prezio_Subtotala;
    float prezio_Totala;
    int product_id;
    int product_Kantitatea;
    int bezeroa_Id;
    LocalDate data;

    //id
    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //order_Id
    @XmlElement(name = "order_Id")
    public int getOrder_Id() {
        return order_Id;
    }
    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    //izena
    @XmlElement(name = "Izena")
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }

    //prezio_Unitatea
    @XmlElement(name = "Prezio_Unitatea")
    public float getPrezio_Unitatea() {
        return prezio_Unitatea;
    }
    public void setPrezio_Unitatea(float prezio_Unitatea) {
        this.prezio_Unitatea = prezio_Unitatea;
    }

    //prezio_Subtotala
    @XmlElement(name = "Subtotala")
    public float getPrezio_Subtotala() {
        return prezio_Subtotala;
    }
    public void setPrezio_Subtotala(float prezio_Subtotala) {
        this.prezio_Subtotala = prezio_Subtotala;
    }

    //prezio_Totala
    @XmlElement(name = "Totala")
    public float getPrezio_Totala() {
        return prezio_Totala;
    }
    public void setPrezio_Totala(float prezio_Totala) {
        this.prezio_Totala = prezio_Totala;
    }

    //product_Id
    @XmlElement(name = "Produktua")
    public int getProduktua_Id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    //product_Kantitatea
    @XmlElement(name = "Kantitatea")
    public int getProduct_Kantitatea() {
        return product_Kantitatea;
    }
    public void setProduct_Kantitatea(int product_Kantitatea) {
        this.product_Kantitatea = product_Kantitatea;
    }

    //bezeroa_Id
    @XmlElement(name = "Bezeroa_Id")
    public int getBezeroa_Id() {
        return bezeroa_Id;
    }
    public void setBezeroa_Id(int bezeroa_Id) {
        this.bezeroa_Id = bezeroa_Id;
    }

    //data
    @XmlElement(name = "Data")
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SalmentaLerroa[Salmenta Lerroa ID: " + id + ", \n" + 
            "Produktua: " + izena + ", \n" +
            "Totala: " + prezio_Totala + ", \n" + 
            "Bezeroa ID: " + bezeroa_Id + ", \n" + 
            "Data: " + data + "]";
    }
}
