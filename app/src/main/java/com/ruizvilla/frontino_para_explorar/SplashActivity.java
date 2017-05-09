package com.ruizvilla.frontino_para_explorar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        // Esta parte no la hice con TimerTask porque daba errores, entonces trabaje con Hancl
       new android.os.Handler().postDelayed(new Runnable() {
           @Override

                             public void run() {
                                 Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                                 startActivity(intent);
                             }
                         },4000);



    }
}












