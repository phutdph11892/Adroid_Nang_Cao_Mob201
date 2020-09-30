package com.example.lap4.lap41;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lap4.R;

public class Lap41Activity extends AppCompatActivity implements LocationListener {
TextView txtLong,txtLat;
LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap41);
        txtLong = findViewById(R.id.lap41txtLong);
        txtLat=findViewById(R.id.lap41txtLat);

        locationManager=(LocationManager)getSystemService(LOCATION_SERVICE);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED&&
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            return;

        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,1,this);

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        double last =location.getLatitude();
        double longg =location.getLongitude();
        txtLat.setText("Toa do last :"+String.valueOf(last));
        txtLong.setText("Toa do Long :"+String.valueOf(longg));

    }

}