package com.example.jhongger.wander;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jhongger.wander.adapter.FirebaseReferences;
import com.example.jhongger.wander.adapter.Mensaje;
import com.google.firebase.database.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference myref = db.getReference(FirebaseReferences.notification_ref);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SimpleDateFormat formateadorF = new SimpleDateFormat("dd/MM/yy");
                SimpleDateFormat formateadorH = new SimpleDateFormat("HH:mm:ss");
                String fecha = formateadorF.format(new Date());
                String hora = formateadorH.format(new Date());

                Mensaje msg = new Mensaje("jhonny1",hora,"1",fecha);
                myref.push().setValue(msg);
                Toast.makeText(MainActivity.this,msg.getMessager(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void navegarAlarma(View view){
        Intent intent = new Intent(this, DirectorioActivity.class);
        startActivity(intent);
    }

}
