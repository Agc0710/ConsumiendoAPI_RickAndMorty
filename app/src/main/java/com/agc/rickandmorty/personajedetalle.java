package com.agc.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.agc.rickandmorty.Apimanager.RetrofitClient;
import com.agc.rickandmorty.Models.Personaje;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class personajedetalle extends AppCompatActivity {

     private String id;
    TextView namepersonaje;
    TextView statuspersonaje;
    TextView speciepersonaje;
    TextView genderpersonaje;
    TextView createdpersonaje;
    ImageView imgpersonajedetalle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajedetalle);

        Bundle bundle= getIntent().getExtras();
        id= bundle.getString("id");

        namepersonaje = findViewById(R.id.nombrepersonajedetalle);
        statuspersonaje = findViewById(R.id.Statuspersonajedetalle);
        speciepersonaje = findViewById(R.id.SpeciePersonajedetalle);
        genderpersonaje = findViewById(R.id.genderpersonadetalle);
        createdpersonaje = findViewById(R.id.createdpersonajedetalle);
        imgpersonajedetalle = findViewById(R.id.imgpersonajedetalle);
        getPersonajebyId(id);



    }
    private void getPersonajebyId(String id){
        Call<Personaje>call= RetrofitClient.getInstance().getMyApi().getPersonajes1(id);
        call.enqueue(new Callback<Personaje>() {
            @Override
            public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                Personaje personaje1= response.body();

               Picasso.get()
                        .load(personaje1.getImagen())
                        .resize(140,100)
                        .centerCrop()
                        .error(R.mipmap.ic_launcher)
                        .into(imgpersonajedetalle);

                namepersonaje.setText(personaje1.getNombre());
                statuspersonaje.setText(personaje1.getEstadoPersonaje());
                speciepersonaje.setText(personaje1.getEspeciesPersonaje());
                genderpersonaje.setText(personaje1.getGeneroPersonaje());
                createdpersonaje.setText(personaje1.getCrear());



            }

            @Override
            public void onFailure(Call<Personaje> call, Throwable t) {

            }
        });

    }



}