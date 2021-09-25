package com.example.listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import com.example.listcontact.database.Contact;
import com.example.listcontact.database.ContactLab;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView list;
    private TextView txtView;
    private Button btnGuardar;
    private ContactLab contactoLab;
    private Contact contact;
    //private ContactAdapter listItemadapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private ArrayList<Contact> listContact =new ArrayList<Contact>();
    ArrayAdapter<Contact> personaArrayAdapter;
    private ContactAdapter adapter;
    Contact selectItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactoLab = new ContactLab(this);

        btnGuardar= (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);
        list = (ListView) findViewById(R.id.listView);
        txtView = (TextView) findViewById(R.id.textViewNoItems);

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.activity_list_item, nombres);


        llenarDatosBD();
        if (listContact !=null && listContact.size()>0){
            txtView.setVisibility(View.GONE); //para ocultar
            list.setVisibility(View.VISIBLE); //para mostrar
            adapter = new ContactAdapter(this, listContact);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Contact selectItem = (Contact) adapter.getItem(position);

                    Toast toast = Toast.makeText(MainActivity.this, "Posición: " + position +", id: "+  id, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();

                    Intent intent = new Intent(MainActivity.this, Detail_context.class);
                    intent.putExtra("nombre", selectItem.getNombre());
                    intent.putExtra("apellido", selectItem.getApellido());
                    intent.putExtra("ciudad", selectItem.getCiudad());
                    intent.putExtra("correo", selectItem.getCorreo());
                    intent.putExtra("telefono", selectItem.getTelefono());
                    intent.putExtra("foto", selectItem.getUrl());
                    startActivity(intent);
                }
            });
        }else{
            list.setVisibility(View.GONE);
            txtView.setVisibility(View.VISIBLE);
        }
    }
        /*ContactAdapter adapter = new ContactAdapter(this, listContact);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contact objContact = (Contact) adapter.getItem(position);

                Intent intent = new Intent(MainActivity.this, Detail_context.class);
                intent.putExtra("nombre", selectItem.getNombre());
                intent.putExtra("ciudad", selectItem.getCiudad());
                intent.putExtra("telefono", selectItem.getTelefono());
                intent.putExtra("correo", selectItem.getCorreo());
                intent.putExtra("url", selectItem.getUrl());
                startActivity(intent);

        //objContact.getNombre();
        //objContact.getCiudad();
        //Toast.makeText(getApplicationContext(),objContact
        //.getNombre(), Toast.LENGTH_LONG).show();

        //int posicion = Integer.parseInt(selectItem);
        }
            });
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return super.onCreateOptionsMenu(menu);
        }*/


    private void eliminarContacto(Contact contact, int posicion){
            listContact.remove(posicion);
            contactoLab.deleteAllPersona();
            adapter.notifyDataSetChanged();
        }

    private void eliminarTodo(){
        listContact.clear();
        contactoLab.deleteAllPersona();
        adapter.notifyDataSetChanged();
    }

    private void llenarDatosCodigo(ArrayList<Contact> lista){

        Contact contacto1 = new Contact();
        contacto1.setNombre("Pablo");
        contacto1.setApellido("Abrigo");
        contacto1.setCiudad("Loja");
        contacto1.setTelefono("0994941403");
        contacto1.setCorreo("pabloochoa518@gmail.com");
        contacto1.setUrl("https://w7.pngwing.com/pngs/786/826/png-transparent-public-toilet-gender-symbol-bathroom-male-man-toilet-text-bathroom-logo.png");
        lista.add(contacto1);

        Contact contacto2 = new Contact();
        contacto2.setNombre("Karen");
        contacto2.setApellido("Abrigo");
        contacto2.setCiudad("Loja");
        contacto2.setTelefono("0966334477");
        contacto2.setCorreo("k-rencitabrigo@gmail.com");
        contacto2.setUrl("https://w7.pngwing.com/pngs/240/305/png-transparent-woman-female-girls-only-s-angle-text-logo.png");
        lista.add(contacto2);

        Contact contacto3 = new Contact();
        contacto3.setNombre("Ludy");
        contacto3.setApellido("Ochoa");
        contacto3.setCiudad("Loja");
        contacto3.setTelefono("0994109117");
        contacto3.setCorreo("lulu123@gmail.com");
        contacto3.setUrl("https://w7.pngwing.com/pngs/240/305/png-transparent-woman-female-girls-only-s-angle-text-logo.png");
        lista.add(contacto3);

        Contact contacto4 = new Contact();
        contacto4.setNombre("Oddy");
        contacto4.setApellido("Mantequilla");
        contacto4.setCiudad("Loja");
        contacto4.setTelefono("0994947788");
        contacto4.setCorreo("odicin654@gmail.com");
        contacto4.setUrl("https://st.depositphotos.com/1035449/1574/v/600/depositphotos_15742775-stock-illustration-vector-dog-labrador-retriever-cheerful.jpg");
        lista.add(contacto4);
    }

    private void llenarDatosBD(){
        listContact.clear();
        try {
            listContact.addAll(contactoLab.getContactos());
        } catch (Exception e) {
                Log.i(null,"llenarDatosBD: no hay datos");
            }
        }


    @Override
    public void onClick(View view) {
        if (view==btnGuardar){
            Intent intent = new Intent(this, SaveActivity.class);
            startActivity(intent);
        }
    }
    protected void onRestart(){
        super.onRestart();
        llenarDatosBD();
        adapter.notifyDataSetChanged();
        listContact.clear();
        listContact.addAll(contactoLab.getContactos());
    }
}
        //Comando para ejercutar el Firebase
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");*/


