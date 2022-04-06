package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //step2
    TextView tvResult;
    EditText edtnum1,edtnum2;
    Button btnAdd,btnSub,btnMult,btnDiv;
    int n1;
    int n2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step3
        tvResult = findViewById(R.id.tvResult);
        edtnum1= findViewById(R.id.editnum1);
        edtnum2= findViewById(R.id.editnum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1,num2;

                num1= edtnum1.getText().toString();
                num2= edtnum2.getText().toString();

                n1=Integer.parseInt(num1);
                n2=Integer.parseInt(num2);
                double sum = n1+n2;
                tvResult.setText(String.valueOf(sum));
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1,num2;

                num1 = edtnum1.getText().toString();
                num2 = edtnum2.getText().toString();

                n1=Integer.parseInt(num1);
                n2=Integer.parseInt(num2);
                double sum = n1-n2;
                tvResult.setText(String.valueOf(sum));
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1,num2;

                num1= edtnum1.getText().toString();
                num2= edtnum2.getText().toString();

                n1=Integer.parseInt(num1);
                n2=Integer.parseInt(num2);
                double sum = n1*n2;
                tvResult.setText(String.valueOf(sum));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1,num2;

                num1= edtnum1.getText().toString();
                num2= edtnum2.getText().toString();

                n1=Integer.parseInt(num1);
                n2=Integer.parseInt(num2);
                double div = (double) n1/n2;
                tvResult.setText(String.valueOf(div));
            }
        });
    }
}