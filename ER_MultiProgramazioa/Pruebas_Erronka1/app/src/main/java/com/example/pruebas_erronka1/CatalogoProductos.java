package com.example.pruebas_erronka1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CatalogoProductos extends AppCompatActivity {

    private Spinner spinnerElegirProductos;
    private LinearLayout linearLayout;
    private Button btnMenuraBueltatu;

    private Produktua prod_Sel = new Produktua();
    ArrayList<String> produktuenIzenak = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_productos);

        this.setTitle("HJAA - Produktuen Katalogoa");

        Database db = new Database();
        ProduktuaIkusi katalogoaIkusi = new ProduktuaIkusi(db.getExtraConnection());
        katalogoaIkusi.start();

        try {
            katalogoaIkusi.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<Produktua> listaProductos = katalogoaIkusi.getProduktuGuztiak();
        linearLayout = findViewById(R.id.lytProductos);

        for (int i = 0; i < listaProductos.size(); i++) {
            produktuenIzenak.add(katalogoaIkusi.getProduktuGuztiak().get(i).getName());

            TextView textView = new TextView(getApplicationContext());
            textView.setText(katalogoaIkusi.getProduktuGuztiak().get(i).toStringDefinitivo());
            linearLayout.addView(textView);
        }

        spinnerElegirProductos = findViewById(R.id.spinnerElegirProductos);
        spinnerElegirProductos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, produktuenIzenak));

        btnMenuraBueltatu = findViewById(R.id.btnMenuDesdeProductos);
        btnMenuraBueltatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCerrar_Catalogo = new Intent(CatalogoProductos.this, MenuOpciones.class);
                startActivity(intentCerrar_Catalogo);
                finish();
            }
        });


    }
}