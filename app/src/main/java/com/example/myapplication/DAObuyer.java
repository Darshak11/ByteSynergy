package com.example.myapplication;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DAObuyer {
    private  DatabaseReference dr;
    public DAObuyer()
    {
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        dr=db.getReference(Buyer.class.getSimpleName());
    }
    public Task<Void> add(Buyer s)
    {
        return dr.push().setValue(s);
    }
    public Task<Void> update(String key, HashMap<String, Object> hashMap){
        return dr.child(key).updateChildren(hashMap);
    }
    public Task<Void> remove(String key)
    {
        return dr.child(key).removeValue();
    }
}
