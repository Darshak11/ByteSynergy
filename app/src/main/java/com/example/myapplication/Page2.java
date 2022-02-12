package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Page2 extends AppCompatActivity {
    Button bt,bt1;
    TextView tv1;
    FusedLocationProviderClient flp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        bt = findViewById(R.id.button3);
        tv1 = findViewById(R.id.textView2);
        bt1 = findViewById(R.id.button4);
        bt1.setEnabled(false);

        flp = LocationServices.getFusedLocationProviderClient(this);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(Page2.this
                        , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                    bt1.setEnabled(true);
                } else {
                    ActivityCompat.requestPermissions(Page2.this
                            , new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage3();
            }
        });

    }
    public void openPage3() {
        Intent intent = new Intent(this, Page3.class);
        startActivity(intent);
    }

    private void getLocation() {

            flp.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location l = task.getResult();
                    if (l != null) {

                        try {
                            Geocoder g = new Geocoder(Page2.this,
                                    Locale.getDefault());
                            List<Address> a=g.getFromLocation(
                                    l.getLatitude(),l.getLongitude(),1
                            );
                            String cn=a.get(0).getLocality().toString();
                            tv1.setText(cn);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }
            });


    }
}