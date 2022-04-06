package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvRes;
    Spinner spnProf, spnPerson;
    Button btnSubmit;
    String person[] = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step 3
        tvRes = findViewById(R.id.tvResult);
        spnPerson = findViewById(R.id.spnProfession);
        spnProf = findViewById(R.id.spnProfessional);
        btnSubmit = findViewById(R.id.btnSubmit);

        spnProf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0:
                        person = new String[]{"Narendra Modi", "Mamta Benarjee", "Rahul Gandhi", "Yogi Adityanath"};
                        break;
                    case 1:
                        person = new String[]{"Dr. Kamal", "Albert Einstein", "Newton", "Dr." };
                        break;
                    case 2:
                        person = new String[]{"M S Dhoni", "Ronaldo", "Sachin"};
                        break;
                    case 3:
                        person = new String[]{"Jagjit Singh", "R.D. Burman", "AR Rahman"};
                        break;
                    case 4:
                        person = new String[]{"Ratan Tata", "Aditya Birla", "Jindal"};
                        break;
                }
                ArrayAdapter<String> adt = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, person);
                spnPerson.setAdapter(adt);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Professional =spnProf.getSelectedItem().toString();
                String Profession = spnPerson.getSelectedItem().toString();

                tvRes.setText(Professional+" is a "+Profession);
            }
        });
    }
}