package com.example.pruebas_erronka1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//SalmentaIkusiHaria
public class SalmentaIkusi extends Thread {
    Connection conn;
    private int salmenta_Id;
    public static ArrayList<Salmenta> salmentaGuztiak = new ArrayList<>();
    public static ArrayList<Salmenta> handienetik_Txikienera = new ArrayList<>();
    public static ArrayList<Salmenta> txikienetik_Handienera = new ArrayList<>();

    public SalmentaIkusi(Connection conn) {
        this.conn = conn;
    }


    public void run() {

        Statement st = null;
        try {
            st = conn.createStatement();

            //consulta sql que nos devolverá TODAS LAS VENTAS que se han realizado
            String sql_Ventas = "select \n" +
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

            //consulta sql que nos devolverá LA MEJOR COMPRA DE CADA CLIENTE
            String sql_MejorVentaCliente = "SELECT " +
                    "ventas.order_partner_id as Customer_Id, customer.name as Customer_Name, max(price_total) as Mayor\n" +
                    "FROM public.sale_order_line as ventas, public.res_partner as customer\n" +
                    "WHERE ventas.order_partner_id = customer.id\n" +
                    "GROUP BY customer.name, ventas.order_partner_id\n" +
                    "ORDER BY Mayor desc";


            //------------ PRIMERA CONSULTA ------------

            ResultSet rs = st.executeQuery(sql_Ventas);

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
                        sale_Identificador, sale_Nombre, sale_Precio_Unidad, sale_Precio_Subtotal,
                        sale_Precio_Toal, sale_Producto_Identificador, sale_Cantidad_Producto,
                        sale_Comprador_Identificador, sale_Fecha_Creacion, sale_Descripcion_Cliente
                );
                salmentaGuztiak.add(salmenta);
            }


            //------------ SEGUNDA CONSULTA ------------

            ResultSet rs2 = st.executeQuery(sql_MejorVentaCliente);

            while (rs2.next()) {
                int sale_Cliente_Identificador = rs2.getInt("Customer_Id");
                String sale_Cliente_Nombre = rs2.getString("Customer_Name");
                float sale_Precio_Compra = rs2.getFloat("Mayor");

                Salmenta salmenta_HT = new Salmenta(sale_Cliente_Identificador, sale_Cliente_Nombre, sale_Precio_Compra);
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

}
