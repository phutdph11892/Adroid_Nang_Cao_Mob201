package com.example.lap7;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button btnAll,btnDoremon,btnNobita;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAll=findViewById(R.id.btnAll);
        btnDoremon=findViewById(R.id.btnDoremon);
         btnNobita=findViewById(R.id.btnNobita);
         imageView=findViewById(R.id.imgDoremon);
         btnAll.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                showImage("All");
             }
         });
         btnDoremon.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 showImage("Doremon");
             }
         });
         btnNobita.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 showImage("Nobita");
             }
         });
    }
    private void showImage(String img){
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(imageView,"translationX",0f,500f);
        anim1.setDuration(2000);
        ObjectAnimator anim2 =  ObjectAnimator.ofFloat(imageView,"alpha",1f,0f);
        anim2.setDuration(2000);

        ObjectAnimator anim3 =  ObjectAnimator.ofFloat(imageView,"translationX",-500f,0f);
        anim3.setDuration(2000);

        ObjectAnimator anim4 =  ObjectAnimator.ofFloat(imageView,"alpha",0f,1f);
        anim4.setDuration(2000);

        AnimatorSet ani = new AnimatorSet();
      ani.play(anim3).with(anim4).after(anim1).after(anim2);
      ani.start();

      final String imgName  = img;

      anim2.addListener(new AnimatorListenerAdapter() {
          @Override
          public void onAnimationCancel(Animator animation) {
              super.onAnimationCancel(animation);
          }

          @Override
          public void onAnimationEnd(Animator animation) {
              if (imgName=="Nobita"){
                  imageView.setImageResource(R.drawable.nobita);

              }     if (imgName=="Doremon"){
                  imageView.setImageResource(R.drawable.doraemon);

              }                //super.onAnimationEnd(animation);
          }

          @Override
          public void onAnimationRepeat(Animator animation) {
              super.onAnimationRepeat(animation);
          }

          @Override
          public void onAnimationStart(Animator animation) {
              super.onAnimationStart(animation);
          }
      });
    }
}