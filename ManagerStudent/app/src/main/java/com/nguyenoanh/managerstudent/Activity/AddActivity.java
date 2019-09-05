package com.nguyenoanh.managerstudent.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nguyenoanh.managerstudent.AppConstants;
import com.nguyenoanh.managerstudent.Database.InforStudent;
import com.nguyenoanh.managerstudent.R;
import com.nguyenoanh.managerstudent.util.AppUtils;

public class AddActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener,
        View.OnTouchListener ,AppConstants {

    TextView tvTitle;
    Button btnAdd, btnDelete;
    ImageView btnClose;
    EditText edtName, edtDate, edtGender, edtAddress, edtSpecial;

    InforStudent student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add);

        initLayout ();

        btnAdd.setOnClickListener(this);
        btnClose.setOnClickListener (this);
        student = (InforStudent) getIntent().getSerializableExtra(AppConstants.INTENT_TASK);
        if(student == null){
            tvTitle.setText ("Add Information");
            btnAdd.setText ("Add");
        }else{
            tvTitle.setText ("Edit Information");
            btnAdd.setText ("Delete");
            btnClose.setImageResource (R.drawable.ic_delete);
            if(student.getName () != null && !student.getName ().isEmpty()) {
                edtName.setText(student.getName ());
                edtName.setSelection(edtName.getText().length());
            }
            if(student.getDate () != null && !student.getDate ().isEmpty()) {
                edtDate.setText(student.getDate ());
                edtDate.setSelection(edtDate.getText().length());
            }
            if(student.getGender () != null && !student.getGender ().isEmpty()) {
                edtGender.setText(student.getGender ());
                edtGender.setSelection(edtGender.getText().length());
            }
            if(student.getAddress () != null && !student.getAddress ().isEmpty()) {
                edtAddress.setText(student.getAddress ());
                edtAddress.setSelection(edtAddress.getText().length());
            }
            if(student.getSpecial () != null && !student.getSpecial ().isEmpty()) {
                edtSpecial.setText(student.getSpecial ());
                edtSpecial.setSelection(edtSpecial.getText().length());
            }
        }

        AppUtils.openKeyboard(getApplicationContext());

//        btnAdd.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent (AddActivity.this, ShowActivity.class);
//                startActivity (intent);
//            }
//        });
    }

    public void initLayout(){
        tvTitle = (TextView) findViewById (R.id.tv_title);

        btnAdd = (Button) findViewById (R.id.btn_add);
        btnClose = (ImageView) findViewById (R.id.btn_close);
        btnDelete = (Button) findViewById (R.id.btn_delete);

        edtName = (EditText) findViewById (R.id.edt_name);
        edtDate = (EditText) findViewById (R.id.edt_date);
        edtGender = (EditText) findViewById (R.id.edt_gender);
        edtAddress = (EditText) findViewById (R.id.edt_address);
        edtSpecial = (EditText) findViewById (R.id.edt_special);
    }

    @Override
    public void onClick(View view) {
        AppUtils.hideKeyboard(this);
         if(view == btnAdd) {
             Intent intent = getIntent ();
             if (student != null) {
                 student.setName (edtName.getText ().toString ());
                 student.setDate (edtDate.getText ().toString ());
                 student.setGender (edtGender.getText ().toString ());
                 student.setAddress (edtAddress.getText ().toString ());
                 student.setSpecial (edtSpecial.getText ().toString ());
                 intent.putExtra (AppConstants.INTENT_TASK, student);

             } else {
                 intent.putExtra (AppConstants.INTENT_NAME, edtName.getText ().toString ());
                 intent.putExtra (AppConstants.INTENT_DATE, edtDate.getText ().toString ());
                 intent.putExtra (AppConstants.INTENT_GENDER, edtGender.getText ().toString ());
                 intent.putExtra (AppConstants.INTENT_ADDRESS, edtAddress.getText ().toString ());
                 intent.putExtra (AppConstants.INTENT_SPECIAL, edtSpecial.getText ().toString ());
             }
             setResult (Activity.RESULT_OK, intent);
             finish ();
             overridePendingTransition(R.anim.stay, R.anim.slide_down);
        }else if(view == btnDelete) {
             if((Integer)btnDelete.getTag() == R.drawable.ic_add_plus) {
                 setResult(Activity.RESULT_CANCELED);

             } else {
                 Intent intent = getIntent();
                 intent.putExtra(AppConstants.INTENT_DELETE, true);
                 intent.putExtra(AppConstants.INTENT_TASK, student);
                 setResult(Activity.RESULT_OK, intent);
             }
             finish();
             overridePendingTransition(R.anim.stay, R.anim.slide_down);
         }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int DRAWABLE_RIGHT = 2;
        if(event.getAction() == MotionEvent.ACTION_UP) {
            return true;
        }
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
