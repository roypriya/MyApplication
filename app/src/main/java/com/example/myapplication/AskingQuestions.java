package com.example.myapplication;

import android.animation.ArgbEvaluator;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AskingQuestions extends AppCompatActivity implements TextToSpeech.OnInitListener {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ArrayList<String> description;
    TextToSpeech tts;
    Button readOutButton;
    String textToRead = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking_questions);

        models = new ArrayList<>();
        description = new ArrayList<>();
        tts=new TextToSpeech(this,this);
        tts.setSpeechRate(0.5f);
        readOutButton = findViewById(R.id.btnOrder);
        readOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readOut();
            }
        });
        description.add("Sometimes in class I have a question");
        description.add("When I want to ask question, I raise my hand up and wait for the teacher to call my name");
        description.add("When the teacher calls my name, that means it is my turn to ask my questions");
        description.add("I will put my hand down and ask the teacher my question");
        description.add("The teacher will do her best to answer my question");

        Integer[] imgId = {
                R.drawable.ask1,
                R.drawable.ask2,
                R.drawable.ask3,
                R.drawable.ask4,
                R.drawable.ask5
        };
        for (int i=0;i<imgId.length;i++){
            models.add(new Model(imgId[i],"",""));
        }
        textToRead = description.get(0);
        adapter = new Adapter(models,this);
        viewPager= findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        Integer[] colors_temp={
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),

        };
        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,
                            colors[position],colors[position +1]));
                }
                else{
                    viewPager.setBackgroundColor(colors[colors.length -1]);
                }
            }

            @Override
            public void onPageSelected(int i) {
                textToRead = description.get(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);
            if ( result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "onInit: Error Language Not Suppported" );
            } else {
//                readOutButton.setEnabled(true);
                readOut();
            }
        } else {
            Log.e("TTS", "onInit: Failed Instantiating");
        }
    }
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void readOut() {
        tts.speak(textToRead,TextToSpeech.QUEUE_FLUSH,null);
    }
}
