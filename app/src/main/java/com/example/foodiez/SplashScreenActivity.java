package com.example.foodiez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.*;

import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {
    protected static int limit=2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in=new Intent(SplashScreenActivity.this,MainActivity.class);
                startActivity(in);
                finish();

            }
        },limit);

    }
}