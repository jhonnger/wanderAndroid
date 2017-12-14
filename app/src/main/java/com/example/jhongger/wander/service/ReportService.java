package com.example.jhongger.wander.service;


import com.example.jhongger.wander.BasicNameValue;
import com.example.jhongger.wander.entities.Report;
import com.example.jhongger.wander.entities.Type;
import com.example.jhongger.wander.util.Constants;
import com.google.android.gms.maps.model.LatLngBounds;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportService {

    public List<Report> traerDenuncias(LatLngBounds curScreen){
        List<Report> reports ;
        reports=null;
        String response;
        System.out.println("Trayendo denuncias...");

        try{
            List<BasicNameValue> params = new ArrayList<>();
            ConexionHttpService conexionHttpService = new ConexionHttpService(Constants.API_URL.REPORT_GET_BY_FILTERS,"POST",params);

            params.add(new BasicNameValue("turnos", "todos"));
            params.add(new BasicNameValue("fechas", "todos"));
            params.add(new BasicNameValue("bounds[north]", curScreen.northeast.latitude + ""));
            params.add(new BasicNameValue("bounds[east]", curScreen.northeast.longitude + ""));
            params.add(new BasicNameValue("bounds[south]", curScreen.southwest.latitude + ""));
            params.add(new BasicNameValue("bounds[west]", curScreen.southwest.longitude + ""));
            response=conexionHttpService.conectar();
            JSONObject json_object = new JSONObject(response);
            System.out.println(response);
            JSONArray reportsJson = json_object.getJSONArray("reports");
            int i;
            reports = new ArrayList<>();
            for ( i = 0; i < reportsJson.length(); i++) {
                JSONObject item = reportsJson.getJSONObject(i);
                Report report = new Report();
                report.setId(item.getLong("id"));
                report.setDescription(item.getString("descripcion"));
                report.setAddress(item.getString("direccion"));
                report.setLatitude(item.getDouble("latitud"));
                report.setLongitude(item.getDouble("longitud"));
                report.setType( new Type(item.getJSONObject("tipo_denuncia").getString("nombre")));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try
                {
                    report.setEventDate(simpleDateFormat.parse(item.getString("fecha_denuncia")));
                }
                catch (ParseException ex)
                {
                    System.out.println("Exception "+ex);
                }
                //report.setEventDate(new Date(item.getString("eventDate")));

                reports.add(report);

               // System.out.println(item);
            }
            System.out.println("cantidad: "+i);
        }catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
        return reports;
    }
}
