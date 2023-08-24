package com.example.mainactivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.mainactivity.R;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    private int second  = 0;

    private boolean running;

    private boolean was_running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        if(savedInstanceState != null)
        {
            second = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            was_running = savedInstanceState.getBoolean("was_running");

        }
        runTimer();
    }

    private void runTimer() {

        final TextView time_view = findViewById(R.id.textview);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = second / 3600;
                int minute = (second % 3600) / 60;
                int secs = second % 60;

                String time = String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minute,secs);
                time_view.setText(time);

                if(running)
                {
                    second++;
                }

                handler.postDelayed(this,1000);

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        was_running= running;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(was_running)
        {
            running = true;
        }
    }

    public void onClicK_Start(View view)
    {
        running = true;
    }

    public void onClicK_Stop(View view)
    {
        running = false;
    }

    public void onClicK_Reset(View view)
    {
        running = false;
        second = 0;
    }
}