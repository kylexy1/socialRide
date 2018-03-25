package com.example.prince.socialride;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView myTextView=(TextView)findViewById(R.id.font);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/murdered.ttf");
        myTextView.setTypeface(typeFace);
    }
    public void log(View v){
        startActivity(new Intent(this,MainActivity.class));
    }
}
