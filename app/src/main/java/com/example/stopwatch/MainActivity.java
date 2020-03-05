package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    TextView tv1;


    //  number of seconds displayed on the stopwatch.
    private int seconds=0;
    //is the stop watch running;
    private boolean running;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();

       b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=true;

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;
            }
        });


    }
    // when you use the onclick method without using set on clicklistener
    public void onreset(View view)
    {
        running=false;
        seconds=0;
    }


    ///sets the number of seconds on the timer.

    private void runTimer()
    {
        final TextView tv1 =(TextView)findViewById(R.id.tv1);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String  time = String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,secs);
                tv1.setText(time);
                if (running)
                {
                    seconds++;
                }

                handler.postDelayed(this,1000);
            }
        });

    }

}
