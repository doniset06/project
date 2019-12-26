package com.example.projectandroid;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class modipa1 extends Activity implements View.OnClickListener {

    EditText Number, Nik, Nama, Date, Time, Subject, Status;
    private Long _id;
    private DbManager dbManager;
private String sta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modipa1);
        dbManager = new DbManager(this);
        dbManager.open();

//        final List<String> categories2 = new ArrayList<>();
//
//        categories2.add("Present");
//        categories2.add("Sick");
//        categories2.add("Permission");
//        categories2.add("Abstain");
//
//        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>
//                (this, android.R.layout.simple_spinner_item, categories2);
//        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(dataAdapter2);
        Number = (EditText) findViewById(R.id.number);
        Nik = (EditText) findViewById(R.id.NIK);
        Nama = (EditText) findViewById(R.id.Name);
        Date = (EditText) findViewById(R.id.date);
        Time = (EditText) findViewById(R.id.time);
        Subject = (EditText) findViewById(R.id.subject);
        Status=(EditText)findViewById(R.id.status);



        Intent intent = getIntent();
        String num = intent.getStringExtra("_id");
        String Id = intent.getStringExtra("id");
        String nam = intent.getStringExtra("name");
        String dat = intent.getStringExtra("date");
        String tim = intent.getStringExtra("time");
        String sub = intent.getStringExtra("subject");
        String stat = intent.getStringExtra("status");


        _id = Long.parseLong(num);
        Nik.setText(Id);
        Nama.setText(nam);
        Date.setText(dat);
        Time.setText(tim);
        Subject.setText(sub);
        Status.setText(stat);

        Button update = (Button) findViewById(R.id.button3);
        Button delete = (Button) findViewById(R.id.button4);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:


                String status = Status.getText().toString();
                dbManager.update1(_id, status);
                this.returnHome();
                break;
            case R.id.button4:
                dbManager.delete1(_id);
                this.returnHome();

        }
    }


    public void returnHome() {

        String sub = Subject.getText().toString();
        Intent home_intent = new Intent(getApplicationContext(),
                IPA1.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        home_intent.putExtra("mapel",sub);
        startActivity(home_intent);
    }

    //function imageview
    public void Click(View v){

        this.finish();
    }
}

