package sv.edu.utec.foodfinder.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import sv.edu.utec.foodfinder.ViewModel.RestaurantesViewModel;

public class Restaurantes extends BaseHelper{
    public Restaurantes(@Nullable Context context) {
        super(context);
    }


    public ArrayList<RestaurantesViewModel> obtenerListaRestaurantes(int idCategoria) {
        BaseHelper baseHelp = new BaseHelper(context);
        SQLiteDatabase bd = baseHelp.getWritableDatabase();
        ArrayList<RestaurantesViewModel> listaRestaurantes = new ArrayList<>();
        RestaurantesViewModel restaurante = null;
        Cursor cursorUsuarios;

        String consulta = "SELECT r.IdRestaurante, r.NombreRestaurante, " +
                "(r.DiasAtencion || ' de ' || r.HoraApertura || ' a ' || r.HoraCierre) as Horario, " +
                "r.Contacto, m.NombreMunicipio, c.DescripcionCategoria, e.DescripcionEspecialidad, " +
                "c.IdCategoria, e.IdEspecialidad, m.IdMunicipio "+
                "FROM Restaurantes r " +
                "INNER JOIN Categorias c ON c.IdCategoria = r.IdCategoria " +
                "INNER JOIN Especialidades e ON e.IdEspecialidad = r.IdEspecialidad " +
                "INNER JOIN Municipios m ON m.IdMunicipio = r.IdMunicipio " +
                "WHERE c.IdCategoria = ?";

        cursorUsuarios = bd.rawQuery(consulta, new String[] { String.valueOf(idCategoria) });

        if (cursorUsuarios.moveToFirst()) {
            do {
                restaurante = new RestaurantesViewModel();
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
                listaRestaurantes.add(restaurante);
            } while (cursorUsuarios.moveToNext());
        }
        cursorUsuarios.close();
        return listaRestaurantes;
    }

}
