package com.utkarsh.carepath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import java.util.List;
import java.util.Vector;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Fragment> fragments = new Vector<>();
        fragments.add(Fragment.instantiate(this,Tab1.class.getName()));
        fragments.add(Fragment.instantiate(this,Tab2.class.getName()));
        fragments.add(Fragment.instantiate(this,Tab3.class.getName()));

        ViewPager viewPager = findViewById(R.id.view_pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager,true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.answer_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.answer2) {
            Intent intent = new Intent(HomeActivity.this,Answer2.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.answer3){
            Intent intent = new Intent(HomeActivity.this,Answer3.class);
            startActivity(intent);
        }
        return true;
    }
}
