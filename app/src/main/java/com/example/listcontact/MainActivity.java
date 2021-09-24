package com.example.listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import com.example.listcontact.database.Contact;
import com.example.listcontact.database.ContactLab;


public class MainActivity extends AppCompatActivity {

    private ListView list;
    private String [] nombres = {"Pablo", "Karen", "Ludy", "Oddy"};
    private ContactLab contactoLab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);

        ArrayAdapter adpter = new ArrayAdapter(this, android.R.layout.activity_list_item, nombres);
        //setListAdapter(adpter);

        ArrayList<Contact> listContact = new ArrayList<Contact>();
        llenarDatosBD(listContact);

        ContactAdapter adapter = new ContactAdapter(this, listContact);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact objContact = (Contact) adapter.getItem(position);

                /*Intent intent = new Intent(MainActivity.this, Detail_context.class);
                /*intent.putExtra("nombre", selectItem.getNombre());
                intent.putExtra("ciudad", selectItem.getCiudad());
                intent.putExtra("telefono", selectItem.getTelefono());
                intent.putExtra("correo", selectItem.getCorreo());
                intent.putExtra("url", selectItem.getUrl());
                startActivity(intent);*/

                objContact.getNombre();
                objContact.getCiudad();
                Toast.makeText(getApplicationContext(),objContact
                        .getNombre(), Toast.LENGTH_LONG).show();

                //int posicion = Integer.parseInt(selectItem);
            }
        });
    }
    private void llenarDatosCodigo(ArrayList<Contact> lista){

        Contact contacto1 = new Contact();
        contacto1.setNombre("Pablo");
        contacto1.setCiudad("Loja");
        contacto1.setTelefono("0994941403");
        contacto1.setCorreo("pabloochoa518@gmail.com");
        contacto1.setUrl("https://w7.pngwing.com/pngs/786/826/png-transparent-public-toilet-gender-symbol-bathroom-male-man-toilet-text-bathroom-logo.png");
        lista.add(contacto1);

        Contact contacto2 = new Contact();
        contacto2.setNombre("Karen");
        contacto2.setCiudad("Loja");
        contacto2.setTelefono("0966334477");
        contacto2.setCorreo("k-rencitabrigo@gmail.com");
        contacto2.setUrl("https://w7.pngwing.com/pngs/240/305/png-transparent-woman-female-girls-only-s-angle-text-logo.png");
        lista.add(contacto2);

        Contact contacto3 = new Contact();
        contacto3.setNombre("Ludy");
        contacto3.setCiudad("Loja");
        contacto3.setTelefono("0994109117");
        contacto3.setCorreo("lulu123@gmail.com");
        contacto3.setUrl("https://w7.pngwing.com/pngs/240/305/png-transparent-woman-female-girls-only-s-angle-text-logo.png");
        lista.add(contacto3);

        Contact contacto4 = new Contact();
        contacto4.setNombre("Oddy");
        contacto4.setCiudad("Loja");
        contacto4.setTelefono("0994947788");
        contacto4.setCorreo("odicin654@gmail.com");
        contacto4.setUrl("https://st.depositphotos.com/1035449/1574/v/600/depositphotos_15742775-stock-illustration-vector-dog-labrador-retriever-cheerful.jpg");
        lista.add(contacto4);
    }

    private void llenarDatosBD(ArrayList<Contact> lista){
        lista.clear();
        lista.addAll(contactoLab.getContactos());

    }
}

