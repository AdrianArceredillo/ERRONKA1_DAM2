package com.example.pruebas_erronka1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MainActivity binding;

    private Connection connection = null;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();   // Class name for Log tag
    private String usuarioCorrecto = "adrian";
    private String contraseña_Correcta = "password";
    public static final int TEXT_REQUEST = 1;   // Unique tag for the intent reply

    private static final ArrayList<Produktua> catalogo_Productos = null;
    private TextView txtPruebaProd;

    public EditText mUsuario, mContraseña;
    public Button btnSartu;
    public Button btnPruebaActivar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("HJAA Denda");

        Database db = new Database();
        Konexioa kon = new Konexioa();
        kon.connectDatabase(db.host, db.port, db.database, db.user, db.pass);


        ProduktuaIkusiHaria produktuakIkusi = new ProduktuaIkusiHaria(db);
        produktuakIkusi.start();
        try {
            produktuakIkusi.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        txtPruebaProd = findViewById(R.id.txtPruebaProd);
        //txtPruebaProd.setText(doInBackground());
        txtPruebaProd.setText(produktuakIkusi.getProduktuGuztiak().get(0).getName());


        //asignar los elementos de la actividad
        mUsuario = findViewById(R.id.editTextErabiltzailea);
        mContraseña = findViewById(R.id.editTextPasahitza);

        btnPruebaActivar = findViewById(R.id.btnPruebaActivar);
        btnPruebaActivar.setEnabled(false);

        btnSartu = findViewById(R.id.btnIniciarSesion);
        btnSartu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                String usuarioUser = mUsuario.getText().toString();
                String contraseñaUser = mContraseña.getText().toString();

                if (usuarioCorrecto.equals(usuarioUser) & contraseña_Correcta.equals(contraseñaUser)) {
                    Toast mezua_Correcto = Toast.makeText(getApplicationContext()," Ongi etorri! ", Toast.LENGTH_LONG);
                    mezua_Correcto.show();
                    btnPruebaActivar.setEnabled(true);
                } else {
                    Toast mezua_Incorrecto = Toast.makeText(getApplicationContext()," Los datos introducidos no son correctos! ", Toast.LENGTH_LONG);
                    mezua_Incorrecto.show();
                }
                */
                comprobarInicioSesion();
            }
        });

        //txtPruebaProd = findViewById(R.id.txtPruebaProd);
    }


    public void comprobarInicioSesion(/*String usuarioUser, String contraseñaUser*/) {
        String usuarioUser = mUsuario.getText().toString();
        String contraseñaUser = mContraseña.getText().toString();

        if (usuarioCorrecto.equals(usuarioUser) & contraseña_Correcta.equals(contraseñaUser)) {
            Toast mezua_Correcto = Toast.makeText(getApplicationContext(), " Ongi etorri! ", Toast.LENGTH_LONG);
            mezua_Correcto.show();
            btnPruebaActivar.setEnabled(true);
        } else {
            Toast mezua_Incorrecto = Toast.makeText(getApplicationContext(), " Los datos introducidos no son correctos! ", Toast.LENGTH_LONG);
            mezua_Incorrecto.show();
            mContraseña.setText("");

        }
    }


    protected String doInBackground() {
        //En esta parte es donde realizamos la llamada. Se realiza de manera asíncrona

//        String url = db.getUrl();
//        String user = db.getUser();
//        String pass = db.getPass();

        String url_Prueba = "jdbc:postgresql://10.0.2.2:5432/Ariketa_1";

        String resultado_Prueba = "";

        Connection conn = null;
        Statement st = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url_Prueba, "openpg", "openpgpwd");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
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
                catalogo_Productos.add(produktua);
                //resultado_Prueba = "Id: " + prod_Identificador + ". Nombre: " + prod_Nombre;


                //Display values
                resultado_Prueba = produktua.toString();
                return resultado_Prueba;

                //System.out.print(", First: " + first);
                //System.out.println(", Last: " + last);
            }
            //STEP 6: Clean-up environment
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (st != null)
                    st.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }

        /*protected void onPostExecute(String result) {
            //En esta parte es donde tratamos el resultado devuelto por la llamada a la BBDD.
        }
        */

        return resultado_Prueba;

    }


    //Consultas a la base de datos
    //1 - https://es.stackoverflow.com/questions/103039/conectividad-de-estudio-de-android-con-postgresql


}