package sv.edu.utec.foodfinder.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import sv.edu.utec.foodfinder.entidades.EntCategorias;

public class Categorias extends BaseHelper{
    public Categorias(@Nullable Context context) {
        super(context);
    }


    public ArrayList<EntCategorias> obtenerCategorias() {
        BaseHelper baseHelp = new BaseHelper(context);
        SQLiteDatabase bd = baseHelp.getWritableDatabase();
        ArrayList<EntCategorias> listaCategorias = new ArrayList<>();
        EntCategorias entCategoria = null;
        Cursor cursorUsuarios;

        cursorUsuarios = bd.rawQuery("SELECT * FROM " + NOMBRE_TABLA_CATEGORIAS, null);
        if (cursorUsuarios.moveToFirst()) {
            do {
                entCategoria = new EntCategorias();
                entCategoria.setIdCtegoria(cursorUsuarios.getInt(0));
                entCategoria.setDescripcion(cursorUsuarios.getString(1));
                listaCategorias.add(entCategoria);
            } while (cursorUsuarios.moveToNext());
        }
        cursorUsuarios.close();
        return listaCategorias;
    }
}
