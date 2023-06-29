package com.example.recycler_views_2906.adaptadores;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recycler_views_2906.R;
import com.example.recycler_views_2906.modelos.Noticia;
import com.example.recycler_views_2906.modelos.Usuario;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorUsuarios  extends ArrayAdapter<Usuario> {

    public AdaptadorUsuarios(Context context, ArrayList<Usuario> datos) {
        super(context, R.layout.lyitemusuario, datos);
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemusuario, null);

        TextView txtNombres = (TextView)item.findViewById(R.id.lblNombre);
        TextView txtEmail = (TextView)item.findViewById(R.id.lblEmail);
        TextView txtWeb = (TextView)item.findViewById(R.id.lblweb);

        txtNombres.setText(getItem(position).getNombre());
        txtEmail.setText(getItem(position).getEmail());
        txtWeb.setText(getItem(position).getWebsite());

        ImageView imgView = (ImageView)item.findViewById(R.id.imgUsr);

        Glide.with(this.getContext())
                .load(getItem(position).getUrlavatar())
                .into(imgView);


        return(item);

    }
}
