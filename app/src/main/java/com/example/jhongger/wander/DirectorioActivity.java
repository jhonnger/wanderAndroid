package com.example.jhongger.wander;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class DirectorioActivity extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_lista_planetas, container, false);

        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ListaGeneral listaGeneral = new ListaGeneral();
        fragmentTransaction.add(R.id.lista_de_planetas, listaGeneral);
        fragmentTransaction.commit();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Directorio");
    }

}
