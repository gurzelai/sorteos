package com.example.sorteo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.Button;
import android.widget.TextView;

public class Ayuda extends AppCompatActivity {

    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        this.setTitle("Pagina de ayuda");
        Button atras = (Button) findViewById(R.id.atras);
        atras.setOnClickListener(view -> finish());
        titulo = (TextView) findViewById(R.id.titulo);
        SpannableString mitextoU = new SpannableString(titulo.getText().toString());
        mitextoU.setSpan(new UnderlineSpan(), 6, mitextoU.length(), 0);
        titulo.setText(mitextoU);
    }
}