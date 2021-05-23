package com.example.interludeapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toolbar;

public class Journal extends AppCompatActivity {
    Toolbar journal_toolbar;
    RecyclerView journal_recyclerView;
    //private Object Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.journal);

        journal_toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(journal_toolbar);
        journal_recyclerView = findViewById(R.id.journal_notes);
    }
     @Override
     public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.add_menu_item, menu);
            return true;

    }

    private void setSupportActionBar(Toolbar journal_toolbar) {
    }

}