package com.example.pruebas_erronka1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuOpciones extends AppCompatActivity {

    private Button btnSalmentak, btnProduktuak;
    private TextView txtUsuarioRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);

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

        btnProduktuak = findViewById(R.id.btnProduktuak);
        btnProduktuak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCatalogoProductos();
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


}