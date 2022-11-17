package com.konexioa;


import java.sql.Connection;
import java.sql.DriverManager;

public class Konexioa {
    public Connection connectDatabase() {
        String host = "192.168.65.95"; //192.168.65.95
        String port = "5432"; //5432
        String database = "HJAA"; //HJAA
        String user = "gorka"; //gorka
        String password = "gorka"; //gorka
        String url = "";
        Connection connection = null;
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Errorea PostgreSQL driverra erregistratzean: " + ex);
            }
            url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
            // Datu basearekin konektatuko da.
            connection = DriverManager.getConnection(url,user, password);
        } catch (java.sql.SQLException sqle) { 
            System.out.println("Errorea PostgreSQLko datu basearekin konektatzean (" + url + "): " + sqle);
        }
        return connection;
    }


}
