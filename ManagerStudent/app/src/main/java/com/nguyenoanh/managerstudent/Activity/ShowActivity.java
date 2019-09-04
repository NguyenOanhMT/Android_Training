package com.nguyenoanh.managerstudent.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nguyenoanh.managerstudent.AppConstants;
import com.nguyenoanh.managerstudent.Adapter.InforStudentAdapter;
import com.nguyenoanh.managerstudent.Database.InforStudent;
import com.nguyenoanh.managerstudent.Database.StudentRepository;
import com.nguyenoanh.managerstudent.R;
import com.nguyenoanh.managerstudent.util.NavigatorUtils;
import com.nguyenoanh.managerstudent.util.RecyclerItemClickListener;

import java.util.List;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener,
        RecyclerItemClickListener.OnRecyclerViewItemClickListener, AppConstants {


    private RecyclerView recyclerView;
    private InforStudentAdapter adapter;
    private FloatingActionButton btnAdd;
    private TextView emptyView;

    private StudentRepository repository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_show);

        repository = new StudentRepository (getApplicationContext());

        recyclerView = findViewById(R.id.recycler_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager ( getApplicationContext ());
        recyclerView.setLayoutManager (layoutManager);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, this));

        btnAdd = (FloatingActionButton) findViewById (R.id.btn_add);

        emptyView = (TextView) findViewById (R.id.empty_view);

        updateTaskList();

        btnAdd.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (ShowActivity.this, AddActivity.class);
                startActivity (intent);
            }
        });

    }

    private void updateTaskList() {
        repository.getTasks().observe (this, new Observer<List<InforStudent>> () {
            @Override
            public void onChanged(List<InforStudent> list) {
                if(list.size() > 0) {
                    emptyView.setVisibility (View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                if (adapter == null) {
                    adapter = new InforStudentAdapter (getApplicationContext (), list);
                    recyclerView.setAdapter(adapter);

                } else adapter.addTasks(list);
            } else updateEmptyView();
            }
        });
    }
    private void updateEmptyView() {
        emptyView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    //New list student to be added
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(ShowActivity.this, AddActivity.class);
        startActivityForResult(intent,AppConstants.ACTIVITY_REQUEST_CODE);
    }

    //Update/delete existing student
    @Override
    public void onItemClick(View parentView, View childView, int i) {
        InforStudent student = adapter.getItem (i);
        NavigatorUtils.redirectToEditTaskScreen (this, student);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AppConstants.ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if(data.hasExtra(AppConstants.INTENT_TASK)) {
                if(data.hasExtra(AppConstants.INTENT_DELETE)) {
                    repository.deleteStudent ((InforStudent) data.getSerializableExtra(AppConstants.INTENT_TASK));
                } else {
                    repository.updateTask((InforStudent) data.getSerializableExtra(AppConstants.INTENT_TASK));
                }
            } else {
                int id = 0;
                String name = data.getStringExtra(AppConstants.INTENT_NAME);
                String date = data.getStringExtra (AppConstants.INTENT_DATE);
                String gender = data.getStringExtra(AppConstants.INTENT_GENDER);
                String address = data.getStringExtra(AppConstants.INTENT_ADDRESS);
                String special = data.getStringExtra(AppConstants.INTENT_SPECIAL);

                repository.insertInfor (id, name, date, gender, address, special);
            }
            updateTaskList();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
