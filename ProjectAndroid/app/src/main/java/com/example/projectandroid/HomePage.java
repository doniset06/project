package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.List;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    CardView card1, card2;
    TextView Nik;
    TextView Name;
TextView subject;
   private DbManager dbManager;
   private DbHelper dbHelper;
    SQLiteDatabase database;
    SQLiteOpenHelper openHelper;

    protected Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        card1 = (CardView)findViewById(R.id.card1);
        card1.setOnClickListener(this);
        card2 = (CardView)findViewById(R.id.card2);
        card2.setOnClickListener(this);

        Nik = (TextView)findViewById(R.id.NIKName);
        Name = (TextView)findViewById(R.id.userName);
       subject= (TextView)findViewById(R.id.subject);
        int listcounter=0;
        dbManager =new DbManager(this);
        dbManager.open();
        openHelper= new DbHelper(this);
        database=openHelper.getReadableDatabase();






        Intent intent = getIntent();
        String addition = (String)intent.getSerializableExtra("teacher");
        String addition1 = (String)intent.getSerializableExtra("nama");
        String addition2 = (String)intent.getSerializableExtra("mapel");

   Nik.setText(addition);
   Name.setText(addition1);
 subject.setText(addition2);
    }

    @Override
    public void onClick(View v) {
        String mapel = subject.getText().toString();
        String nama = Name.getText().toString();
        String id = Nik.getText().toString();
        switch (v.getId()){
            case R.id.card1 :
                Intent i = new Intent(HomePage.this, SelectAttendance.class);
                i.putExtra("teacher",id);
                i.putExtra("nama",nama);
                i.putExtra("mapel",mapel);
                startActivity(i);
                break;
            case R.id.card2 :
                Intent student = new Intent(HomePage.this, SelectClass.class);
                startActivity(student);
                student.putExtra("teacher",id);
                student.putExtra("nama",nama);
                student.putExtra("mapel",mapel);
                startActivity(student);
                break;
            default:
                break;
    }
}
    //funciton imageview
    public void Click(View v){
        Intent login = new Intent(getApplicationContext(),LoginTeacher.class);
        startActivity(login);
    }
}
