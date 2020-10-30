package com.example.cronometrocountdowtimeraleman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    //Declaramos las variables necesarias 
    private EditText et_username, et_password;
    private Button btn_entrar, btn_registrar;
    private TextView tv_nuevoUsuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_inicio);

        et_username = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_entrar = findViewById(R.id.btn_entrar);
        btn_registrar = findViewById(R.id.btn_registrar);
        tv_nuevoUsuario = findViewById(R.id.tv_nuevo_usuario);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if(username.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Debe introducir un nombre de usuario", Toast.LENGTH_SHORT).show();
                }else if(password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Debe introducir una contraseña", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                    //TODO: CONEXIÓN CON LA BASE DE DATOS
                }

            }
        });

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Nuevo_usuario.class));
            }
        });

    }
}
