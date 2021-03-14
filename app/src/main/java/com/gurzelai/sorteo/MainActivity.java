package com.gurzelai.sorteo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final public static String EXTRA_TIPO_SORTEO = "Tipo de sorteo grupos / sencillo";
    public static final String SORTEOS = "Lista de sorteos";

    Button btnAyuda, btnSimples, btnGrupos, btnGuardados, btnReales;

    ListaSorteos sorteos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAyuda = (Button) findViewById(R.id.atras);
        btnAyuda.setOnClickListener(view -> abrirIntentAyuda());
        btnSimples = (Button) findViewById(R.id.añadir);
        btnSimples.setOnClickListener(view -> abrirIntentCreacion("sencillo"));
        btnGrupos = (Button) findViewById(R.id.btnGrupos);
        btnGrupos.setOnClickListener(view -> abrirIntentCreacion("grupos"));
        btnGuardados = (Button) findViewById(R.id.btnGuardados);
        btnReales = (Button) findViewById(R.id.btnReales);

        sorteos = new ListaSorteos();
    }

    private void abrirIntentAyuda() {
        Intent intent = new Intent(this, Ayuda.class);
        startActivity(intent);
    }

    private void abrirIntentCreacion(String s) {
        Intent intent = new Intent(this, Nuevo.class);
        intent.putExtra(MainActivity.EXTRA_TIPO_SORTEO,s);
        startActivity(intent);
    }
}