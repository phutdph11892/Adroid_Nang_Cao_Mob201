package com.example.demo_lap3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listviewLab3);
        if( isStoragePermissionGranted1() ){
            showContacts();
        }


    }
//    public void showAllContact(){
//        //uri
//        Uri uri = Uri.parse("content://contacts//people");
//        ArrayList<String> list = new ArrayList<>();
//        CursorLoader loader = new CursorLoader(this,uri,null,null,null,null);
//        Cursor cursor =loader.loadInBackground();
//        cursor.moveToFirst();//di chuyen ve bang gi dau tien
//        while (cursor.isAfterLast()==false){//neu khonbg phai bang ghi
//            String s="";
//            String idColumnName=ContactsContract.Contacts._ID;
//            int idIndext = cursor.getColumnIndex(idColumnName);
//
//            String nameColumnName = ContactsContract.Contacts.DISPLAY_NAME;
//            int nameIndext=cursor.getColumnIndex(nameColumnName);
//
//
//            s+=cursor.getString(nameIndext);
//            cursor.moveToNext();
//            list.add(s);
//
//        }
//        cursor.close();
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
//        listView.setAdapter(adapter);
//    }
    public void showContacts(){
        //uri
        Uri uri = Uri.parse("content://contacts//people");
        ArrayList<String> arrayList = new ArrayList<>();
        CursorLoader cursorLoader = new CursorLoader(this,uri,null,null,null,null);
        Cursor cursor = cursorLoader.loadInBackground();
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            String s = "";
            String idColumn = ContactsContract.Contacts._ID;
            int index = cursor.getColumnIndex(idColumn);

            String nameColumn = ContactsContract.Contacts.DISPLAY_NAME;
            int nameIndex = cursor.getColumnIndex(nameColumn);
            s+=cursor.getString(nameIndex);
            cursor.moveToNext();
            arrayList.add(s);
        }
        cursor.close();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
    public boolean isStoragePermissionGranted1() {
        if (Build.VERSION.SDK_INT >= 23) {
            if
            (checkSelfPermission(Manifest.permission.READ_CONTACTS)
                    == PackageManager.PERMISSION_GRANTED
                    &&
                    checkSelfPermission(Manifest.permission.WRITE_CONTACTS)
                            == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission is granted");
                return true;
            } else {
                Log.v("TAG", "Permission is revoked");
                ActivityCompat.requestPermissions(MainActivity.this,
                        new
                                String[]{android.Manifest.permission.READ_CONTACTS,
                                Manifest.permission.WRITE_CONTACTS},
                        1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23
          //  upon installation
            Log.v("TAG", "Permission is granted");
            return true;
        }
    }
}