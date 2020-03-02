package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import play.GameActivity;

public class PlayList extends AppCompatActivity {
    ListView listView;
    ArrayList<MyOptions> list=new ArrayList<>();
    MyCard arrayAdapter;
    AppCompatTextView compatTextView;
    int resid[]={R.drawable.animalicon,R.drawable.placesicon,R.drawable.occion,R.drawable.transporticon,R.drawable.sporticon};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.play_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.help:
                compatTextView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
                break;
            case R.id.closeHelp:
                compatTextView.setVisibility(View.INVISIBLE);
                listView.setVisibility(View. VISIBLE);

        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
        compatTextView=(AppCompatTextView)findViewById(R.id.helpText);
        Toast.makeText(this, "Welcome to Game Section", Toast.LENGTH_SHORT).show();
        listView=(ListView)findViewById(R.id.playList);
        //inflating array list
        list.add(new MyOptions("Animals",resid[0]));
        list.add(new MyOptions("Public Places",resid[1]));
        list.add(new MyOptions("Occupation",resid[2]));
        list.add(new MyOptions("Transport",resid[3]));
        list.add(new MyOptions("Sports",resid[4]));
        //setting adapter
        arrayAdapter=new MyCard(this,R.layout.card_list,list);
        listView.setAdapter(arrayAdapter);

        //setting click listener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int i=0;
                switch (position)
                {
                    case 0:
                        i=0;
                        Intent intent=new Intent(getApplicationContext(), GameActivity.class);
                        intent.putExtra("choice",i);
                        startActivity(intent);
                        break;

                    case 1:
                        i=1;
                        Intent intent1=new Intent(getApplicationContext(), GameActivity.class);
                        intent1.putExtra("choice",i);
                        startActivity(intent1);
                        break;

                    case 2:
                        i=2;
                        Intent intent2=new Intent(getApplicationContext(), GameActivity.class);
                        intent2.putExtra("choice",i);
                        startActivity(intent2);
                        break;

                    case 3:
                        i=3;
                        Intent intent3=new Intent(getApplicationContext(), GameActivity.class);
                        intent3.putExtra("choice",i);
                        startActivity(intent3);
                        break;

                    case 4:
                        i=4;
                        Intent intent4=new Intent(getApplicationContext(),GameActivity.class);
                        intent4.putExtra("choice",i);
                        startActivity(intent4);
                        break;

                }
            }
        });
    }
}
