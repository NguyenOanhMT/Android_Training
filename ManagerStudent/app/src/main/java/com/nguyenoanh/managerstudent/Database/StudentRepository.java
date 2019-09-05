package com.nguyenoanh.managerstudent.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class StudentRepository {

    private String DB_NAME = "information_student";
    private InforStudentDatabase studentDatabase;

    public StudentRepository(Context context) {
        studentDatabase = Room.databaseBuilder(context, InforStudentDatabase.class, DB_NAME).build();
    }

//    public void insertTask(String name) {
////        insertInfor(id, name, date, gender, address, special);
//
//    }
    public void insertInfor(int id, String name, String date, String gender,
                            String address, String special) {

        InforStudent student = new InforStudent ();
        student.setId (id);
        student.setName (name);
        student.setGender (gender);
        student.setDate (date);
        student.setAddress (address);
        student.setSpecial (special);

        insertInfor (student);
    }

    public void insertInfor(final InforStudent student) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                studentDatabase.studentDao ().insertStudent (student);
                return null;
            }
        }.execute();
    }

    public void updateTask(final InforStudent student) {
        new AsyncTask<Void, Void, Void> () {
            @Override
            protected Void doInBackground(Void... voids) {
                studentDatabase.studentDao ().updateStudent (student);
                return null;
            }
        }.execute();
    }

    public void deleteStudent(final int id) {
        final LiveData<InforStudent> task = getTask(id);
        if(task != null) {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    studentDatabase.studentDao ().deleteStudent (task.getValue());
                    return null;
                }
            }.execute();
        }
    }

    public void deleteStudent(final InforStudent student) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                studentDatabase.studentDao ().deleteStudent (student);
                return null;
            }
        }.execute();
    }

    public LiveData<InforStudent> getTask(int id) {
        return studentDatabase.studentDao ().getTask(id);
    }

    public LiveData<List<InforStudent>> getTasks() {
        return studentDatabase.studentDao ().fetchAllTasks();
    }

}
