package com.example.listcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private List<Contact> contactArrayList;

    public ContactAdapter(@NonNull Context context, List<Contact> contactArrayList) {
        super(context, R.layout.list_contact);
        this.context=context;
        this.contactArrayList=contactArrayList;//Recibo la lista y le asigno a otra lista

    }
    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Contact getItem(int position) {
        return contactArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Este metodo permite obtener la Vista apartir de una fila determinada (position)
    //La vista que representa la lista se pasa por parametros al metodo (convertView)
    //Se
    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        View view;
        final ViewHolder viewHolder;
        if (convertView == null || convertView.getTag()==null){
            viewHolder = new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.list_contact,parent,false);
            viewHolder.mContactName=(TextView) view.findViewById(R.id.adapterContactName);
            viewHolder.mContactImage = view.findViewById(R.id.adapterContactImage);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        viewHolder.mContactName.setText(contactArrayList.get(position).getNombre());
        //Seteamos la imagen
        Glide.with(context)
                .load(contactArrayList.get(position).getUrl())
                .into(viewHolder.mContactImage);
        return view;


    }
    static class ViewHolder{
        protected TextView mContactName;
        protected ImageView mContactImage;
    }
}
