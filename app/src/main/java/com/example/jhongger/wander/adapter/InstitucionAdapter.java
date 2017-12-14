package com.example.jhongger.wander.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.jhongger.wander.R;
import com.example.jhongger.wander.modelo.Telefono;
import com.example.jhongger.wander.service.LocationService;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class InstitucionAdapter extends ArrayAdapter<Telefono> implements LocationListener {

    LocationService locationService;
    Location location;
    Persona persona;
    Mensaje mensaje;
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
        locationService = new LocationService(context);
        persona = new Persona();
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference myref = db.getReference(FirebaseReferences.notification_ref);



        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                location = locationService.getLocation();
                String lat,lon;
                lat = String.valueOf(location.getLatitude());
                lon = String.valueOf(location.getLongitude());
                Date fechaMax = new Date("31/12/2200");
                Date date = new Date();
                SimpleDateFormat formateadorF = new SimpleDateFormat("dd/MM/yy");
                SimpleDateFormat formateadorH = new SimpleDateFormat("HH:mm:ss");

                String fecha = formateadorF.format(date);
                String hora = formateadorH.format(date);
                int aux = (int) (fechaMax.getTime()-date.getTime());
                String time =String.valueOf(aux);
                mensaje = new Mensaje(persona,"robo",hora,fecha,time,lat,lon);
                myref.push().setValue(mensaje);


                String posted_by = "306265";
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + posted_by.trim()));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) return;
                context.startActivity(intent);
            }
        });
        return view;
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
