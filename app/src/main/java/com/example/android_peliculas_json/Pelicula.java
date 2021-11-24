package com.example.android_peliculas_json;

public class Pelicula {

    private String portada, titulo, descripcion;
    private Double puntuacion;

    public Pelicula(String portada, String titulo, Double puntuacion, String descripcion) {
        this.portada = portada;
        this.titulo = titulo;
        this.puntuacion = puntuacion;
        this.descripcion = descripcion;
    }

    public String getPortada() {
        return portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
