package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ActivityGame5 extends AppCompatActivity {

    private int intentos = 0;
    private final int maxIntentos = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_5letters);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);  // Configura el Toolbar como la ActionBar de la actividad
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Muestra la flecha de retroceso
            getSupportActionBar().setHomeButtonEnabled(true); // Habilita el botón de retroceso
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        Button botonRecara = findViewById(R.id.buttonRecarga);
        botonRecara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recargarActivity(v);
            }
        });
    }

    public void recargarActivity(View view) {
        finish();
        startActivity(getIntent());
    }

    public void verStats(View view) {
            Intent intent = new Intent(this, StatsActivity.class);
            Intent intent2 = getIntent();
            String nombre = intent2.getStringExtra("jugador");
            intent.putExtra("jugador", nombre);
            startActivity(intent);
    }

    public void verificaIntento(View view) {

        String letra = view.getTag().toString();
        Intent intent1 = getIntent();
        String palabra = intent1.getStringExtra("palabra");

        if(palabra.contains(letra)){
            Button button = (Button) view;
            button.setEnabled(false);
            List<Integer> posiciones = new ArrayList<>( );

            for (int i = 0; i < palabra.length(); i++) {
                if (String.valueOf(palabra.charAt(i)).equals(letra)) {
                    posiciones.add(i);
                }
            }

            EditText[] editTexts = {
                    findViewById(R.id.editTextText1),
                    findViewById(R.id.editTextText2),
                    findViewById(R.id.editTextText3),
                    findViewById(R.id.editTextText4),
                    findViewById(R.id.editTextText5),
                    findViewById(R.id.editTextText6)
            };

            for (int i = 0; i < posiciones.size(); i++) {
                int posicion = posiciones.get(i);

                if (posicion < editTexts.length) {
                    editTexts[posicion].setText(String.valueOf(letra));
                    editTexts[posicion].setEnabled(true);
                }
            }
        }
        else{
            ImageView imageView = findViewById(R.id.imageView4);
            intentos++;

            if (intentos <= maxIntentos) {
                int resId = getResources().getIdentifier("ic_antenna_game_" + intentos, "mipmap", getPackageName());
                imageView.setImageResource(resId);
            } else {
                System.out.println("ACABO EL JUEGO");
            }
        }
    }

    public void pierdeIntento(View view) {
        ImageView imageView = findViewById(R.id.imageView4);

        intentos++;

        if (intentos <= maxIntentos) {
            int resId = getResources().getIdentifier("ic_antenna_game_" + intentos, "mipmap", getPackageName());
            imageView.setImageResource(resId);
        } else {
            System.out.println("ACABO EL JUEGO");
        }
    }

}

