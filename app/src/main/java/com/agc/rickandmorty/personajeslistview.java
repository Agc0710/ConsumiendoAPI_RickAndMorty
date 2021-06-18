package com.agc.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.agc.rickandmorty.Apimanager.RetrofitClient;
import com.agc.rickandmorty.Models.Personaje;
import com.agc.rickandmorty.Models.Personajes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class personajeslistview extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ListView listpersonaje;
    Personajes mypersonaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajeslistview);
        listpersonaje = findViewById(R.id.ListaPersonaje);
        getFromInternetPersonaje();
        listpersonaje.setOnItemClickListener(this);

    }

    private void getFromInternetPersonaje() {
        Call<Personajes> callrickandmorty = RetrofitClient.getInstance().getMyApi().getPersonas();
        callrickandmorty.enqueue(new Callback<Personajes>() {
            @Override
            public void onResponse(Call<Personajes> call, Response <Personajes> response) {

                mypersonaje= response.body();
                AdapterPersonajes Adapter = new AdapterPersonajes(personajeslistview.this,mypersonaje.getListapersonajes());
                listpersonaje.setAdapter(Adapter);
            }

            @Override
            public void onFailure(Call <Personajes> call, Throwable t) {

                Toast.makeText(personajeslistview.this, "Error no funciona", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent myint= new Intent(this,personajedetalle.class);
        myint.putExtra("id",mypersonaje.getListapersonajes().get(position).getId());
        startActivity(myint);
    }
}