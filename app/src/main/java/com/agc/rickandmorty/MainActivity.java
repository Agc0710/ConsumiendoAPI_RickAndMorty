package com.agc.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnpersonajes;
    private Button btnubicaciones;
    private Button btnepisodios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnpersonajes = findViewById(R.id.btnPersonajes);
        btnubicaciones = findViewById(R.id.btnUbicaciones);
        btnepisodios = findViewById(R.id.btnEpisodios);

        btnpersonajes.setOnClickListener(this);
        btnubicaciones.setOnClickListener(this);
        btnepisodios.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnPersonajes){
            Intent Myintent = new Intent(this, personajeslistview.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnUbicaciones){
            Intent Myintent = new Intent(this, ubicacioneslistview.class );
            startActivity(Myintent);
        }
        if (v.getId() == R.id.btnEpisodios){
            Intent Myintent = new Intent(this, episodioslistview.class );
            startActivity(Myintent);
        }

    }
}