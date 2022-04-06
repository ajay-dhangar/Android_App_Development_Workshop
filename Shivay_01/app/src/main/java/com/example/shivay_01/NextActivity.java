package com.example.shivay_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NextActivity extends AppCompatActivity {
    Button btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        btnPrev = findViewById(R.id.btnPrevAct);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(NextActivity.this, MainActivity.class);
                startActivity(int1);
            }
        });
    }
}