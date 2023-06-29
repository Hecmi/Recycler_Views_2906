package com.example.recycler_views_2906.modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario {

    String nombres;
    String email;
    String website;
    String urlavatar;

    public Usuario(JSONObject a) throws JSONException {
        nombres = a.getString("first_name").toString() + " " + a.getString("last_name").toString();
        email = a.getString("email").toString() ;
        website = a.getString("avatar").toString() ;
        urlavatar = a.getString("avatar").toString() ;
    }

    public String getNombre() { return nombres; }
    public String getEmail() { return email; }
    public String getWebsite() { return website; }
    public String getUrlavatar() { return urlavatar; }
    public void setNombre(String nombre) { this.nombres = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setWebsite(String website) { this.website = website; }
    public void setUrlavatar(String urlavatar) { this.urlavatar = urlavatar; }


    public static ArrayList<Usuario> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            usuarios.add(new Usuario(datos.getJSONObject(i)));
        }
        return usuarios;
    }


}
