package com.example.pruebas_erronka1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();   // Class name for Log tag
    private String usuarioCorrecto = "adrian";
    private String contraseña_Correcta = "password";
    public static final int TEXT_REQUEST = 1;   // Unique tag for the intent reply

    public EditText mUsuario, mContraseña;
    public Button btnSartu;
    public Button btnPruebaActivar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("HJAA Denda");

        //Database db = new Database();

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

    }



    public void comprobarInicioSesion(/*String usuarioUser, String contraseñaUser*/) {
        String usuarioUser = mUsuario.getText().toString();
        String contraseñaUser = mContraseña.getText().toString();

        if (usuarioCorrecto.equals(usuarioUser) & contraseña_Correcta.equals(contraseñaUser)) {
            Toast mezua_Correcto = Toast.makeText(getApplicationContext()," Ongi etorri! ", Toast.LENGTH_LONG);
            mezua_Correcto.show();
            btnPruebaActivar.setEnabled(true);
        } else {
            Toast mezua_Incorrecto = Toast.makeText(getApplicationContext()," Los datos introducidos no son correctos! ", Toast.LENGTH_LONG);
            mezua_Incorrecto.show();
            mContraseña.setText("");

        }
    }





}