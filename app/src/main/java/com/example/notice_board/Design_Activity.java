package com.example.notice_board;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

public class Design_Activity extends AppCompatActivity {

    CardView tvNotice,server,cse,uprint,civil,mac,bba;
    ImageButton tvpic;
    ImageView serverPic,csepic,eeepic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        tvNotice=findViewById(R.id.tvNotice);
        server=findViewById(R.id.server);
        cse=findViewById(R.id.cse);
        uprint=findViewById(R.id.uprint);

        tvpic=findViewById(R.id.tvpic);
        serverPic=findViewById(R.id.serverPic);
        csepic=findViewById(R.id.csepic);
        eeepic=findViewById(R.id.eeepic);




        RequestQueue queue = Volley.newRequestQueue(Design_Activity.this);
        String url = "https://carefree-straps.000webhostapp.com/apps/image/";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Picasso.get().load("https://carefree-straps.000webhostapp.com/apps/image/notic123.jpg").into(tvpic);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        queue.add(stringRequest);














       server.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(Design_Activity.this,server_MainActivity.class));


           }
       });

        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Design_Activity.this,CSE_MainActivity.class));

            }
        });

        uprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Design_Activity.this,Uprint_Activity.class));

            }
        });



    }
}