package com.gurzelai.sorteo;

import java.util.ArrayList;
import java.util.List;

public class Sencillo extends Sorteo {

    int cantPremios;
    List<Participante> ganadores;

    public Sencillo(List<Participante> participantes, boolean ordenados) {
        super(participantes, ordenados);
        ganadores = new ArrayList<Participante>();
        cantPremios = 2;
    }

    @Override
    protected List<Participante> getGanadores() {
        return ganadores;
    }

    @Override
    protected void realizarSorteo() {
        for (int i = 0; i < (Math.min(cantPremios, participantes.size())); i++) {
            ganadores.add(participantes.get(i));
        }
    }
}
