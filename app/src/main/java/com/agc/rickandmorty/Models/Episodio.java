package com.agc.rickandmorty.Models;

import com.google.gson.annotations.SerializedName;

public class Episodio {
    @SerializedName("id")
    private String Id;

    @SerializedName("name")
    private String nombre;

    @SerializedName("air_date")
    private String airdate;

    @SerializedName("episode")
    private String numeroepisodio;

    @SerializedName("created")
    private String creado;

    public Episodio(String id, String nombre, String airdate, String numeroepisodio, String creado) {
        Id = id;
        this.nombre = nombre;
        this.airdate = airdate;
        this.numeroepisodio = numeroepisodio;
        this.creado = creado;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAirdate() {
        return airdate;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechalanzamiento() {
        return airdate;
    }

    public void setFechalanzamiento(String airdate) {
        this.airdate = airdate;
    }

    public String getNumeroepisodio() {
        return numeroepisodio;
    }

    public void setNumeroepisodio(String numeroepisodio) {
        this.numeroepisodio = numeroepisodio;
    }
}
