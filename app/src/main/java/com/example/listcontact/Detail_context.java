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
    private TextView ciudad, descripcion;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_contact);


        ciudad = findViewById(R.id.detailContactCity);
        descripcion = findViewById(R.id.detailContactDescription);
        img = findViewById(R.id.detailContactImage);


        //Obtenemos los datos del Main Activity
        Intent intent = new Intent();
        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String ciudad = getIntent().getStringExtra("ciudad");
        String telefono = getIntent().getStringExtra("telefono");
        String correo = getIntent().getStringExtra("correo");
        String img = intent.getStringExtra("foto");
        System.out.println("img: " + img);


        /*Seteamos los datos obtenidos
        nombre.setText(nombre);
        ciudad.setText(ciudad);
        descripcion.setText(descripcion);*/

        //seteamos la imagen a la Vista
        /*Glide.with(this)
                //seteamos la imagen
                .load(Uri.parse(img))
                .into(img);*/
    }
}
