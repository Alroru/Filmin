package es.studium.filmingapp;

import java.io.Serializable;

public class Serie implements Serializable {
    private final int imagen;
    private final String nombre;
    private final String director;
    private final String actor;
    private final String sinopsis;
    private final int puntuacion;
    private final String temporadas;




    public Serie(int imagen, String nombre, String director, String actor, String sinopsis, int puntuacion,String temporadas){
        this.imagen=imagen;
        this.nombre=nombre;
        this.director = director;
        this.actor = actor;
        this.sinopsis = sinopsis;
        this.puntuacion = puntuacion;
        this.temporadas=temporadas;
    }


    public String getNombre(){
        return nombre;
    }

    public int getImagen(){
        return imagen;
    }

    public String getDirector() {
        return director;
    }

    public String getActor() {
        return actor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getTemporadas() {
        return temporadas;
    }
}