package com.example.pruebas_erronka1;

import static com.example.pruebas_erronka1.R.string.lblProductoSeleccionado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CatalogoProductos extends AppCompatActivity {

    private LinearLayout linearLayout, lytProductoInfoCompleta;
    private Spinner spinnerElegirProductos;
    private TextView txtProductoSeleccionado;
    private Button btnVerSeleccionado;

    private Produktua prod_Sel = new Produktua();

    String[] produktuenIzenak_A = {};
    ArrayList<String> produktuenIzenak = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_productos);

        Database db = new Database();
        ProduktuaIkusiHaria produktuakIkusi = new ProduktuaIkusiHaria(db.getExtraConnection());
        produktuakIkusi.start();

        try {
            produktuakIkusi.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<Produktua> listaProductos = produktuakIkusi.getProduktuGuztiak();
        linearLayout = findViewById(R.id.lytProductos);

        for( int i = 0; i < listaProductos.size(); i++ )
        {
            produktuenIzenak.add(produktuakIkusi.getProduktuGuztiak().get(i).getName());

            TextView textView = new TextView(getApplicationContext());
            textView.setText(produktuakIkusi.getProduktuGuztiak().get(i).toStringDefinitivo());
            linearLayout.addView(textView);
        }

        spinnerElegirProductos = findViewById(R.id.spinnerElegirProductos);
        spinnerElegirProductos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, produktuenIzenak));

        txtProductoSeleccionado = findViewById(R.id.txtProductoSeleccionado);

        btnVerSeleccionado = findViewById(R.id.btnVerSeleccionado);
        btnVerSeleccionado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre_Seleccionado_A = spinnerElegirProductos.getSelectedItem().toString();

                prod_Sel = produktuakIkusi.productoSeleccionadoInfo(nombre_Seleccionado_A);

                String nombre_Seleccionado_BBB = String.valueOf(prod_Sel.getPrice());
                txtProductoSeleccionado.setText(nombre_Seleccionado_BBB);
            }
        });



    }
}