package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;


public class Page3 extends AppCompatActivity
{
    Button bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        bt1=findViewById(R.id.button2);
        bt2=findViewById(R.id.button);
        bt3=findViewById(R.id.button3);
        bt4=findViewById(R.id.button4);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    openPage3();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage5();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage6();
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage7();
            }
        });

    }
    public void openPage3() {
        Intent intent = new Intent(this, Page4.class);
        startActivity(intent);
    }
    public void openPage5() {
        Intent intent = new Intent(this, Page5.class);
        startActivity(intent);
    }
    public void openPage6() {
        Intent intent = new Intent(this, Page6.class);
        startActivity(intent);
    }
    public void openPage7() {
        Intent intent = new Intent(this, Page7.class);
        startActivity(intent);
    }
}