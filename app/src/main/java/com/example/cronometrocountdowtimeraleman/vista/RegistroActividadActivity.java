package com.example.cronometrocountdowtimeraleman.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.cronometrocountdowtimeraleman.R;
import com.example.cronometrocountdowtimeraleman.controlador.ConexionSQLite;
import com.example.cronometrocountdowtimeraleman.modelo.*;

import java.util.ArrayList;

public class RegistroActividadActivity extends AppCompatActivity {

    private TableLayout tlTabla;
    private TableRow fila;
    private TextView tvUsuario, tvIdEjercicio, tvFecha;
    private ArrayList<SesionesEnt> listaSesiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_actividad);

        //Obtener el ID de usuario

        SharedPreferences preferencias = getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);

        int id_Usuario = preferencias.getInt("usuarioId", 0); //Lo utilizaremos en el WHERE de la query SQL

        listaSesiones = new ArrayList<>();

        SesionesEnt sesion;

        ConexionSQLite conexion = new ConexionSQLite(this);

        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] parametros = {String.valueOf(id_Usuario)};

        String query = "SELECT E.nombreEjercicio, E.tipoEjercicio, S.fechahora FROM Ejercicio E, Sesion S WHERE E.id = S.idEjercicio AND S.idUsuario = ?";

        Cursor cursor = db.rawQuery(query,parametros);

        while(cursor.moveToNext()){
            sesion = new SesionesEnt();
            sesion.setNombreEjercicio(cursor.getString(0));
            sesion.setTipoEjercicio(cursor.getString(1));
            sesion.setFecha(cursor.getString(2));

            listaSesiones.add(sesion);
        }


        tlTabla = findViewById(R.id.tlTabla);



        //Aquí irá un método que obtendrá la información de la base de datos
        //método provisianal hardcodeado


        //Crear modelo para las filas y columnas
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);


        //Rellenar la tabla
        for (int i = -1; i < listaSesiones.size(); i++) {
            fila = new TableRow(this);
            fila.setLayoutParams(layoutFila);

            if(i == -1){//Fila cabecera
                tvUsuario = new TextView(this);
                tvUsuario.setText("NOMBRE EJERCICIO");
                tvUsuario.setGravity(Gravity.CENTER);
                tvUsuario.setBackgroundColor(Color.BLUE);
                tvUsuario.setTextColor(Color.WHITE);
                tvUsuario.setPadding(10, 10, 10, 10);
                tvUsuario.setLayoutParams(layoutFila);
                fila.addView(tvUsuario);

                tvIdEjercicio = new TextView(this);
                tvIdEjercicio.setText("TIPO EJERCICIO");
                tvIdEjercicio.setGravity(Gravity.CENTER);
                tvIdEjercicio.setBackgroundColor(Color.BLUE);
                tvIdEjercicio.setTextColor(Color.WHITE);
                tvIdEjercicio.setPadding(10, 10, 10, 10);
                tvIdEjercicio.setLayoutParams(layoutFila);
                fila.addView(tvIdEjercicio);

                tvFecha = new TextView(this);
                tvFecha.setText("FECHA Y HORA");
                tvFecha.setGravity(Gravity.CENTER);
                tvFecha.setBackgroundColor(Color.BLUE);
                tvFecha.setTextColor(Color.WHITE);
                tvFecha.setPadding(10, 10, 10, 10);
                tvFecha.setLayoutParams(layoutFila);
                fila.addView(tvFecha);

                tlTabla.addView(fila);
            }else{

                tvUsuario = new TextView(this);
                tvUsuario.setText(String.valueOf(listaSesiones.get(i).getNombreEjercicio()));
                tvUsuario.setPadding(10, 10, 10, 10);
                tvUsuario.setLayoutParams(layoutFila);
                fila.addView(tvUsuario);

                tvIdEjercicio = new TextView(this);
                tvIdEjercicio.setText(String.valueOf(listaSesiones.get(i).getTipoEjercicio()));
                tvIdEjercicio.setPadding(10, 10, 10, 10);
                tvIdEjercicio.setGravity(Gravity.CENTER);
                tvIdEjercicio.setLayoutParams(layoutFila);
                fila.addView(tvIdEjercicio);

                tvFecha = new TextView(this);
                tvFecha.setText(listaSesiones.get(i).getFecha());
                tvFecha.setPadding(10, 10, 10, 10);
                tvFecha.setGravity(Gravity.CENTER);
                tvFecha.setLayoutParams(layoutFila);
                fila.addView(tvFecha);

                tlTabla.addView(fila);

            }
        }
    }
}