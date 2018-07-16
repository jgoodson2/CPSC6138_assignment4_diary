package com.jtgoodson.cpsc6138_assignment4_diary;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "jonathon";
    private static final String NVL_USERNAME = "no-username-set";
    private static final String NVL_PASSWORD = "no-password-set";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences("userPass", Context.MODE_PRIVATE);

        String username = sharedPref.getString("username", NVL_USERNAME);
        String password = sharedPref.getString("password", NVL_PASSWORD);
        TextView userPwHint = (TextView) findViewById(R.id.lbl_userPwHint);
        if (!username.equalsIgnoreCase(NVL_USERNAME))
            userPwHint.setText("(Hint: user credentials are " + username + "/" + password + " )");
    }

    public void authenticateUser(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userPass", Context.MODE_PRIVATE);
        String username = sharedPref.getString("username", NVL_USERNAME);
        String password = sharedPref.getString("password", NVL_PASSWORD);

        EditText input_username = (EditText) findViewById(R.id.txt_signin_username);
        EditText input_password = (EditText) findViewById(R.id.txt_signin_password);

        if (!(input_username.getText().toString().equalsIgnoreCase(username) && input_password.getText().toString().equals(password))) {
            System.out.println("authentication failed");
            Toast.makeText(this, R.string.invalid_credentials, Toast.LENGTH_LONG).show();

        } else {
            System.out.println("user authenticated successfully");
            Intent i = new Intent(this, DiaryMainActivity.class);
            startActivity(i);
        }

    }

    public void goToSignUp(View view) {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
    }
}
