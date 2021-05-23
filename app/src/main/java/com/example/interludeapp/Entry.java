package com.example.interludeapp;

public class Entry {
    private long ID;
    private String title;
    private String content;
    private String date;
    private String time;

    Entry(){

    }
    Entry(String title, String content, String date, String time){
        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
    }
    Entry(long ID, String title, String content, String date, String time){
        this.ID = ID;
        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public long getID(){
        return ID;
    }
    public void setID(){
        this.ID = ID;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(){
        this.content = content;
    }

    public String getDate(){
        return date;
    }
    public void setDate(){
        this.date = date;
    }

    public String getTime(){
        return time;
    }
    public void setTime(){
        this.time = time;
    }


}








