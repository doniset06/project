package com.example.projectandroid;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IPA2 extends AppCompatActivity {
    private DbManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { "_id","id","name", "date", "time","subject","status" };
    final int[] to = new int[] { R.id.number, R.id.Nik, R.id.name, R.id.date, R.id.time ,R.id.subject,R.id.status };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityipa1);
        Intent intent = getIntent();
        String addition = (String)intent.getSerializableExtra("mapel");
        dbManager = new DbManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch2(addition);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));
        adapter = new SimpleCursorAdapter(this, R.layout.activity_ipa1, cursor, from, to, 0);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                // Mengambil nilai list yang dipilih
                TextView noTextView = (TextView) view.findViewById(R.id.number);
                TextView idTextView = (TextView) view.findViewById(R.id.Nik);
                TextView nameTextView = (TextView) view.findViewById(R.id.name);
                TextView dateTextView = (TextView) view.findViewById(R.id.date);
                TextView timeTextView = (TextView) view.findViewById(R.id.time);
                TextView subjectTextView = (TextView) view.findViewById(R.id.subject);
                TextView statusTextView = (TextView) view.findViewById(R.id.status);
                // Menyimpan nilai list yang di pilih ke variabel
                String number = noTextView.getText().toString();
                String  id = idTextView.getText().toString();
                String  name= nameTextView.getText().toString();
                String date = dateTextView.getText().toString();
                String time = timeTextView.getText().toString();
                String subject = subjectTextView.getText().toString();
                String status = statusTextView.getText().toString();
                // Proses Intent untuk mengirim data ke halaman Edit
                Intent modify_intent = new Intent(getApplicationContext(), modipa1.class);
                modify_intent.putExtra("_id", number);
                modify_intent.putExtra("id", id);
                modify_intent.putExtra("name", name);
                modify_intent.putExtra("date",date );
                modify_intent.putExtra("time", time);
                modify_intent.putExtra("subject", subject);
                modify_intent.putExtra("status", status);
                startActivity(modify_intent);
            }
        });
    }




}
