package com.example.sobrelalineaapp;

import java.util.Map;

//creamos las clase 'MensajeEnviar' que se extiende de la clase 'Mensaje'.
public class MensajeEnviar extends Mensaje{
    private Map hora;//creamos las variables dónde guardaremos la hora.


    //Constrcutor vacio de la clase
    public MensajeEnviar() {
    }

    //Constructor que solo contiene la variable hora
    public MensajeEnviar(Map hora) {
        this.hora = hora;
    }


    //Constructor semi-completo de la clase.
    public MensajeEnviar(String mensaje, String nombre, String type_mensaje, Map hora) {
        super(mensaje, nombre, type_mensaje);
        this.hora = hora;
    }

    //Constructor completo de la clase.
    public MensajeEnviar(String mensaje, String nombre, String type_mensaje, String urlFoto, Map hora) {
        super(mensaje, nombre, type_mensaje, urlFoto);
        this.hora = hora;
    }

    //creamos los getter y setter de la variable hora.

    public Map getHora() {
        return hora;
    }

    public void setHora(Map hora) {
        this.hora = hora;
    }
}
