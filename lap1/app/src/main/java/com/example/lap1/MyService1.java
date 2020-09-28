package com.example.lap1;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService1 extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getBundleExtra("sdt");
        int id = bundle.getInt("id");
        String ten = bundle.getString("name");
        String lop = bundle.getString("class");
        Toast.makeText(this,"Them sinh vien thanh cong: "+"MSV"+id+"Ten Sinh Vien"+ten+"lop"+lop,Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
