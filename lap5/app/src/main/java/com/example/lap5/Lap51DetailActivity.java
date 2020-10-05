package com.example.lap5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Lap51DetailActivity extends AppCompatActivity {
WebView webView;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap51_detail);
        webView = findViewById(R.id.lap51webView);
        intent = getIntent();
        String link = intent.getStringExtra("linkURL");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
    }
}