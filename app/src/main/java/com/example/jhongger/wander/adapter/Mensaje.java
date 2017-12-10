package com.example.jhongger.wander.adapter;

/**
 * Created by marth on 10/12/2017.
 */

import java.util.Date;

/**
 * Created by marth on 10/12/2017.
 */

public class Mensaje {
    private String name;
    private String messager;
    private String estado;
    private String fecha;

    public Mensaje(String name, String messager, String estado, String fecha) {
        this.name = name;
        this.messager = messager;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessager() {
        return messager;
    }

    public void setMessager(String messager) {
        this.messager = messager;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}