package com.jtgoodson.cpsc6138_assignment4_diary;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "jonathon";
    private static final String NVL_USERNAME = "no-username-set";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SharedPreferences sharedPref = getSharedPreferences("userPass", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("username", null);
//        editor.apply();

//        String username = sharedPref.getString("username", NVL_USERNAME); //the second arg is like a nvl value
//        if (!username.equalsIgnoreCase(NVL_USERNAME)) {
//            Log.i(TAG, "username set; redirect to sign in: " + username);
//            setContentView(R.layout.activity_main);
//        } else {
//            Log.i(TAG, "username NOT set; redirect to sign up");
////            goToSignUp();
//            Intent i = new Intent(this, SignUpActivity.class);
////            startActivity(i);
//        }
    }

    public void goToSignUp(View view) {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
        System.out.println("this is when i am supposed to go to sign up screen");
    }
}
