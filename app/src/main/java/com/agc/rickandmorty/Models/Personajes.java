package com.agc.rickandmorty.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Personajes {
    @SerializedName("results")
    List<Personaje> Listapersonajes;

    public List<Personaje> getListapersonajes() {
        return Listapersonajes;
    }

    public void setListapersonajes(List<Personaje> listapersonajes) {
        Listapersonajes = listapersonajes;
    }
}
