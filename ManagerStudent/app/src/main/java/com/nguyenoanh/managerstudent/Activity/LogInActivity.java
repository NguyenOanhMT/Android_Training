package com.nguyenoanh.managerstudent.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.nguyenoanh.managerstudent.R;

public class LogInActivity extends AppCompatActivity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_log_in);

        initLayot ();
        btnLogin.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (LogInActivity.this, ShowActivity.class);
                startActivity (intent);
            }
        });

    }

    private void initLayot(){
        btnLogin = (Button) findViewById (R.id.btn_log_in);
    }
}
