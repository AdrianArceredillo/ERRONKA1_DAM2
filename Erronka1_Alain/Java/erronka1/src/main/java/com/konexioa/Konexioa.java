package com.konexioa;


import java.sql.Connection;
import java.sql.DriverManager;

public class Konexioa {
    public Connection connectDatabase() {
        String host = "192.168.65.10";
        String port = "5432";
        String database = "HJAA";
        String user = "openpg";
        String password = "openpgpwd";
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
