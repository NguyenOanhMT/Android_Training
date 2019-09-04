package com.nguyenoanh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList.add(
                new Product(
                         1,
                        "Quick Brown Fox Jumps Over",
                        "TRAVELLING",
                        "16 MAY 2016",
                        "Synth polaroid bitters chillwave pickled. Vegan disrupt tousled, Portland keffiyeh aesthetic food",
                        "14 COMMENTS",
                        "254 LIKE",
                        R.drawable.img1
                )
        );
        productList.add(
                new Product(
                        2,
                        "Quick Brown Fox Jumps Over",
                        "HOBBY",
                        "16 MAY 2016",
                        "Synth polaroid bitters chillwave pickled. Vegan disrupt tousled, Portland keffiyeh aesthetic food",
                        "14 COMMENTS",
                        "254 LIKE",
                        R.drawable.img1
                )
        );
        ProductAdapter adapter = new ProductAdapter(this, productList);

        recyclerView.setAdapter(adapter);
    }
}
