package com.example.pruebas_erronka1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProduktuaIkusiHaria extends Thread {
    Connection conn;
    private int prod_Id;
    public static ArrayList<Produktua> produktuGuztiak = new ArrayList<>();
    private Produktua productoSeleccionado = new Produktua();


    public ProduktuaIkusiHaria(Connection conn) {
        this.conn = conn;
    }

    public Produktua getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Produktua productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }



    public void run() {

        Statement st = null;
        try {
            st = conn.createStatement();
            String sql;
            sql = "select id, name, list_price FROM public.product_template";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int prod_Identificador = rs.getInt("id");
                String prod_Nombre = rs.getString("name");
                float price_Prod = rs.getFloat("list_price");

                Produktua produktua = new Produktua(prod_Identificador, prod_Nombre, price_Prod);
                produktuGuztiak.add(produktua);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }


    public void productoSeleccionadoInfo(String nombreProducto) {
        Statement st = null;
        try {
            st = conn.createStatement();
            String sql;
            sql = "select id, name, list_price, create_date, type FROM public.product_template";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int prod_Identificador = rs.getInt("id");
                String prod_Nombre = rs.getString("name");
                float price_Prod = rs.getFloat("list_price");
                String createDate_Product = rs.getString("create_date");
                String type_Product = rs.getString("type");

                productoSeleccionado = new Produktua(prod_Identificador, prod_Nombre, price_Prod, createDate_Product, type_Product);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }


    public ArrayList<Produktua> getProduktuGuztiak() {
        return produktuGuztiak;
    }

}
