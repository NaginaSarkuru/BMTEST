package com.bmfun.penjodohbilangan2;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class level2 extends AppCompatActivity {

    private static final long START_TIME_MILLIS = 50000; //50secs

    private TextView mTextViewCountdown;

    private CountDownTimer mCountDownTimer;

    private long mTimeLeftinMillis = START_TIME_MILLIS;

    private Button Buttonnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        Buttonnext = (Button) findViewById(R.id.button_NEXT2);
        Buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlevel3();
            }
        });

        mTextViewCountdown = findViewById(R.id.text_view_countdown);

        mTimerRunning();
        updateCountDownText();
    }

    public void openlevel3(){
        Intent intent = new Intent(this, level3.class);
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
                openlevel3();
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
