package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.lab2.databinding.ActivityMainBinding;

public class StatsActivity extends AppCompatActivity{
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);  // Configura el Toolbar como la ActionBar de la actividad

        // Habilita la flecha de retroceso
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Muestra la flecha de retroceso
            getSupportActionBar().setHomeButtonEnabled(true); // Habilita el botón de retroceso
        }

        // Configura la acción para el ícono de navegación
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}
