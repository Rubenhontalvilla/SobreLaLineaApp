package com.example.sobrelalineaapp;

//Creamos la clase Pedido para recoger sus datos en la base de datos
public class Pedido {

    //Creamos las variables.
    private String precio;

    //Creamos el constrcutor vacio.
    public Pedido() {

    }


//Creamos el constructor completo.
    public Pedido(String precio) {
        this.precio = precio;
    }

//Creamos los getters y setter de la clase.
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
