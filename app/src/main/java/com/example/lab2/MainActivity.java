package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import com.example.lab2.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registrarNombre();
    }

    public void registrarNombre() {
        binding.buttonJugar.setOnClickListener(view -> {
            String nombre = binding.editTextNombre.getText().toString();
            Log.d("nombre", "EL NOMBRE ES: " + nombre);
            if(!nombre.isEmpty()){

                /*palabra del juego*/
                String[] diccionario = {"FIBRA", "REDES", "PROPA", "CLOUD"};
                Random random = new Random();
                int index = random.nextInt(diccionario.length);
                String palabraElegida = diccionario[index];

                Log.d("nombre", "LA PALABRA ES: " + palabraElegida);

                if(palabraElegida.length()==5){
                    Intent intent = new Intent(this, ActivityGame5.class);
                    intent.putExtra("jugador", nombre);
                    intent.putExtra("palabra", palabraElegida);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(this, ActivityGame6.class);
                    intent.putExtra("jugador", nombre);
                    intent.putExtra("palabra", palabraElegida);
                    startActivity(intent);
                }

            }
        });
    }
}