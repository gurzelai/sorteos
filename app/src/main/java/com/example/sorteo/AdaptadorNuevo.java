package com.example.sorteo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorNuevo extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Participante> names;
    public AdaptadorNuevo(Context context, int layout, ArrayList<Participante> names){
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // Copiamos la vista
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v= layoutInflater.inflate(R.layout.list_adaptadornuevo, null);
        // Valor actual según la posición

        Participante p  = names.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView nombre = (TextView) v.findViewById(R.id.nombreAdaptador);
        nombre.setText(p.getNombre());
        //Devolvemos la vista inflada
        return v;
    }
}
