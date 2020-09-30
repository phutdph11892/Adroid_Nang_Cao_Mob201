package com.example.lap4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

public class Lap42Activity extends AppCompatActivity {
TextView textView;
ConnectivityManager connectivityManager;
NetworkInfo MyWifi,my4G;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap42);
        textView = findViewById(R.id.lap42tv);

        connectivityManager =(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        MyWifi =connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        my4G=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if(MyWifi.isAvailable()==true){
            textView.setText("Dang dung wifi");
        }
        else if(my4G.isAvailable()==true){
            textView.setText("Dang dung 4G");
        }else{
            textView.setText("Khong co mang");
        }
    }
}