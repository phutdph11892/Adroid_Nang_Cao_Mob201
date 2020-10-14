package com.example.lap7;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Bai3lap7Activity extends AppCompatActivity {
ImageView hourImg,minuteImg,secondImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3lap7);
        hourImg=findViewById(R.id.imageView4);
        minuteImg=findViewById(R.id.imageView3);
        secondImg=findViewById(R.id.imageView2);
        startClock();
    }
    public void startClock(){
        Animation animationHous =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hour);
        Animation animationMinute= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.minute);
        Animation animationSecond = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.second);
        hourImg.startAnimation(animationHous);
        minuteImg.startAnimation(animationMinute);
        secondImg.startAnimation(animationSecond);
    }
}