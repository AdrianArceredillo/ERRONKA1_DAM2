package com.example.pruebas_erronka1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String NOMBRE_USUARIO = "Usuario";

    public EditText mUsuario, mContraseña;
    public Button btnSartu, btnAplikazioaItxi;

    private String nombreUsuario;
    private String usuarioCorrecto = "HjaaEmpresa";
    private String contraseña_Correcta = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("HJAA Denda");

        //asignar los elementos de la actividad
        mUsuario = findViewById(R.id.editTextErabiltzailea);
        mContraseña = findViewById(R.id.editTextPasahitza);

        btnAplikazioaItxi = findViewById(R.id.btnAplikazioaItxi);
        btnAplikazioaItxi.setEnabled(true);
        btnAplikazioaItxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finishAffinity(); //FINALIZAR POR COMPLETO la activadad
                System.exit(0); //SALIR de la actividad -> DETENER LA EJECUCIÓN de la aplicación
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


}