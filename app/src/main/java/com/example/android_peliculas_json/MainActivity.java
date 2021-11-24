package com.example.android_peliculas_json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Pelicula> peliculaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = Singleton.getInstance(this).getRequestQueue();

        peliculaList = new ArrayList<>();
        buscarPeliculas();
    }

    private void buscarPeliculas() {

        String url = "https://raw.githubusercontent.com/scalahorra/json-code/main/movie-code.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for(int i=0; i<response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String portada = jsonObject.getString("poster");
                                String titulo = jsonObject.getString("title");
                                Double puntuacion = jsonObject.getDouble("rating");
                                String descripcion = jsonObject.getString("overview");

                                Pelicula pelicula = new Pelicula(portada, titulo, puntuacion, descripcion);
                                peliculaList.add(pelicula);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            PeliculaAdapter adapter = new PeliculaAdapter(MainActivity.this, peliculaList);
                            recyclerView.setAdapter(adapter);
                        }
                    }
                },
                new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
        });
        requestQueue.add(jsonArrayRequest);
    }
}