package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Page8 extends AppCompatActivity {
    Buyer temp;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page8);
        final TextView tv=findViewById(R.id.textView8);
        Intent i=getIntent();
        Buyer temp=(Buyer) i.getSerializableExtra("Buyer");
        if(temp.getInfo().getName()!=null)
        {
            tv.setText("Name: "+temp.getInfo().getName()+"\nMobile No.: "+temp.getInfo().getPhno()+"\nCrop: "+temp.getInfo().getCrop()+"\nQuantity: "+temp.getInfo().getQua());
        }
        else
        {
            tv.setText("No Seller found according to requirements");
        }
    }
}