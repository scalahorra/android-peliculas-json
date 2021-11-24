package com.example.android_peliculas_json;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Singleton {

    private RequestQueue requestQueue;
    private static Singleton instancia;

    private Singleton(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized Singleton getInstance(Context context) {

        if(instancia == null) {
            instancia = new Singleton(context);
        }
        return instancia;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
