package com.example.notice_board;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class civil_MainActivity extends AppCompatActivity {

   ListView listView;
   HashMap<String,String>hashMap=new HashMap<>();
   ArrayList<HashMap<String,String>>arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_main);
        listView=findViewById(R.id.listView);



        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://carefree-straps.000webhostapp.com/apps/pdf.json";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    for (int x = 0; x < jsonArray.length(); x++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(x);
                        String name = jsonObject.getString("name");
                        String title = jsonObject.getString("code");
                        String link = jsonObject.getString("video_id");
                        String image = "https://carefree-straps.000webhostapp.com/apps/image/" + link + ".pdf";

                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("tvname", name);
                        hashMap.put("tvtitle", title);
                        hashMap.put("tvcover", image);
                        arrayList.add(hashMap);
                    }
                    MyAdapter myAdapter = new MyAdapter();
                    listView.setAdapter(myAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonArrayRequest);
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return arrayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.pdf, viewGroup, false);
            }

            TextView tvname = view.findViewById(R.id.tvname);
            TextView tvtitle = view.findViewById(R.id.tvtitle);
            CardView layout = view.findViewById(R.id.layout);
            TextView tv=view.findViewById(R.id.tv);
            HashMap<String, String> hashMap = arrayList.get(position);
            String name = hashMap.get("tvname");
            String title = hashMap.get("tvtitle");
            String pdfUrl = hashMap.get("tvcover");

            tvname.setText(name);
            tvtitle.setText(title);


            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // Open a new activity with the PDF URL
                    Intent intent = new Intent(civil_MainActivity.this, PdfView_MainActivity.class);
                    intent.putExtra("pdfUrl", pdfUrl);
                    startActivity(intent);
                }
            });

            return view;
        }
    }
}
