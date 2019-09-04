package com.nguyenoanh.managerstudent.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.nguyenoanh.managerstudent.Database.InforStudent;
import com.nguyenoanh.managerstudent.Database.InforStudentDatabase;
import com.nguyenoanh.managerstudent.R;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_add, btn_edit, btn_delete;
    ImageButton btn_search, btn_sort, btn_show;
    private String DB_NAME = "information_student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        final InforStudentDatabase db = Room.databaseBuilder(getApplicationContext(),
                InforStudentDatabase.class, DB_NAME).build();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                InforStudent student =new InforStudent ();
//                student.setId (2);
//                student.setName ("an");
//                db.studentDao () . insertStudent (student);
//            }
//        }) .start();

        initLayout ();
        btn_add.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, AddActivity.class);
                startActivity (intent);
            }
        });
    }



    public void initLayout(){
        btn_add = (ImageButton) findViewById (R.id.btn_add);
        btn_edit = (ImageButton) findViewById (R.id.btn_edit);
        btn_delete = (ImageButton) findViewById (R.id.btn_delete);

        btn_search = (ImageButton) findViewById (R.id.btn_search);
        btn_sort = (ImageButton) findViewById (R.id.btn_sort);
        btn_show = (ImageButton) findViewById (R.id.btn_show);
    }
}
