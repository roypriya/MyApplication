package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

import createStory.CreateStoryHome;

public class CategoryActivity extends AppCompatActivity {
//    ArrayList<String> categgoryList;
//    ListAdapter adapter;
//    ListView listView;
//    TextView categoryText;
//    ArrayList<Integer> imgid;
android.support.v7.widget.GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mainGrid = (android.support.v7.widget.GridLayout)findViewById(R.id.mainGrid);
//        categgoryList = new ArrayList<>();
//        imgid = new ArrayList<>();
//        categgoryList.add("SchoolActivity");
//        categgoryList.add("Brush Your Tooth");
//        categgoryList.add("Play with friends");
//        categgoryList.add("Birthday");
//        adapter=new ListAdapter(this,categgoryList,imgid);
////        listView=findViewById(R.id.lview1);
//        categoryText = findViewById(R.id.categoryText1);
//        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });

        for (int i=0;i<mainGrid.getChildCount();i++){
            CardView cardView=(CardView)mainGrid.getChildAt(i);
            final int finalI=i;
            final int finalI1 = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0){
                        startActivity(new Intent(getApplicationContext(), LearnPlayStartActivity.class));
                    }
                    else if(finalI1 ==1){
                        startActivity(new Intent(getApplicationContext(),Menu_SocialStoryCategory.class));
                    }
                    else if(finalI1 ==2){
                        startActivity(new Intent(getApplicationContext(), CreateStoryHome.class));
                    }


                }
                });
            }


    }
}
