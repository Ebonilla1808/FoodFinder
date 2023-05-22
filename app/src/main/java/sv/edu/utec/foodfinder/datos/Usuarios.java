package sv.edu.utec.foodfinder.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import sv.edu.utec.foodfinder.entidades.EntUsuarios;

public class Usuarios extends BaseHelper {

    public Usuarios(@Nullable Context context) {
        super(context);
        //this.context = context;
    }

    /*
     * Métodos CRUD para la tabla de usuarios
     */

    // Insertar un nuevo usuario en la tabla de usuarios
    public long insertUsuario(String Nombres, String Apellidos, String Correo, String Telefono, String Usuario, String Contrasenia, String TipoUsuario) {
        long codigo = 0;

        try {
            BaseHelper baseHelp = new BaseHelper(context);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues valoresUsuario = new ContentValues();
            valoresUsuario.put("Nombres", Nombres);
            valoresUsuario.put("Apellidos", Apellidos);
            valoresUsuario.put("Correo", Correo);
            valoresUsuario.put("Telefono", Telefono);
            valoresUsuario.put("Usuario", Usuario);
            valoresUsuario.put("Contrasenia", Contrasenia);
            valoresUsuario.put("TipoUsuario", TipoUsuario);

            codigo = bd.insert(NOMBRE_TABLA_USUARIOS, null, valoresUsuario);
            return codigo;
        } catch (Exception ex) {
            ex.toString();
            return codigo = 0;
        }
    }

    // Obtener la lista de usuarios
    public ArrayList<EntUsuarios> mostrarUsuarios() {
        BaseHelper baseHelp = new BaseHelper(context);
        SQLiteDatabase bd = baseHelp.getWritableDatabase();
        ArrayList<EntUsuarios> listaUsuarios = new ArrayList<>();
        EntUsuarios entUsuarios = null;
        Cursor cursorUsuarios;

        cursorUsuarios = bd.rawQuery("SELECT IdUsuario, Nombres, Apellidos, Correo, Telefono, Usuario, Contrasenia, TipoUsuario FROM " + NOMBRE_TABLA_USUARIOS, null);
        if (cursorUsuarios.moveToFirst()) {
            do {
                entUsuarios = new EntUsuarios();
                entUsuarios.setIdUsuario(cursorUsuarios.getInt(0));
                entUsuarios.setNombre(cursorUsuarios.getString(1));
                entUsuarios.setApellido(cursorUsuarios.getString(2));
                entUsuarios.setCorreo(cursorUsuarios.getString(3));
                entUsuarios.setTelefono(cursorUsuarios.getString(4));
                entUsuarios.setNombreUsuario(cursorUsuarios.getString(5));
                entUsuarios.setContraseña(cursorUsuarios.getString(6));
                entUsuarios.setTipoUsuario(cursorUsuarios.getString(7));
                listaUsuarios.add(entUsuarios);
            } while (cursorUsuarios.moveToNext());
        }
        cursorUsuarios.close();
        return listaUsuarios;
    }

    // Actualizar un usuario existente
    public int actualizarUsuario(int IdUsuario, String Nombres, String Apellidos, String Correo, String Telefono, String Usuario, String Contrasenia, String TipoUsuario) {
        BaseHelper baseHelp = new BaseHelper(context);
        SQLiteDatabase bd = baseHelp.getWritableDatabase();

        ContentValues valoresUsuario = new ContentValues();
        valoresUsuario.put("Nombres", Nombres);
        valoresUsuario.put("Apellidos", Apellidos);
        valoresUsuario.put("Correo", Correo);
        valoresUsuario.put("Telefono", Telefono);
        valoresUsuario.put("Usuario", Usuario);
        valoresUsuario.put("Contrasenia", Contrasenia);
        valoresUsuario.put("TipoUsuario", TipoUsuario);

        return bd.update(NOMBRE_TABLA_USUARIOS, valoresUsuario, "IdUsuario=?", new String[]{String.valueOf(IdUsuario)});
    }

    // Eliminar un usuario existente
    public int eliminarUsuario(int IdUsuario) {
        BaseHelper baseHelp = new BaseHelper(context);
        SQLiteDatabase bd = baseHelp.getWritableDatabase();

        return bd.delete(NOMBRE_TABLA_USUARIOS, "IdUsuario=?", new String[]{String.valueOf(IdUsuario)});
    }

    // Iniciar sesión y verificar las credenciales de usuario retorna un bool
    public boolean iniciarSesion(String usuario, String contrasenia) {
        BaseHelper baseHelp = new BaseHelper(context);
        SQLiteDatabase bd = baseHelp.getReadableDatabase();

        String[] columnas = {"Usuario"};
        String seleccion = "Usuario=? AND Contrasenia=?";
        String[] argumentos = {usuario, contrasenia};

        Cursor cursor = bd.query(NOMBRE_TABLA_USUARIOS, columnas, seleccion, argumentos, null, null, null);

        boolean existeUsuario = cursor.getCount() > 0;
        cursor.close();

        return existeUsuario;
    }
}


