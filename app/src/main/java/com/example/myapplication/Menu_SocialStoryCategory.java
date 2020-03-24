package com.example.myapplication;

//import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu_SocialStoryCategory extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> parent;
    Map<String,List<String>> map;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__social_story_category);
        expandableListView=findViewById(R.id.expandableListView);

        fillData();
        expandableListAdapter=new MyExListAdapter(this,parent,map);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String name1=(String)expandableListAdapter.getChild(groupPosition,childPosition);
                if(name1.equals("School"))
                {
                    startActivity(new Intent(Menu_SocialStoryCategory.this,SchoolActivity.class));
                }
                if(name1.equals("Hygiene"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,Hygiene.class));
                if(name1.equals("Brushing Tooth"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,Brushtooth.class));
                if(name1.equals("Play with Friends"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,PlayFriendsActivity.class));
                if(name1.equals("Play Hide & Seek"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,PlayHideAndSeek.class));
                if(name1.equals("Ask for help"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,AskForHelp.class));
                if(name1.equals("School Work"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,SchoolWork.class));
                if(name1.equals("Learn about Sharing"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,Sharing.class));
                if(name1.equals("Cross a Road"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,CrossRoad.class));
                if(name1.equals("Learn about Taking Turns"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,TakingTurn.class));
                if(name1.equals("Ask a question"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,AskingQuestions.class));
                if(name1.equals("Personal Space"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,PersonalSpace.class));
                if(name1.equals("Learn about Touching"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,Toucing.class));
                if(name1.equals("Hitting is bad"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,Hitting.class));
                if(name1.equals("Control your Anger"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,ControlAnger.class));
                if(name1.equals("Birthday Celebration"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,BirthdayActivity.class));
                if(name1.equals("Summer Vacation"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,SummerVacation.class));
                if(name1.equals("Visit a Doctor"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,VisitDoctor.class));
                if(name1.equals("Get a Haircut"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,HairCut.class));
                if(name1.equals("Ride a School Bus"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,SchoolBus.class));
                if(name1.equals("Interaction with Strangers"))
                    startActivity(new Intent(Menu_SocialStoryCategory.this,Strangers.class));




                return false;
            }
        });
    }

    private void fillData() {
        parent=new ArrayList<>();
        map=new HashMap<>();
        parent.add("Activities of Daily Life");
        parent.add("School");
        parent.add("Emotion");
        parent.add("Event");
        map.put(parent.get(0),new ArrayList<>(Arrays.asList("School","Brushing Tooth","Play with Friends","Play Hide & Seek","Ask for help","School Work","Learn about Sharing","Cross a Road","Ride a School Bus","Interaction with Strangers","Hygiene")));
        map.put(parent.get(1),new ArrayList<>(Arrays.asList("School","School Work","Play with Friends","Learn about Sharing","Learn about Taking Turns","Ask a question","Ride a School Bus")));
        map.put(parent.get(2),new ArrayList<>(Arrays.asList("Personal Space","Learn about Touching","Hitting is bad","Control your Anger")));
        map.put(parent.get(3),new ArrayList<>(Arrays.asList("Birthday Celebration","Summer Vacation","Visit a Doctor","Get a Haircut","Interaction with Strangers")));

    }
}
