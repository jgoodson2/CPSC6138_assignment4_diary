package com.jtgoodson.cpsc6138_assignment4_diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DiaryMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_main);
    }

    public void goToNewDiaryEntry(View view) {
        Intent i = new Intent(this, DiaryNewEntryActivity.class);
        startActivity(i);
    }
}
