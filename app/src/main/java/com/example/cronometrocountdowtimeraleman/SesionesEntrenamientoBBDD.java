package com.example.cronometrocountdowtimeraleman;

import java.util.Date;

public class SesionesEntrenamientoBBDD { //CLASE POJO (Plain Old Java Object)

    //Campos de clase de la tabla sesiones entrenamiento
    private int id;
    private String nombreUsuario;
    private Date fecha;
    private String ejercicio;

    //Constructor vacío por defecto
    public SesionesEntrenamientoBBDD(){

    }

    //Métodos setter y getter de todos los campos de clase

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }
}
