package com.example.interludeapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class JournalDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VER = 2;
    private static final String DATABASE_TABLE = "journalDBTable";
    private static final String DATABASE_NAME = "journal";

    //database columns:
    private static final String ID = "id";
    private static final String CONTENT = "id";
    private static final String DATE = "id";
    private static final String TIME = "id";
    private static final String TITLE = "id";

    JournalDatabase(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating database table
        String query = "create table " + DATABASE_TABLE + "(" + ID + "int primary key," +
                TITLE + "text," +
                CONTENT + "text," +
                DATE + "text," +
                TIME + "text" + ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion >= newVersion){
            return;
        }
        else{
            db.execSQL("drop table if exists " + DATABASE_TABLE);
            onCreate(db);
        }


    }
}
