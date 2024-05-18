package com.example.notice_board;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class CSE_MainActivity extends AppCompatActivity {

    CardView fac,routing,asssignment,allNotice,classVideo,complainBox,pdf;
    LinearLayout layout1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_main);

        asssignment=findViewById(R.id.asssignment);
        routing=findViewById(R.id.routing);
        layout1=findViewById(R.id.layout1);
        allNotice=findViewById(R.id.allNotice);
        classVideo=findViewById(R.id.classVideo);
        complainBox=findViewById(R.id.complainBox);
        pdf=findViewById(R.id.pdf);


        fac=findViewById(R.id.fac);


        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CSE_MainActivity.this, civil_MainActivity.class));
            }
        });







        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(CSE_MainActivity.this,faculty.class));

            }
        });

        routing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CSE_MainActivity.this,Routing_activity.class));


            }
        });

asssignment.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(CSE_MainActivity.this,Assignment_activity.class));


    }
});

        allNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CSE_MainActivity.this, All_notice_activity.class));

            }
        });


        classVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CSE_MainActivity.this, Classvideo_MainActivity.class));
            }
        });

        complainBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CSE_MainActivity.this, ComplaintBox_Activity.class));
            }
        });




    }
   


}