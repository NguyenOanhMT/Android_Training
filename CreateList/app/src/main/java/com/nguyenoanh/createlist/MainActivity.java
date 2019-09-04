package com.nguyenoanh.createlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nguyenoanh.createlist.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter productAdapter;

    List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //thêm các mặt hàng vào list
        productList.add(
                new com.nguyenoanh.createlist.Product(
                        1,
                        "Khoai tây chiên",
                        "Giá: 20k",
                        R.drawable.khoai_chien));

        productList.add(
                new com.nguyenoanh.createlist.Product(
                        2,
                        "Bún đậu mắm tôm",
                        "Giá: 30k",
                        R.drawable.bundau));

        productList.add(
                new com.nguyenoanh.createlist.Product(
                        3,
                        "Bún trộn",
                        "Giá: 30k",
                        R.drawable.bun_tron));

        productList.add(
                new com.nguyenoanh.createlist.Product(
                        4,
                        "Sushi",
                        "Giá: 50k",
                        R.drawable.sushi));
        productList.add(
                new com.nguyenoanh.createlist.Product(
                        5,
                        "Kimbac",
                        "Giá: 15k",
                        R.drawable.kimbac));
        productList.add(
                new com.nguyenoanh.createlist.Product(
                        6,
                        "Phở cuốn",
                        "Giá: 25k",
                        R.drawable.pho_cuon));
        productList.add(
                new com.nguyenoanh.createlist.Product(
                        7,
                        "Cao lầu",
                        "Giá: 45k",
                        R.drawable.mi_tron));

        //tạo recyclerview adapter
        com.nguyenoanh.createlist.ProductAdapter adapter = new com.nguyenoanh.createlist.ProductAdapter(this, productList);

        //cài đặt adapter cho recyclerview
        recyclerView.setAdapter(adapter);
    }
}
