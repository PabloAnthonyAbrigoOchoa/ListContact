package com.example.listcontact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.sql.SQLOutput;
import java.util.jar.Attributes;

public class Detail_context extends AppCompatActivity {
    private TextView txtCiudad, txtCorreo, txtNombre;
    private ImageView foto;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_contact);

        txtNombre = (TextView) findViewById(R.id.detailContactName);
        txtCiudad = (TextView) findViewById(R.id.detailContactCity);
        txtCorreo = (TextView) findViewById(R.id.detailContactCorreo);
        foto = findViewById(R.id.detailContactImage);


        //Obtenemos los datos del Main Activity
        Intent intent = getIntent();

        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String ciudad = intent.getStringExtra("ciudad");
        String correo = intent.getStringExtra("correo");
        String telefono = intent.getStringExtra("telefono");
        String img = intent.getStringExtra("foto");


        //Seteamos los datos obtenidos
        txtNombre.setText(nombre+ " "+apellido);
        txtCiudad.setText(ciudad);
        txtCorreo.setText(correo);


        //seteamos la imagen a la Vista
        Glide.with(this)
                //seteamos la imagen
                .load(Uri.parse(img))
                .into(foto);
    }
}
