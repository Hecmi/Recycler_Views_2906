package com.example;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.WebService.Asynchtask;
import com.example.WebService.WebService;
import com.example.recycler_views_2906.R;
import com.example.recycler_views_2906.adaptadores.AdaptadorNoticias;
import com.example.recycler_views_2906.adaptadores.AdaptadorUsuarios;
import com.example.recycler_views_2906.modelos.Noticia;
import com.example.recycler_views_2906.modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class ActividadUsuarios extends AppCompatActivity implements Asynchtask {
    ArrayList<Usuario> usuarios;
    ListView lstUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_usuarios);

        lstUsuarios = (ListView)findViewById(R.id.lstUsuarios);

        View header = getLayoutInflater().inflate(R.layout.lyheader, null);
        lstUsuarios.addHeaderView(header);



        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, ActividadUsuarios.this, ActividadUsuarios.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaUsuarios= JSONlista.getJSONArray("data");

        usuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);

        AdaptadorUsuarios adaptadorUsuario = new AdaptadorUsuarios (this, usuarios);
        lstUsuarios.setAdapter(adaptadorUsuario);


    }
}