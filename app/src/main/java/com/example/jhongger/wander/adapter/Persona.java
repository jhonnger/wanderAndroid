package com.example.jhongger.wander.adapter;

/**
 * Created by marth on 12/12/2017.
 */

class Persona {
    private String name;
    private String lastname;
    private String edad;
    private String telefono;
    private String correo;

    public Persona() {
        this.name = "Jhon Marthin";
        this.lastname = "Lachira Iman";
        this.edad = "21";
        this.telefono = "989961046";
        this.correo = "marthin.lachira@wander.pe";
    }

    public Persona(String name, String lastname, String edad, String telefono, String correo) {
        this.name = name;
        this.lastname = lastname;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
