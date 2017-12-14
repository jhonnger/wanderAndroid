package com.example.jhongger.wander;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jhongger.wander.adapter.DirectorioAdapter;
import com.example.jhongger.wander.modelo.Institucion;
import com.example.jhongger.wander.modelo.Telefono;

import java.util.ArrayList;

/**
 * Created by jhongger on 13/12/2017.
 */

public class ListaGeneral  extends android.support.v4.app.ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ListAdapter listAdapter = new DirectorioAdapter(getActivity(), listar());;
        setListAdapter(listAdapter);
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {


        System.out.println("click");
        System.out.println("johnny");
        ListaInstitucion listaInstitucion = new ListaInstitucion();

        Bundle parametros = new Bundle();
        parametros.putString("nombre",listar().get(position).getNombre());

        listaInstitucion.setArguments(parametros);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.lista_de_planetas, listaInstitucion);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Toast.makeText(getActivity(), "click",
                Toast.LENGTH_LONG).show();


    }



    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Directorio");
    }

    private ArrayList<Institucion> listar(){
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
                new Telefono( "Emergencias", "105"),
                new Telefono( "Muni Castilla", "#961092025"),
                new Telefono( "Hospital Regional", "306265"),
                new Telefono( "B Santa Rosa", "306255")
        };

        Institucion instituciones[] = {
                new Institucion("Policia",telefonosPolicias),
                new Institucion("Serenazgo",telefonosSerenazgo),
                new Institucion("Ambulacia",telefonosAmbulancias),
                new Institucion("Bomberos",telefonosBomberos),
        };

        ArrayList<Institucion> lista = new ArrayList<>();
        for (Institucion institucion: instituciones) {
            lista.add(institucion);
        }

        return lista;
    }
}
