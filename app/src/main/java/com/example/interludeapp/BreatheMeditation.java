package com.example.interludeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.interludeapp.utilities.Preferences;
import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;

import java.text.MessageFormat;

public class BreatheMeditation extends AppCompatActivity {

    ImageView BreatheLogo;
    TextView breaths_taken;
    TextView breathing_guide;
    TextView last_used;
    TextView a_session_text;
    TextView time_used_today;
    TextView two_minute_session;
    Button start_button;
    private Preferences preferences;
    //private Object Preferences;
    private ImageButton home_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breathe_meditation);

        BreatheLogo = findViewById(R.id.breathe_logo);
        breaths_taken = findViewById(R.id.breaths_taken);
        time_used_today = findViewById(R.id.time_used_today);
        last_used = findViewById(R.id.last_used);
        start_button = findViewById(R.id.start_button);
        breathing_guide = findViewById(R.id.breathing_guide);
        preferences = new Preferences(this);

        introTextGuideAnimation();


        breaths_taken.setText(MessageFormat.format("{0} Breaths", preferences.getBreaths()));
        time_used_today.setText(MessageFormat.format("{0} min today", preferences.getSessions()));
        last_used.setText(preferences.getDate());


        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });


        home_icon = (ImageButton) findViewById(R.id.home_icon);
        home_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }


    private void introTextGuideAnimation(){
        ViewAnimator
                .animate(breathing_guide)
                .scale(0,1)
                .duration(1500)
                .onStart(new AnimationListener.Start() {
                    @Override
                    public void onStart() {
                        breathing_guide.setText("Breathe");
                    }

                })
                .start();
    }
    private void startAnimation(){
        ViewAnimator
                .animate(BreatheLogo)
                .alpha(0, 1)
                .onStart(new AnimationListener.Start() {
                    @Override
                    public void onStart() {

                        breathing_guide.setText("Inhale ... Exhale");
                    }

                })
                .decelerate()
                .duration(1000)
                .thenAnimate(BreatheLogo)
                .scale(0.1f, 1.5f, 0.1f)

                .rotation(360)
                .repeatCount(23) //change to 23
                .accelerate()
                .duration(5000)
                .onStop(new AnimationListener.Stop() {
                    @Override
                    public void onStop() {
                        breathing_guide.setText("Complete!");
                        BreatheLogo.setScaleX(1.0f);
                        BreatheLogo.setScaleY(1.0f);

                        preferences.setSessions( preferences.getSessions() + 2 );
                        preferences.setBreaths( preferences.getBreaths() + 1 );
                        preferences.setDate(System.currentTimeMillis());

                        //need to refresh activity
                        new CountDownTimer(2000, 1000){

                            @Override
                            public void onTick(long millisUntilFinished) {
                                //ticking code
                            }

                            @Override
                            public void onFinish() {
                                startActivity(new Intent(getApplicationContext(), BreatheMeditation.class));
                                finish();
                                //Preferences.clear();
                            }
                        }.start();
                    }
                })
                .start();
    }


}