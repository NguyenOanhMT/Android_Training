package com.nguyenoanh.managerstudent.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class InforStudent implements Serializable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    public int id;

    @ColumnInfo(name = "Name")
    public String name;

    @ColumnInfo(name = "Date of birthday")
//    @TypeConverters ({TimesConverter.class})
    public String date;

    @ColumnInfo(name = "Gender")
    public String gender;

    @ColumnInfo(name = "Class Student")
    public String classStudent;

    @ColumnInfo(name = "Address")
    public String address;

    @ColumnInfo(name = "Specialized")
    public String special;

    @Ignore
    public InforStudent(int id, String name, String date, String gender, String address, String special) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.special = special;
    }

    public InforStudent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }
}
