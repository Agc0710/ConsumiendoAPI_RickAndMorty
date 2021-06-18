package com.agc.rickandmorty;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.agc.rickandmorty.Models.Episodio;
import com.agc.rickandmorty.Models.Personaje;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class AdapterEpisodios extends BaseAdapter {
    protected Activity activity;
    protected List<Episodio> Episodios1;

    public AdapterEpisodios(Activity activity, ArrayList<Episodio> episodios1) {
        this.activity = activity;
        Episodios1 = episodios1;
    }


    @Override
    public int getCount() {
        return Episodios1.size();
    }

    @Override
    public Object getItem(int position) {
        return Episodios1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vista = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inf.inflate(R.layout.itemepisodios,null);
        }

        Episodio episodio = Episodios1.get(position);
        TextView Idepisodio = vista.findViewById(R.id.IdEpisodio);
        Idepisodio.setText( String.valueOf(episodio.getId()));

        TextView nameepisodio = vista.findViewById(R.id.NameEpisodio);
        nameepisodio.setText(episodio.getNombre());

        TextView Airdate = vista.findViewById(R.id.AirdateEpisodio);
        Airdate.setText(episodio.getFechalanzamiento());

        TextView numepisodio = vista.findViewById(R.id.NumberEpisodio);
        numepisodio.setText(episodio.getNumeroepisodio());

        return vista;

    }
}
