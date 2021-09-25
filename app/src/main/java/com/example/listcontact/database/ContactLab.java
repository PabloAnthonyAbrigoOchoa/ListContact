package com.example.listcontact.database;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.room.Room;
import java.util.List;


public class ContactLab {

    @SuppressLint("StaticFieldLeak")
    private static ContactLab sContactoLab;

    private ContactDAO mContactoDao;

    public ContactLab(Context context){

        Context appContext = context.getApplicationContext();
        ContactDataBase database = Room.databaseBuilder(appContext, ContactDataBase.class, "contactosBD")
                .allowMainThreadQueries().build();

        mContactoDao = database.getContactDao();

    }

    public static ContactLab get(Context context){

        if (sContactoLab==null){
            sContactoLab=new ContactLab(context);
        }
        return sContactoLab;
    }

    //Leer
    public List<Contact> getContactos(){

        return mContactoDao.getContactos();
    }

    //String
    public Contact getContacto(String n){

        return mContactoDao.getContacto(n);
    }

    //Agregar
    public void addContacto(Contact c){
        mContactoDao.addContacto(c);
    }
    public void updateContacto(Contact c){
        mContactoDao.updateContacto(c);
    }
    public void deleteContacto(Contact c){
        mContactoDao.deleteContacto(c);
    }
    public void deleteAllPersona(){
        mContactoDao.deleteAllContacto();
    }

}
