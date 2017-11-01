package com.example.navigationmenu;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    //Method start:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() { // Ei tea
            @Override
            public void run() { //Create handler
                Intent mainIntent = new Intent(SplashActivity.this,//Create intent and goes to the MainActivity opening the activity_main.xml layout
                        MainActivity.class);
                startActivity(mainIntent);
                finish();//Handler is finished
            }
        }, SPLASH_TIME_OUT);//Start SPLASH_TIME_OUT-i
    }
}
