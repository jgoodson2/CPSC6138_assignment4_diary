package com.jtgoodson.cpsc6138_assignment4_diary;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void saveInfo(View view) {

        EditText username = (EditText) findViewById(R.id.txt_signup_username);
        EditText password = (EditText) findViewById(R.id.txt_signup_password);

        SharedPreferences sharedPref = getSharedPreferences("userPass", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

}
