package com.example.pruebas_erronka1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class VentasListado extends AppCompatActivity {

    private LinearLayout linearLayout, lytVentasInfoCompleta;
    private Spinner spinnerElegirVentas;
    private TextView txtVentasSeleccionado;
    private Button btnVerSeleccionado;

    ArrayList<String> bezeroenIzenak = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas_listado);

        Database db = new Database();
        SalmentaIkusiHaria salmentaIkusi = new SalmentaIkusiHaria(db.getExtraConnection());
        salmentaIkusi.start();

        try {
            salmentaIkusi.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<Salmenta> listaVentas = salmentaIkusi.getSalmentaGuztiak();
        linearLayout = findViewById(R.id.lytListadoVentas);

        for( int i = 0; i < listaVentas.size(); i++ )
        {
            bezeroenIzenak.add(
                    String.valueOf(salmentaIkusi.getSalmentaGuztiak().get(i).getId()) + ".- " +
                            salmentaIkusi.getSalmentaGuztiak().get(i).getDescripcion_Cliente()
            );

            TextView textView = new TextView(getApplicationContext());
            textView.setText(salmentaIkusi.getSalmentaGuztiak().get(i).toString());
            linearLayout.addView(textView);
        }


        spinnerElegirVentas = findViewById(R.id.spinnerElegirVentas);
        spinnerElegirVentas.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bezeroenIzenak));


    }
}