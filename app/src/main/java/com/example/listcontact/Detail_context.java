package com.example.listcontact;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Detail_context extends AppCompatActivity {
    private TextView ciudad, descripcion;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_contact);

        //Obtenemos los datos del Main Activity
        String nombre = getIntent().getStringExtra("nombre");
        String ciudad = getIntent().getStringExtra("ciudad");
        String telefono = getIntent().getStringExtra("telefono");
        String correo = getIntent().getStringExtra("correo");
        String url = getIntent().getStringExtra("url");

        //ciudad = findViewById(R.id.detailContactName);
        descripcion = findViewById(R.id.detailContactDescription);
        img = findViewById(R.id.detailContactImage);

        /*Seteamos los datos obtenidos
        nombre.setText(nombre);
        ciudad.setText(ciudad);
        descripcion.setText(descripcion);*/

        //seteamos la imagen a la Vista
        Glide.with(this)
                //seteamos la imagen
                .load(img)
                .into(img);





    }
}
