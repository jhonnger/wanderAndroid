package com.example.jhongger.wander.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jhongger.wander.CategoriaTelefonoActivity;
import com.example.jhongger.wander.R;
import com.example.jhongger.wander.modelo.Telefono;

import java.util.List;



public class InstitucionAdapter extends ArrayAdapter<Telefono> {
    public InstitucionAdapter(Context context, List<Telefono> objects) {
        super(context, R.layout.institucion_template, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = convertView;
        if (convertView == null){
            view = inflater.inflate(R.layout.institucion_template,null);
        }

        //Definicion de objetos de la interfaz grafica
        TextView nombre = (TextView) view.findViewById(R.id.nombreTelefono);
         //TextView telefono = (TextView) view.findViewById(R.id.numeroTelefono);

        nombre.setText(getItem(position).getNombre());
        //telefono.setText(getItem(position).getNumero());

        final Context context = getContext();

        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "306265"));
                context.startActivity(intent);
            }
        });
        return view;
    }
}
