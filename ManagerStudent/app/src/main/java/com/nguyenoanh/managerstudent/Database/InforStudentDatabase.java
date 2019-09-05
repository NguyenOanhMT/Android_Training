package com.nguyenoanh.managerstudent.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (entities = {InforStudent.class}, version = 1, exportSchema = false)
public abstract class InforStudentDatabase extends RoomDatabase {
    public abstract InforStudentDao studentDao();

}
