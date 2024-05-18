package com.example.notice_board;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PdfView_MainActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view_main);
        webView=findViewById(R.id.webView);

        webView = findViewById(R.id.webView);
        webView = findViewById(R.id.webView);

        String url = getIntent().getStringExtra("pdfUrl");
        // webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptEnabled(true);

        // Load the PDF using Google Docs Viewer
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url="+url);




    }
}