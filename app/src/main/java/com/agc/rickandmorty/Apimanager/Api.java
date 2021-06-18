package com.agc.rickandmorty.Apimanager;

import java.util.List;

import com.agc.rickandmorty.Models.Episodio;
import com.agc.rickandmorty.Models.Episodios;
import com.agc.rickandmorty.Models.Personaje;
import com.agc.rickandmorty.Models.Personajes;
import com.agc.rickandmorty.Models.Ubicacion;
import com.agc.rickandmorty.Models.Ubicaciones;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    String BASE_URL ="https://rickandmortyapi.com/api/";

    @GET("character")
    Call<Personajes> getPersonas();

    @GET("location")
    Call<Ubicaciones> getUbicaciones();

    @GET("episode")
    Call<Episodios> getEpisodios();

    @GET("character/{id}")
    Call<Personaje> getPersonajes1(@Path("id") String id);

    @GET("location/{id}")
    Call<Ubicacion> getUbicaciones1(@Path("id") String id);

    @GET("location/{id}")
    Call<Episodio> getEpisodios1(@Path("id") String id);



}
