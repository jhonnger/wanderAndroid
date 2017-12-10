package com.example.jhongger.wander.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jhongger.wander.CategoriaTelefonoActivity;
import com.example.jhongger.wander.DirectorioActivity;
import com.example.jhongger.wander.MainActivity;
import com.example.jhongger.wander.R;
import com.example.jhongger.wander.modelo.Telefono;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class InstitucionAdapter extends ArrayAdapter<Telefono> {
    public InstitucionAdapter(Context context, List<Telefono> objects) {
        super(context, R.layout.institucion_template, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = convertView;
        if (convertView == null) {
            view = inflater.inflate(R.layout.institucion_template, null);
        }

        //Definicion de objetos de la interfaz grafica
        TextView nombre = (TextView) view.findViewById(R.id.nombreTelefono);
        //TextView telefono = (TextView) view.findViewById(R.id.numeroTelefono);

        nombre.setText(getItem(position).getNombre());
        //telefono.setText(getItem(position).getNumero());

        final Context context = getContext();

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference myref = db.getReference(FirebaseReferences.notification_ref);


        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Date fechaMax = new Date("31/12/2200");
                Date date = new Date();
                SimpleDateFormat formateadorF = new SimpleDateFormat("dd/MM/yy");
                SimpleDateFormat formateadorH = new SimpleDateFormat("HH:mm:ss");

                String fecha = formateadorF.format(date);
                String hora = formateadorH.format(date);
                int aux = (int) (fechaMax.getTime()-date.getTime());
                String time =String.valueOf(aux);

                Mensaje msg = new Mensaje("jhonny1",hora,"1",fecha,time);
                myref.push().setValue(msg);
                Toast.makeText(context,msg.getMessager(), Toast.LENGTH_SHORT).show();

                String posted_by = "306265";
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + posted_by.trim()));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) return;
                context.startActivity(intent);
            }
        });
        return view;
    }
}
