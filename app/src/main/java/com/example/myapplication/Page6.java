package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Page6 extends AppCompatActivity {
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);
        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Maize", "Paddy", "Sugarcane", "Sapota", "Cocoa", "Ginger", "Jowar", "Lemon Grass", "Ragi", "Ground Nuts", "Cocunut", "Cotton", "Malbury Silk", "Sun Flower", "Horse Gram", "Bengal Gram", "Banana", "Grapes", "Lemon", "Bajra", "Cardamom", "Turmeric"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        Spinner dropdown2 = findViewById(R.id.spinner2);
        String[] items2 = new String[]{"0.5 Ton", "1 Ton", "5 Ton", "10 Ton"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);
        final EditText name = findViewById(R.id.editTextTextPersonName);
        final EditText number = findViewById(R.id.editTextPhone);
        Button bt = findViewById(R.id.button5);
        bt.setEnabled(false);
        DAOseller daos = new DAOseller();
        DAObuyer dao = new DAObuyer();
        ArrayList<Seller> se = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>();
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference();
        DatabaseReference dr2 = dr.child("Seller");
        dr2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dsp : snapshot.getChildren()) {
                    keys.add(dsp.getKey());
                    Seller s = new Seller();
                    ArrayList<String> val = new ArrayList<>();
                    for (DataSnapshot bump : dsp.getChildren()) {
                        val.add(String.valueOf(bump.getValue()));
                    }
                    s.setCrop(val.get(0));
                    s.setName(val.get(1));
                    s.setPhno(val.get(2));
                    s.setQua(val.get(3));
                    se.add(s);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        if (true) {
            bt.setEnabled(true);
            bt.setOnClickListener(v -> {
                Seller req=new Seller();
                boolean flag = false;
                for (int i = 0; i < se.size(); i++) {
                    Seller temp = se.get(i);
                    if (temp.getCrop().equals(dropdown.getSelectedItem()) && temp.getQua().equals(dropdown2.getSelectedItem())) {
                        req = temp;
                        daos.remove(keys.get(i));
                        flag = true;
                        break;
                    }
                }
                Buyer s = new Buyer(name.getText().toString(), number.getText().toString(), dropdown.getSelectedItem().toString(), dropdown2.getSelectedItem().toString(), req);
                dao.add(s).addOnCompleteListener(suc -> {
                    Intent intent = new Intent(this, Page8.class);
                    intent.putExtra("Buyer",s);
                    startActivity(intent);
                }).addOnFailureListener(err -> {
                    Toast.makeText(this, "" + err.getMessage(), Toast.LENGTH_SHORT).show();
                });
            });
        }
    }

}