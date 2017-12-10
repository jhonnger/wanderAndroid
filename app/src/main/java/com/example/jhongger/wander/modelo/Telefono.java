package com.example.jhongger.wander.modelo;

/**
 * Created by jhongger on 10/12/2017.
 */

public class Telefono {
    private String institucion;
    private String nombre;
    private String numero;

    public Telefono(String institucion, String nombre, String numero) {
        this.institucion = institucion;
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
