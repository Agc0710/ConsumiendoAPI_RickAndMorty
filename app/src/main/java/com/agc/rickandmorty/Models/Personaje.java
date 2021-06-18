package com.agc.rickandmorty.Models;

import com.google.gson.annotations.SerializedName;

public class Personaje {
    @SerializedName("id")
    private String Id;

    @SerializedName("name")
    private String nombre;

    @SerializedName("status")
    private String estadoPersonaje;

    @SerializedName("species")
    private String especiesPersonaje;

    @SerializedName("gender")
    private String GeneroPersonaje;

    @SerializedName("image")
    private String imagen;

    @SerializedName("created")
    private String crear;

    public Personaje(String id, String nombre, String estadoPersonaje, String especiesPersonaje, String generoPersonaje, String imagen, String crear) {
        Id = id;
        this.nombre = nombre;
        this.estadoPersonaje = estadoPersonaje;
        this.especiesPersonaje = especiesPersonaje;
        GeneroPersonaje = generoPersonaje;
        this.imagen = imagen;
        this.crear = crear;
    }

    public String getCrear() {
        return crear;
    }

    public void setCrear(String crear) {
        this.crear = crear;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    public String getEstadoPersonaje() {
        return estadoPersonaje;
    }

    public void setEstadoPersonaje(String estadoPersonaje) {
        this.estadoPersonaje = estadoPersonaje;
    }

    public String getEspeciesPersonaje() {
        return especiesPersonaje;
    }

    public void setEspeciesPersonaje(String especiesPersonaje) {
        this.especiesPersonaje = especiesPersonaje;
    }

    public String getGeneroPersonaje() {
        return GeneroPersonaje;
    }

    public void setGeneroPersonaje(String generoPersonaje) {
        GeneroPersonaje = generoPersonaje;
    }
}
