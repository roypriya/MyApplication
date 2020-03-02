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

public class PlayHideAndSeek extends AppCompatActivity implements TextToSpeech.OnInitListener {

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
        setContentView(R.layout.activity_play_hide_and_seek);

        tts=new TextToSpeech(this,this);
        tts.setSpeechRate(0.5f);

        readOutButton=findViewById(R.id.btnOrder);
        readOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readOut();
            }
        });
        models =new ArrayList<>();
        description = new ArrayList<>();
        description.add("Playing Hide and seek");
        description.add("Its fun to play games with my friends.One game I can play is called hide and seek.I can play it indoors and outdoors");
        description.add("If my friends and I want to play Hide and seek then first we need to pick someone to be \"it\".The person who is \"it\" is the seeker .They find all the people who are hiding. ");
        description.add("When I am \"it\" , I close or cover my eyes and count out loud to 20 while my friends run off to hide. I won't peek through because it is more fun when I cannot see where my friends hide.");
        description.add("When I finish counting, I shout , \"Ready or not here I come! \" That tells my friends that I am coming to find them.");
        description.add("When I am searching for my friends, I can look behind  things (such as a tree or a couch ) or under things (such as park bench or bed).I can also use my ears to help find my friends.They might be giggling  while they are hiding!");
        description.add("When I find my friends, I can say \"I found you!\" Once I have found all of my friends, we pick someone new to be \"it\".We should all take turns being \"it\"  ");
        description.add("Sometimes I might find it hard to find all my friends and that's  okay . I can Simply say \"I Give Up! \" and all my friends will come out from their hiding spots. I can also ask my friends who I already found to help me find other friends.");
        description.add("When its my tun to hide,I have to run and hide before the person who is \"it\"  finishes counting to 20 .");
        description.add("if I am playing outdoors, then I need to make sure my parents or babysitter can still see where I am playing. I need to stay inside the house or the playground. ");
        description.add("I need to hide in a spot that is safe to hide in. I can hide under things (such as bed or park bench) or behind things (such as tree or a couch)");
        description.add("When I am hiding, I should try to pick a spot to hide myself. It is more fun if my friends and I hide in different spots.");
        description.add("When I am hiding, I should try to hide in new place each time I play.If I hide somewhere that one of my friends or I did, then it is too easy for the person who is \"it \" to find me. ");
        description.add("When the person who is \"it \" is coming to find me,I should stay quite,but it's okay to make noise or giggle while hiding.That just means my friend will find me quicker ");
        description.add("When my friends finds me , they say \"I found you!\" I can help my friend search for other friends if they want my help.");
        description.add("Once all my friends are found, we can play again because playing hide and seek with friends is so much fun! ");
        Integer[] imgId={R.drawable.hans1,R.drawable.hans2,R.drawable.hans3,R.drawable.hans4,R.drawable.hans5,
                R.drawable.hans6,R.drawable.hans7,R.drawable.hans8,R.drawable.hans9,R.drawable.hans10,
                R.drawable.hans11,R.drawable.hans12,R.drawable.hans13,R.drawable.hans14,R.drawable.hans15,R.drawable.hans16};
        for (int i=0;i<imgId.length;i++){
            models.add(new Model(imgId[i],"",""));
        }
//        models.add(new Model(R.drawable.birthday, "Brochure", "qqqqqqqqqqqqq"));
//        models.add(new Model(R.drawable.friends, "Sticker", "qqqqqqqqqqqq"));
//        models.add(new Model(R.drawable.school1, "Poster", "qqqqqqqq"));
//        models.add(new Model(R.drawable.toothbrush, "Namecard", "qqqqqqqqqq"));
        textToRead=description.get(0);

        adapter = new Adapter(models,this);
        viewPager= findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

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

        colors =colors_temp;

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
                textToRead=description.get(i);
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
}
