package com.example.a_eye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class signin extends AppCompatActivity {
    private TextView uSelection;
    private Button base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        uSelection=findViewById(R.id.textView2);
        uSelection.setOnClickListener(view -> {
            uSelection();
        });
        base=findViewById(R.id.button3);
        base.setOnClickListener(view -> {
            base();
        });
    }
    private void uSelection(){
        Intent intent=new Intent(this,userselection. class);
        startActivity(intent);
        finish();
    }
    private void base(){
        Intent intent=new Intent(this,base_activity. class);
        startActivity(intent);
        finish();
    }
}