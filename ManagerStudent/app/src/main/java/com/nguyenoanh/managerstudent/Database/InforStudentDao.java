package com.nguyenoanh.managerstudent.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface InforStudentDao {

    @Insert
    void insertStudent(InforStudent student);

    @Update
    void updateStudent(InforStudent student);

    @Query("DELETE FROM `InforStudent`")
    void deleteAll();

    @Delete
    void deleteStudent(InforStudent student);

    @Query("SELECT * FROM InforStudent WHERE id =:id")
    LiveData<InforStudent> getTask(int id);

    @Query("SELECT * FROM InforStudent ORDER BY id desc")
    LiveData<List<InforStudent>> fetchAllTasks();
}
