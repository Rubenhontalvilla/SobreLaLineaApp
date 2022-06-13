package com.example.sobrelalineaapp;

public class MensajeRecibir extends Mensaje {

    //Creamos la variable por la que recibiremos la variable hora en el mensaje.
    private Long hora;

//Creamos el constructor vacio.
    public MensajeRecibir() {
    }

    //Creamos el constructor semi-completo.
    public MensajeRecibir(Long hora) {
        this.hora = hora;

    }

    //Creamos el constructor completo de la clase.
    public MensajeRecibir(String mensaje, String nombre, String type_mensaje, String urlFoto, Long hora) {
        super(mensaje, nombre, type_mensaje, urlFoto);
        this.hora = hora;
    }

    //Creamos los gette y setter de la variable 'Long' hora.
    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }
}
