package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            boolean handler = new Handler().postDelayed(new Runnable(){
                @Override
                public void run()
                {
                    Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(i);
                    finish();
                }
            },this,4000);
        }
    }
}