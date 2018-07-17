package com.jtgoodson.cpsc6138_assignment4_diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DiaryNewEntryActivity extends AppCompatActivity {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    EditText subject;
    EditText content;
    DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_new_entry);

        subject = (EditText) findViewById(R.id.txt_subject);
        content = (EditText) findViewById(R.id.txt_content);
        dao = new DAO(this, null, null, 1);

    }

    public void insertRecord(View view) {
        DiaryEntry de = new DiaryEntry(sdf.format(new Timestamp(System.currentTimeMillis()))
                , subject.getText().toString()
                , content.getText().toString());
        dao.addDiaryEntry(de);
        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, DiaryMainActivity.class);
        startActivity(i);
    }

}
