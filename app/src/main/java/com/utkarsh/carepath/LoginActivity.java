package com.utkarsh.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText un,pass;
    private String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        un = findViewById(R.id.username);
        pass = findViewById(R.id.password);

        getData();

        un.requestFocus();

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this,"All fields must be filled...",Toast.LENGTH_SHORT).show();
                }
                else if (username.equals("utkarshjain") && password.equals("qwertyuiop")) {
                    sharedPreferences.edit().putString("username",username).apply();
                    sharedPreferences.edit().putString("password",password).apply();
                    Toast.makeText(LoginActivity.this,"Login Successfully...",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this,"Invalid Credentials...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void getData() {

        username = un.getText().toString().trim();
        password = pass.getText().toString().trim();
    }
}
