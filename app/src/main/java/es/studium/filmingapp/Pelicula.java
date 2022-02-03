package es.studium.filmingapp;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private final int imagen;
    private final String nombre;


    public Pelicula(int imagen,String nombre){
        this.imagen=imagen;
        this.nombre=nombre;

    }

    public String getNombre(){return nombre;}
    public int getImagen(){return imagen;}
}

