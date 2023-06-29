package com.example.recycler_views_2906.interfaces;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class iListaPrueba implements AdapterView.OnItemClickListener
{
    Context context_app;
    public iListaPrueba(Context context){
        context_app = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context_app, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
