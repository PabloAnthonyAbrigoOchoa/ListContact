package com.example.listcontact.database;

import androidx.room.RoomDatabase;

public abstract class ContactDataBase extends RoomDatabase {

    public abstract ContactDAO getContactDao();

}
