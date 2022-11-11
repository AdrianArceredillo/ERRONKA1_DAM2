package com.example.pruebas_erronka1;

import java.time.LocalDateTime;
import java.util.TimeZone;

public class Produktua {
    int id;
    String name;

    public Produktua(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Produktua[Id: " + id + ". Nombre: " + name + "]";
    }

}
