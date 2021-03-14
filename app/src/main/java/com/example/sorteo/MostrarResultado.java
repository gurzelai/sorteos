package com.example.sorteo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MostrarResultado extends AppCompatActivity {

    ListView lvGanadores;
    AdaptadorNuevo adaptador;
    Button inicio;

    List<Participante> ganadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_resultado);
        ganadores = new ArrayList<>();

        String ganadoresString = getIntent().getStringExtra("ganadores");
        String ganadoresDiv [] = ganadoresString.split("[ ]");
        for(String s :ganadoresDiv){
            ganadores.add(new Participante(s));
        }
        adaptador = new AdaptadorNuevo(this, R.layout.list_adaptadornuevo, (ArrayList<Participante>) ganadores);
        lvGanadores = (ListView) findViewById(R.id.lvGanadores);
        lvGanadores.setAdapter(adaptador);
        inicio = (Button) findViewById(R.id.inicio);
        inicio.setOnClickListener(view -> acabarInstancia());
    }

    private void acabarInstancia() {
        finish();
    }

}