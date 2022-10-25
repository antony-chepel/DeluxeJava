package com.fuseboxgames.loveislang.deluxewhite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fuseboxgames.loveislang.R;

import java.util.Random;

public class ResDeluxeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_deluxe);
        TextView tvRes = findViewById(R.id.tv_res_deluxe);
        Button b_res = findViewById(R.id.b_deluxe_retry);
        DeluxeUtils ggf =  new DeluxeUtils();
        Random random = new Random();
        String resDeluxe = ggf.bonusDeluxe.get(random.nextInt(4));
        tvRes.setText(resDeluxe);
        b_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),StartScreenDeluxe.class));
            }
        });
    }
}