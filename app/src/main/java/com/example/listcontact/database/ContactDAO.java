package com.example.listcontact.database;

/*
* LA SIGUIENTE INTERFACE ES DONDE SE IMPLEMENTA LA SENTENCIA DE ROOM
* PARA MANIPULAR LA BASE DE DATOS COMO LAS CONSULTAS
* INSERTAR, ELIMINAR, BORRAR */


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {

    @Query("SELECT * FROM Contacto")
    List<Contact> getContactos();

    @Query("SELECT * FROM CONTACTO WHERE ID LIKE :uuid")
    Contact getContacto(String uuid);

    @Insert
    void addContacto(Contact c);

    @Delete
    void deleteContacto(Contact c);

    @Update
    void updateContacto(Contact c);

    @Query("DELETE FROM Contacto")
    void deleteAllContacto(Contact c);


}
