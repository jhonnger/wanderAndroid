package com.example.jhongger.wander;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.jhongger.wander.adapter.TelefonoAdapter;
import com.example.jhongger.wander.modelo.Telefono;

import java.util.ArrayList;

/**
 * Created by jhongger on 10/12/2017.
 */

public class TelefonoActivity extends AppCompatActivity {
    private ListView listaTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        TelefonoAdapter adapter = new TelefonoAdapter(this, listar());
        listaTelefono = (ListView) findViewById(R.id.listaAlarma);
        listaTelefono.setAdapter(adapter);
    }

    private ArrayList<Telefono> listar(){
        Telefono telefonos[] = {
                new Telefono("Policia", "Emergencias", "105"),
                new Telefono("Serenazgo", "Muni Castilla", "#961092025"),
                new Telefono("Ambulacia", "Hospital Regional", "306265"),
                new Telefono("Bomberos", "B Santa Rosa", "306255")
        };

        ArrayList<Telefono> lista = new ArrayList<>();
        for (Telefono telefono: telefonos) {
            lista.add(telefono);
        }

        return lista;
    }
}
