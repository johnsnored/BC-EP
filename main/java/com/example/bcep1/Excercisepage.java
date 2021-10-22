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

public class Excercisepage extends AppCompatActivity {

    Button homepage, muscle, weightbutton;
    TextView workout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercisepage);

        weightbutton = findViewById(R.id.loseweight);
        weightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Excercisepage.this, Weightworkout.class));
            }
        });

        muscle = findViewById(R.id.Muscle);
        muscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Excercisepage.this, Muscleworkout.class));
            }
        });


        homepage = findViewById(R.id.homepage);
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Excercisepage.this, com.example.bcep1.MainActivity.class));
            }
        });
    }
}

