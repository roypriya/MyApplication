package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SocialStoryCategory extends AppCompatActivity {
    ArrayList<String> als;
    ArrayAdapter<String> adapter;
    ListView listView;
    TextView categoryText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_story_category);
        categoryText=findViewById(R.id.categoryText1);
        als=new ArrayList<>();
        als.add("Birthday Celebration");
        als.add("School");
        als.add("Brushing Tooth");
        als.add("Play With Friends");
        als.add("Play hide and seek");
        als.add("Ask for help");
        als.add("Quiet Please");
        als.add("School Work");
        als.add("Personal Space");
        als.add("Learn About Touching");
        als.add("Hitting Is Bad!!");
        als.add("Control Your Anger");
        als.add("Summer Vacation");
        als.add("Learn About Sharing");
        als.add("Learn About Taking Turns");
        als.add("Visit a Doctor");
        als.add("Get a Haircut");
        als.add("Ask a Question");
        als.add("Cross a Road");
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,als);
        listView=findViewById(R.id.socialStoryListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(new Intent(SocialStoryCategory.this,BirthdayActivity.class));
                }
                else if(position==1){
                    startActivity(new Intent(SocialStoryCategory.this, SchoolActivity.class));
                }
                else if(position==2){
                    startActivity(new Intent(SocialStoryCategory.this,Brushtooth.class));
                }
                else if(position==3){
                    startActivity(new Intent(SocialStoryCategory.this,PlayFriendsActivity.class));
                }
                else if(position==4){
                    startActivity(new Intent(SocialStoryCategory.this,PlayHideAndSeek.class));
                }
                else if(position==5){
                    startActivity(new Intent(SocialStoryCategory.this,AskForHelp.class));
                }
                else if(position==6){
                    startActivity(new Intent(SocialStoryCategory.this,QuietPlease.class));
                }
                else if(position==7){
                    startActivity(new Intent(SocialStoryCategory.this,SchoolWork.class));
                }
                else if(position==8){
                    startActivity(new Intent(SocialStoryCategory.this,PersonalSpace.class));
                }
                else if(position==9){
                    startActivity(new Intent(SocialStoryCategory.this,Toucing.class));
                }
                else if(position==10){
                    startActivity(new Intent(SocialStoryCategory.this,Hitting.class));
                }else if(position==11){
                    startActivity(new Intent(SocialStoryCategory.this,ControlAnger.class));
                }else if(position==12){
                    startActivity(new Intent(SocialStoryCategory.this,SummerVacation.class));
                }
                else if(position==13){
                    startActivity(new Intent(SocialStoryCategory.this,Sharing.class));
                }
                else if(position==14){
                    startActivity(new Intent(SocialStoryCategory.this,TakingTurn.class));
                }
                else if(position==15){
                    startActivity(new Intent(SocialStoryCategory.this,VisitDoctor.class));
                }
                else if(position==16){
                    startActivity(new Intent(SocialStoryCategory.this,HairCut.class));
                }
                else if(position==17){
                    startActivity(new Intent(SocialStoryCategory.this,AskingQuestions.class));
                }
                else if(position==18){
                    startActivity(new Intent(SocialStoryCategory.this,CrossRoad.class));
                }

            }
        });

    }
}
