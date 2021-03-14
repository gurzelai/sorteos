package com.gurzelai.sorteo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Nuevo extends AppCompatActivity {

    public static final String EXTRA_SORTEO = "El sorteo recien creado";

    ArrayList<Participante> participantes = new ArrayList<Participante>();

    boolean tipoSencillo;
    ListView lvParticipantes;
    Button atras, siguiente;
    FloatingActionButton btnAnadir;
    EditText nombre;
    AdaptadorNuevo adaptador;
    RadioButton restablecer;
    CheckBox ordenados;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        setTitle("Nuevo sorteo");

        //EXTRAS
        tipoSencillo  = getIntent().getExtras().getString(MainActivity.EXTRA_TIPO_SORTEO).equals("sencillo");

        //LAYOUT
        participantes = new ArrayList<>();
        adaptador = new AdaptadorNuevo(this, R.layout.list_adaptadornuevo, participantes);
        lvParticipantes = (ListView) findViewById(R.id.lvParticipantes);
        lvParticipantes.setAdapter(adaptador);
        atras = (Button) findViewById(R.id.atras);
        atras.setOnClickListener( view -> finish());
        siguiente = (Button) findViewById(R.id.siguiente);
        siguiente.setOnClickListener(view -> realizarSorteo());
        btnAnadir = (FloatingActionButton) findViewById(R.id.btnañadir);
        nombre = (EditText) findViewById(R.id.nombreNuevo);
        agregarConBotonTeclado();
        btnAnadir.setOnClickListener(view -> crearNuevoParticipante());
        restablecer = (RadioButton) findViewById(R.id.radRes);
        restablecer.setOnClickListener(view -> restablecerPagina());
        adaptador.notifyDataSetChanged();
        ordenados = (CheckBox) findViewById(R.id.checkOrdenados);
        //setVisibilidad();
        participantes.add(new Participante("Gorka"));
        participantes.add(new Participante("Mikel"));
        participantes.add(new Participante("Peio"));
        participantes.add(new Participante("Miren"));
    }

    private void realizarSorteo() {
        Sorteo s = null;
        if(tipoSencillo) {
            s = new Sencillo(participantes, ordenados.isChecked());
        }
        abrirIntentSortear(s);
    }
    private void abrirIntentSortear(Sorteo s) {
        Intent intent = new Intent(this, MostrarResultado.class);
        intent.putExtra("ganadores", s.getGanadores().toString());
        intent.putExtra("tipo",tipoSencillo);
        startActivity(intent);
    }


    private void crearNuevoParticipante() {
        if(!nombre.getText().toString().equals("")) {
            participantes.add(new Participante(nombre.getText().toString()));
            nombre.setText("");
            //nombre.clearFocus();
        }
        adaptador.notifyDataSetChanged();
    }

    private void agregarConBotonTeclado() {
        nombre.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    crearNuevoParticipante();
                    handled = true;
                }
                return handled;
            }
        });
    }
    private void setVisibilidad() {
        if(tipoSencillo){
            ordenados.setVisibility(View.INVISIBLE);
        }
        else{
            ordenados.setVisibility(View.VISIBLE);
        }
    }

    private void restablecerPagina() {
        participantes.clear();
        adaptador.notifyDataSetChanged();
        restablecer.setChecked(false);
        restablecer.clearFocus();
    }

    public void quitarTeclado(){
        //imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); //para quitar el teclado
        //imm.hideSoftInputFromWindow(nombre.getWindowToken(), 0); //quitar teclado
    }
}