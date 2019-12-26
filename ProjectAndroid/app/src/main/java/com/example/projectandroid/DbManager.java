package com.example.projectandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManager {
    private DbHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DbManager(Context c) {
        context = c;
    }

    public DbManager open() throws SQLException {
        dbHelper = new DbHelper(context);
        database = dbHelper.getWritableDatabase();

        return this;
    }

    public void close() {
        dbHelper.close();

    }

    public void insert1(String id, String nama, String date, String time, String subject, String status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", nama);
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("subject", subject);
        contentValues.put("status", status);
        database.insert("Absensi1", null, contentValues);


    }

    public void insert2( String id, String nama, String date, String time, String subject, String status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", nama);
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("subject", subject);
        contentValues.put("status", status);
        database.insert("Absensi2", null, contentValues);


    }
    public Cursor fetch1(String sub) {

        String[] columns = new String[] { "_id", "id","name","date","time","subject","status"};
        Cursor cursor = database.rawQuery("select*from Absensi1 where subject =?",new String[]{sub});
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public Cursor fetch2(String sub) {
        String[] columns = new String[] { "_id", "id","name","date","time","subject","status"};
        Cursor cursor = database.rawQuery("select*from Absensi2 where subject=?",new String[]{sub});
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public int update1(Long _id,String status) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("status", status);
        int i = database.update("Absensi1", contentValues,
                "_id"+ " = " +_id, null);
        return i;
    }
    public void delete1(long _id) {

        database.delete("Absensi1", "_id" + "="
                + _id, null);
    }
    public int update2(Long _id,String status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", status);
        int i = database.update("Absensi2", contentValues,
                "_id"+ " = " +_id, null);
        return i;
    }
    public void delete2(long _id) {

        database.delete("Absensi2", "_id" + "="
                + _id, null);
    }
}
