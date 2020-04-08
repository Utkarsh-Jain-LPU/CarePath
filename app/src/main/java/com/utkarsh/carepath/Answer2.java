package com.utkarsh.carepath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Answer2 extends AppCompatActivity {

    private String data,getdata = "";
    private CancelableEdittext edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer2);

        Toolbar toolbar = findViewById(R.id.toolbar_answer2);
        setSupportActionBar(toolbar);

        checkPermission();

        edittext = findViewById(R.id.edit_text_2);

        edittext.requestFocus();

        Button save = findViewById(R.id.save_data);
        save.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                data = Objects.requireNonNull(edittext.getText()).toString().trim();
                if (data.isEmpty()) {
                    Toast.makeText(Answer2.this,"Field is Empty...",Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        File root = new File(Environment.getExternalStorageDirectory(), "Data");
                        if (!root.exists()) {
                            root.mkdirs();
                        }
                        File gpxfile = new File(root, "Record.txt");
                        FileWriter writer = new FileWriter(gpxfile);
                        writer.append(data);
                        writer.flush();
                        writer.close();
                        Toast.makeText(Answer2.this, "Data Saved Successfully...", Toast.LENGTH_SHORT).show();
                        edittext.setText("");
                        edittext.hideButton();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Button show = findViewById(R.id.show_data);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String line;
                    String path = Environment.getExternalStorageDirectory()+"/Data/Record.txt";
                    FileReader fileReader = new FileReader(new File(path));
                    StringBuilder builder = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    while ((line = bufferedReader.readLine()) != null) {
                        builder.append(line);
                        builder.append("\n");
                    }
                    getdata = builder.toString();
                    if (getdata.isEmpty()) {
                        Toast.makeText(Answer2.this,"File is Empty...",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Answer2.this,getdata,Toast.LENGTH_SHORT).show();
                    }
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressLint("InlinedApi")
    private void checkPermission() {

        if (ContextCompat.checkSelfPermission(Answer2.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Answer2.this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},131);
        }
    }

    @SuppressLint("InlinedApi")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 131) {
            if (grantResults[0]!=PackageManager.PERMISSION_GRANTED || grantResults[1]!=PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Answer2.this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},131);
            }
        }
    }
}
