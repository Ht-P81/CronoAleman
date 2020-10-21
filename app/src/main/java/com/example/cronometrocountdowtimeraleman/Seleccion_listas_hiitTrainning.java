package com.example.cronometrocountdowtimeraleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class Seleccion_listas_hiitTrainning extends AppCompatActivity {

    //Creamos las variables que vayamos a utilizar con los elementos de las vistas de la actividad
    Button mbtn_grupo1;
    Button mbtn_grupo2;
    Button mbtn_entrenar;
    HashMap<String, String> hashMap = new HashMap<String, String>();
    private ArrayList<String> ejerciciosSuperiores;
    private ArrayList<String> ejerciciosCardio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_listas_hiit_trainning);

        //Mapeamos las variables con las vistas (en este caso botones) de la actividad.
        mbtn_grupo1 = findViewById(R.id.btn_grupo1);
        mbtn_grupo2 = findViewById(R.id.btn_grupo2);
        mbtn_entrenar = findViewById(R.id.btn_entrenar);

        //Recepcionamos el bundle envíado desde el activity_main
        Bundle informacion = getIntent().getExtras();

        if(informacion != null){
            if(informacion.getStringArrayList("superiores") != null){
                ejerciciosSuperiores = informacion.getStringArrayList("superiores");
            }

            if(informacion.getStringArrayList("cardio") != null){
                ejerciciosCardio = informacion.getStringArrayList("cardio");
            }
        }



        //Le damos funcionalidad a los botones VER1
        mbtn_grupo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un intent
                Intent intentVer = new Intent (Seleccion_listas_hiitTrainning.this, Lista_Ejercicios.class);
                //Pasamos información mediante bundles
                intentVer.putExtra("Ejercicio1", "Superior1");
                intentVer.putExtra("Ejercicio2", "Superior2");
                intentVer.putExtra("Ejercicio3", "Superior3");
                intentVer.putExtra("Ejercicio4", "Superior4");
                intentVer.putExtra("Ejercicio5", "Superior5");
                intentVer.putExtra("Ejercicio6", "Superior6");
                intentVer.putExtra("tipoEjercicios", "superiores");
                //Iniciamos el intent
                startActivity(intentVer);
            }
        });

        //Le damos funcionalidad a los botones VER2
        mbtn_grupo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un intent
                Intent intentVer = new Intent (Seleccion_listas_hiitTrainning.this, Lista_Ejercicios.class);
                //Pasamos información mediante bundles
                intentVer.putExtra("Ejercicio1", "Cardio1");
                intentVer.putExtra("Ejercicio2", "Cardio2");
                intentVer.putExtra("Ejercicio3", "Cardio3");
                intentVer.putExtra("Ejercicio4", "Cardio4");
                intentVer.putExtra("Ejercicio5", "Cardio5");
                intentVer.putExtra("Ejercicio6", "Cardio6");
                intentVer.putExtra("tipoEjercicios", "cardio");
                //Iniciamos el intent
                startActivity(intentVer);
            }
        });

        //Le damos funcionalidad a los botones AENTRENAR!!!
        mbtn_entrenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un intent
                Intent intentEntrenar= new Intent (Seleccion_listas_hiitTrainning.this, MainActivity.class);
                intentEntrenar.putExtra("ejerciciosSuperiores", ejerciciosSuperiores);
                intentEntrenar.putExtra("ejerciciosCardio", ejerciciosCardio);
                //Iniciamos el intent
                startActivity(intentEntrenar);
            }
        });
    }
}