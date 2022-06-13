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

public class Registro extends AppCompatActivity {

    //Creación de las variables que necesitaremos a continuación.
    EditText nombre, email, contraseña, telefono;
    Button btnRegistro, btnIniciarSesion;
    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        //Inicialización de dichas variables
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        nombre = findViewById(R.id.registroNombre);
        email = findViewById(R.id.registroEmail);
        contraseña = findViewById(R.id.registroContraseña);
        telefono = findViewById(R.id.registroTelefono);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);



        //Boton de creación de la cuenta en el que si los parametros que pasamoe estan correctos no creará el usuario y el saldrá por pantalla el mensaje de que hemos creado un usuario.
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chequeamos que los campos no esten vacios.
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
                            Toast.makeText(Registro.this, "Cuenta Creada", Toast.LENGTH_LONG).show();
                            DocumentReference df = fStore.collection("Usuarios").document(user.getUid());
                            Map<String,Object> userInfo = new HashMap<>();
                            userInfo.put("Nombre",nombre.getText().toString());
                            userInfo.put("Email",email.getText().toString());
                            userInfo.put("Telefono",telefono.getText().toString());
                            // Especificamos que el usuario es cliente.
                            userInfo.put("esUsuario","1");

                            df.set(userInfo);


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //Mensaje de error en el que caso de que no se pueda crear el usuario.
                            Toast.makeText(Registro.this, "Fallo en la creación del usuario", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


        //Boton que nos lleva al inicio de sesión una vez sepamos que el usuario esta registrado correctamente o no hayamos confundido al pulsarle.
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registro.this, Iniciar_sesion.class);
                startActivity(i);
            }

        });

    }

    //Validamos que los campos no estenb vacios. Si está vacio no saldrá un error y no están vacios no aparecera nada.
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