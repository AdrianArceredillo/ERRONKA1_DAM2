package com.example.pruebas_erronka1;

import android.widget.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SalmentaIkusiHaria extends Thread  {
    Connection conn;
    private int salmenta_Id;
    public static ArrayList<Salmenta> salmentaGuztiak = new ArrayList<>();

    public SalmentaIkusiHaria(Connection conn) {
        this.conn = conn;
    }


    public void run() {

        Statement st = null;
        try {
            st = conn.createStatement();
            String sql;
//            sql = "select " +
//                    "id, name, price_unit, price_subtotal, price_total, product_id, product_uom_qty, order_partner_id, create_date " +
//                    "FROM public.sale_order_line";


            //select ventas.id as sale_Id, ventas.name as sale_Nombre, price_unit as sale_Precio_Unidad, price_subtotal as sale_Precio_Subtotal, price_total as sale_Precio_Total,product_id as sale_Producto_Identificador,product_uom_qty as sale_Cantidad_Producto, order_partner_id as sale_Comprador_Identificador, ventas.create_date as sale_Fecha_Creacion,compradores.name as descripcion_Comprador FROM public.sale_order_line as ventas, public.res_partner as compradores WHERE ventas.order_partner_id = compradores.id;
            String sql2 = "select \n" +
                    "ventas.id as sale_Id, " +
                    "ventas.name as sale_Nombre, " +
                    "price_unit as sale_Precio_Unidad, " +
                    "price_subtotal as sale_Precio_Subtotal, " +
                    "price_total as sale_Precio_Total, " +
                    "product_id as sale_Producto_Identificador, " +
                    "product_uom_qty as sale_Cantidad_Producto, " +
                    "order_partner_id as sale_Comprador_Identificador, " +
                    "ventas.create_date as sale_Fecha_Creacion, \n" +
                    "compradores.name as descripcion_Comprador\n" +
                    "FROM public.sale_order_line as ventas, public.res_partner as compradores\n" +
                    "where ventas.order_partner_id = compradores.id";


            //CREAR CONSULTA SQL QUE SAQUE LOS DIFERENTES CLIENTES QUE HAN REALIZADO COMPRAS (usando Distinct)
            //guardar en sql3 y un nuevo ResultSet
            //crear un nuevo arraylist<String> con los clientes: -> 1(id).- Adrián(nombre)

//            ResultSet rs = st.executeQuery(sql);
            ResultSet rs = st.executeQuery(sql2);

            while (rs.next()) {
                int sale_Identificador = rs.getInt("sale_Id");
                String sale_Nombre = rs.getString("sale_Nombre");
                float sale_Precio_Unidad = rs.getFloat("sale_Precio_Unidad");
                float sale_Precio_Subtotal = rs.getFloat("sale_Precio_Subtotal");
                float sale_Precio_Toal = rs.getFloat("sale_Precio_Total");
                int sale_Producto_Identificador = rs.getInt("sale_Producto_Identificador");
                int sale_Cantidad_Producto = rs.getInt("sale_Cantidad_Producto");
                int sale_Comprador_Identificador = rs.getInt("sale_Comprador_Identificador");
                String sale_Fecha_Creacion = rs.getString("sale_Fecha_Creacion");
                String sale_Descripcion_Cliente = rs.getString("descripcion_Comprador");


                Salmenta salmenta = new Salmenta(
                        sale_Identificador,
                        sale_Nombre,
                        sale_Precio_Unidad,
                        sale_Precio_Subtotal,
                        sale_Precio_Toal,
                        sale_Producto_Identificador,
                        sale_Cantidad_Producto,
                        sale_Comprador_Identificador,
                        sale_Fecha_Creacion,
                        sale_Descripcion_Cliente
                );

                salmentaGuztiak.add(salmenta);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }


    public ArrayList<Salmenta> getSalmentaGuztiak() {
        return salmentaGuztiak;
    }

}
