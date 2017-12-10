package com.example.jhongger.wander.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jhongger.wander.R;
import com.example.jhongger.wander.modelo.Telefono;

import java.util.List;

/**
 * Created by jhongger on 10/12/2017.
 */

public class TelefonoAdapter  extends ArrayAdapter<Telefono> {
    public TelefonoAdapter(Context context, List<Telefono> objects) {
        super(context, R.layout.alarma_template, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = convertView;
        if (convertView == null){
            view = inflater.inflate(R.layout.alarma_template,null);
        }

        //Definicion de objetos de la interfaz grafica
        TextView hora = (TextView) view.findViewById(R.id.entidad);
         TextView activo = (TextView) view.findViewById(R.id.nombre);
         TextView telefono = (TextView) view.findViewById(R.id.numero);

        hora.setText(getItem(position).getInstitucion());

        activo.setText(getItem(position).getNombre());
        telefono.setText(getItem(position).getNumero());


        return view;
    }
}
