package com.example.pruebas_erronka1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.sql.Connection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MainActivity binding;

    private Connection connection = null;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();   // Class name for Log tag
    public static final String NOMBRE_USUARIO = "Usuario";

    private String nombreUsuario;
    private String usuarioCorrecto = "adrian";
    private String contraseña_Correcta = "password";
    public static final int TEXT_REQUEST = 1;   // Unique tag for the intent reply

    private static final ArrayList<Produktua> catalogo_Productos = null;

    private Toolbar toolbarLogin;
    public EditText mUsuario, mContraseña;
    public Button btnSartu;
    public Button btnAplikazioaItxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("HJAA Denda");

//        Database db = new Database();
//
//        ProduktuaIkusiHaria produktuakIkusi = new ProduktuaIkusiHaria(db.getExtraConnection());
//        produktuakIkusi.start();
//
//        try {
//            produktuakIkusi.join();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        txtPruebaProd = findViewById(R.id.txtPruebaProd);
//        txtPruebaProd.setText(produktuakIkusi.getProduktuGuztiak().get(3).toString());
//
//        ArrayList<Produktua> listaProductos = produktuakIkusi.getProduktuGuztiak();
//        linearLayout = findViewById(R.id.lytPruebasProd);
//
//        for( int i = 0; i < listaProductos.size(); i++ )
//        {
//            TextView textView = new TextView(getApplicationContext());
//            textView.setText(produktuakIkusi.getProduktuGuztiak().get(i).toStringDefinitivo());
//            linearLayout.addView(textView);
//        }


        //asignar los elementos de la actividad
        mUsuario = findViewById(R.id.editTextErabiltzailea);
        mContraseña = findViewById(R.id.editTextPasahitza);

        btnAplikazioaItxi = findViewById(R.id.btnAplikazioaItxi);
        btnAplikazioaItxi.setEnabled(true);
        btnAplikazioaItxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish(); //FINALIZAR la actividad
                System.exit(0); //SALIR de la actividad - dejar de ejecutar la aplicación
            }
        });

        btnSartu = findViewById(R.id.btnIniciarSesion);
        btnSartu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarInicioSesion();
            }
        });
    }


    public void comprobarInicioSesion(/*String usuarioUser, String contraseñaUser*/) {
        String usuarioUser = mUsuario.getText().toString();
        String contraseñaUser = mContraseña.getText().toString();

        if (usuarioCorrecto.equals(usuarioUser) & contraseña_Correcta.equals(contraseñaUser)) {
            Toast mezua_Correcto = Toast.makeText(getApplicationContext(), " Ongi etorri! ", Toast.LENGTH_LONG);
            mezua_Correcto.show();

            abrirMenuInformacion(); //abrir la acitividad que permitirá al usuario elegir el tipo de información que desea ver
            btnAplikazioaItxi.setEnabled(true);
        } else {
            Toast mezua_Incorrecto = Toast.makeText(getApplicationContext(), " Los datos introducidos no son correctos! ", Toast.LENGTH_LONG);
            mezua_Incorrecto.show();
            mContraseña.setText("");

        }
    }

    public void abrirMenuInformacion() {
        Intent intentCatalogo = new Intent(this, MenuOpciones.class);
        nombreUsuario = mUsuario.getText().toString();
        intentCatalogo.putExtra(NOMBRE_USUARIO, nombreUsuario);
        startActivity(intentCatalogo);
    }

    public void abrirCatalogo() {
        Intent intentCatalogo = new Intent(this, CatalogoProductos.class);
        startActivity(intentCatalogo);
    }


    //Consultas a la base de datos
    //1 - https://es.stackoverflow.com/questions/103039/conectividad-de-estudio-de-android-con-postgresql


}