package com.example.recycler_views_2906;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActividadNoticia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_noticia);

        Bundle b = this.getIntent().getExtras();

        TextView txtTitulo = (TextView)findViewById(R.id.txtTitulo);
        TextView txtSubtitulo = (TextView)findViewById(R.id.txtSubtitulo);
        txtTitulo.setText(b.getString("titulo"));
        txtSubtitulo.setText(b.getString("subtitulo"));

    }
}