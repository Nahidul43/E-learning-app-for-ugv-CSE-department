package com.example.notice_board;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

public class Routing_activity extends AppCompatActivity {

    ImageView routingpic;

   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routing);
        routingpic=findViewById(R.id.routingpic);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(Routing_activity.this);
        String url = "https://carefree-straps.000webhostapp.com/apps/image/";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Picasso.get().load("https://carefree-straps.000webhostapp.com/apps/image/routing-crop.png").into(routingpic);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);





    }
}