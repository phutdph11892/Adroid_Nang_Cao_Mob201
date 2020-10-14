package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinDm;
    EditText editma,editten;
    Button btnNhap;
    ListView lvSp;
    //cặp đối tượng dùng cho Spinner
    ArrayList<Catalog> arraySpinner=new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpinner=null;
    //Cặp đối tượng dùng cho ListView
    ArrayList<Product>arrayListview=new ArrayList<Product>();
    ArrayAdapter<Product>adapterListview=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgetsControl();
        fakeDataCatalog();
        addEventsForFormWidgets();
    }
    private void getWidgetsControl()
    {
        spinDm=(Spinner) findViewById(R.id.spDanhmuc);
        editma=(EditText) findViewById(R.id.editId);
        editten=(EditText) findViewById(R.id.editName);
        btnNhap=(Button) findViewById(R.id.btnInput);
        lvSp=(ListView) findViewById(R.id.lvsanpham);

        //Cấu hình cho Spinner
        adapterSpinner=new ArrayAdapter<Catalog>(this,
                android.R.layout.simple_spinner_item,
                arraySpinner);

        adapterSpinner.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinDm.setAdapter(adapterSpinner);

        //Cấu hình cho ListView
        adapterListview=new ArrayAdapter<Product>(this,
                android.R.layout.simple_list_item_1,
                arrayListview);
        lvSp.setAdapter(adapterListview);
    }
    /***
     * Hàm giả dữ liệu, tạo 3 danh mục mặc định cho Spinner
     */
    private void fakeDataCatalog()
    {
        Catalog cat1=new Catalog("1", "SamSung");
        Catalog cat2=new Catalog("2", "Iphone");
        Catalog cat3=new Catalog("3", "IPad");
        arraySpinner.add(cat1);
        arraySpinner.add(cat2);
        arraySpinner.add(cat3);
        adapterSpinner.notifyDataSetChanged();
    }
    /**
     * Hàm gán sự kiện cho Button và Spinner
     */
    private void addEventsForFormWidgets()
    {
        btnNhap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                addProductForCatalog();
            }
        });
        spinDm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                //mỗi lần chọn danh mục trong Spinner thì cập nhập ListView
                loadListProductByCatalog(arraySpinner.get(arg2));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });
    }
    /**
     * Hàm thêm một sản phẩm vào cho danh mục được chọn trong Spinner
     */
    private void addProductForCatalog()
    {
        Product p=new Product();
        p.setid(editma.getText()+"");
        p.setName(editten.getText()+"");
        Catalog c= (Catalog) spinDm.getSelectedItem();
        c.addProduct(p);
        //Mỗi lần thêm xong thì cập nhập lại ListView
        loadListProductByCatalog(c);
    }
    /**
     * Lọc danh sách sản phẩm theo danh mục và update lại ListView
     * @param c
     */
    private void loadListProductByCatalog(Catalog c)
    {
        //xóa danh sách cũ
        arrayListview.clear();
        //lấy danh sách mới từ Catalog chọn trong Spinner
        arrayListview.addAll(c.getListProduct());
        //cập nhật lại ListView
        adapterListview.notifyDataSetChanged();
    }
}
