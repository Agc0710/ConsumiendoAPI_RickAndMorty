package com.agc.rickandmorty.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Ubicaciones {
    @SerializedName("results")
    private List<Ubicacion> Listaubicaciones;

    public List<Ubicacion> getListaubicaciones() {
        return Listaubicaciones;
    }

    public void setListaubicaciones(List<Ubicacion> listaubicaciones) {
        Listaubicaciones = listaubicaciones;
    }
}
