package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Student2 extends AppCompatActivity {
    private Button submit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student2);
    }

    public void browser1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://evarsity.srmuniv.ac.in/srmwebonline/exam/onlineResult.jsp"));
        startActivity(browserIntent);
    }
}