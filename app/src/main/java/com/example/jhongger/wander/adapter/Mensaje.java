package com.example.jhongger.wander.adapter;

/**
 * Created by marth on 10/12/2017.
 */

import java.util.Date;

/**
 * Created by marth on 10/12/2017.
 */

public class Mensaje {
    private Persona persona;
    private String messager;
    private String hora;
    private String fecha;
    private String time;
    private String lat;
    private String lon;

    public Mensaje() {
    }

    public Mensaje(Persona persona,String messager, String hora, String fecha, String time, String lat, String lon) {
        this.persona = persona;
        this.messager = messager;
        this.hora = hora;
        this.fecha = fecha;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getMessager() {
        return messager;
    }

    public void setMessager(String messager) {
        this.messager = messager;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

}