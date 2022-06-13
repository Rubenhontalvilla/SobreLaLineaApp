package com.example.sobrelalineaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class botonesCliente extends AppCompatActivity {

    //Inicializo los botones que nos llevan a las activities de información, productos y chat
    Button btnInformacion, btnProductos, btnChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones_cliente);

        btnInformacion = findViewById(R.id.btnInformacion);
        btnProductos = findViewById(R.id.btnProductos);
        btnChat = findViewById(R.id.btnChat);


        //Metodo con el que pulsando en el boton de información no lleva dicha activity
        btnInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(botonesCliente.this, Informacion.class);
                startActivity(i);
            }
        });

        //Metodo con el que pulsando en el boton de productos no lleva dicha activity
      btnProductos.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i = new Intent(botonesCliente.this,Productos.class);
              startActivity(i);
          }
      });

        //Metodo con el que pulsando en el boton de chat no lleva dicha activity
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(botonesCliente.this, chat.class);
                startActivity(i);
            }
        });

    }
}