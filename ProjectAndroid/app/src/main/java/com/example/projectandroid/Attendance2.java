package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Attendance2 extends AppCompatActivity {
    TextView nik;
    Spinner spinner,spinner2;
    TextView nama;
    TextView Kelas;
    TextView Date;
    TextView Time;
    TextView mapel;
    private TimePicker timePicker;
    private int hour, min;
    private DatePicker datePicker;
    private Calendar calendar,calendar1;
    private int year, month, day;
    private DbManager dbManager;
    private DbHelper dbHelper;
    private Cursor cursor;
    SQLiteDatabase database;
    SQLiteOpenHelper openHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        spinner = (android.widget.Spinner) findViewById(R.id.spinner);
        spinner2 = (android.widget.Spinner) findViewById(R.id.status);
        openHelper= new DbHelper(this);
        dbManager = new DbManager(this);
        dbManager.open();
        database=openHelper.getReadableDatabase();

        // get date
        Date = (TextView) findViewById(R.id.date);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        //get Time
        Time = (TextView) findViewById(R.id.time);
        calendar1 = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);


        final List<String> categories = new ArrayList<>();
        categories.add("Select Nik");
        categories.add("IPA20001");
        categories.add("IPA20002");
        categories.add("IPA20003");
        categories.add("IPA20004");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        final List<String> categories2 = new ArrayList<>();

        categories2.add("Present");
        categories2.add("Sick");
        categories2.add("Permission");
        categories2.add("Abstain");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
        nik = (TextView) findViewById(R.id.NIK);
        nama = (TextView) findViewById(R.id.Name);
        Kelas = (TextView) findViewById(R.id.kelas);
        Date = (TextView) findViewById(R.id.date);
        Time = (TextView) findViewById(R.id.time);
        mapel = (TextView)findViewById(R.id.subject);

        Button select = (Button) findViewById(R.id.button3);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Id = nik.getText().toString();
                final String name = nama.getText().toString();
                final String tanggal = Date.getText().toString();
                final String waktu = Time.getText().toString();
                final String su=mapel.getText().toString();
                final String stat=spinner2.getSelectedItem().toString();

                dbManager.insert2(Id,name,tanggal,waktu,su,stat);
                Toast.makeText(getApplicationContext(),"Data berhasil dimasukan",Toast.LENGTH_LONG).show();

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {

                String selecteditem = (String) adapterView.getItemAtPosition(i);
                nik.setText(selecteditem);
                String Id = nik.getText().toString();
                cursor = database.rawQuery("Select id, name ,class from Student where id=?", new String[]{Id});
                if (cursor != null) {

                    if (cursor.getCount() > 0) {
                        cursor.moveToNext();

                        String name = cursor.getString(1);
                        String klas = cursor.getString(2);


                        nama.setText(name);
                        Kelas.setText(klas);
                        Bundle bundle=getIntent().getExtras();
                        final String s=bundle.getString("mapel");
                        mapel.setText(s);
                    }


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    //Function Date
    @SuppressWarnings("deprecation")
    public void setDate(View view){
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Date", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if (id == 999){
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }else if (id == 998){
            return new TimePickerDialog(this, myTimeListener, hour, min, true);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            showDate(year, month+1, dayOfMonth);
        }
    };

    private void  showDate(int year, int month, int day) {
        Date.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }

    //Function Timepicker
    @SuppressWarnings("deprecation")
    public void setTime(View view) {
        showDialog(998);
        Toast.makeText(getApplicationContext(), "Time",Toast.LENGTH_SHORT).show();
    }

    private TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hour, int min) {
            showTime(hour, min);
        }
    };

    private void showTime(int hour, int min){
        Time.setText(new StringBuilder().append(hour).append(" : ").append(min).append(" "));
    }


    //funciton imageview
    public void Click(View v){
        this.finish();
    }
}