package com.example.cronometrocountdowtimeraleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Lista_Ejercicios extends AppCompatActivity {

    //Declaración de variables
    TextView tituloEjercicio;
    CheckBox ejercicio1;
    CheckBox ejercicio2;
    CheckBox ejercicio3;
    CheckBox ejercicio4;
    CheckBox ejercicio5;
    CheckBox ejercicio6;
    Button botonAceptar;
    ArrayList <String> nombreEjercicios;
    ArrayList<CheckBox> checkBoxes;
    String tipoEjercicios;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ejercicios);

        nombreEjercicios = new ArrayList<>();
        checkBoxes = new ArrayList<>();

        //Mapeamos las variables con las vistas de la actividad
        tituloEjercicio = findViewById(R.id.TV_listaEjercicios);
        ejercicio1 = findViewById(R.id.CB_Ejercicio1);
        ejercicio2 = findViewById(R.id.CB_Ejercicio2);
        ejercicio3 = findViewById(R.id.CB_Ejercicio3);
        ejercicio4 = findViewById(R.id.CB_Ejercicio4);
        ejercicio5 = findViewById(R.id.CB_Ejercicio5);
        ejercicio6 = findViewById(R.id.CB_Ejercicio6);
        botonAceptar = findViewById(R.id.btn_Aceptar);

        //Recepcionamos el bundle envíado desde el activity_main
        Bundle informacion = getIntent().getExtras();

        //Creamos la variable para albergar la información mediante el key (SUPERIORES)
        String nombreEjercicio1 = informacion.getString("Ejercicio1");
        String nombreEjercicio2 = informacion.getString("Ejercicio2");
        String nombreEjercicio3 = informacion.getString("Ejercicio3");
        String nombreEjercicio4 = informacion.getString("Ejercicio4");
        String nombreEjercicio5 = informacion.getString("Ejercicio5");
        String nombreEjercicio6 = informacion.getString("Ejercicio6");
        tipoEjercicios = informacion.getString("tipoEjercicios");

        //Si la información que enviamos no está vacía, entonces que ponga el texto enviado (SUPERIORES)
        if(nombreEjercicio1!=null) {

            //Le colocamos nombre a los ejercicios de la actividad
            ejercicio1.setText(nombreEjercicio1);
            ejercicio2.setText(nombreEjercicio2);
            ejercicio3.setText(nombreEjercicio3);
            ejercicio4.setText(nombreEjercicio4);
            ejercicio5.setText(nombreEjercicio5);
            ejercicio6.setText(nombreEjercicio6);

            checkBoxes.add(ejercicio1);
            checkBoxes.add(ejercicio2);
            checkBoxes.add(ejercicio3);
            checkBoxes.add(ejercicio4);
            checkBoxes.add(ejercicio5);
            checkBoxes.add(ejercicio6);
        }

        //con este bón envíamos información desde esta actividad al mainActivity(CRONOMETROS)
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i = 0; i < checkBoxes.size(); i++){
                    if(checkBoxes.get(i).isChecked()){
                        nombreEjercicios.add(checkBoxes.get(i).getText().toString());
                    }
                }

                //Creamos el intent dentro del onclick del botón Aceptar
                Intent intentAceptar = new Intent (Lista_Ejercicios.this, Seleccion_listas_hiitTrainning.class);

                //bundles para enviar información de los ejercicios
                intentAceptar.putExtra(tipoEjercicios, nombreEjercicios);


                //Iniciamos el intent
                startActivity(intentAceptar);
            }
        });

    }
}