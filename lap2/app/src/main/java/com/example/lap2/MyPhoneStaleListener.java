package com.example.lap2;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.widget.Toast;

public class MyPhoneStaleListener extends PhoneStateListener {
    Context pContext;
    public MyPhoneStaleListener(Context context){
        this.pContext = context;

    }

    @Override
    public void onCallStateChanged(int state, String phoneNumber) {
        if(state==1){
            Toast.makeText(pContext,"So dien thoai goi den "+phoneNumber,Toast.LENGTH_SHORT).show();
        }
        super.onCallStateChanged(state, phoneNumber);
    }
}
