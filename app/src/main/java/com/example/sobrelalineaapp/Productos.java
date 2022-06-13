package com.example.sobrelalineaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Productos extends AppCompatActivity {

    //Creamos las variable de la clase 'Producto'
    TextView tvCantProductos;
    Button btnVerCarro;
    RecyclerView rvListaProductos;
    AdaptadorProductos adaptador;

    List<Producto> listaProductos = new ArrayList<>();
    List<Producto> carroCompras = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        getSupportActionBar().hide();

    //Inicializamos las variables.
        tvCantProductos = findViewById(R.id.tvCantProductos);
        btnVerCarro = findViewById(R.id.btnVerCarro);
        rvListaProductos = findViewById(R.id.rvListaProductos);
        rvListaProductos.setLayoutManager(new GridLayoutManager(Productos.this, 1));

        //pasamos las lista de productos que aprecera en la activity de productos.
        listaProductos.add(new Producto("1", "Cuaderno Rojo", "Cuaderno de tapa de dura de la marca 'OXFORD' de 80 hojas en color rojo.", 5.0));
        listaProductos.add(new Producto("2", "Cuaderno Verde", "Cuaderno de tapa de dura de la marca 'OXFORD' de 80 hojas en color verde.", 5.0));
        listaProductos.add(new Producto("3", "Cuaderno Morado", "Cuaderno de tapa de dura de la marca 'OXFORD' de 80 hojas en color morado.", 5.0));
        listaProductos.add(new Producto("4", "Cuaderno Azul", "Cuaderno de tapa de dura de la marca 'OXFORD' de 80 hojas en color azul.", 5.0));
        listaProductos.add(new Producto("5", "Cuaderno amarillo", "Cuaderno de tapa de dura de la marca 'OXFORD' de 80 hojas en color amarillo.", 5.0));
        listaProductos.add(new Producto("6", "Lápiz HB2", "Lápiz de la marca 'STAEDLER' de HB2 con goma en el extremo.", 0.7));
        listaProductos.add(new Producto("7", "Boligrafo BIC Negro", "Boligrafo de cristal de la marca 'BIC' en color negro.", 0.3));
        listaProductos.add(new Producto("8", "Boligrafo BIC Azul", "Boligrafo de cristal de la marca 'BIC' en color azul.", 0.3));
        listaProductos.add(new Producto("9", "Boligrafo BIC Rojo", "Boligrafo de cristal de la marca 'BIC' en color rojo.", 0.3));
        listaProductos.add(new Producto("10", "Goma de borrar Blanca", "Goma de borrar de la marca 'MILAN'de color blanco.", 0.5));
        listaProductos.add(new Producto("11", "Agenda 2022", "Agenda personalizable del 2022.", 3.5));
        listaProductos.add(new Producto("12", "Portaminas Negro", "Portaminas de la marca 'STAEDLER'en color negro.", 1.5));
        listaProductos.add(new Producto("13", "Tip-Ex Estilo cinta", "Tip-Ex de la marca 'STAEDLER' del estilo de cinta.", 0.8));
        listaProductos.add(new Producto("14", "Tip-Ex Estilo boligrafo", "Tip-Ex de la marca 'STAEDLER' estilo boligrafo.", 1.5));


        adaptador = new AdaptadorProductos(Productos.this, tvCantProductos, btnVerCarro, listaProductos, carroCompras);
        rvListaProductos.setAdapter(adaptador);



    }
}