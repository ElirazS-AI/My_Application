package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Mission1 extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private Button button3;
    private Button nextButton;
    private Button backButton;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ShowFirstActivity();
    }

    private void ShowFirstActivity() {
        setContentView(R.layout.activity_main1);
        button = findViewById(R.id.button);
        button3 = findViewById(R.id.button3);
        textView = findViewById(R.id.textView);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);

        textView.setText("count: " + count);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textView.setText("count: " + count);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                textView.setText("count: " + count);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mission1.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        if (backButton != null) {
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Mission1.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
