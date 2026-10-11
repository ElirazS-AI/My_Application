package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Mission1 extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private TextView textMessage;
    private Button button;
    private TextView textView;
    private Button button3;
    private Button nextButton;
    private Button secretButton;
    private Button backButton;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private Button btnLogin;
    private Button nextButton1;
    private Button backButton1;

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
                ShowSecondActivity();
            }
        });
    }

    private void ShowSecondActivity() {
        setContentView(R.layout.activity_2);
        nextButton1= findViewById(R.id.nextButton1);
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
                ShowFirstActivity();
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
                ThirdActivity();
            }
        });
    }
    private void ThirdActivity(){
        setContentView(R.layout.activity_3);
        backButton1 = findViewById(R.id.backButton1);
        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        textMessage = findViewById(R.id.textMessage);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.length()==0 || etPassword.length()==0){
                    textMessage.setText("לא כל השדות מלאות, נסו שוב");
                }
                else {
                    textMessage.setText("ישששששש");
                }
            }
        });
        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowSecondActivity();
            }
        });

    }
}