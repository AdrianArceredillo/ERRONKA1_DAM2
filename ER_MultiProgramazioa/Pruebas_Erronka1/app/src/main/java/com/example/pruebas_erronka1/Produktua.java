package com.example.pruebas_erronka1;

import java.time.LocalDateTime;
import java.util.TimeZone;

public class Produktua {
    int id;
    String name;
    float price;
    String date;
    String type;

    public Produktua() {

    }

    public Produktua(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Produktua(int id, String name, float price, String date, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id: " + id + ". Nombre: " + name + ". Price: " + price;
    }

    public String toStringDefinitivo() {
        //String s = String.format("%.2f", 1.2975118);
        return id + ". Nombre: " + name + ". Price: " + String.format("%.2f", price) + " €\n";

    }

}
