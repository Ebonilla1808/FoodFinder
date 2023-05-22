package sv.edu.utec.foodfinder.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class BaseHelper extends SQLiteOpenHelper {
    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASE = "FoodFinderBD.db";
    public static final String NOMBRE_TABLA_ESPECIALIDADES = "Especialidades";
    public static final String NOMBRE_TABLA_CATEGORIAS = "Categorias";
    public static final String NOMBRE_TABLA_DEPARTAMENTOS = "Departamentos";
    public static final String NOMBRE_TABLA_MUNICIPIOS = "Municipios";
    public static final String NOMBRE_TABLA_USUARIOS = "Usuarios";
    public static final String NOMBRE_TABLA_RESTAURANTES = "Restaurantes";
    public static final String NOMBRE_TABLA_COMENTARIOS = "Comentarios";

    public BaseHelper(@Nullable Context context) {
        super(context, NOMBRE_BASE, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NOMBRE_TABLA_ESPECIALIDADES + " (" +
                "IdEspecialidad INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "DescripcionEspecialidad TEXT" +
                ")");

        db.execSQL("CREATE TABLE " + NOMBRE_TABLA_CATEGORIAS + " (" +
                "IdCategoria INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "DescripcionCategoria TEXT" +
                ")");

        db.execSQL("CREATE TABLE " + NOMBRE_TABLA_DEPARTAMENTOS + " (" +
                "IdDepartamento INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "NombreDepartamento TEXT" +
                ")");

        db.execSQL("CREATE TABLE " + NOMBRE_TABLA_MUNICIPIOS + " (" +
                "IdMunicipio INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "IdDepartamento INTEGER ," +
                "NombreMunicipio TEXT" +
                ")");

        db.execSQL("CREATE TABLE " + NOMBRE_TABLA_USUARIOS + " (" +
                "IdUsuario INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "Nombres TEXT," +
                "Apellidos TEXT," +
                "Correo TEXT," +
                "Telefono TEXT," +
                "Usuario TEXT," +
                "Contrasenia TEXT," +
                "TipoUsuario TEXT" +
                ")");

        db.execSQL("CREATE TABLE " + NOMBRE_TABLA_RESTAURANTES + " (" +
                "IdRestaurante INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "IdEspecialidad INTEGER ," +
                "IdCategoria INTEGER ," +
                "NombreRestaurante, "+
                "SitioWeb TEXT," +
                "IdMunicipio INTEGER ," +
                "HoraApertura TEXT," +
                "HoraCierre TEXT," +
                "DiasAtencion TEXT," +
                "Contacto TEXT" +
                ")");

        db.execSQL("CREATE TABLE " + NOMBRE_TABLA_COMENTARIOS + " (" +
                "IdComentario INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "IdUsuario INTEGER ," +
                "IdRestaurante INTEGER ," +
                "Calificacion INTEGER ," +
                "Opinion TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA_ESPECIALIDADES);
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA_CATEGORIAS);
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA_DEPARTAMENTOS);
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA_MUNICIPIOS);
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA_RESTAURANTES);
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA_COMENTARIOS);

        onCreate(db);
    }
}
