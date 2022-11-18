package com.example.pruebas_erronka1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public Connection connection = null;

//    public final String host = "10.0.2.2";
//    public final String database = "Ariketa_1";
//    public final int port = 5432;
//    public final String user = "openpg";
//    public final String pass = "openpgpwd";
//    public String url = "jdbc:postgresql://%s:%d/%s";
//    private boolean status;

    public final String host = "192.168.65.95";
    public final String database = "HJAA";
    public final int port = 5432;
    public final String user = "gorka";
    public final String pass = "gorka";
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


    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }


}
