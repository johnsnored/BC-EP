package com.example.bcep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bcep1.R;

public class bmicalc extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Button backbtn,calc,nextpage;
    EditText Weight,Height;
    TextView BmiValue,bmimsg;
    String gender;
    double bmi;
    int weight,height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalc);
        Weight = findViewById(R.id.weightvalue);
        Height = findViewById(R.id.heightvalue);
        calc = findViewById(R.id.calc);
        nextpage = findViewById(R.id.nextpage);
        BmiValue = findViewById(R.id.bmivalue);
        bmimsg = findViewById(R.id.bmimsg);

        calc.setOnClickListener(this);
        backbtn = findViewById(R.id.prevpage);
        backbtn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           startActivity(new Intent(bmicalc.this, com.example.bcep1.MainActivity.class));
                                       }
                                   }
        );
        nextpage.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bmicalc.this, com.example.bcep1.Excercisepage.class));
            }
        }));

        spinner = (Spinner) findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(this, R.array.genders , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                gender=parent.getItemAtPosition(position).toString().trim();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        int viewId=v.getId();
        if(viewId==R.id.calc)
        {
              weight = Integer.parseInt(Weight.getText().toString());
              height = Integer.parseInt(Height.getText().toString());
            bmi = weight*10000/(height*height);
            BmiValue.setText(Double.toString(bmi));
            if (bmi < 18.5)
                bmimsg.setText("You are underweight.");
            else if (bmi >= 18.5 && bmi < 25.0)
                bmimsg.setText("You are normal weight.");
            else if (bmi >= 25.0 && bmi < 30.0)
                bmimsg.setText("You are overweight.");
            else
                bmimsg.setText("You are obese.");
        }
    }
}