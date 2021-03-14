package com.gurzelai.sorteo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaSorteos implements Serializable {

    List<Sorteo> guardados;
    List<Sorteo> listaSorteos;
    Sorteo actual;

    public ListaSorteos() {
        listaSorteos = new ArrayList<>();
        guardados = new ArrayList<>();
    }
}
