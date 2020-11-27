package com.example.cronometrocountdowtimeraleman.modelo;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SesionesEnt { //CLASE POJO (Plain Old Java Object)

    //Campos de clase de la tabla sesiones entrenamiento

    private String fecha;
    private String nombreEjercicio;
    private String tipoEjercicio;

    //Constructor vacío por defecto
    public SesionesEnt() {

    }

    //Métodos setter y getter de todos los campos de clase

    public String getFecha() {

        //TODO: Conversión formato fecha

        SimpleDateFormat conver = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat conver2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = null;

        String nuevoFormato = null;

        try {
            date = conver.parse(this.fecha);
        } catch (ParseException e) {
            Log.e("Error", "Error en fecha");
        }

        //Para convertir de Date a String, usamos lo siguiente:

        try {

            nuevoFormato = conver2.format(date.getTime());
        } catch (Exception ex) {
            Log.e("ERROR", "CONVERTIR FECHA A TEXTO");
        }

        return nuevoFormato;

    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }
}
