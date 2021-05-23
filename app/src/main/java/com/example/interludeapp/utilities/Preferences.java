package com.example.interludeapp.utilities;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.Calendar;

public class Preferences {
    private static SharedPreferences preferences = null;

    //to clear SharedPreferences data
    public static void clear(){
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();
    }

    public Preferences(Activity activity){
        this.preferences = activity.getPreferences(Activity.MODE_PRIVATE);
    }
    public void setDate(long milliseconds){

        preferences.edit().putLong("seconds", milliseconds).apply();
    }

    public String getDate(){
        String dayOrNight;
        long milliDate = preferences.getLong("seconds", 0);

        Calendar calendar = Calendar.getInstance(); //to get the actual time
        calendar.setTimeInMillis(milliDate);
        int i = calendar.get(Calendar.AM_PM);
        if(i == Calendar.AM){
            dayOrNight = "AM";
        }
        else{
            dayOrNight = "PM";
        }

        String time = "Last used " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + " " + dayOrNight;
        return time;
    }

    public void setSessions(int session){
        preferences.edit().putInt("sessions", session).apply();
    }

    public int getSessions(){
        return preferences.getInt("sessions", 0);
    }

    public void setBreaths(int breaths){
        preferences.edit().putInt("breaths", breaths).apply(); //saving breaths into system file
    }
    public int getBreaths(){
        return preferences.getInt("breaths", 0);
    }
}
