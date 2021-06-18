package com.agc.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.agc.rickandmorty.Apimanager.RetrofitClient;
import com.agc.rickandmorty.Models.Episodio;
import com.agc.rickandmorty.Models.Personaje;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class episodiosdetalles extends AppCompatActivity {

    private String id;
    TextView nameepisodio;
    TextView createdepisode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodiosdetalles);

        Bundle bundle= getIntent().getExtras();
        id= bundle.getString("id");

        nameepisodio = findViewById(R.id.nameepisodiodetallado);
        createdepisode = findViewById(R.id.createdepisodiodetallado);

        getEpisodiobyId(id);

    }

    private void getEpisodiobyId(String id) {
        Call<Episodio> call= RetrofitClient.getInstance().getMyApi().getEpisodios1(id);
        call.enqueue(new Callback<Episodio>() {
            @Override
            public void onResponse(Call<Episodio> call, Response<Episodio> response) {
                Episodio episodio1= response.body();

                nameepisodio.setText(episodio1.getNombre());
                createdepisode.setText(episodio1.getCreado());

            }

            @Override
            public void onFailure(Call<Episodio> call, Throwable t) {
                Toast.makeText(episodiosdetalles.this, "Error no funciona", Toast.LENGTH_SHORT).show();

            }
        });

    }
}