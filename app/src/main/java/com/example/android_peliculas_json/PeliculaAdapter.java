package com.example.android_peliculas_json;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PeliculaHolder> {

    private Context context;
    private List<Pelicula> peliculaList;

    PeliculaAdapter(Context context, List<Pelicula> peliculas) {
        this.context = context;
        peliculaList = peliculas;
    }

    @NonNull
    @Override
    public PeliculaAdapter.PeliculaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.pelicula, parent, false);
        return new PeliculaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaAdapter.PeliculaHolder holder, int position) {

        Pelicula pelicula = peliculaList.get(position);
        Glide.with(context).load(pelicula.getPortada()).into(holder.portada);
        holder.titulo.setText(pelicula.getTitulo());
        holder.puntuacion.setText(pelicula.getPuntuacion().toString());
        holder.descripcion.setText(pelicula.getDescripcion());

        holder.layout_pelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PeliculaDetallada.class);

                Bundle bundle = new Bundle();
                bundle.putString("portada", pelicula.getPortada());
                bundle.putString("titulo", pelicula.getTitulo());
                bundle.putDouble("puntuacion", pelicula.getPuntuacion());
                bundle.putString("descripcion", pelicula.getDescripcion());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return peliculaList.size();
    }

    public class PeliculaHolder extends RecyclerView.ViewHolder {

        ImageView portada;
        TextView titulo, puntuacion, descripcion;
        ConstraintLayout layout_pelicula;

        public PeliculaHolder(@NonNull View itemView) {
            super(itemView);

            portada = itemView.findViewById(R.id.portada);
            titulo = itemView.findViewById(R.id.titulo_tv);
            puntuacion = itemView.findViewById(R.id.puntuacion_tv);
            descripcion = itemView.findViewById(R.id.descripcion_tv);
            layout_pelicula = itemView.findViewById(R.id.layout_pelicula);
        }
    }
}
