package com.fuseboxgames.loveislang.deluxewhite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuseboxgames.loveislang.R;

public class StartScreenDeluxe extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        Button b_more = findViewById(R.id.b_more_deluxe);
        Button b_less = findViewById(R.id.b_less_deluxe);

        b_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GameDeluxeScreen.class)
                        .putExtra("moreD","more")
                );
            }
        });

        b_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GameDeluxeScreen.class)
                        .putExtra("moreD","less")
                );
            }
        });

    }
}
