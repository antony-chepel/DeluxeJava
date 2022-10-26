package com.fuseboxgames.loveislang.deluxewhite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fuseboxgames.loveislang.R;

import java.util.Arrays;

public class GameDeluxeScreen extends AppCompatActivity {
    Integer progressDeluxeData = 0;
    Integer bonusDelux = 2;
    Integer timerDeluxe = 20;
    CountDownTimer pbDeluxeTime;

    TextView tvTimer;
    TextView tvBonus;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_deluxe_screen);
        ProgressBar pbDeluxe = findViewById(R.id.progressBar);
        ImageView imDeluxe = findViewById(R.id.imMainDeluxe);
        tvBonus = findViewById(R.id.tv_bonus_deluxe);
        tvTimer = findViewById(R.id.tv_timer_deluxe);
        String getIntentTimer = Arrays.toString(getIntent().getStringArrayExtra("moreD"));

        if(getIntentTimer.equals("more")){
            timerDeluxe = 20;
            tvTimer.setText("Time :"+timerDeluxe);

        } else {
            timerDeluxe = 15;
            tvTimer.setText("Time :"+timerDeluxe);
        }


        pbDeluxe.setProgress(progressDeluxeData);
        imDeluxe.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                 progressDeluxeData+=2;
                 bonusDelux+=1;

                 if(progressDeluxeData==100){
                     startActivity(new Intent(getApplicationContext(),ResDeluxeActivity.class)
                     );
                     progressDeluxeData = 0;
                 }
                    tvBonus.setText("Your new bonus x" + bonusDelux);
                    pbDeluxe.setProgress(progressDeluxeData);

                    v.animate().scaleX(0.99f).scaleY(0.99f).setDuration(0);


                } else  if(event.getAction() ==  MotionEvent.ACTION_UP){
                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(0);

                }

                return true;
            }
        });
        setgame();
    }


    private  void setgame(){
        if(pbDeluxeTime != null) {
            pbDeluxeTime.cancel();
        }
        pbDeluxeTime = new CountDownTimer(20000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timerDeluxe--;
                if(timerDeluxe>=0){

                    String count = timerDeluxe.toString();
                    tvTimer.setText("Time : " + count);

                }
            }

            @Override
            public void onFinish() {
                if(timerDeluxe == 0){
                    startActivity(new Intent(getApplicationContext(),ResDeluxeActivity.class));
                    timerDeluxe = 15;
                }
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pbDeluxeTime.cancel();
    }
}