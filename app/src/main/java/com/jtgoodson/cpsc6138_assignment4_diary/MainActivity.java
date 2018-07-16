package com.jtgoodson.cpsc6138_assignment4_diary;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

    public void goToSignUp(View view) {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
    }
}
