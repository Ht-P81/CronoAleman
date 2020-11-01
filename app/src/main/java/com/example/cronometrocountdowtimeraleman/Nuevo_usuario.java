package com.example.cronometrocountdowtimeraleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Nuevo_usuario extends AppCompatActivity {

    //Creamos las variables para operar y asignar funcionalidad
    private Button mBtn_Guardar;
    private EditText et_nombre, et_apellidos, et_correo, et_clave, et_clave2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);

        //Mapeamos las variables con los elementos de la vista
        mBtn_Guardar = findViewById(R.id.btn_guardarNuevoUsuario);
        et_nombre = findViewById(R.id.et_nombre);
        et_apellidos = findViewById(R.id.et_apellidos);
        et_correo = findViewById(R.id.et_email);
        et_clave = findViewById(R.id.et_clave);
        et_clave2 = findViewById(R.id.et_clave2);

        //Creamos funcionalidad al boton guardar
        mBtn_Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Instanciamos al objeto Usuario mediante su constructor por defecto
                UsuarioBBDD nuevoUsuarioBBDD = new UsuarioBBDD();
                //Colocamos la informacion introducida por el usuario y lo pasamos
                // a String para poderla tratar
                nuevoUsuarioBBDD.setNombre(et_nombre.getText().toString());
                nuevoUsuarioBBDD.setApellidos(et_apellidos.getText().toString());
                nuevoUsuarioBBDD.setCorreo(et_correo.getText().toString());
                nuevoUsuarioBBDD.setClave(et_clave.getText().toString());

                //Esta variable no forma parte del objeto Usuario pq no formará
                // parte de las tablas de BBDD
                String clave2 = et_clave2.getText().toString();

                //Creamos condicionales que digan que todos los campos a rellenar son obligatorios
                //Así el usuario obtiene información de usabilidad con nuestra app
                if(nuevoUsuarioBBDD.getNombre().isEmpty()
                        || nuevoUsuarioBBDD.getApellidos().isEmpty()
                        || nuevoUsuarioBBDD.getCorreo().isEmpty()
                        || nuevoUsuarioBBDD.getClave().isEmpty()
                        || clave2.isEmpty()){
                    mostrarMensaje("Debe rellenar todos los campos");

                //Si los campos password no coinciden, entonces
                }else if(nuevoUsuarioBBDD.getClave().equals(clave2) == false){
                    mostrarMensaje("¡Compruebe la contraseña!");
                }else{

                    //Realizamos la conexión a la BBDD
                    ConexionSQLite conexion = new ConexionSQLite(getApplicationContext());
                    conexion.registrarUsuario(nuevoUsuarioBBDD);
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