package com.example.lap2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        TelephonyManager telephonyManager =(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        MyPhoneStaleListener myPhoneStaleListener = new MyPhoneStaleListener(context);
        telephonyManager.listen(myPhoneStaleListener, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
