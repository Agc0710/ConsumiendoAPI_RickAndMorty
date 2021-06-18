package com.agc.rickandmorty.Models;

import com.google.gson.annotations.SerializedName;

public class Ubicacion {
    @SerializedName("id")
    private String Id;

    @SerializedName("name")
    private String nombre;

    @SerializedName("type")
    private String tipodeplaneta;

    @SerializedName("dimension")
    private String dimension;

    @SerializedName("created")
    private String creacion;

    public Ubicacion(String id, String nombre, String tipodeplaneta, String dimension, String creacion) {
        Id = id;
        this.nombre = nombre;
        this.tipodeplaneta = tipodeplaneta;
        this.dimension = dimension;
        this.creacion = creacion;
    }

    public String getCreacion() {
        return creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipodeplaneta() {
        return tipodeplaneta;
    }

    public void setTipodeplaneta(String tipodeplaneta) {
        this.tipodeplaneta = tipodeplaneta;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
