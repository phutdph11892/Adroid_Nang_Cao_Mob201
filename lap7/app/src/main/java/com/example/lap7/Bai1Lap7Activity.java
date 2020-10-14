package com.example.lap7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class Bai1Lap7Activity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_lap7);
        imageView=findViewById(R.id.imgAll);


    }
    public void  zoom(){
        Animation animation =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.anizom);
        imageView.startAnimation(animation);
    }
    public void Rotation(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.xoay);
        imageView.startAnimation(animation);
    }

    public void Zoom(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anizom);
        imageView.startAnimation(animation);
    }


    public void Moving(View view) {
        TranslateAnimation animation = new TranslateAnimation(0.0f, 400.0f,
                0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(5000);  // animation duration
        animation.setRepeatCount(5);  // animation repeat count
        animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
        //animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }
}