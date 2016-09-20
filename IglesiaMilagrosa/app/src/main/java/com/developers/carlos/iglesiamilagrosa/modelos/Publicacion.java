package com.developers.carlos.iglesiamilagrosa.modelos;

/**
 * Created by carlos on 08/09/16.
 */
public class Publicacion {

    private String titulo;
    private String fecha;
    private String descripcion;
    private boolean favorito;
    private int imagen;

    public Publicacion() {
    }

    public Publicacion(String titulo, String fecha, String descripcion, boolean favorito, int imagen) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.favorito = favorito;
        this.imagen = imagen;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
