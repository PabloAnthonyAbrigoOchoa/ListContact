package com.example.listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.listcontact.database.Contact;
import com.example.listcontact.database.ContactLab;

public class SaveActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtCiudad;
    private EditText txtTelefono;
    private EditText txtCorreo;
    private Button btnGuardarContacto;
    private Contact contacto;
    private ContactLab contactoLab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        txtNombre=(EditText) findViewById(R.id.EditTextPersonNombre);
        txtApellido=(EditText) findViewById(R.id.EditTextPersonApellido);
        txtCiudad=(EditText) findViewById(R.id.EditTextPersonCiudad);
        txtTelefono=(EditText) findViewById(R.id.EditTextPersonTelefono);
        txtCorreo=(EditText) findViewById(R.id.EditTextPersonCorreo);
        btnGuardarContacto=(Button) findViewById(R.id.btnGuardarContacto);
        btnGuardarContacto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btnGuardarContacto){
            guardarBaseDatos();
        }
    }
    public void guardarBaseDatos(){
        contacto= new Contact();
        contacto.setNombre(txtNombre.getText().toString());
        contacto.setApellido(txtApellido.getText().toString());
        contacto.setCiudad(txtCiudad.getText().toString());
        contacto.setTelefono(txtTelefono.getText().toString());
        contacto.setCorreo(txtCorreo.getText().toString());
        contactoLab.addContacto(contacto);

    }
}