package com.utkarsh.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] username = new String[1];
        final String[] password = new String[1];
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!sharedPreferences.getString("username","").equals("")) {
                    username[0] = sharedPreferences.getString("username","");
                }
                else{
                    username[0] = "";
                }
                if (!sharedPreferences.getString("password","").equals("")) {
                    password[0] = sharedPreferences.getString("password","");
                }
                else {
                    password[0] = "";
                }
                if (username[0].equals("utkarshjain") && password[0].equals("qwertyuiop")) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        },3000);
    }
}
