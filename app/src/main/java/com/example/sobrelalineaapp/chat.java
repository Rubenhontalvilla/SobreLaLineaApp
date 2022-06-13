package com.example.sobrelalineaapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class chat extends AppCompatActivity {


    //Creamos las variables a utilizar.
    private CircleImageView fotoPerfil;
    private TextView nombre;
    private RecyclerView rvMensajes;
    private EditText txtMensaje;
    private Button btnEnviar;
    private AdapterMensajes adapter;
    private ImageButton btnEnviarFoto;


    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage;
    private StorageReference storageReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        //Inicializamos dichas variables.
        fotoPerfil = findViewById(R.id.fotoPerfil);
        nombre =  findViewById(R.id.nombre);
        rvMensajes = (RecyclerView) findViewById(R.id.rvMensajes);
        txtMensaje = findViewById(R.id.txtMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("chat");//Sala del chat (nombre)
        storage = FirebaseStorage.getInstance();

        adapter = new AdapterMensajes(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMensajes.setLayoutManager(l);
        rvMensajes.setAdapter(adapter);


        //metodo con el que los usuarios envían los mensajes.
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.push().setValue(new MensajeEnviar(txtMensaje.getText().toString(),nombre.getText().toString(),"1", ServerValue.TIMESTAMP));
                txtMensaje.setText("");
            }
        });

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });


        //Metodo con el que los usuario recibe los mensajes.
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MensajeRecibir m = dataSnapshot.getValue(MensajeRecibir.class);
                adapter.addMensaje(m);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    //Metodo para la pantalla se vaya bajando automaticamente cada vez que se reciben nuevos mensajes.
    private void setScrollbar(){

        rvMensajes.scrollToPosition(adapter.getItemCount()-1);
    }
}