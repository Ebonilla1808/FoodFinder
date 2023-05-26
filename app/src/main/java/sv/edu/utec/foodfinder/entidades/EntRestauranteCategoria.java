package sv.edu.utec.foodfinder.entidades;

public class EntRestauranteCategoria {
    private int IdRestaurante;
    private int IdCategoria;
    private int IdEspecialidad;
    private int IdMunicipio;
    private String NombreRestaurante;
    private String Horario;
    private String Contacto;
    private String SitioWeb;
    private String NombreMunicipio;
    private String DescripcionCategoria;
    private String DescripcionEspecialidad;

    private String Ubicacion;

    public int getIdRestaurante() {
        return IdRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        IdRestaurante = idRestaurante;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        IdCategoria = idCategoria;
    }

    public int getIdEspecialidad() {
        return IdEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        IdEspecialidad = idEspecialidad;
    }

    public int getIdMunicipio() {
        return IdMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        IdMunicipio = idMunicipio;
    }

    public String getNombreRestaurante() {
        return NombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        NombreRestaurante = nombreRestaurante;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String contacto) {
        Contacto = contacto;
    }

    public String getSitioWeb() {
        return SitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        SitioWeb = sitioWeb;
    }

    public String getNombreMunicipio() {
        return NombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        NombreMunicipio = nombreMunicipio;
    }

    public String getDescripcionCategoria() {
        return DescripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        DescripcionCategoria = descripcionCategoria;
    }

    public String getDescripcionEspecialidad() {
        return DescripcionEspecialidad;
    }

    public void setDescripcionEspecialidad(String descripcionEspecialidad) {
        DescripcionEspecialidad = descripcionEspecialidad;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }
}
