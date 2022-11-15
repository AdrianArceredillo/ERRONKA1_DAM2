package com.example.pruebas_erronka1;

import android.widget.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SalmentaIkusiHaria extends Thread {
    Connection conn;
    private int salmenta_Id;
    public static ArrayList<Salmenta> salmentaGuztiak = new ArrayList<>();
    public static ArrayList<Salmenta> handienetik_Txikienera = new ArrayList<>();
    public static ArrayList<Salmenta> txikienetik_Handienera = new ArrayList<>();

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
                    "to_char(ventas.create_date, 'DD/MM/YYYY') as sale_Fecha_Creacion, \n" +
                    //"ventas.create_date as sale_Fecha_Creacion, \n" +
                    "compradores.name as descripcion_Comprador\n" +
                    "FROM public.sale_order_line as ventas, public.res_partner as compradores\n" +
                    "where ventas.order_partner_id = compradores.id";


            //CREAR CONSULTA SQL QUE SAQUE LOS DIFERENTES CLIENTES QUE HAN REALIZADO COMPRAS (usando Distinct)
            //guardar en sql3 y un nuevo ResultSet
            //crear un nuevo arraylist<String> con los clientes: -> 1(id).- Adrián(nombre)

            //Total del objeto comprado
            String sql3 = "SELECT max(price_total) as Mayor, ventas.name FROM public.sale_order_line as ventas GROUP BY ventas.name ORDER BY Mayor asc";
            String sql4 = "SELECT min(price_total) as Menor, ventas.name FROM public.sale_order_line as ventas GROUP BY ventas.name ORDER BY Menor asc";
            String sql5 = "select * from public.sale_order_line ORDER BY price_Total desc limit 3";
            String sql6 = "SELECT ventas.order_partner_id as Customer_Id, customer.name as Customer_Name, max(price_total) as Mayor\n" +
                    "FROM public.sale_order_line as ventas, public.res_partner as customer\n" +
                    "WHERE ventas.order_partner_id = customer.id\n" +
                    "GROUP BY customer.name, ventas.order_partner_id\n" +
                    "ORDER BY Mayor desc";   //máxima compra de cada cliente

//            ResultSet rs = st.executeQuery(sql);
            ResultSet rs2 = st.executeQuery(sql2);

            while (rs2.next()) {
                int sale_Identificador = rs2.getInt("sale_Id");
                String sale_Nombre = rs2.getString("sale_Nombre");
                float sale_Precio_Unidad = rs2.getFloat("sale_Precio_Unidad");
                float sale_Precio_Subtotal = rs2.getFloat("sale_Precio_Subtotal");
                float sale_Precio_Toal = rs2.getFloat("sale_Precio_Total");
                int sale_Producto_Identificador = rs2.getInt("sale_Producto_Identificador");
                int sale_Cantidad_Producto = rs2.getInt("sale_Cantidad_Producto");
                int sale_Comprador_Identificador = rs2.getInt("sale_Comprador_Identificador");

//                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//                String fecha_Creacion = formatter.format(new Date(Long.parseLong(YOUR TIMESTAMP VALUE)));
//                txtDate.setText(dateString);

                String sale_Fecha_Creacion = rs2.getString("sale_Fecha_Creacion");
                String sale_Descripcion_Cliente = rs2.getString("descripcion_Comprador");


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

            //guardar datos de la sentencia: sql3
            ResultSet rs6 = st.executeQuery(sql6);

            while (rs6.next()) {
                int sale_Cliente_Identificador = rs6.getInt("Customer_Id");
                String sale_Cliente_Nombre = rs6.getString("Customer_Name");
                float sale_Precio_Compra = rs6.getFloat("Mayor");

                Salmenta salmenta_HT = new Salmenta(
                        sale_Cliente_Identificador,
                        sale_Cliente_Nombre,
                        sale_Precio_Compra
                );

                handienetik_Txikienera.add(salmenta_HT);
            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }


    public ArrayList<Salmenta> getSalmentaGuztiak() {
        return salmentaGuztiak;
    }

    public ArrayList<Salmenta> getSalmentakOrdenatuta_HT() {
        return handienetik_Txikienera;
    }

    /*
    public ArrayList<Salmenta> getSalmentakOrdenatuta_TH() {
        return handienetik_Txikienera;
    }
    */

}
