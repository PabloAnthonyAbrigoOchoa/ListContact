package com.example.listcontact.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)


public abstract class ContactDataBase extends RoomDatabase {

    public abstract ContactDAO getContactDao();

}
