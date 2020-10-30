package com.example.cronometrocountdowtimeraleman;

public class Usuario { //CLASE POJO (Plain Old Java Object)

    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String clave;


    public Usuario(){
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
