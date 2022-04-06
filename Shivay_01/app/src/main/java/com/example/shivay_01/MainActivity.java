package com.example.shivay_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity<btnSpin> extends AppCompatActivity {
    //Step 2
    Button btnNext, btnSpin, btnBro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 3

        btnNext = findViewById(R.id.btnNextAct);
        btnSpin = findViewById(R.id.btnSpinnerAct);
        btnBro = findViewById(R.id.btnBrowserAct);

        //Step 4

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainActivity.this, NextActivity.class);
                startActivity(int1);
            }
        });
        btnBro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(int1);
            }
        });

        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent("myHandler");
                startActivity(int1);
            }
        });
    }
}