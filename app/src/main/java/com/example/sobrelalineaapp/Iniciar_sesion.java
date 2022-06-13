package com.example.sobrelalineaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Iniciar_sesion extends AppCompatActivity {


    //Creamos las variables.
    EditText email, contraseña;
    Button btnIncioSesion, btnRegistro;
    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);


        //Inicializamos las variables
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        email = findViewById(R.id.Email);
        contraseña = findViewById(R.id.Contraseña);
        btnIncioSesion = findViewById(R.id.iniciarSesion);
        btnRegistro = findViewById(R.id.crearCuenta);


        //Creamos el boton de iniciar sesion, la cuál se inicia si los campos están correctos  no saldrá el mensaje de que se ha iniciado sesión, en el caso contrario
        //nos saldra un mensaje de que no hemos podido iniciar sesión
        btnIncioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(email);
                checkField(contraseña);


                if(valid){
                    fAuth.signInWithEmailAndPassword(email.getText().toString(),contraseña.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(Iniciar_sesion.this,"Has iniciado sesion correctamente.", Toast.LENGTH_SHORT).show();
                            checkUserAccesLevel(authResult.getUser().getUid());
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        });



        //Boton con el que vamos a la creación de usuario.
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Registro.class));
            }
        });


    }


    //Chequeamos si el nivel del usuario es 'Administrador' o 'Cliente', dependiendo cuál se nos incia una u otra activity.
    private void checkUserAccesLevel(String uid) {
        DocumentReference df = fStore.collection("Usuarios").document(uid);
        //Extraemos la información de la base de datos.
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d("TAG","enProceso" + documentSnapshot.getData());
                // identificamos el rol del usuario.

                if(documentSnapshot.getString("esAdmin") != null){
                    //el usuario es admin.


                    startActivity(new Intent(getApplicationContext(),botonesAdmin.class));//La activit que se abre si el usuario es administrador.
                    finish();
                }

                if(documentSnapshot.getString("esUsuario") != null){
                    startActivity(new Intent(getApplicationContext(),botonesCliente.class));//La activit que se nos abre si el usuario es cliente.
                    finish();
                }


            }
        });
    }

    //Chequeamos que los datos aportados están correctos.
    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error. Los campos de nombre de usuarios y contraseña no pueden estar vacios");
            valid = false;
        }else {
            valid = true;
        }

        return valid;

    }


}