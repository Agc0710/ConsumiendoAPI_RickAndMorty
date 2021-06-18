package com.agc.rickandmorty;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.agc.rickandmorty.Models.Personaje;
import com.agc.rickandmorty.Models.Personajes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class AdapterPersonajes extends BaseAdapter {
    protected Activity activity;
    protected List<Personaje> Personajes1;

    public AdapterPersonajes(Activity activity, List<Personaje> personajes1) {
        this.activity = activity;
        Personajes1 = personajes1;
    }

    @Override
    public int getCount() {
        return Personajes1.size();
    }

    @Override
    public Object getItem(int position) { return Personajes1.get(position);
    }

    @Override
    public long getItemId(int position) { return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vista = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inf.inflate(R.layout.itempersonajes,null);
        }

        Personaje personaje = Personajes1.get(position);
        TextView Idpersonaje = vista.findViewById(R.id.Idpersonaje);
        Idpersonaje.setText( String.valueOf(personaje.getId()));

        TextView namepersonaje = vista.findViewById(R.id.NamePersonaje);
        namepersonaje.setText(personaje.getNombre());

        ImageView imagen = vista.findViewById(R.id.imgPersonaje);


        Glide.with(activity)
                .load(personaje.getImagen())
                .centerCrop()
                //.crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imagen);

        return vista;

    }
}
