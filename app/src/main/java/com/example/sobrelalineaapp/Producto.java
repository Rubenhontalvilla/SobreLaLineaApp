package com.example.sobrelalineaapp;

import java.io.Serializable;
//Creamos la clase 'Producto'
public class Producto implements Serializable {

//Creamos las variables.
    String idProducto;
    String nomProducto;
    String descripcion;
    double precio;

    //Creamos el constructor completo.
    public Producto(String idProducto, String nomProducto, String descripcion, double precio) {
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //Creamos los getter y setter de la clase.
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
