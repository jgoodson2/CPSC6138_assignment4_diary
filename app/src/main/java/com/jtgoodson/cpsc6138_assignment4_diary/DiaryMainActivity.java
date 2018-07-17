package com.jtgoodson.cpsc6138_assignment4_diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DiaryMainActivity extends AppCompatActivity {

    TextView diaryEntries;
    DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_main);

        dao = new DAO(this, null, null, 1);
        diaryEntries = (EditText) findViewById(R.id.txt_diaryEntries);
        diaryEntries.setText(dao.printAllRecords());


    }

    public void goToNewDiaryEntry(View view) {
        Intent i = new Intent(this, DiaryNewEntryActivity.class);
        startActivity(i);
    }
}
