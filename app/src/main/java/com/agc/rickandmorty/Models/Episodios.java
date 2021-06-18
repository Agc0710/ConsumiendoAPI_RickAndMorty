package com.agc.rickandmorty.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Episodios {
    @SerializedName("results")
    private List<Episodio> listaEpisodios;

    public List<Episodio> getListaEpisodios() {
        return listaEpisodios;
    }

    public void setListaEpisodios(List<Episodio> listaEpisodios) {
        this.listaEpisodios = listaEpisodios;
    }
}
