package com.example.recycler_views_2906;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener {

    TextView txtItemSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtItemSeleccionado = (TextView)findViewById(R.id.txtItemSeleccionado);

        //Datos
        final String [] datos = new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        //Array adapter
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item, datos);

        //Vista
        Spinner cmbOpciones = (Spinner)findViewById(R.id.cbOpciones);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        cmbOpciones.setAdapter(adaptador);

        //Establecer los listeners
        cmbOpciones.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Los datos vienen del adapter view: parent
        txtItemSeleccionado.setText("Seleccionado: " + parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        txtItemSeleccionado.setText("");
    }
}