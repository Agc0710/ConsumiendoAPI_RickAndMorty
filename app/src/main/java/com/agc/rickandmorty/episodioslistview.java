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
import com.agc.rickandmorty.Models.Episodio;
import com.agc.rickandmorty.Models.Episodios;
import com.agc.rickandmorty.Models.Personaje;
import com.agc.rickandmorty.Models.Personajes;
import com.agc.rickandmorty.Models.Ubicacion;
import com.agc.rickandmorty.Models.Ubicaciones;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class episodioslistview extends AppCompatActivity  implements AdapterView.OnItemClickListener {


    ListView listepisodios;
    Episodios myepisodio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodioslistview);
        listepisodios= findViewById(R.id.ListaEpisodios);
        getFromInternetEpisodio();
        listepisodios.setOnItemClickListener(this);
    }

    private void getFromInternetEpisodio() {
        Call<Episodios> callrickandmorty = RetrofitClient.getInstance().getMyApi().getEpisodios();
        callrickandmorty.enqueue(new Callback<Episodios>() {
            @Override
            public void onResponse(Call<Episodios> call, Response<Episodios> response) {

                myepisodio= response.body();
                AdapterEpisodios Adapter = new AdapterEpisodios(episodioslistview.this, (ArrayList<Episodio>)myepisodio.getListaEpisodios());
                listepisodios.setAdapter(Adapter);
            }

            @Override
            public void onFailure(Call <Episodios> call, Throwable t) {

                Toast.makeText(episodioslistview.this, "Error no funciona", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent myint= new Intent(this,episodiosdetalles.class);
            myint.putExtra("id",myepisodio.getListaEpisodios().get(position).getId());
            startActivity(myint);
        }
}
