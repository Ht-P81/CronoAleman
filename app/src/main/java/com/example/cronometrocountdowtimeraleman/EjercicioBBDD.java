package com.example.cronometrocountdowtimeraleman;

public class EjercicioBBDD { //CLASE POJO (Plain Old Java Object)

    //Campos de clase que tendrá nuestra tabla Ejercicio BBDD
    private int id;
    private String nombre;
    private String tipo;

    //Creamos constructor por defecto
    public EjercicioBBDD(){

    }

    //Creamos setter y getters de todos los campos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
