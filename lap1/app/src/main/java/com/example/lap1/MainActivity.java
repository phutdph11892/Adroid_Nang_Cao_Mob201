package com.example.lap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Intent intent1,intent2,intent3;
Button btnStart,btnStop;
EditText editText;
int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent1 = new Intent(this,MyService.class);
        intent2 = new Intent(this,MyService1.class);
        intent3 = new Intent(this,MyService2.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",1);
        bundle.putString("name","Nguyen van A");
        bundle.putString("class","PT-MOB15354");
        intent2.putExtra("sdt",bundle);
        editText=findViewById(R.id.edt1);
        Bundle bundle1 = new Bundle();
        bundle1.putString("edt",editText.getText().toString());
        intent3.putExtra("pkg",bundle1);


    }
    public void start(View view){
startService(intent3);
    }
    public void stop(View view){
stopService(intent1);

    }



}