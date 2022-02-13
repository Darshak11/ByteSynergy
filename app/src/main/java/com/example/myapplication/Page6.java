package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Page6 extends AppCompatActivity {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);
        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Maize", "Paddy", "Sugarcane","Sapota","Cocoa","Ginger","Jowar","Lemon Grass","Ragi","Ground Nuts","Cocunut","Cotton","Malbury Silk","Sun Flower","Horse Gram","Bengal Gram","Banana","Grapes","Lemon","Bajra","Cardamom","Turmeric"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        Spinner dropdown2 = findViewById(R.id.spinner2);
        String[] items2= new String[]{"0.5 Ton","1 Ton","5 Ton","10 Ton"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);
        final EditText name = findViewById(R.id.editTextTextPersonName);
        final EditText number = findViewById(R.id.editTextPhone);
        Button bt = findViewById(R.id.button5);
        bt.setEnabled(false);
        while(true)
        {
            if(!name.getText().toString().matches("") && !number.getText().toString().matches(""))
            {
                bt.setEnabled(true);
                break;
            }
        }
    }
}