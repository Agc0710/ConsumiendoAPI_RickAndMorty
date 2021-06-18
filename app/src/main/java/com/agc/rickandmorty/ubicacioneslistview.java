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
import com.agc.rickandmorty.Models.Ubicacion;
import com.agc.rickandmorty.Models.Ubicaciones;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ubicacioneslistview extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listubicacion;
    Ubicaciones myubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacioneslistview);
        listubicacion = findViewById(R.id.ListaUbicaciones);
        getFromInternetUbicacion();
        listubicacion.setOnItemClickListener(this);
    }

    private void getFromInternetUbicacion() {
        Call<Ubicaciones> callrickandmorty = RetrofitClient.getInstance().getMyApi().getUbicaciones();
        callrickandmorty.enqueue(new Callback<Ubicaciones>() {
            @Override
            public void onResponse(Call<Ubicaciones> call, Response<Ubicaciones> response) {

                myubicacion= response.body();
                AdapterUbicaciones Adapter = new AdapterUbicaciones(ubicacioneslistview.this, (ArrayList<Ubicacion>) myubicacion.getListaubicaciones());
                listubicacion.setAdapter(Adapter);
            }

            @Override
            public void onFailure(Call <Ubicaciones> call, Throwable t) {

                Toast.makeText(ubicacioneslistview.this, "Error no funciona", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent myint= new Intent(this,ubicaciondetalles.class);
        myint.putExtra("id",myubicacion.getListaubicaciones().get(position).getId());
        startActivity(myint);
    }
}