package com.example.sobrelalineaapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HolderMensaje extends RecyclerView.ViewHolder {
    //Creamos las variables.
    private TextView nombre;
    private TextView mensaje;
    private TextView hora;
    private ImageView fotoMensaje;

    //Inicializamos las variables.
    public HolderMensaje(@NonNull View itemView) {
        super(itemView);

        nombre =  (TextView) itemView.findViewById(R.id.tvNombreMensaje);
        mensaje = (TextView) itemView.findViewById(R.id.tvMensaje);
        hora = (TextView) itemView.findViewById(R.id.tvHoraMensaje);
        fotoMensaje = (ImageView) itemView.findViewById(R.id.mensajeFoto);


    }


    //Creación de los getters  setters de las variables.
    public TextView getNombre() {

        return nombre;
    }

    public void setNombre(TextView nombre) {

        this.nombre = nombre;
    }

    public TextView getMensaje() {

        return mensaje;
    }

    public void setMensaje(TextView mensaje) {

        this.mensaje = mensaje;
    }

    public TextView getHora() {

        return hora;
    }

    public void setHora(TextView hora) {
        this.hora = hora;
    }

    public ImageView getFotoMensaje() {
        return fotoMensaje;
    }

    public void setFotoMensaje(ImageView fotoMensaje) {
        this.fotoMensaje = fotoMensaje;
    }
}
