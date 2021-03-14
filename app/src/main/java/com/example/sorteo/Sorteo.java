package com.example.sorteo;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
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
