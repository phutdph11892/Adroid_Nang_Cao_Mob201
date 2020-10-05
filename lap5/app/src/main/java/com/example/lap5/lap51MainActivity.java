package com.example.lap5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class lap51MainActivity extends AppCompatActivity {
    ListView listView;
    List<String> arrayList=new ArrayList<>();
    List<String> arrauLink=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
   Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap51_main);
        listView=findViewById(R.id.lap51listView);
        //goi ham xu ly tren sever
      new RSSFeed().execute("https://vnexpress.net/rss/tin-moi-nhat.rss");
      //xu li adapter
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        //xu li phan cick vao item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String link = arrauLink.get(i);
                intent = new Intent(lap51MainActivity.this,Lap51DetailActivity.class);
                intent.putExtra("linkURL",link);
                startActivity(intent);
            }
        });
    }

    //dinh nghia xu li Asytack lay du lieu tu server qua moi truong internet dau vao dau ra
    public class RSSFeed extends AsyncTask<String, Void, String> {
        //ham thuc hien lay du lieu ru sever
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder contect=new StringBuilder();
            try {
                URL url=new URL(strings[0]);
                InputStreamReader inputStreamReader=new InputStreamReader(url.openConnection().getInputStream());
                String line="";
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                while ((line=bufferedReader.readLine()) != null) {
                    contect.append(line);//dua du lieu doc tu sever vao contan
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return contect.toString();//tra ve krt qua
        }
        //dan ket qua len dien thoai


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLParser xmlParser=new XMLParser();
            try {
                Document document=xmlParser.getDocument(s);
                NodeList nodeList=document.getElementsByTagName("item");
                String title="";
                for (int i=0; i < nodeList.getLength(); i++) {
                    Element element=(Element) nodeList.item(i);
                    title+=xmlParser.getValue(element, "title") + "\n";
                    arrayList.add(title);
                    arrauLink.add(xmlParser.getValue(element, "link"));
                }
                arrayAdapter.notifyDataSetChanged();
            } catch (SAXException | IOException e) {

            }
        }
    }
}