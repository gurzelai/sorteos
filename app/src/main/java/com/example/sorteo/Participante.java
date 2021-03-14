package com.example.sorteo;

public class Participante {

    String nombre;

    @Override
    public String toString() {
        return nombre+" ";
    }

    public Participante(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
