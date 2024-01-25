package com.example.a_eye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class userselection extends AppCompatActivity {

    private ImageView signUp1;
    private ImageView signUp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userselection);
        signUp1=findViewById(R.id.blind);
        signUp1.setOnClickListener(view -> {
            signUp1();
        });
        signUp2=findViewById(R.id.caretaker);
        signUp2.setOnClickListener(view -> {
            signUp2();
        });
    }
    private void signUp1(){
        Intent intent=new Intent(this, signupblind. class);
        startActivity(intent);
        finish();
    }
    private void signUp2(){
        Intent intent=new Intent(this, signupcaretaker. class);
        startActivity(intent);
        finish();
    }
}