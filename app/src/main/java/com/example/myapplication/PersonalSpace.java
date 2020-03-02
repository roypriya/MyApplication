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

public class PersonalSpace extends AppCompatActivity implements TextToSpeech.OnInitListener {
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
        setContentView(R.layout.activity_personal_space);
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
        description.add("Lets Learn about Personal Space");
        description.add("Most people like to be with\n" +
                "others.");
        description.add("When I am at school, I am with\n" +
                "my teacher.");
        description.add("When a teacher talks with me,\n" +
                "she stands about the length of\n" +
                "an arm away. A teacher\n" +
                "usually does not stand too\n" +
                "close to me.");
        description.add("When I talk with a teacher, I\n" +
                "should try to stand about an\n" +
                "arm’s length away too.");
        description.add("If I stand too close, I am in my\n" +
                "teacher’s personal space. My\n" +
                "teacher does not like it if I am\n" +
                "in her personal space.");
        description.add("When I am at school, I am with\n" +
                "other kids. When kids talk with\n" +
                "me, they stand about the\n" +
                "length of an arm away.");
        description.add("When I talk with other kids, I\n" +
                "should try to stand about an\n" +
                "arm’s length away too.");
        description.add("When I talk with other kids, I\n" +
                "should try to stand about an\n" +
                "arm’s length away too.");
        description.add("Touching other kids means\n" +
                "getting into their personal\n" +
                "space, too.Kids don’t like it if\n" +
                "I am in their personal space.");
        description.add("I will try to respect others by\n" +
                "giving them personal space.\n" +
                "My teachers will like that.\n" +
                "Other kids will like that, too.");

        Integer[] imgId = {
                R.drawable.personalspace1,
                R.drawable.personalspace2,
                R.drawable.personalspace3,
                R.drawable.personalspace4,
                R.drawable.personalspace5,
                R.drawable.personalspace6,
                R.drawable.personalspace7,
                R.drawable.personalspace8,
                R.drawable.personalspace9,
                R.drawable.personalspace10,
                R.drawable.personalspace11

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
    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
    private void readOut() {
        tts.speak(textToRead,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
