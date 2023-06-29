package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.recycler_views_2906.ActividadListView;
import com.example.recycler_views_2906.ActividadNoticia;
import com.example.recycler_views_2906.R;
import com.example.recycler_views_2906.adaptadores.AdaptadorNoticias;
import com.example.recycler_views_2906.interfaces.iListaPrueba;
import com.example.recycler_views_2906.modelos.Noticia;

public class ListViewPersonalizado extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Noticia[] noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_personalizado);

        /*
        noticias = new Noticia[]{
                        new Noticia("Noticia 1", "SubNoticia Contenido Contenido Contenido Contenido 1"),
                        new Noticia("Noticia 2", "SubNoticia Contenido Contenido Contenido Contenido 2"),
                        new Noticia("Noticia 3", "SubNoticia Contenido Contenido Contenido Contenido 3"),
                        new Noticia("Noticia 4", "SubNoticia Contenido Contenido Contenido Contenido 4")
        };
        */

        noticias = new Noticia[10];
        for (int i = 0; i < noticias.length; i++){
            noticias[i] = new Noticia("Noticia " + (i + 1) ,"SubNoticia Contenido Contenido Contenido Contenido " + (i + 1));
        }

        //Adaptador
        AdaptadorNoticias adaptadorNoticias = new AdaptadorNoticias(this, noticias);

        //Vistas
        ListView lstLista2 = (ListView)findViewById(R.id.lstLista2);

        //Añadir header
        View header = getLayoutInflater().inflate(R.layout.lyheader, null);
        lstLista2.addHeaderView(header);

        lstLista2.setAdapter(adaptadorNoticias);


        //lstLista2.setOnItemClickListener(new iListaPrueba(this.getApplicationContext()));
        lstLista2.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ListViewPersonalizado.this, ActividadNoticia.class);
        Bundle b = new Bundle();

        Noticia noticia = (Noticia)parent.getItemAtPosition(position);

        b.putString("titulo",noticia.getTitulo());
        b.putString("subtitulo",noticia.getSubtitulo());

        intent.putExtras(b);
        startActivity(intent);
    }
}