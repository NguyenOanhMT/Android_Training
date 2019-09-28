package com.nguyenoanh.email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private List<ItemAccount> list;
    private ItemAccountAdapter adapter;
    private RecyclerView recyclerView;

    private FloatingActionButton btnPencil;
    private ImageView imvChecked;
    private ImageView imvClosed;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        initLayout ();

        list = new ArrayList<> ();

        ItemAccount item1 = new ItemAccount (0, "Canada",
                "String iconName;private String name;private String content;private String time;",
                "4:30 pm", R.color.dark_blue_grey);
        ItemAccount item2 = new ItemAccount (0, "ana",
                "String iconName;private String name;private String content;private String time;",
                "4:30 pm", R.color.darkish_pink);
        list.add(item1);
        list.add(item1);
        list.add(item2);
        list.add(item2);
        list.add(item1);
        list.add(item1);
        list.add(item1);
        list.add(item2);

        adapter = new ItemAccountAdapter (this,list);

        LinearLayoutManager layoutManager = new LinearLayoutManager (this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator ());
        recyclerView.setAdapter(adapter);


        imvClosed.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                relativeLayout.setVisibility (View.GONE);
            }
        });
        imvChecked.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Sender.class);
                startActivity (intent);
            }
        });
        btnPencil.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Sender.class);
                startActivity (intent);
            }
        });

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }


    public void initLayout(){
        imvClosed = findViewById (R.id.imv_closed);
        imvChecked = findViewById (R.id.imv_checked);
        btnPencil = findViewById (R.id.btn_pencil);

        relativeLayout = findViewById (R.id.sender);
        btnPencil = findViewById (R.id.btn_pencil);
    }

}