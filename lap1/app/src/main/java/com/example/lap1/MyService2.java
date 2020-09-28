package com.example.lap1;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService2 extends IntentService {
   int count = 0;
    public MyService2() {
        super("MyService2");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
      //  Bundle bundle = intent.getBundleExtra("pkg");
      //  String stg = bundle.getString("edt");
     //   char[] chars = stg.charAt()//stg.toCharArray();//bien chuoi thanh mang ki tu;
//
//        for(int i=0;i<stg.length();i++){
//             if(stg.charAt(i)=='A'){
//                 count++;
//             }
//        }
//        Toast.makeText(this,"So Luong Ki Tu A :"+count,Toast.LENGTH_SHORT).show();
        count = countChareter("student",'s');
        Toast.makeText(getApplicationContext(),String.valueOf(count),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),String.valueOf(count),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Goi ham onDestroy:",Toast.LENGTH_SHORT).show();
    }


    public int countChareter(String stg,char c){
     int count=0;
        for(int i=0;i<stg.length();i++){

            if(stg.charAt(i)==c){
                count++;
            }
        }

        return count;
    }
}
