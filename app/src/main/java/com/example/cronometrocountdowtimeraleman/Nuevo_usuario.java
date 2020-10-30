package com.example.cronometrocountdowtimeraleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Nuevo_usuario extends AppCompatActivity {

    private Button mBtn_Guardar;
    private EditText et_nombre, et_apellidos, et_correo, et_clave1, et_clave2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);

        mBtn_Guardar = findViewById(R.id.btn_guardarNuevoUsuario);
        et_nombre = findViewById(R.id.et_nombre);
        et_apellidos = findViewById(R.id.et_apellidos);
        et_correo = findViewById(R.id.et_email);
        et_clave1 = findViewById(R.id.et_password);
        et_clave2 = findViewById(R.id.et_password2);

        mBtn_Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setNombre(et_nombre.getText().toString());
                nuevoUsuario.setApellidos(et_apellidos.getText().toString());
                nuevoUsuario.setCorreo(et_correo.getText().toString());
                nuevoUsuario.setClave(et_clave1.getText().toString());

                String clave2 = et_clave2.getText().toString();

                if(nuevoUsuario.getNombre().isEmpty()
                        || nuevoUsuario.getApellidos().isEmpty()
                        || nuevoUsuario.getCorreo().isEmpty()
                        || nuevoUsuario.getClave().isEmpty()
                        || clave2.isEmpty()){
                    mostrarMensaje("Debe rellenar todos los campos");
                }else if(nuevoUsuario.getClave().equals(clave2) == false){
                    mostrarMensaje("Compruebe la contraseña!");
                }else{

                    ConexionSQLite conexion = new ConexionSQLite(getApplicationContext());
                    conexion.registrarUsuario(nuevoUsuario);
                    mostrarMensaje("Usuario registrado correctamente");

                    //IR A LA APLICACIÓN PRINCIPAL
                    Intent i = new Intent(Nuevo_usuario.this, MainActivity.class);
                    startActivity(i);
                }

            }
        });
    }

    private void mostrarMensaje(String mensaje){
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }
}