package com.example.notice_board;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class server_MainActivity extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_main);
        web=findViewById(R.id.web);

        web.getSettings().setJavaScriptEnabled(true);

        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://webportal.ugv.edu.bd/LoginPage.aspx");
    }

    public  void onBackPressed(){
        if(web.canGoBack()){
            web.goBack();
        }
        else{
            super.onBackPressed();
        }
    }





    }
