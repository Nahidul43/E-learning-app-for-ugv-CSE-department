package com.example.notice_board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class All_notice_activity extends AppCompatActivity {


    ListView listView;
    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notice);

        listView=findViewById(R.id.listView);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://carefree-straps.000webhostapp.com/apps/allnotice.json";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    for (int x = 0; x < jsonArray.length(); x++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(x);
                        String name = jsonObject.getString("notice");


                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("tvnotice", name); // Use the correct keys


                        arrayList.add(hashMap); // Add the HashMap to the ArrayList
                    }
                    MyAdapter myAdapter=new MyAdapter();
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
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View MyView = inflater.inflate(R.layout.all_notic_design, viewGroup, false);
            TextView tvnotice = MyView.findViewById(R.id.tvnotice);



            HashMap<String, String> hashMap = arrayList.get(position);
            String name = hashMap.get("tvnotice");


            tvnotice.setText(name);



            // Set the title

            return MyView;
        }
    }









}