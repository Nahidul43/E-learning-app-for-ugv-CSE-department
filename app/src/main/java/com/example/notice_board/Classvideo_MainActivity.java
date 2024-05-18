package com.example.notice_board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

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

public class Classvideo_MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    MediaController mediaController;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classvideo_main);
        listView=findViewById(R.id.listView);







            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://carefree-straps.000webhostapp.com/apps/class.json";
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray jsonArray) {
                    try {
                        for (int x = 0; x < jsonArray.length(); x++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(x);
                            String name = jsonObject.getString("name");
                            String title = jsonObject.getString("code");
                            String id = jsonObject.getString("video_id");

                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("tvname", name);
                            hashMap.put("tvtitle", title);
                            hashMap.put("videoUrl", "https://carefree-straps.000webhostapp.com/apps/image/" + id + ".mp4");

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
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View MyView = inflater.inflate(R.layout.classvideo_design, viewGroup, false);

                TextView tvname = MyView.findViewById(R.id.tvname);
                TextView tvtitle = MyView.findViewById(R.id.tvtitle);
                VideoView videoView = MyView.findViewById(R.id.videoView);

                HashMap<String, String> hashMap = arrayList.get(position);
                String name = hashMap.get("tvname");
                String title = hashMap.get("tvtitle");
                String videoUrl = hashMap.get("videoUrl");

                tvname.setText(name);
                tvtitle.setText(title);

                // Set the media controller to the VideoView
                mediaController = new MediaController(Classvideo_MainActivity.this);
                videoView.setMediaController(mediaController);

                // Create a Uri object from the video URL and set it to the VideoView
                Uri uri = Uri.parse(videoUrl);
                videoView.setVideoURI(uri);

                // Start the video
                videoView.start();





                return MyView;
            }
        }




    }







