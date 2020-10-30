package com.example.cronometrocountdowtimeraleman;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLite extends SQLiteOpenHelper {

    public ConexionSQLite(@Nullable Context context) {
        super(context, "entrena_peques", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USUARIO (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellidos TEXT, clave TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USUARIO");
        onCreate(db);
    }

    public void registrarUsuario(Usuario usuario){
        SQLiteDatabase base_de_datos = this.getWritableDatabase();

        String nombre = usuario.getNombre();
        String apellidos = usuario.getApellidos();
        String correo = usuario.getCorreo();
        String clave = usuario.getClave();

        String sentencia = "INSERT INTO USUARIO (nombre, apellidos, clave, email) VALUES ('"+nombre+"', '"+apellidos+"', '"+correo+"', '"+clave+"')";

        base_de_datos.execSQL(sentencia);

        base_de_datos.close();

    }


}
