package com.example.recycler_views_2906.modelos;

import androidx.annotation.NonNull;

public class Noticia {
    private String titulo;
    private String subtitulo;

    public Noticia (String tit, String
            sub){
        titulo = tit;
        subtitulo = sub;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }

    @NonNull
    @Override
    public String toString() {
        return titulo + "\n" + subtitulo;
    }
}
