package com.example.notice_board;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ComplaintBox_Activity extends AppCompatActivity {



    EditText semester,complaint;
    ProgressBar progressBar;
    CardView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_box);

        semester=findViewById(R.id.semester);
        complaint=findViewById(R.id.complaint);
        progressBar=findViewById(R.id.progressBar);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sem=semester.getText().toString();
                String com=complaint.getText().toString();
                progressBar.setVisibility(View.VISIBLE);


                RequestQueue queue = Volley.newRequestQueue(ComplaintBox_Activity.this);
                String url = "https://carefree-straps.000webhostapp.com/apps/complaint.php?n="+sem+"&c="+com;

// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressBar.setVisibility(View.GONE);

                                new AlertDialog.Builder(ComplaintBox_Activity.this)
                                        .setTitle("Server Response")
                                        .setMessage("Submit Your Complaint successfully")
                                        .show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

// Add the request to the RequestQueue.

                if(com.length()>3){
                    queue.add(stringRequest);
                }else {
                    complaint.setError("Please Enter Your Complaint");
                    progressBar.setVisibility(View.GONE);
                }








            }
        });




    }
}