package com.example.recycler_views_2906;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.recycler_views_2906.interfaces.iListaPrueba;
import com.example.recycler_views_2906.modelos.Noticia;

public class ActividadListView extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_list_view);

        //Datos
        final String [] datos = new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        //Adaptador de los datos
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, datos);

        //Vista
        ListView lstOpciones = (ListView)findViewById(R.id.lstLista);
        lstOpciones.setAdapter(adaptador2);

        //lstOpciones.setOnItemClickListener(new iListaPrueba(this.getApplicationContext()));

        lstOpciones.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ActividadListView.this, ActividadNoticia.class);
        Bundle b = new Bundle();

        Noticia noticia = (Noticia)parent.getItemAtPosition(position);

        b.putString("titulo",noticia.getTitulo());
        b.putString("subtitulo",noticia.getSubtitulo());

        intent.putExtras(b);
        startActivity(intent);
    }
}