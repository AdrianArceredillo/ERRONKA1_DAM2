package com.example.pruebas_erronka1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//ProduktuaIkusiHaria
public class ProduktuaIkusi extends Thread {
    Connection conn;
    private int prod_Id;
    public static ArrayList<Produktua> produktuGuztiak = new ArrayList<>();
    public Produktua productoSeleccionado = new Produktua();


    public ProduktuaIkusi(Connection conn) {
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


    public Produktua productoSeleccionadoInfo(String nombreProducto) {
        Statement st = null;
        try {
            st = conn.createStatement();
            String sql;
            sql = "select id, name, list_price, create_date, type FROM public.product_template WHERE name = '" + nombreProducto + "'";

            ResultSet rs = st.executeQuery(sql);

            int prod_Identificador = rs.getInt("id");
            String prod_Nombre = rs.getString("name");
            float price_Prod = rs.getFloat("list_price");
            String createDate_Product = String.valueOf(rs.getTimestamp("create_date"));
            String type_Product = rs.getString("type");

            productoSeleccionado = new Produktua(prod_Identificador, prod_Nombre, price_Prod, createDate_Product, type_Product);
            return productoSeleccionado;

//            while (rs.next()) {
//                int prod_Identificador = rs.getInt("id");
//                String prod_Nombre = rs.getString("name");
//                float price_Prod = rs.getFloat("list_price");
//                String createDate_Product = String.valueOf(rs.getTimestamp("create_date"));
//                String type_Product = rs.getString("type");

//                productoSeleccionado = new Produktua(prod_Identificador, prod_Nombre, price_Prod, createDate_Product, type_Product);
//                return productoSeleccionado;
//            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return productoSeleccionado;
    }


    public ArrayList<Produktua> getProduktuGuztiak() {
        return produktuGuztiak;
    }

}
