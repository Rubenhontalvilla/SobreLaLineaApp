package com.example.sobrelalineaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CrearOtroAdmin extends AppCompatActivity {


    //Creamos las variables.
    EditText nombre, email, contraseña, telefono;
    Button btnRegistro, btnIniciarSesion;
    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_otro_admin);


        //Inicializamos las variables
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        nombre = findViewById(R.id.registroNombre);
        email = findViewById(R.id.registroEmail);
        contraseña = findViewById(R.id.registroContraseña);
        telefono = findViewById(R.id.registroTelefono);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);



        //Boton que nos sirve para registrar un nuevo administrador, con el metodo que hay dentro se valida que se pueda registrar el admin con dichos datos.
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(nombre);
                checkField(email);
                checkField(contraseña);
                checkField(telefono);


                if(valid){
                    // empezamos el proceso de registro de los usuarios.
                    fAuth.createUserWithEmailAndPassword(email.getText().toString(),contraseña.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = fAuth.getCurrentUser();
                            Toast.makeText(CrearOtroAdmin.this, "Cuenta Creada", Toast.LENGTH_LONG).show();
                            DocumentReference df = fStore.collection("Usuarios").document(user.getUid());
                            Map<String,Object> userInfo = new HashMap<>();
                            userInfo.put("Nombre",nombre.getText().toString());
                            userInfo.put("Email",email.getText().toString());
                            userInfo.put("Telefono",telefono.getText().toString());
                            // Especificamos que el usuario es administrador
                            userInfo.put("esAdmin","1");

                            df.set(userInfo);


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(CrearOtroAdmin.this, "Fallo en la creación del usuario", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });



    }

    //Comprobamos que no se ha quedado ningún campo vacio.
    public boolean checkField(EditText textField) {
        if (textField.getText().toString().isEmpty()) {
            textField.setError("Error. Los campos de nombre, email, contraseña y telefono no pueden estar vacios.");
            valid = false;
        } else {
            valid = true;
        }


        return valid;
    }
}