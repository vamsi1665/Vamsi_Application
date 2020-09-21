package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {

    private Button ok;
    private EditText number1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        ok=(Button)findViewById(R.id.enter);
        number1=(EditText)findViewById(R.id.number);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(number1.getText().toString())||number1.getText().toString().equals("0")){
                    Toast.makeText(StudentActivity.this, "enter valid text", Toast.LENGTH_SHORT).show();
                }


                else {

                    Intent i=new Intent(StudentActivity.this,SelectActivity.class);
                    i.putExtra("subjects",Integer.parseInt(number1.getText().toString()));
                    startActivity(i);
                }
            }});


    }
}