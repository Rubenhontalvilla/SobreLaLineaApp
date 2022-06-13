package com.example.sobrelalineaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class botonesAdmin extends AppCompatActivity {

    //Creación de las variables de los botones.
    Button  btnRegistrarAdmin, btnChatAdmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones_admin);

        //Inicialización de las variabloes de los botones.
        btnRegistrarAdmin = findViewById(R.id.btnInformacion);
        btnChatAdmin = findViewById(R.id.btnChat);


        //Boton que nos lleva a la activity para registrar mas usuarios.
        btnRegistrarAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(botonesAdmin.this, CrearOtroAdmin.class);
                startActivity(i);
            }
        });


        //Botón que nos lleva a la activity del chat por parte del administrador.
        btnChatAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(botonesAdmin.this, chat.class);
                startActivity(i);
            }
        });




    }
}