package com.example.jhongger.wander;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.jhongger.wander.adapter.DirectorioAdapter;
import com.example.jhongger.wander.adapter.InstitucionAdapter;
import com.example.jhongger.wander.modelo.Institucion;
import com.example.jhongger.wander.modelo.Telefono;

import java.util.ArrayList;


public class CategoriaTelefonoActivity extends AppCompatActivity {

    private ListView listaTelefono;
    private String nombre = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono_list_view);
        Intent intent = this.getIntent();
        this.nombre = intent.getStringExtra("nombre");

        InstitucionAdapter adapter = new InstitucionAdapter(this, listar());
        listaTelefono = (ListView) findViewById(R.id.listaInstitucion);
        listaTelefono.setAdapter(adapter);
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
