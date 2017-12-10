package com.example.jhongger.wander.modelo;

/**
 * Created by jhongger on 10/12/2017.
 */

public class Institucion {
    private String nombre;
    private Telefono telefonos[];

    public Institucion(String nombre, Telefono[] telefonos) {
        this.nombre = nombre;
        this.telefonos = telefonos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Telefono[] getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Telefono[] telefonos) {
        this.telefonos = telefonos;
    }
}
