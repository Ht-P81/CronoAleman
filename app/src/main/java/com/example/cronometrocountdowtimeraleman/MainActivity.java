package com.example.cronometrocountdowtimeraleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    //Creamos las variables que vayamos a utilizar con los elementos de las vistas de la actividad
    Button mbtn_grupo1;
    Button mbtn_grupo2;
    Button mbtn_entrenar;

    private Set<String> ejerciciosSuperiores;
    private Set<String> ejerciciosCardio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mapeamos las variables con las vistas (en este caso botones) de la actividad.
        mbtn_grupo1 = findViewById(R.id.btn_grupo1);
        mbtn_grupo2 = findViewById(R.id.btn_grupo2);
        mbtn_entrenar = findViewById(R.id.btn_entrenar);

        ejerciciosSuperiores = new LinkedHashSet<>();
        ejerciciosCardio = new LinkedHashSet<>();

        //Recepcionamos el bundle envíado desde Lista_Ejercicios con los ejercicios seleccionados por el usuario
        Bundle informacion = getIntent().getExtras();

        cargarPreferencias();

        //TODO: INCORPORAR SHARED PREFERENCES

        //Este codigo recepcion el envío desde Lista_Ejercicios con los posibles ejercicios seleccionados por el usuario
        /*if(informacion != null){
            if(informacion.getStringArrayList("superiores") != null){
                ejerciciosSuperiores = informacion.getStringArrayList("superiores");
            }

            if(informacion.getStringArrayList("cardio") != null){
                ejerciciosCardio = informacion.getStringArrayList("cardio");
            }
        }*/


        //Le damos funcionalidad a los botones VER1, desde aquí envíamos datos a activity lista ejercicios
        mbtn_grupo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un intent
                Intent intentVer = new Intent (MainActivity.this, Lista_Ejercicios.class);
                //Pasamos información mediante bundles
                intentVer.putExtra("Ejercicio1", "Superior1");
                intentVer.putExtra("Ejercicio2", "Superior2");
                intentVer.putExtra("Ejercicio3", "Superior3");
                intentVer.putExtra("Ejercicio4", "Superior4");
                intentVer.putExtra("Ejercicio5", "Superior5");
                intentVer.putExtra("Ejercicio6", "Superior6");
                intentVer.putExtra("tipoEjercicios", "ejerciciosSuperiores");
                //Iniciamos el intent
                startActivity(intentVer);
            }
        });

        //Le damos funcionalidad a los botones VER2
        mbtn_grupo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un intent
                Intent intentVer = new Intent (MainActivity.this, Lista_Ejercicios.class);
                //Pasamos información mediante bundles
                intentVer.putExtra("Ejercicio1", "Cardio1");
                intentVer.putExtra("Ejercicio2", "Cardio2");
                intentVer.putExtra("Ejercicio3", "Cardio3");
                intentVer.putExtra("Ejercicio4", "Cardio4");
                intentVer.putExtra("Ejercicio5", "Cardio5");
                intentVer.putExtra("Ejercicio6", "Cardio6");
                intentVer.putExtra("tipoEjercicios", "ejerciciosCardio");
                //Iniciamos el intent
                startActivity(intentVer);
            }
        });

        //Le damos funcionalidad a los botones A ENTRENAR!!!
        mbtn_entrenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ejerciciosSuperiores.size() != 0 || ejerciciosCardio.size() != 0){
                    //Creamos un intent
                    Intent intentEntrenar= new Intent (MainActivity.this, CronosEntrenar.class);
                    //Con estos putExtra enviamos información a activity_cronos con los ejercicios seleccionados
                    //intentEntrenar.putExtra("ejerciciosSuperiores", ejerciciosSuperiores);
                    //intentEntrenar.putExtra("ejerciciosCardio", ejerciciosCardio);
                    //Iniciamos el intent
                    startActivity(intentEntrenar);
                }else{
                    Toast.makeText(getApplicationContext(), "Debe seleccionar algún ejercicio", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void cargarPreferencias() {
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        ejerciciosSuperiores = preferencias.getStringSet("ejerciciosSuperiores", null);
        ejerciciosCardio = preferencias.getStringSet("ejerciciosCardio", null);
    }
}