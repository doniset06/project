package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class LoginTeacher extends AppCompatActivity {
    private DbManager dbManager;
    protected Cursor cursor;

    Button login;
    EditText Id;
    EditText Password;
    SQLiteDatabase database;
    SQLiteOpenHelper openHelper;
    private DbHelper dbHelper;
    private SimpleCursorAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);
        dbManager =new DbManager(this);
        dbManager.open();
        openHelper= new DbHelper(this);
        database=openHelper.getReadableDatabase();
        Id = (EditText) findViewById(R.id.id);
        Password = (EditText) findViewById(R.id.password);


        login = (Button) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usr = Id.getText().toString();
                String Pwd = Password.getText().toString();


                cursor = database.rawQuery("Select*from Teacher where id=?  and password =? ",new String[]{usr,Pwd});


                if (cursor!=null) {

                if (cursor.getCount()>0) {

                        cursor.moveToNext();
                String id = cursor.getString(1);
     String nama =cursor.getString(2);
       String subject =cursor.getString(4);
                    Intent i = new Intent(LoginTeacher.this, HomePage.class);
                    i.putExtra("teacher",id);
                    i.putExtra("nama",nama);
                    i.putExtra("mapel",subject);
                        startActivity(i);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Password dont match", Toast.LENGTH_LONG).show();
                }
            }

        });
    }}
