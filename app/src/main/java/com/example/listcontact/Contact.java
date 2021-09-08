package com.example.listcontact;

import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String nombre, ciudad, telefono, correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    @Override
    public String toString() {
        return "Contact{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }

    public void guardarContactosList () {
        List<Contact> contactArrayList = new ArrayList<>();
        Contact c = new Contact();
        c.setNombre("Pablo");
        c.setCiudad("Loja");
        c.setTelefono("0994941403");
        c.setCorreo("pabloochoa518@gmail.com");
        contactArrayList.add(c);
    }
}
