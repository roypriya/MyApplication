package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class HomeScreen extends AppCompatActivity {
//    Button getStartButton;
    Animation fromBottomAnimation, fromTopAnimation;
    ImageView ballonImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
//        getStartButton=findViewById(R.id.getStarted);
        ballonImageView=findViewById(R.id.baloon);
        fromBottomAnimation= AnimationUtils.loadAnimation(this,R.anim.from_bottom);
        fromTopAnimation=AnimationUtils.loadAnimation(this,R.anim.from_top);
//        getStartButton.setAnimation(fromBottomAnimation);
        ballonImageView.setAnimation(fromTopAnimation);
        Runnable r =new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(HomeScreen.this,CategoryActivity.class));
                finish();
            }
        };
        Handler h = new Handler();
        h.postDelayed(r,4000);
    }
}
