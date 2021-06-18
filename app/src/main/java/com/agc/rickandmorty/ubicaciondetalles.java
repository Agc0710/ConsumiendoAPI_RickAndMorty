package com.agc.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.agc.rickandmorty.Apimanager.RetrofitClient;
import com.agc.rickandmorty.Models.Personaje;
import com.agc.rickandmorty.Models.Ubicacion;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ubicaciondetalles extends AppCompatActivity {

    private String id;
    TextView nameubicacion;
    TextView typeubicacion;
    TextView dimensionubicacion;
    TextView createdubicacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciondetalles);

        Bundle bundle= getIntent().getExtras();
        id= bundle.getString("id");

        nameubicacion = findViewById(R.id.namedetallesubicacion);
        typeubicacion = findViewById(R.id.typedetallesubicacion);
        dimensionubicacion = findViewById(R.id.dimensiondetallesubicacion);
        createdubicacion = findViewById(R.id.createddetallesubicacion);

        getUbicacionbyId(id);
        
    }

    private void getUbicacionbyId(String id) {
        Call<Ubicacion> call= RetrofitClient.getInstance().getMyApi().getUbicaciones1(id);
        call.enqueue(new Callback<Ubicacion>() {
            @Override
            public void onResponse(Call<Ubicacion> call, Response<Ubicacion> response) {
                Ubicacion ubicacion1= response.body();


                nameubicacion.setText(ubicacion1.getNombre());
                typeubicacion.setText(ubicacion1.getTipodeplaneta());
                dimensionubicacion.setText(ubicacion1.getDimension());
                createdubicacion.setText(ubicacion1.getCreacion());

            }

            @Override
            public void onFailure(Call<Ubicacion> call, Throwable t) {
                Toast.makeText(ubicaciondetalles.this, "Error no funciona", Toast.LENGTH_SHORT).show();

            }
        });

    }
}