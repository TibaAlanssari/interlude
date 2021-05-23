package com.example.interludeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button breathe_meditation_button;
    private Button journal_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breathe_meditation_button = (Button) findViewById(R.id.breathe_meditation_button);
        breathe_meditation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBreatheMeditationActivity();

            }
        });

        journal_button = (Button) findViewById(R.id.journal_button);
        journal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJournalActivity();

            }
        });

    }

    public void openBreatheMeditationActivity() {
        Intent intent = new Intent(this, BreatheMeditation.class);
        startActivity(intent);

    }

    public void openJournalActivity() {
        Intent intent = new Intent(this, Journal.class);
        startActivity(intent);

    }

    }



