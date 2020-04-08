package com.utkarsh.carepath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Answer3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer3);

        Toolbar toolbar = findViewById(R.id.toolbar_answer3);
        setSupportActionBar(toolbar);

        TextView frgmnt1 = findViewById(R.id.frgmnt1);
        TextView frgmnt2 = findViewById(R.id.frgmnt2);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment1()).commit();

        frgmnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment1()).commit();
            }
        });
        frgmnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment2()).commit();
            }
        });
    }
}
