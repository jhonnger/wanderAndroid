package com.example.jhongger.wander;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.jhongger.wander.adapter.DirectorioAdapter;
import com.example.jhongger.wander.modelo.Institucion;
import com.example.jhongger.wander.modelo.Telefono;

import java.util.ArrayList;



public class DirectorioActivity extends AppCompatActivity {
    private ListView listaTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);





        DirectorioAdapter adapter = new DirectorioAdapter(this, listar());
        listaTelefono = (ListView) findViewById(R.id.listaAlarma);
        listaTelefono.setAdapter(adapter);
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
