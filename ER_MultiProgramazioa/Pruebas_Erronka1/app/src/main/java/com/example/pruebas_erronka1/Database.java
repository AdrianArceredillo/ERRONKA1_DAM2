package com.example.pruebas_erronka1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public Connection connection = null;

    // For Amazon Postgresql
    // private final String host = "ssprojectinstance.csv2nbvvgbcb.us-east-2.rds.amazonaws.com"

    // For Google Cloud Postgresql
    // private final String host = "35.44.16.169";

    // For Local PostgreSQL


    //private final String host = "192.168.65.5";
    //private final String database = "Pekin_Bilbo_Store";
    //private final int port = 5432;
    //private final String user = "joseba";
    //private final String pass = "joseba";
    //private String url = "jdbc:postgresql://%s:%d/%s";
    //private boolean status;

    public final String host = "10.0.2.2";
    public final String database = "Ariketa_1";
    public final int port = 5432;
    public final String user = "openpg";
    public final String pass = "openpgpwd";
    public String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public Database() {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        //this.disconnect();
        System.out.println("connection status:" + status);
    }

    private void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    //connection = DriverManager.getConnection(url);
                    status = true;
                    System.out.println("connected:\n" + status);
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection() {
        return connection;
    }

//    public Connection getExtraConnection() {
//        Connection c = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager.getConnection(url, user, pass);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return c;
//    }


    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }


    //INFO INTERNET
    //Conexión a PostgreSQL desde Android Studio - https://medium.com/cyber-explorer/how-to-connect-an-android-project-to-a-postgresql-database-663cb0f5ba19
    //Conexión a PostgreSQL desde Android Studio 2 - https://www.cloudclusters.io/docs/postgresql/Connecting%20to%20PostgreSQL%20Database%20via%20Different%20Languages1605494263.html
    //Conectarse a PostgreSQL - https://www.youtube.com/watch?v=THd1kOw24HY


}
