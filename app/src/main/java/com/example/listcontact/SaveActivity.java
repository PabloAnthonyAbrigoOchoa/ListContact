package com.example.listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listcontact.database.Contact;
import com.example.listcontact.database.ContactLab;

public class SaveActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtCiudad;
    private EditText txtTelefono;
    private EditText txtCorreo;
    private EditText txtUrl;
    private Button btnGuardarContacto;
    private Contact contacto;
    private ContactLab contactLab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        contactLab=new ContactLab(this);

        txtNombre=(EditText) findViewById(R.id.EditTextPersonNombre);
        txtApellido=(EditText) findViewById(R.id.EditTextPersonApellido);
        txtCiudad=(EditText) findViewById(R.id.EditTextPersonCiudad);
        txtTelefono=(EditText) findViewById(R.id.EditTextPersonTelefono);
        txtCorreo=(EditText) findViewById(R.id.EditTextPersonCorreo);
        txtUrl=(EditText) findViewById(R.id.EditTextPersonUrl);
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

        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        String ciudad = txtCiudad.getText().toString();
        String telefono = txtTelefono.getText().toString();
        String correo = txtCorreo.getText().toString();
        String url = txtUrl.getText().toString();
        if (nombre=="" && apellido=="" && ciudad=="" && telefono=="" && correo==""){
            if (apellido==""){
                txtApellido.setError("Ingrese Datos");
            }
            txtNombre.setError("Ingrese Datos");

            txtCiudad.setError("Ingrese Datos");
            txtTelefono.setError("Ingrese Datos");
            txtCorreo.setError("Ingrese Datos");

        }

        contacto= new Contact();
        contacto.setNombre(txtNombre.getText().toString());
        contacto.setApellido(txtApellido.getText().toString());
        contacto.setCiudad(txtCiudad.getText().toString());
        contacto.setTelefono(txtTelefono.getText().toString());
        contacto.setCorreo(txtCorreo.getText().toString());
        contacto.setUrl(txtUrl.getText().toString());
        //Toast.makeText(this,contacto.getNombre(), Toast.LENGTH_SHORT).show();
        contactLab.addContacto(contacto);


        Intent intent = new Intent(SaveActivity.this,MainActivity.class);
        startActivity(intent);

    }
}