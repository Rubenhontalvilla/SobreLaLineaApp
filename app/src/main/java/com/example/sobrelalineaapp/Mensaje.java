package com.example.sobrelalineaapp;


//Creamos las variables.
public class Mensaje {
    private String mensaje;
    private String nombre;
    private String type_mensaje;
    private String urlFoto;

    //Creamos el constructor vacio.
    public Mensaje( ) {
    }

    //Creamos el constrcutor semi-completo.
    public Mensaje(String mensaje, String nombre, String type_mensaje ) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.type_mensaje = type_mensaje;
    }


    //Creamos el constructor completo.
    public Mensaje(String mensaje, String nombre, String type_mensaje, String urlFoto) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.type_mensaje = type_mensaje;
        this.urlFoto = urlFoto;
    }


    //Creamos los getters  los setters de las variables.
    public String getMensaje() {

        return mensaje;
    }

    public void setMensaje(String mensaje) {

        this.mensaje = mensaje;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getType_mensaje() {
        return type_mensaje;
    }

    public void setType_mensaje(String type_mensaje) {
        this.type_mensaje = type_mensaje;
    }



    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
