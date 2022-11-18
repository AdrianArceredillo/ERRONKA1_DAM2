package com.example.pruebas_erronka1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class VentasListado extends AppCompatActivity {


    private LinearLayout lytListadoVentas, lytSalmentakOrdenatuta;
    private Button btnMenuDesdeVentas, btnSalmentakOrdenatuta;
    private Spinner spinnerElegirVentas;
    private TextView txtFiltroarenAzalpena;
    private ScrollView scrollViewSalmentaGuztiak, scrollViewSalmentakOrdenatuta;

    ArrayList<String> bezeroenIzenak = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas_listado);

        this.setTitle("HJAA - Salmentak");

        Database db = new Database();
        SalmentaIkusi salmenta_Zerrenda = new SalmentaIkusi(db.getExtraConnection());
        salmenta_Zerrenda.start();

        try {
            salmenta_Zerrenda.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<Salmenta> listaVentas = salmenta_Zerrenda.getSalmentaGuztiak();
        ArrayList<Salmenta> ventas_HT = salmenta_Zerrenda.getSalmentakOrdenatuta_HT();

        lytListadoVentas = findViewById(R.id.lytListadoVentas);
        lytSalmentakOrdenatuta = findViewById(R.id.lytSalmentakOrdenatuta);
        lytSalmentakOrdenatuta.setVisibility(View.INVISIBLE);

        //ScrollView SUPERIOR (ver todas las ventas) - siempre estará visible
        scrollViewSalmentaGuztiak = findViewById(R.id.scrollViewSalmentaGuztiak);
        scrollViewSalmentaGuztiak.setVisibility(View.VISIBLE);

        //ScrollView INFERIOR (ver todas las ventas) - hasta que el usuario no pulse el botón, estará INVISIBLE
        scrollViewSalmentakOrdenatuta = findViewById(R.id.scrollViewSalmentakOrdenatuta);
        scrollViewSalmentakOrdenatuta.setVisibility(View.INVISIBLE);

        for (int i = 0; i < listaVentas.size(); i++) {
            //bezero desberdinen id-ak eta izenak spinner-aren barruan gorde
            String bezero_Bakoitza =
                    salmenta_Zerrenda.getSalmentaGuztiak().get(i).getOrder_partner_id() + " - " +
                            salmenta_Zerrenda.getSalmentaGuztiak().get(i).getDescripcion_Cliente();

            if (!bezeroenIzenak.contains(bezero_Bakoitza)) {
                bezeroenIzenak.add(bezero_Bakoitza);
            }

            //salmenta guztiak ikusarazi gohiko ScrollView-ean
            TextView textView = new TextView(getApplicationContext());
            textView.setGravity(Gravity.FILL_HORIZONTAL);
            textView.setText(salmenta_Zerrenda.getSalmentaGuztiak().get(i).toStringSalmentak());
            lytListadoVentas.addView(textView);
        }


        //bezero bakoitzak egindako erosketa handiena ikusarazi (handienetik-txikienera ordenaturik)
        for (int i = 0; i < ventas_HT.size(); i++) {
            TextView textView_Ordenatuta = new TextView(getApplicationContext());
            textView_Ordenatuta.setText(salmenta_Zerrenda.getSalmentakOrdenatuta_HT().get(i).toStringTxikia());
            lytSalmentakOrdenatuta.addView(textView_Ordenatuta);
        }

        spinnerElegirVentas = findViewById(R.id.spinnerElegirVentas);
        spinnerElegirVentas.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bezeroenIzenak));

        txtFiltroarenAzalpena = findViewById(R.id.txtFiltroarenAzalpena);
        txtFiltroarenAzalpena.setVisibility(View.INVISIBLE);

        btnSalmentakOrdenatuta = findViewById(R.id.btnSalmentakOrdenatuta);
        btnSalmentakOrdenatuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (scrollViewSalmentakOrdenatuta.getVisibility() != View.VISIBLE) {
                    txtFiltroarenAzalpena.setVisibility(View.VISIBLE);                              //hacer visible la explicación del contenido del ScrollView inferior
                    scrollViewSalmentakOrdenatuta.setVisibility(View.VISIBLE);                      //hacer visible el ScrollView INFERIOR
                    lytSalmentakOrdenatuta.setVisibility(View.VISIBLE);                             //hacer visible el Layout del ScrollView INFERIOR

                    /*
                    Cambiar la APARIENCIA y FUNCIONALIDAD del botón para que el usuario sepa que al pulsarlo de nuevo
                        - Al pulsarlo una vez, mostrará un determinado contenido en la parte inferior
                        - Si lo volvemos a pulsar, esconderá dicho contenido

                    Apariencia inicial:
                        - BackgroundTint    -   "#FF1919"   -   (rojo)
                        - TextColor         -   "#FFFFFF"   -   (blanco)
                        - Text (contenido)  -   R.string.btn_Ver_MejorCompraClientes

                    Después de pulsar:
                        - BackgroundTint    -   "#FFFFFF"   -   (blanco)
                        - TextColor         -   "#FF1919"   -   (rojo)
                        - Text (contenido)  -   R.string.btn_Ocultar_MejorCompraClientes
                     */
                    btnSalmentakOrdenatuta.setText(R.string.btn_Ocultar_MejorCompraClientes);
                    btnSalmentakOrdenatuta.setTextColor(Color.parseColor("#FF1919"));
                    btnSalmentakOrdenatuta.setBackgroundColor(Color.parseColor("#FFFFFF"));

                } else {
                    txtFiltroarenAzalpena.setVisibility(View.INVISIBLE);
                    scrollViewSalmentakOrdenatuta.setVisibility(View.INVISIBLE);
                    lytSalmentakOrdenatuta.setVisibility(View.INVISIBLE);

                    btnSalmentakOrdenatuta.setText(R.string.btn_Ver_MejorCompraClientes);
                    btnSalmentakOrdenatuta.setTextColor(Color.parseColor("#FFFFFF"));
                    btnSalmentakOrdenatuta.setBackgroundColor(Color.parseColor("#FF1919"));
                }
            }
        });


        btnMenuDesdeVentas = findViewById(R.id.btnMenuDesdeVentas);
        btnMenuDesdeVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cerrar_VentasListado = new Intent(VentasListado.this, MenuOpciones.class);
                startActivity(cerrar_VentasListado);
                finish();
            }
        });


    }
}