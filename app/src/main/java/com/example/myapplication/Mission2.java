package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Mission2 extends AppCompatActivity {

    private int currentMission = 1;

    private EditText etUrl;
    private Button btnGo, btnBrowserBack, btnBrowserForward, btnNextMission, btnPrevMission;
    private WebView webView;

    private ImageView ivDice;
    private Button btnRoll, btnNextMission2, btnPrevMission2;
    private Random random;

    private RadioGroup rgAnswers;
    private Button btnCheckTrivia, btnNextMission3, btnPrevMission3;

    private Switch switchAc;
    private TextView tvAcStatus;
    private Button btnNextMission4, btnPrevMission4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        loadCurrentMission();
    }

    private void loadCurrentMission() {
        if (currentMission == 1) {
            showBrowserMission();
        } else if (currentMission == 2) {
            showDiceMission();
        } else if (currentMission == 3) {
            showTriviaMission();
        } else if (currentMission == 4) {
            showSmartHomeMission();
        }
    }

    public void showBrowserMission() {
        setContentView(R.layout.activity_browser);

        etUrl = findViewById(R.id.etUrl);
        btnGo = findViewById(R.id.btnGo);
        btnBrowserBack = findViewById(R.id.btnBrowserBack);
        btnBrowserForward = findViewById(R.id.btnBrowserForward);
        btnNextMission = findViewById(R.id.btnNextMission);
        btnPrevMission = findViewById(R.id.btnPrevMission);
        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (etUrl != null && url != null) {
                    etUrl.setText(url);
                }
            }
        });
        webView.loadUrl("https://www.google.com");

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etUrl.getText().toString().trim();
                if (!url.isEmpty()) {
                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "https://" + url;
                    }
                    webView.loadUrl(url);
                }
            }
        });

        btnBrowserBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                }
            }
        });

        btnBrowserForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoForward()) {
                    webView.goForward();
                }
            }
        });

        btnNextMission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentMission = 2;
                loadCurrentMission();
            }
        });

        btnPrevMission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentMission = 4;
                loadCurrentMission();
            }
        });
    }

    public void showDiceMission() {
        setContentView(R.layout.activity_dice);

        ivDice = findViewById(R.id.ivDice);
        btnRoll = findViewById(R.id.btnRoll);
        btnNextMission2 = findViewById(R.id.btnNextMission2);
        btnPrevMission2 = findViewById(R.id.btnPrevMission2);
        random = new Random();

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNumber = random.nextInt(6) + 1;
                switch (randomNumber) {
                    case 1: ivDice.setImageResource(R.drawable.dice_1); break;
                    case 2: ivDice.setImageResource(R.drawable.dice_2); break;
                    case 3: ivDice.setImageResource(R.drawable.dice_3); break;
                    case 4: ivDice.setImageResource(R.drawable.dice_4); break;
                    case 5: ivDice.setImageResource(R.drawable.dice_5); break;
                    case 6: ivDice.setImageResource(R.drawable.dice_6); break;
                }
            }
        });

        btnNextMission2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentMission = 3;
                loadCurrentMission();
            }
        });

        btnPrevMission2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentMission = 1;
                loadCurrentMission();
            }
        });
    }

    public void showTriviaMission() {
        setContentView(R.layout.activity_trivia);

        rgAnswers = findViewById(R.id.rgAnswers);
        btnCheckTrivia = findViewById(R.id.btnCheckTrivia);
        btnNextMission3 = findViewById(R.id.btnNextMission3);
        btnPrevMission3 = findViewById(R.id.btnPrevMission3);

        btnCheckTrivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgAnswers.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(Mission2.this, "אנא בחר תשובה", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedId == R.id.rbJerusalem) {
                    Toast.makeText(Mission2.this, "כל הכבוד!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Mission2.this, "טעות, נסה שוב", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnNextMission3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentMission = 4;
                loadCurrentMission();
            }
        });

        btnPrevMission3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentMission = 2;
                loadCurrentMission();
            }
        });
    }

    public void showSmartHomeMission() {
        setContentView(R.layout.activity_smart_home);

        switchAc = findViewById(R.id.switchAc);
        tvAcStatus = findViewById(R.id.tvAcStatus);
        btnNextMission4 = findViewById(R.id.btnNextMission4);
        btnPrevMission4 = findViewById(R.id.btnPrevMission4);

        switchAc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvAcStatus.setText("המזגן פועל מקרר!");
                    tvAcStatus.setTextColor(Color.BLUE);
                } else {
                    tvAcStatus.setText("המזגן כבוי");
                    tvAcStatus.setTextColor(Color.GRAY);
                }
            }
        });

        btnNextMission4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentMission = 1;
                loadCurrentMission();
            }
        });

        btnPrevMission4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentMission = 3;
                loadCurrentMission();
            }
        });
    }
}