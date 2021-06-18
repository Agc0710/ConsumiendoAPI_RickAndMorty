package com.agc.rickandmorty;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.agc.rickandmorty.Models.Personaje;
import com.agc.rickandmorty.Models.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class AdapterUbicaciones extends BaseAdapter {
    protected Activity activity;
    protected List<Ubicacion> Ubicacion1;

    public AdapterUbicaciones(Activity activity, ArrayList<Ubicacion> ubicacion1) {
        this.activity = activity;
        Ubicacion1 = ubicacion1;
    }

    @Override
    public int getCount() {
        return Ubicacion1.size();
    }

    @Override
    public Object getItem(int position) {
        return Ubicacion1.get(position);
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
            vista = inf.inflate(R.layout.itemubicaciones,null);
        }

        Ubicacion ubicacion  = Ubicacion1.get(position);

        TextView IdUbicacion = vista.findViewById(R.id.IdUbicacion);
        IdUbicacion.setText( String.valueOf(ubicacion.getId()));

        TextView nameUbicacion = vista.findViewById(R.id.NameUbicacion);
        nameUbicacion.setText(ubicacion.getNombre());

        return vista;
    }
}
