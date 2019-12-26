package com.example.projectandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Absensi.db";
    private static final int DATABASE_VERSION = 1;
    private static final String Create_Teacher = "create table Teacher(number integer primary key autoincrement,id varchar unique not null,name varchar not null,password varchar not null,subject varchar not null);";
    private static final String Create_Student = "create table Student (number integer primary key autoincrement,id varchar unique not null,name varchar not null,password varchar not null,class varchar not null);";
    private static final String Create_Absensi1 = "create table Absensi1 (_id integer primary key autoincrement,id varchar not null,name char not null,date varchar not null,time varchar not null,subject char not null,status char not null);";
    private static final String Create_Absensi2 = "create table Absensi2 (_id integer primary key autoincrement,id varchar not null,name char not null,date varchar not null,time varchar not null,subject char not null,status char not null);";
    private static final String Insert_Teacher = "INSERT INTO Teacher(number,id,name,password,subject) VALUES (null,'IND0001','Joshua Suherman','password','Bahasa Indonesia');";
    private static final String Insert_Teacher2 = "INSERT INTO Teacher(number,id,name,password,subject) VALUES (null,'ENG0001','Bagus Suherman','password1','Bahasa Inggris');";
    private static final String Insert_student1 = "INSERT INTO Student(number,id,name,password,class) VALUES (null,'IPA10001','Ananda Suhenadar','1234','IPA1');";
    private static final String Insert_student2 = "INSERT INTO Student(number,id,name,password,class) VALUES (null,'IPA20001','Bagus Atmojo','bagus123','IPA2');";
    private static final String Insert_student3 = "INSERT INTO Student(number,id,name,password,class) VALUES (null,'IPA10002','Abi Sutmojo','1234','IPA1');";
    private static final String Insert_student4 = "INSERT INTO Student(number,id,name,password,class) VALUES (null,'IPA20002','Budi Setiwan','bagus123','IPA2');";
    private static final String Insert_student5 = "INSERT INTO Student(number,id,name,password,class) VALUES (null,'IPA10003','Bagus Sunandar','1234','IPA1');";
    private static final String Insert_student6 = "INSERT INTO Student(number,id,name,password,class) VALUES (null,'IPA20003','Doni Atmoko','bagus123','IPA2');";
    private static final String Insert_student7 = "INSERT INTO Student(number,id,name,password,class) VALUES (null,'IPA10004','Borju Surahman','1234','IPA1');";
    private static final String Insert_student8 = "INSERT INTO Student(number,id,name,password,class) VALUES (null,'IPA20004','Bayu Aksioma','bagus123','IPA2');";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_Teacher);
        db.execSQL(Create_Student);
        db.execSQL(Create_Absensi1);
        db.execSQL(Create_Absensi2);
        db.execSQL(Insert_Teacher);
        db.execSQL(Insert_Teacher2);
        db.execSQL(Insert_student1);
        db.execSQL(Insert_student2);
        db.execSQL(Insert_student3);
        db.execSQL(Insert_student4);
        db.execSQL(Insert_student5);
        db.execSQL(Insert_student6);
        db.execSQL(Insert_student7);
        db.execSQL(Insert_student8);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "Teacher");
        db.execSQL("DROP TABLE IF EXISTS " + "Student");
        db.execSQL("DROP TABLE IF EXISTS " + "Absensi1");
        db.execSQL("DROP TABLE IF EXISTS " + "Absensi2");
        onCreate(db);


    }





}
