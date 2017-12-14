package com.example.jhongger.wander.adapter;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jhongger.wander.CategoriaTelefonoActivity;
import com.example.jhongger.wander.ListaInstitucion;
import com.example.jhongger.wander.R;
import com.example.jhongger.wander.modelo.Institucion;
import com.example.jhongger.wander.modelo.Telefono;

import java.util.List;

/**
 * Created by jhongger on 10/12/2017.
 */

public class DirectorioAdapter extends ArrayAdapter<Institucion> {

    public DirectorioAdapter(Context context, List<Institucion> objects) {
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
        TextView entidad = (TextView) view.findViewById(R.id.entidad);
         TextView nombre = (TextView) view.findViewById(R.id.nombre);
         TextView telefono = (TextView) view.findViewById(R.id.numero);

        entidad.setText(getItem(position).getNombre());

        nombre.setText(getItem(position).getTelefonos()[0].getNombre());
        telefono.setText(getItem(position).getTelefonos()[0].getNumero());
        final Context context = getContext();

       /* entidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListaInstitucion listaInstitucion = new ListaInstitucion();

                FragmentTransaction fragmentTransaction = context.getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.lista_de_planetas, listaInstitucion);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });*/
        return view;
    }
}
