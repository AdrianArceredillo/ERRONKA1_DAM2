package com.example.pruebas_erronka1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProduktuaIkusiHaria extends Thread {
    Database conn;
    Connection con;
    private int prod_Id;
    public static ArrayList<Produktua> produktuGuztiak = null;


    public ProduktuaIkusiHaria(Database conn) {
        this.conn = conn;
    }

    public ProduktuaIkusiHaria(Connection con) {
        this.con = con;
    }


    public void run(Database db) {
        Statement st = null;
        Connection conn = db.connection;
        try {
            Class.forName("org.postgresql.Driver");
            db.connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
            //connection = DriverManager.getConnection(url);
            st = conn.createStatement();
            String sql;
            //sql = "SELECT  id, name FROM product_template";
            sql = "select public.product_template.id, public.product_template.name\n" +
                    "FROM \n" +
                    "public.product_template\n" +
                    "WHERE \n" +
                    "public.product_template.id > 5";
            ResultSet rs = st.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int prod_Identificador = rs.getInt("id");
                String prod_Nombre = rs.getString("name");

                Produktua produktua = new Produktua(prod_Identificador, prod_Nombre);
                produktuGuztiak.add(produktua);
                //resultado_Prueba = "Id: " + prod_Identificador + ". Nombre: " + prod_Nombre;

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
