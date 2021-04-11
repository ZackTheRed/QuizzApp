package com.test.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    //Step 1: Declaration
    EditText etLogin, etPassword;
    Button bLogin;
    TextView tvRegister;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Step 2: Recuperation des ids
        etLogin = (EditText) findViewById(R.id.etMail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        //Step 3: Association de listeners

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Step 4: Traitement
                String login = etLogin.getText().toString().trim();
                String pswd = etPassword.getText().toString().trim();
                if (!etLogin.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty() && etPassword.length()>6){
                    fAuth.signInWithEmailAndPassword(login, pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(Login.this, "Connecté avec succès!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this, Quiz1.class));
                            }
                            else {
                                Toast.makeText(Login.this,"Login or password incorrect! Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(Login.this,"Please fill the required fields!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Step 4: Traitement
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}
