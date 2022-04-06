package com.example.mygfirstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText edtNum1, edtNum2;
    Button btnAdd, btnMul, btnDiv, btnSub;
    int n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //step 3
        tvResult = findViewById(R.id.Output);
        btnAdd = findViewById(R.id.btnadd);
        btnMul = findViewById(R.id.btnmul);
        btnDiv = findViewById(R.id.btndiv);
        btnSub = findViewById(R.id.btnSub);
        edtNum1 = findViewById(R.id.edtnum1);
        edtNum2 = findViewById(R.id.edtnum2);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1, num2;
                num1= edtNum1.getText().toString();
                num2= edtNum2.getText().toString();

                n1=Integer.parseInt(num1);
                n2=Integer.parseInt(num2);
                int res=n1+n2;
                tvResult.setText(String.valueOf(res));
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1, num2;
                num1= edtNum1.getText().toString();
                num2= edtNum2.getText().toString();

                n1=Integer.parseInt(num1);
                n2=Integer.parseInt(num2);
                int res=n1/n2;
                tvResult.setText(String.valueOf(res));
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1, num2;
                num1= edtNum1.getText().toString();
                num2= edtNum2.getText().toString();

                n1=Integer.parseInt(num1);
                n2=Integer.parseInt(num2);
                int res=n1*n2;
                tvResult.setText(String.valueOf(res));
            }
        });
    }
}