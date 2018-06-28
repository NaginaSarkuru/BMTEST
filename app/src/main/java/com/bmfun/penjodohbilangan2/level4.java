package com.bmfun.penjodohbilangan2;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class level4 extends AppCompatActivity {

    private static final long START_TIME_MILLIS = 30000; //30secs

    private TextView mTextViewCountdown;

    private CountDownTimer mCountDownTimer;

    private long mTimeLeftinMillis = START_TIME_MILLIS;

    private Button Buttonnexttt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

        Buttonnexttt = (Button) findViewById(R.id.button_NEXT4);
        Buttonnexttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        mTextViewCountdown = findViewById(R.id.text_view_countdown);


        mTimerRunning();
        updateCountDownText();
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    private void mTimerRunning (){
        mCountDownTimer = new CountDownTimer(mTimeLeftinMillis, 1000){
            @Override
            public void onTick(long millisUntilFinish){
                mTimeLeftinMillis = millisUntilFinish;
                updateCountDownText();
            }

            @Override
            public void onFinish(){
                mTextViewCountdown.setText("Time's Up!");
                openMainActivity();
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftinMillis/1000) / 60;
        int seconds = (int) (mTimeLeftinMillis/1000) % 60;

        String timeleftformatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        mTextViewCountdown.setText(timeleftformatted);

    }
}
