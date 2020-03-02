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

public class VisitDoctor extends AppCompatActivity implements TextToSpeech.OnInitListener {
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
        setContentView(R.layout.activity_visit_doctor);

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
        description.add("I will go to the front desk so they know I am ready for my appointment");
        description.add("I will wait in the waiting room for my turn to see the doctor");
        description.add("When it is my turn,I will go into the office with the nurse");
        description.add("The nurse will weigh me");
        description.add("She also might check how tall I am");
        description.add("She will take my blood pressure");
        description.add("She might give me a shot to keep me healthy.It might pinch but it will be over soon");
        description.add("She will ask how I am feeling");
        description.add("Next the doctor will come in");
        description.add("He will look in my ears and my throat");
        description.add("He will listen to my heart with his stethoscope");
        description.add("If anything is bothering me like my stomach,he will check that too");
        description.add("Then I will check out at the desk and say goodbye");

        Integer[] imgId = {
                R.drawable.visit_doc1,
                R.drawable.visit_doc2,
                R.drawable.visit_doc3,
                R.drawable.visit_doc4,
                R.drawable.visit_doc5,
                R.drawable.visit_doc6,
                R.drawable.visit_doc7,
                R.drawable.visit_doc8,
                R.drawable.visit_doc9,
                R.drawable.visit_doc10,
                R.drawable.visit_doc11,
                R.drawable.visit_doc12,
                R.drawable.visit_doc13
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
