package com.example.pruebas_erronka1;


import java.time.LocalDateTime;

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

    int id;                     //id
    String name;                //name
    float price_unit;           //price_unit
    float price_subtotal;       //price_subtotal
    float price_total;          //price_total
    int product_id;             //product_id
    int product_uom_qty;        //product_uom_qty
    int order_partner_id;       //order_partner_id
    String data;                //create_date
    String descripcion_Cliente; //order_partner_id + name(res_partner)



    public Salmenta() {
    }

    public Salmenta(int id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public Salmenta(int id, String name, float price_unit, float price_subtotal, float price_total,
                    int product_id, int product_uom_qty, int order_partner_id, String data, String descripcion_Cliente) {
        this.id = id;
        this.name = name;
        this.price_unit = price_unit;
        this.price_subtotal = price_subtotal;
        this.price_total = price_total;
        this.product_id = product_id;
        this.product_uom_qty = product_uom_qty;
        this.order_partner_id = order_partner_id;
        this.data = data;
        this.descripcion_Cliente = descripcion_Cliente;
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

    public float getPrice_unit() {
        return price_unit;
    }

    public void setPrice_unit(float price_unit) {
        this.price_unit = price_unit;
    }

    public float getPrice_subtotal() {
        return price_subtotal;
    }

    public void setPrice_subtotal(float price_subtotal) {
        this.price_subtotal = price_subtotal;
    }

    public float getPrice_total() {
        return price_total;
    }

    public void setPrice_total(float price_total) {
        this.price_total = price_total;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_uom_qty() {
        return product_uom_qty;
    }

    public void setProduct_uom_qty(int product_uom_qty) {
        this.product_uom_qty = product_uom_qty;
    }

    public int getOrder_partner_id() {
        return order_partner_id;
    }

    public void setOrder_partner_id(int order_partner_id) {
        this.order_partner_id = order_partner_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescripcion_Cliente() {
        return descripcion_Cliente;
    }

    public void setDescripcion_Cliente(String descripcion_Cliente) {
        this.descripcion_Cliente = descripcion_Cliente;
    }


    @Override
    public String toString() {
        return "Salmenta[" + id + ", " + name + ", " + data + "]\n";
    }


    //INFO INTERNET:
    //TimeStamp without time zone: - https://stackoverflow.com/questions/8655442/create-a-timestamp-without-timezone


}
