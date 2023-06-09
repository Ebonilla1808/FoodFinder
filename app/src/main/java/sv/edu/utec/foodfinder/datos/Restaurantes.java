package sv.edu.utec.foodfinder.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import sv.edu.utec.foodfinder.entidades.EntRestauranteCategoria;

public class Restaurantes extends BaseHelper{
    public Restaurantes(@Nullable Context context) {
        super(context);
    }

    public ArrayList<EntRestauranteCategoria> obtenerListaRestaurantes(int idCategoria) {
        BaseHelper baseHelp = new BaseHelper(context);
        SQLiteDatabase bd = baseHelp.getWritableDatabase();
        ArrayList<EntRestauranteCategoria> listaRestaurantes = new ArrayList<>();
        EntRestauranteCategoria restaurante = null;
        Cursor cursorUsuarios;

        String consulta = "SELECT r.IdRestaurante, r.NombreRestaurante, " +
                "(r.DiasAtencion || ' de ' || r.HoraApertura || ' a ' || r.HoraCierre) as Horario, " +
                "r.Contacto, m.NombreMunicipio, c.DescripcionCategoria, e.DescripcionEspecialidad, " +
                "c.IdCategoria, e.IdEspecialidad, m.IdMunicipio, r.SitioWeb "+
                "FROM Restaurantes r " +
                "INNER JOIN Categorias c ON c.IdCategoria = r.IdCategoria " +
                "INNER JOIN Especialidades e ON e.IdEspecialidad = r.IdEspecialidad " +
                "INNER JOIN Municipios m ON m.IdMunicipio = r.IdMunicipio " +
                "WHERE c.IdCategoria = ?";

        cursorUsuarios = bd.rawQuery(consulta, new String[] { String.valueOf(idCategoria) });

        if (cursorUsuarios.moveToFirst()) {
            do {
                restaurante = new EntRestauranteCategoria();
                restaurante.setIdRestaurante(cursorUsuarios.getInt(0));
                restaurante.setNombreRestaurante(cursorUsuarios.getString(1));
                restaurante.setHorario(cursorUsuarios.getString(2));
                restaurante.setContacto(cursorUsuarios.getString(3));
                restaurante.setNombreMunicipio(cursorUsuarios.getString(4));
                restaurante.setDescripcionCategoria(cursorUsuarios.getString(5));
                restaurante.setDescripcionEspecialidad(cursorUsuarios.getString(6));
                restaurante.setIdCategoria(cursorUsuarios.getInt(7));
                restaurante.setIdEspecialidad(cursorUsuarios.getInt(8));
                restaurante.setIdMunicipio(cursorUsuarios.getInt(9));
                restaurante.setSitioWeb(cursorUsuarios.getString(10));
                listaRestaurantes.add(restaurante);
            } while (cursorUsuarios.moveToNext());
        }
        cursorUsuarios.close();
        return listaRestaurantes;
    }

    public ArrayList<EntRestauranteCategoria> obtenerRestauranteNombre(String nombreRestaurante, String nombreMunicipio) {
        BaseHelper baseHelp = new BaseHelper(context);
        SQLiteDatabase bd = baseHelp.getWritableDatabase();
        ArrayList<EntRestauranteCategoria> listaRestaurantes = new ArrayList<>();
        EntRestauranteCategoria restaurante = null;
        Cursor cursorUsuarios;

        String consulta = "SELECT r.IdRestaurante, r.NombreRestaurante, " +
                "(r.DiasAtencion || ' de ' || r.HoraApertura || ' a ' || r.HoraCierre) as Horario, " +
                "r.Contacto, m.NombreMunicipio, c.DescripcionCategoria, e.DescripcionEspecialidad, " +
                "c.IdCategoria, e.IdEspecialidad, m.IdMunicipio, r.SitioWeb, r.Ubicacion "+
                "FROM Restaurantes r " +
                "INNER JOIN Categorias c ON c.IdCategoria = r.IdCategoria " +
                "INNER JOIN Especialidades e ON e.IdEspecialidad = r.IdEspecialidad " +
                "INNER JOIN Municipios m ON m.IdMunicipio = r.IdMunicipio " +
                "WHERE r.NombreRestaurante = ? AND m.NombreMunicipio = ?";

        cursorUsuarios = bd.rawQuery(consulta, new String[]{nombreRestaurante, nombreMunicipio});
        if (cursorUsuarios.moveToFirst()) {
            do {
                restaurante = new EntRestauranteCategoria();
                restaurante.setIdRestaurante(cursorUsuarios.getInt(0));
                restaurante.setNombreRestaurante(cursorUsuarios.getString(1));
                restaurante.setHorario(cursorUsuarios.getString(2));
                restaurante.setContacto(cursorUsuarios.getString(3));
                restaurante.setNombreMunicipio(cursorUsuarios.getString(4));
                restaurante.setDescripcionCategoria(cursorUsuarios.getString(5));
                restaurante.setDescripcionEspecialidad(cursorUsuarios.getString(6));
                restaurante.setIdCategoria(cursorUsuarios.getInt(7));
                restaurante.setIdEspecialidad(cursorUsuarios.getInt(8));
                restaurante.setIdMunicipio(cursorUsuarios.getInt(9));
                restaurante.setSitioWeb(cursorUsuarios.getString(10));
                restaurante.setUbicacion(cursorUsuarios.getString(11));
                listaRestaurantes.add(restaurante);
            } while (cursorUsuarios.moveToNext());
        }
        cursorUsuarios.close();
        return listaRestaurantes;
    }

}
