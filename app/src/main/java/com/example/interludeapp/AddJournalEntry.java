package com.example.interludeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toolbar;

public class AddJournalEntry extends AppCompatActivity {
    Toolbar journal_toolbar;
    EditText entry_title, entry_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_journal_entry);
        journal_toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(journal_toolbar);

        entry_title = findViewById(R.id.entry_title);
        entry_text = findViewById(R.id.entry_title);

    }

    private void setSupportActionBar(Toolbar journal_toolbar) {
    }
}