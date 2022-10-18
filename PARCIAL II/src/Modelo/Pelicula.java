package Modelo;

public class Pelicula {

    private String nombrePelicula;
    private String tipo_publico;
    private String genero;
    private int durancion;
    private int  anio_lanzamiento;
    private boolean estado_pelicula;

    public Pelicula(String nombrePelicula, String tipo_publico, String genero, int durancion, int anio_lanzamiento, boolean estado_pelicula) {
        this.nombrePelicula = nombrePelicula;
        this.tipo_publico = tipo_publico;
        this.genero = genero;
        this.durancion = durancion;
        this.anio_lanzamiento = anio_lanzamiento;
        this.estado_pelicula = estado_pelicula;
    }


    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public String getTipo_publico() {
        return tipo_publico;
    }

    public String getGenero() {
        return genero;
    }

    public int getDurancion() {
        return durancion;
    }

    public int getAnio_lanzamiento() {
        return anio_lanzamiento;
    }

    public boolean isEstado_pelicula() {
        return estado_pelicula;
    }


    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }


    public void setTipo_publico(String tipo_publico) {
        this.tipo_publico = tipo_publico;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public void setDurancion(int durancion) {
        this.durancion = durancion;
    }


    public void setAnio_lanzamiento(int anio_lanzamiento) {
        this.anio_lanzamiento = anio_lanzamiento;
    }


    public void setEstado_pelicula(boolean estado_pelicula) {
        this.estado_pelicula = estado_pelicula;
    }

    
}
