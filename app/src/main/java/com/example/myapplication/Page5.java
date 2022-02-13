package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Page5 extends AppCompatActivity {
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
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
        DAOseller dao=new DAOseller();
        while(true)
        {
            if(!name.getText().toString().matches("") && !number.getText().toString().matches(""))
            {
                bt.setEnabled(true);
                break;
            }
        }
        bt.setOnClickListener(v->{
            Seller s = new Seller(name.getText().toString(),number.getText().toString(),dropdown.getSelectedItem().toString(),dropdown2.getSelectedItem().toString());
            dao.add(s).addOnCompleteListener(suc->{
                openPageSuccessful();
            }).addOnFailureListener(err->{
                Toast.makeText(this,""+err.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

    }

    public void openPageSuccessful() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}