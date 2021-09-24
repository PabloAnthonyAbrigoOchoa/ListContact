package com.example.listcontact.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity (tableName = "Contacto")

public class Contact {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "Nombre")
    private String nombre;

    @ColumnInfo(name = "Apellido")
    private  String apellido;

    @ColumnInfo(name = "Ciudad")
    private String ciudad;

    @ColumnInfo(name = "Telefono")
    private String telefono;

    @ColumnInfo(name = "Correo")
    private String correo;

    @ColumnInfo(name = "Url")
    private String url;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public void guardarContactosList () {
        List<Contact> contactArrayList = new ArrayList<>();
        Contact c = new Contact();
        c.setNombre("Pablo");
        c.setApellido("Abrigo");
        c.setCiudad("Loja");
        c.setTelefono("0994941403");
        c.setCorreo("pabloochoa518@gmail.com");
        c.setUrl("");
        contactArrayList.add(c);
    }
}
