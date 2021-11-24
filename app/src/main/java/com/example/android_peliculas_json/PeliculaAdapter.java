package com.example.android_peliculas_json;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PeliculaHolder> {

    private Context context;
    private List<Pelicula> peliculas;

    @NonNull
    @Override
    public PeliculaAdapter.PeliculaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaAdapter.PeliculaHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PeliculaHolder extends RecyclerView.ViewHolder {

        ImageView portada;
        TextView titulo, puntuacion, descripcion;

        public PeliculaHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
