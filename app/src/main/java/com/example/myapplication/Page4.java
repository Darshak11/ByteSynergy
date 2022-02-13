package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class Page4 extends AppCompatActivity {
    ArrayList<ArrayList<String>> crops=new ArrayList<>();
    ArrayList <String> j =new ArrayList<String>();
    Button bt1,bt2,bt3;
    TextView tv1;
    Calendar c;
    int month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        j.add("January");
        j.add("Maize");
        j.add("Sapota");
        j.add("Cocoa");
        crops.add(j);
        ArrayList <String> f =new ArrayList<String>();
        f.add("February");
        f.add("Maize");
        f.add("Sapota");
        f.add("Cocoa");
        crops.add(f);
        ArrayList <String> m =new ArrayList<String>();
        m.add("March");
        m.add("Ginger");
        m.add("Jowar");
        m.add("LemonGrass");
        crops.add(m);
        ArrayList <String> a =new ArrayList<String>();
        a.add("April");
        a.add("Banana");
        a.add("Jowar");
        a.add("Turmeric");
        crops.add(a);
        ArrayList <String> ma =new ArrayList<String>();
        ma.add("May");
        ma.add("Coconut");
        ma.add("Sapota");
        ma.add("Banana");
        crops.add(ma);
        ArrayList <String> ju =new ArrayList<String>();
        ju.add("June");
        ju.add("Ragi");
        ju.add("Paddy");
        ju.add("Groundnuts");
        crops.add(ju);
        ArrayList <String> jul =new ArrayList<String>();
        jul.add("July");
        jul.add("Bajra");
        jul.add("Maize");
        jul.add("Sunflower");
        crops.add(jul);
        ArrayList <String> au =new ArrayList<String>();
        au.add("August");
        au.add("Horsegram");
        au.add("Malbury Silk");
        au.add("Cotton");
        crops.add(au);
        ArrayList <String> sep=new ArrayList<String>();
        sep.add("September");
        sep.add("Banana");
        sep.add("Cotton");
        sep.add("Groundnuts");
        crops.add(sep);
        ArrayList <String> oct =new ArrayList<String>();
        oct.add("October");
        oct.add("Bengal Gram");
        oct.add("Banana");
        oct.add("Sugarcane");
        crops.add(oct);
        ArrayList <String> nov =new ArrayList<String>();
        nov.add("November");
        nov.add("Cardamom");
        nov.add("Bengal Gram");
        nov.add("Sugar Cane");
        crops.add(nov);
        ArrayList <String> dec=new ArrayList<String>();
        dec.add("December");
        dec.add("Grapes");
        dec.add("Cardamom");
        dec.add("Sugar Cane");
        crops.add(dec);
        tv1=findViewById(R.id.textView3);

        bt1=findViewById(R.id.button);
        bt2=findViewById(R.id.button2);
        bt3=findViewById(R.id.button3);
        c=Calendar.getInstance();
        month=c.get(Calendar.MONTH);
        String text="The Crops that should be grown in " + crops.get(month).get(0)+ " are: ";
        tv1.setText(text);
        bt1.setText(crops.get(month).get(1));
        bt2.setText(crops.get(month).get(2));
        bt3.setText(crops.get(month).get(3));
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage9();
            }
        });
    }
    public void openPage9() {
        Intent intent = new Intent(this, Page9.class);
        startActivity(intent);
    }
}