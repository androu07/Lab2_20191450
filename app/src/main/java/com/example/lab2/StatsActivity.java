package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
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
        Intent intent = new Intent(this, ActivityGame5.class);
        startActivity(intent);
    }
}
