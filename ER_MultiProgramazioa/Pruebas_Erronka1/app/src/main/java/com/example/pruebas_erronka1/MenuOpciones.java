package com.example.pruebas_erronka1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MenuOpciones extends AppCompatActivity {

    private Button btnSalmentak, btnKatalogoa, btnHasiera;
    private TextView txtUsuarioRecibido;
    private Toolbar toolbarMenuOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);

        this.setTitle("Zer egin nahi duzu?");



        Intent intent = getIntent();
        txtUsuarioRecibido = findViewById(R.id.txtUsuarioRecibido);
        txtUsuarioRecibido.setText(intent.getStringExtra(MainActivity.NOMBRE_USUARIO));

        btnSalmentak = findViewById(R.id.btnSalmentak);
        btnSalmentak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirListadoVentas();
            }
        });

        btnKatalogoa = findViewById(R.id.btnKatalogoa);
        btnKatalogoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCatalogoProductos();
            }
        });

        btnHasiera = findViewById(R.id.btnHasiera);
        btnHasiera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverInicio();
            }
        });

    }

    public void abrirListadoVentas() {
        Intent intentVentas = new Intent(this, VentasListado.class);
        startActivity(intentVentas);
    }

    public void abrirCatalogoProductos() {
        Intent intentCatalogo = new Intent(this, CatalogoProductos.class);
        startActivity(intentCatalogo);
    }

    public void volverInicio() {
        Intent intentInicio = new Intent(this, MainActivity.class);
        startActivity(intentInicio);
    }


}