package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button nextButton1;
    private Button secretButton;
    private Button backButton;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);

        nextButton1 = findViewById(R.id.nextButton1);
        secretButton = findViewById(R.id.secretButton);
        backButton = findViewById(R.id.backButton);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        textView1.setText("שם: אלירז");
        textView2.setText("מקצוע: הנדסת תוכנה");
        textView3.setText("משפט: אוהב ליצור אפליקציות");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, Mission1.class);
                startActivity(intent);
            }
        });

        secretButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setText("h............");
            }
        });

        nextButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
