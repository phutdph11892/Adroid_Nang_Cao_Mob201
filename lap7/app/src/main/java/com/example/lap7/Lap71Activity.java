package com.example.lap7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Lap71Activity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap71);
        imageView=findViewById(R.id.lap71ImageView);
        Animation animation =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.xoay);
        imageView.startAnimation( animation);

    }

}