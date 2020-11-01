package com.example.cronometrocountdowtimeraleman;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class ConexionSQLite extends SQLiteOpenHelper {

    //Creamos el constructor SQLiteHelper (abstracto)
    public ConexionSQLite(@Nullable Context context) {
        super(context, "entrena_peques", null, 1);
    }

    //Implementamos (sobreescribimos) los métodos que nos obliga SQLiteHelper (abstracta)
    // a implementar y a desarrollar adaptandolo a nuestra necesidades
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USUARIO (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellidos TEXT, clave TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //en caso de actuliazación de nuestra BBDD que borre y cree de nuevo para actualizar
        db.execSQL("DROP TABLE IF EXISTS USUARIO");
        onCreate(db);
    }

    //Nos creamos este método con el que poder hacer los INSERT en nuestra consulta
    public void registrarUsuario(UsuarioBBDD usuarioBBDD){

        //Escribimos en nuestraBBDD
        SQLiteDatabase base_de_datos = this.getWritableDatabase();

        //Creamos estas variables que asosciamos para escribir la información
        // TODO: ¿Porqué aquí no necesitamos instanciar al objeto usuario?
        //  Usuario nuevoUsuario = new Usuario(); Fijate en el parámetro del método, duda resuelta
        String nombre = usuarioBBDD.getNombre();
        String apellidos = usuarioBBDD.getApellidos();
        String correo = usuarioBBDD.getCorreo();
        String clave = usuarioBBDD.getClave();

        //Guardamos toda la información una sentencia
        String sentencia = "INSERT INTO USUARIO (nombre, apellidos, clave, email) VALUES ('"+nombre+"', '"+apellidos+"', '"+correo+"', '"+clave+"')";

        //Ejecutamos la sentencia albergada en el string sentencia
        base_de_datos.execSQL(sentencia);

        //Cerramos nuestra bases de datos
        base_de_datos.close();
    }

    //Creamos métodos ejercicio (id, nombre, tipo).
    public void registrarEjercicio(EjercicioBBDD ejercicioBBDD){

        //Escribimos en nuestraBBDD
        SQLiteDatabase base_de_datos = this.getWritableDatabase();

        //Creamos estas variables que asociamos para escribir información
        String nombre = ejercicioBBDD.getNombre();
        String tipo = ejercicioBBDD.getTipo();

        //Guardamos la información en una sentencia
        String sentencia = "INSERT INTO EJERCICIO (nombre, tipo) VALUES ('"+nombre+"','"+tipo+"')";

        //Ejecutamos la sentencia mediante el método
        base_de_datos.execSQL(sentencia);

        //Cerramos nuestra bases de datos
        base_de_datos.close();
    }

    //Creamos metodo registro (usuario, dia, ejercicio).
    public void sesionesEntrenos (SesionesEntrenamientoBBDD sesionesEntrenamientoBBDD){

        //Escribimos en nuestra BBDD
        SQLiteDatabase base_de_datos = this.getWritableDatabase();

        //Creamos estas variables que asociamos para escribir información
        String nombreUsuario = sesionesEntrenamientoBBDD.getNombreUsuario();
        Date fechaentreno = sesionesEntrenamientoBBDD.getFecha();
        String ejercicio = sesionesEntrenamientoBBDD.getEjercicio();

        //Guardamos la información en una sentencia
        String sentencia = "INSERT INTO EJERCICIO (nombre, tipo) VALUES ('"+nombreUsuario+"','"
                +fechaentreno+"','"+ejercicio+"')";

        //Ejecutamos la sentencia mediante el método
        base_de_datos.execSQL(sentencia);

        //Cerramos nuestra bases de datos
        base_de_datos.close();
    }
}
