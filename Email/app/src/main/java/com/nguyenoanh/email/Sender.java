package com.nguyenoanh.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class Sender extends AppCompatActivity {

    EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_sender);

        findViewById (R.id.imv_back).setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Sender.this, MainActivity.class);
                startActivity (intent);
            }
        });

        edtName = findViewById (R.id.receiver);
        Intent intent = getIntent ();
        int id = 0;
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra ("bundle");
            if (bundle != null) {
                edtName.setText (bundle.getString ("name"));
                id = bundle.getInt ("id");
            } else {
            }
        }
    }

}
