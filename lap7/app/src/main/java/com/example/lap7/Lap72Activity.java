package com.example.lap7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Lap72Activity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap72);
        imageView=findViewById(R.id.lap72imageView);
        zoom();
    }
    public void  zoom(){
        Animation animation =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.anizom);
        imageView.startAnimation(animation);
    }
}