package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SelectAttendance extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_attendance);
        TextView Nik =(TextView) findViewById(R.id.NIKName);
        TextView Name =(TextView) findViewById(R.id.userName);
        final TextView Subject =(TextView) findViewById(R.id.subject);
        Intent intent = getIntent();
        String addition = (String)intent.getSerializableExtra("teacher");
        String addition1 = (String)intent.getSerializableExtra("nama");
        String addition2 = (String)intent.getSerializableExtra("mapel");

        Nik.setText(addition);
        Name.setText(addition1);
        Subject.setText(addition2);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);


        final List<String> categories = new ArrayList<>();
        categories.add("Select Course");
        categories.add("IPA1");
        categories.add("IPA2");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        Button select = (Button)findViewById(R.id.button2);
        select.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View v) {
                String mapel =Subject.getText().toString();
                    if (spinner.getSelectedItem().equals("IPA1")) {

                        Intent i = new Intent(SelectAttendance.this, Attendance.class);
                        i.putExtra("mapel",mapel);
                        startActivity(i);
                    }
                    else if(spinner.getSelectedItem().equals("IPA2")){

                        Intent i = new Intent(SelectAttendance.this, Attendance2.class);
                        i.putExtra("mapel",mapel);
                        startActivity(i);
                    }
                }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Click(View v){
        this.finish();
    }
}

