package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import learn.Learn_Activity;

public class LearnList extends AppCompatActivity {
    ArrayList<MyOptions> list=new ArrayList<>();
    ListView listView;
    int resid[]={R.drawable.animalicon,R.drawable.placesicon,R.drawable.occion,R.drawable.transporticon,R.drawable.sporticon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_list);
        listView=(ListView)findViewById(R.id.learnList);
//        listView.getBackground().setAlpha(30);
        Toast.makeText(this, "Welcome to Learning Section", Toast.LENGTH_SHORT).show();
        list.add(new MyOptions("Animals",resid[0]));
        list.add(new MyOptions("Public Places",resid[1]));
        list.add(new MyOptions("Occupation",resid[2]));
        list.add(new MyOptions("Transport",resid[3]));
        list.add(new MyOptions("Sports",resid[4]));

        MyCard arrayAdapter=new MyCard(this,R.layout.card_list,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int item, long id) {
                int i;
                switch (item)
                {
                    case 0:i=0;
                        Intent intent=new Intent(getApplicationContext(), Learn_Activity.class);
                        intent.putExtra("choice",i);
                        startActivity(intent);
                        break;
                    case 1:i=1;
                        Intent intent1=new Intent(getApplicationContext(), Learn_Activity.class);
                        intent1.putExtra("choice",i);
                        startActivity(intent1);
                        break;
                    case 2:i=2;
                        Intent intent2=new Intent(getApplicationContext(), Learn_Activity.class);
                        intent2.putExtra("choice",i);
                        startActivity(intent2);
                        break;
                    case 3:i=3;
                        Intent intent3=new Intent(getApplicationContext(), Learn_Activity.class);
                        intent3.putExtra("choice",i);
                        startActivity(intent3);
                        break;
                    case 4:
                        i=4;
                        Intent intent4=new Intent(getApplicationContext(),Learn_Activity.class);
                        intent4.putExtra("choice",i);
                        startActivity(intent4);
                }
            }
        });


    }
}
