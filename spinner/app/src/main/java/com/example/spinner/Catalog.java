package com.example.spinner;

import java.util.ArrayList;

public class Catalog extends Goods {
    private ArrayList<Product> listSp=null;
    public Catalog(String ma, String name) {
        super(ma, name);
        this.listSp=new ArrayList<Product>();
    }

    public Catalog() {
        super();
        this.listSp=new ArrayList<Product>();
    }
    /**
     * kiểm tra sản phẩm đã tồn tại trong danh mục hay chưa
     * @param p
     * @return true nếu tồn tại
     */
    public boolean isDuplicate(Product p)
    {
        for(Product p1: listSp)
        {
            if(p1.getid().trim().equalsIgnoreCase(p.getid().trim()))
                return true;
        }
        return false;
    }
    /**
     * thêm 1 sản phẩm vào danh mục
     * thêm thành công =true
     * @param p
     * @return
     */
    public boolean addProduct(Product p)
    {
        boolean isDup=isDuplicate(p);
        if(!isDup)
        {
            p.setDmuc(this);
            return listSp.add(p);
        }
        return !isDup;
    }
    public ArrayList<Product>getListProduct()
    {
        return this.listSp;
    }
    public int size()
    {
        return listSp.size();
    }
    public Product get(int i)
    {
        return listSp.get(i);
    }
}

