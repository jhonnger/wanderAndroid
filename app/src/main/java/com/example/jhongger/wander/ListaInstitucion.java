package com.example.jhongger.wander;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListAdapter;

import com.example.jhongger.wander.adapter.DirectorioAdapter;
import com.example.jhongger.wander.adapter.InstitucionAdapter;
import com.example.jhongger.wander.modelo.Institucion;
import com.example.jhongger.wander.modelo.Telefono;

import java.util.ArrayList;

/**
 * Created by jhongger on 13/12/2017.
 */

public class ListaInstitucion extends android.support.v4.app.ListFragment {

    private String nombre = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle parametros = getArguments();

        nombre = parametros.getString("nombre");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ListAdapter listAdapter = new InstitucionAdapter(getActivity(), listar());;
        getActivity().setTitle(nombre);
        setListAdapter(listAdapter);
    }

    private ArrayList<Telefono> listar(){
        Telefono telefonosPolicias[] = {
                new Telefono( "Emergencias", "105"),
                new Telefono( "Comisaría Tacala", "#961092025"),
                new Telefono( "Comisaría Castilla", "306265"),
                new Telefono( "Investigación Criminal", "306255")
        };
        Telefono telefonosSerenazgo[] = {
                new Telefono( "Muni Castilla", "#961092025"),
                new Telefono( "Emergencias", "105"),
                new Telefono( "Hospital Regional", "306265"),
                new Telefono( "B Santa Rosa", "306255")
        };
        Telefono telefonosAmbulancias[] = {
                new Telefono( "Hospital Regional", "306265"),
                new Telefono( "Emergencias", "105"),
                new Telefono( "Muni Castilla", "#961092025"),
                new Telefono( "B Santa Rosa", "306255")
        };
        Telefono telefonosBomberos[] = {
                new Telefono( "B Santa Rosa", "306255"),
                new Telefono( "Emergencias", "105"),
                new Telefono( "Muni Castilla", "#961092025"),
                new Telefono( "Hospital Regional", "306265"),
        };

        Institucion instituciones[] = {
                new Institucion("Policia",telefonosPolicias),
                new Institucion("Serenazgo",telefonosSerenazgo),
                new Institucion("Ambulacia",telefonosAmbulancias),
                new Institucion("Bomberos",telefonosBomberos),
        };


        Telefono telefono[] = {};

        switch (this.nombre){
            case "Policia" : telefono = telefonosPolicias;break;
            case "Serenazgo" : telefono = telefonosPolicias;break;
            case "Ambulacia" : telefono = telefonosPolicias;break;
            case "Bomberos" : telefono = telefonosPolicias;break;
        }
        ArrayList<Telefono> lista = new ArrayList<>();
        for (Telefono telefono1: telefono) {
            lista.add(telefono1);
        }
        return lista;
    }
}
