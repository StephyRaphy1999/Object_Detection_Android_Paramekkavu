package com.example.a_eye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class base_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        BottomNavigationView bottomNavView = findViewById(R.id.bottom);
        home home1=new home();
        history history1=new history();
        profile profile1=new profile();
        bottomNavView.setOnNavigationItemSelectedListener(item -> {

            if(item.getItemId()==R.id.home) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.field, new home())
                        .commit();
                return true;
            }
           else if(item.getItemId()==R.id.history) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.field, new history())
                        .commit();
                return true;
            }
            else if(item.getItemId()==R.id.profile) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.field, new profile())
                        .commit();
                return true;
            }
               return false;
           });
    }
}