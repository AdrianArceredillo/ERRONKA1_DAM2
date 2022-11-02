package com.example.pruebas_erronka1;


import java.time.LocalDateTime;
import java.util.TimeZone;

public class Salmenta {

    /*
     * Cada vez que se vende un producto, se registra como una venta diferente. Pero en una misma venta puede haber más de un producto
     * Por ejemplo:
     *   Compra 1:
     *       - producto 1
     *       - producto 2
     * Tanto Odoo como PostgreSQL entienden que se han realizado dos ventas  (Venta 1 - prod 1 / Venta 2 - prod 2), pero como se han
     * vendido a la vez, ambos productos hacen referencia a "la misma" venta:
     *   - El producto 1 pertenece a la venta 1
     *   - El producto 2 también pertenece a la venta 1
     * */

    int id;
    int order_id;
    String izena;               //name

    float aleko_Prezioa;        //price_unit
    float guztirako_Prezioa;    //price_total
    int produktua_Id;           //product_id
    int kantitatea;             //product_uom_qty
    int company_id;             //company_id
    int bezeroa_Id;             //order_partner_id
    LocalDateTime data;         //create_date


    // LocalDateTime ldt = myResultSet.getObject( … , LocalDateTime.class ) ;


    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //order_id
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    //zena
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    //aleko_Prezioa
    public float getAleko_Prezioa() {
        return aleko_Prezioa;
    }

    public void setAleko_Prezioa(float aleko_Prezioa) {
        this.aleko_Prezioa = aleko_Prezioa;
    }

    //guztirako_Prezioa
    public float getGuztirako_Prezioa() {
        return guztirako_Prezioa;
    }

    public void setGuztirako_Prezioa(float guztirako_Prezioa) {
        this.guztirako_Prezioa = guztirako_Prezioa;
    }

    //produktua_Id
    public int getProduktua_Id() {
        return produktua_Id;
    }

    public void setProduktua_Id(int produktua_Id) {
        this.produktua_Id = produktua_Id;
    }

    //kantitatea
    public int getKantitatea() {
        return kantitatea;
    }

    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }

    //company_id
    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    //bezeroa_Id
    public int getBezeroa_Id() {
        return bezeroa_Id;
    }

    public void setBezeroa_Id(int bezeroa_Id) {
        this.bezeroa_Id = bezeroa_Id;
    }

    //data
    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Salmenta[" + id + ", " + izena + "]";
    }


    //INFO INTERNET:
    //TimeStamp without time zone: - https://stackoverflow.com/questions/8655442/create-a-timestamp-without-timezone


}
