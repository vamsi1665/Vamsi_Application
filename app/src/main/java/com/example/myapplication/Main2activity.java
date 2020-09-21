package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2activity extends AppCompatActivity {


    private Button calgpa;
    private Button gengpa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2activity);
        calgpa= (Button)findViewById(R.id.calgpa);
        gengpa= (Button)findViewById(R.id.gengpa);
        calgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2activity.this,StudentActivity.class));
            }
        });
        gengpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2activity.this,Student2.class));
            }
        });
    }
}