package com.example.android_peliculas_json;

public class Pelicula {

    private String portada, titulo, descripcion;
    private Double puntuacion;

    public Pelicula(String portada, String titulo, String descripcion, Double puntuacion) {
        this.portada = portada;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
    }

    public String getPortada() {
        return portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }
}
