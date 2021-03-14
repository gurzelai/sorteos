package com.gurzelai.sorteo;

import java.util.List;

public abstract class Sorteo {

    boolean ordenados;
    String nombre, descripcion;
    List<Participante> participantes;

    public Sorteo(List<Participante> participantes, boolean ordenados) {
        this.participantes = participantes;
        this.ordenados = ordenados;
        nombre = "";
        descripcion = "";
    }
    protected abstract List<Participante> getGanadores();
    protected abstract void realizarSorteo();

}
