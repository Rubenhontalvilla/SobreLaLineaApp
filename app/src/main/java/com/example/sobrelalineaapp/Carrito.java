package com.example.sobrelalineaapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class Carrito extends AppCompatActivity {

    //Creamos las variables.
    List<Producto> carritoCompra;

    AdaptadorCarrito adaptador;

    RecyclerView rvListaCarrito;
    TextView tvTotal;
    Button realizarPedido;


    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage;
    private StorageReference storageReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        getSupportActionBar().hide();


        //Creamos la lista en la que se guardaron los productos que estan marcados como en el carrito.
        carritoCompra = (List<Producto>) getIntent().getSerializableExtra("CarritoCompras");

        //Inicializamos las variables.
        rvListaCarrito = findViewById(R.id.rvListaCarrito);
        rvListaCarrito.setLayoutManager(new GridLayoutManager(Carrito.this, 1));
        tvTotal = findViewById(R.id.tvTotal);
        realizarPedido = findViewById(R.id.btnRealizarPedido);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Pedidos");//como se llama la tabla de la base de datos.
        storage = FirebaseStorage.getInstance();


        //Botón con el que le enviamos al admin el pedido que desea realizar el usuario.
        realizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.push().setValue(new Pedido(tvTotal.getText().toString()));
                tvTotal.setText("");
            }
        });



        //Adaptador para meter los productos en el carrito.
        adaptador = new AdaptadorCarrito(Carrito.this, carritoCompra, tvTotal);
        rvListaCarrito.setAdapter(adaptador);


    }
}
