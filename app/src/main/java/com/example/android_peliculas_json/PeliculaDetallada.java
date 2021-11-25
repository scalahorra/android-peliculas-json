package com.example.android_peliculas_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PeliculaDetallada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula_detallada);

        ImageView portada = findViewById(R.id.portada_detallada);
        TextView titulo = findViewById(R.id.titulo_detallada_tv);
        TextView puntuacion = findViewById(R.id.puntuacion_detallada_tv);
        TextView descripcion = findViewById(R.id.descripcion_detallada_tv);

        Bundle bundle = getIntent().getExtras();

        String pPortada = bundle.getString("portada");
        String pTitulo = bundle.getString("titulo");
        double pPuntuacion = bundle.getDouble("puntuacion");
        String pDescripcion = bundle.getString("descripcion");

        Glide.with(this).load(pPortada).into(portada);
        titulo.setText(pTitulo);
        puntuacion.setText(Double.toString(pPuntuacion));
        descripcion.setText(pDescripcion);
    }
}