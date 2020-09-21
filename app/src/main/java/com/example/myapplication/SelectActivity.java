package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {
    private Button CALUCULATE;
    private RecyclerView alpha;
    private TextView result;
    private ArrayList<MyItem>list;
    private int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        result=findViewById(R.id.result);
        CALUCULATE=(Button)findViewById(R.id.caluculate);
        alpha=(RecyclerView)findViewById(R.id.recyclerview);
        size=getIntent().getExtras().getInt("subjects");
        list=new ArrayList<>();
        for (int i=0;i<size;i++)
            list.add(new MyItem(0,1));
        Log.e("Tests", "onCreate: "+list.size()+size );
        GradesAdapter adapter=new GradesAdapter(list,null);
        alpha.setLayoutManager(new LinearLayoutManager(this));
        alpha.setAdapter(adapter);
        CALUCULATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double grade=0.0;
                int credits=0;
                for (int i=0;i<size;i++){
                    grade+=getGrade(list.get(i).getSubgrade())*list.get(i).getCredits();
                    credits+=list.get(i).getCredits();

                }
                result.setText(String.valueOf(grade/credits));


            }
        });
    }
    int getGrade(int pos){
        switch(pos){
            case 0:
                return 10;
            case 1:
                return 9;
            case 2:
                return 8;
            case 3:
                return 7;
            case 4:
                return 6;
            case 5:
                return 5;
            case 6:
                return 4;
            default:return 0;
        }
    }
}