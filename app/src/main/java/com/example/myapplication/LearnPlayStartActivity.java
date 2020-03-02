package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mikhaellopez.circularimageview.CircularImageView;

public class LearnPlayStartActivity extends AppCompatActivity {
    CircularImageView learn,play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_play_start);

        learn= (CircularImageView) findViewById(R.id.learnButton);
        play= (CircularImageView) findViewById(R.id.playButton);
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),LearnList.class);
                startActivity(i);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PlayList.class);
                startActivity(intent);

            }
        });

    }
}
