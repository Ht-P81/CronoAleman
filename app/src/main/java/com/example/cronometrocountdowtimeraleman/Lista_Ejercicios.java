package com.example.cronometrocountdowtimeraleman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Lista_Ejercicios extends AppCompatActivity {

    //Declaración de variables
    TextView tituloEjercicio;
    CheckBox Ejercicio1;
    CheckBox Ejercicio2;
    CheckBox Ejercicio3;
    CheckBox Ejercicio4;
    CheckBox Ejercicio5;
    CheckBox Ejercicio6;
    Button botonAceptar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ejercicios);

        //Mapeamos las variables con las vistas de la actividad
        tituloEjercicio = findViewById(R.id.TV_listaEjercicios);
        Ejercicio1 = findViewById(R.id.CB_Ejercicio1);
        Ejercicio2 = findViewById(R.id.CB_Ejercicio2);
        Ejercicio3 = findViewById(R.id.CB_Ejercicio3);
        Ejercicio4 = findViewById(R.id.CB_Ejercicio4);
        Ejercicio5 = findViewById(R.id.CB_Ejercicio5);
        Ejercicio6 = findViewById(R.id.CB_Ejercicio6);
        botonAceptar = findViewById(R.id.btn_Aceptar);

    }
}