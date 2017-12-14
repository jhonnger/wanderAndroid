package com.example.jhongger.wander;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by jhongger on 13/12/2017.
 */

public class MapaFragment  extends android.support.v4.app.Fragment {

    private GoogleMap mMap;
    Context mContext;

    MapaReports mapaReports;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportMapFragment mapFragment =(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapa_fragment);

        System.out.println(mapFragment);
        mapaReports = new MapaReports(getActivity());
        mapFragment.getMapAsync(mapaReports);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Directorio");
    }
}
