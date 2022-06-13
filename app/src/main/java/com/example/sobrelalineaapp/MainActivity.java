package com.example.sobrelalineaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Creación del metodo de screen splash por lo que aprecerá al iniciar la aplicación el logo durante 2 segundos.
        new Handler() .postDelayed (new Runnable() {
            @Override
            public void run(){
                Intent intent=new Intent (MainActivity.this,Iniciar_sesion.class);
                startActivity(intent);
                finish();
            }
        },2000);//metodo que hace que el logo solo parezca 2 segundos, tras esto no llevará ala activity de inicio de sesion
    }
}