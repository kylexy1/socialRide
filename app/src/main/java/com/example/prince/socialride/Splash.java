package com.example.prince.socialride;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView myTextView=(TextView)findViewById(R.id.font);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/murdered.ttf");
        myTextView.setTypeface(typeFace);
        Thread t =new Thread(){
            @Override
            public void run() {
                try {

                    sleep(2400);
                    log();
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        t.start();
    }

    private void log() {
        startActivity(new Intent(this,Login.class));
    }
}
