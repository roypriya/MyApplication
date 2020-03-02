package play;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.Random;

/**
 * Created by Rishabh on 2/8/2018.
 */

public class GameActivity extends AppCompatActivity {
    ImageView drag1,drag2,drag3,drag4,answer1,answer2,answer3,answer4;
    TextView answerText1,answerText2,answerText3,answerText4;
    LinearLayout g1;
    LinearLayout g2;
    CardView cardView;
    Button nextButton;
    private ImageView[] options;
    private ImageView[] answers;
    private TextView[] answerTexts;
    int j,i;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final Intent intent=getIntent();
        /*
        Getting choice from previous activity
         */
        i=intent.getIntExtra("choice",0);

        options=new ImageView[4];
        answerTexts=new TextView[4];
        answers=new ImageView[4];
        final Random random=new Random();


       //image view  for quiz
        drag1=(ImageView)findViewById(R.id.drag1);
        drag2=(ImageView)findViewById(R.id.drag2);
        drag3=(ImageView)findViewById(R.id.drag3);
        drag4=(ImageView)findViewById(R.id.drag4);

        //answer  image views
        answer1=(ImageView)findViewById(R.id.answer1);
        answer2=(ImageView)findViewById(R.id.answer2);
        answer3=(ImageView)findViewById(R.id.answer3);
        answer4=(ImageView)findViewById(R.id.answer4);

        //text views for answers
        answerText1=(TextView)findViewById(R.id.answerText1);
        answerText2=(TextView)findViewById(R.id.answerText2);
        answerText3=(TextView)findViewById(R.id.answerText3);
        answerText4=(TextView)findViewById(R.id.answerText4);

         options[0]=drag1;
        options[1]=drag2;
        options[2]=drag3;
        options[3]=drag4;
        answers[0]=answer1;
        answers[1]=answer2;
        answers[2]=answer3;
        answers[3]=answer4;
        answerTexts[0]=answerText1;
        answerTexts[1]=answerText2;
        answerTexts[2]=answerText3;
        answerTexts[3]=answerText4;


        g1=(LinearLayout) findViewById(R.id.grid1);
        g2=(LinearLayout) findViewById(R.id.grid2);
        cardView=(CardView)findViewById(R.id.buttonCard);

        drag1.setOnTouchListener(new MyOnTouchListener());
        drag2.setOnTouchListener(new MyOnTouchListener());
        drag3.setOnTouchListener(new MyOnTouchListener());
        drag4.setOnTouchListener(new MyOnTouchListener());

        answer1.setOnDragListener(new MyDragListener());
        answer2.setOnDragListener(new MyDragListener());
        answer3.setOnDragListener(new MyDragListener());
        answer4.setOnDragListener(new MyDragListener());

        nextButton=(Button)findViewById(R.id.nextButton);

        switch (i)
        {
            case 0:j=random.nextInt(3);
                setAnimal(j);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        j=random.nextInt(3);
                        g1.setVisibility(View.VISIBLE);
                        g2.setVisibility(View.VISIBLE);
                        drag1.setVisibility(View.VISIBLE);
                        drag2.setVisibility(View.VISIBLE);
                        drag3.setVisibility(View.VISIBLE);
                        drag4.setVisibility(View.VISIBLE);
                        cardView.setVisibility(View.INVISIBLE);
                        setAnimal(j);
                    }
                });
                break;

            case 1:j=random.nextInt(2);
                setPlaces(j);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        j=random.nextInt(2);
                        g1.setVisibility(View.VISIBLE);
                        g2.setVisibility(View.VISIBLE);
                        drag1.setVisibility(View.VISIBLE);
                        drag2.setVisibility(View.VISIBLE);
                        drag3.setVisibility(View.VISIBLE);
                        drag4.setVisibility(View.VISIBLE);
                        cardView.setVisibility(View.INVISIBLE);
                        setPlaces(j);
                    }
                });
                break;

            case 2:j=random.nextInt(3);
                setOccupation(j);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        j=random.nextInt(3);
                        g1.setVisibility(View.VISIBLE);
                        g2.setVisibility(View.VISIBLE);
                        drag1.setVisibility(View.VISIBLE);
                        drag2.setVisibility(View.VISIBLE);
                        drag3.setVisibility(View.VISIBLE);
                        drag4.setVisibility(View.VISIBLE);
                        cardView.setVisibility(View.INVISIBLE);
                        setOccupation(j);
                    }
                });
                break;

            case 3:j=random.nextInt(3);
            setTransport(j);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    j=random.nextInt(3);
                    g1.setVisibility(View.VISIBLE);
                    g2.setVisibility(View.VISIBLE);
                    drag1.setVisibility(View.VISIBLE);
                    drag2.setVisibility(View.VISIBLE);
                    drag3.setVisibility(View.VISIBLE);
                    drag4.setVisibility(View.VISIBLE);
                    cardView.setVisibility(View.INVISIBLE);
                    setTransport(j);
                }
            });
            break;

                case 4:j=random.nextInt(3);
                setSports(j);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        j=random.nextInt(3);
                        g1.setVisibility(View.VISIBLE);
                        g2.setVisibility(View.VISIBLE);
                        drag1.setVisibility(View.VISIBLE);
                        drag2.setVisibility(View.VISIBLE);
                        drag3.setVisibility(View.VISIBLE);
                        drag4.setVisibility(View.VISIBLE);
                        cardView.setVisibility(View.INVISIBLE);
                        setSports(j);
                    }
                });
                break;
        }


    }
    /*
    Set Animals for quiz
     */

  private void setAnimal(int i)
  {     Random random=new Random();
        int k;
        int a,b,c,d;
        a=random.nextInt(4);
        b=random.nextInt(4);
        c =random.nextInt(4);
        d=random.nextInt(4);
        //setting random images
        while (true){
            if(a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a)
            {
                options[a]=(ImageView)findViewById(R.id.drag1);
                options[b]=(ImageView)findViewById(R.id.drag2);
                options[c]=(ImageView)findViewById(R.id.drag3);
                options[d]=(ImageView)findViewById(R.id.drag4);

                answers[a]=findViewById(R.id.answer2);
              answers[b]=findViewById(R.id.answer1);
              answers[c]=findViewById(R.id.answer4);
              answers[d]=findViewById(R.id.answer3);

              answerTexts[a]=(TextView)findViewById(R.id.answerText2);
              answerTexts[b]=(TextView)findViewById(R.id.answerText1);
              answerTexts[c]=(TextView)findViewById(R.id.answerText4);
              answerTexts[d]=(TextView)findViewById(R.id.answerText3);
                break;
            }
            a=random.nextInt(4);
            b=random.nextInt(4);
            c =random.nextInt(4);
            d=random.nextInt(4);
        }

      switch (i){
          case 0:
              for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(AnimalList.animals1[m]);
                  options[m].setTag(AnimalList.tags[m]);
              }
              a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a){
                      answers[a].setTag(AnimalList.tags[a]);
                      answerTexts[a].setText(AnimalList.tags[a]);
                      answers[b].setTag(AnimalList.tags[b]);
                      answerTexts[b].setText(AnimalList.tags[b]);
                      answers[c].setTag(AnimalList.tags[c]);
                      answerTexts[c].setText(AnimalList.tags[c]);
                      answers[d].setTag(AnimalList.tags[d]);
                      answerTexts[d].setText(AnimalList.tags[d]);
                      break;
                  }
                a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              }
              break;
          case 1:

               for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(AnimalList.animals2[m]);
                  options[m].setTag(AnimalList.tags2[m]);
              }
              a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a){
                      answers[a].setTag(AnimalList.tags2[a]);
                      answerTexts[a].setText(AnimalList.tags2[a]);
                      answers[b].setTag(AnimalList.tags2[b]);
                      answerTexts[b].setText(AnimalList.tags2[b]);
                      answers[c].setTag(AnimalList.tags2[c]);
                      answerTexts[c].setText(AnimalList.tags2[c]);
                      answers[d].setTag(AnimalList.tags2[d]);
                      answerTexts[d].setText(AnimalList.tags2[d]);
                      break;
                  }
                   a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);
              }

              break;
          case 2:
                for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(AnimalList.animals3[m]);
                  options[m].setTag(AnimalList.tags3[m]);
              }
              b=random.nextInt(4);
              a=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b && c!=a){
                      Log.i("a", Integer.toString(a));
                      Log.i("b", Integer.toString(b));
                      Log.i("c", Integer.toString(c));
                      Log.i("d", Integer.toString(d));
                      answers[a].setTag(AnimalList.tags3[a]);
                      answerTexts[a].setText(AnimalList.tags3[a]);
                      answers[b].setTag(AnimalList.tags3[b]);
                      answerTexts[b].setText(AnimalList.tags3[b]);
                      answers[c].setTag(AnimalList.tags3[c]);
                      answerTexts[c].setText(AnimalList.tags3[c]);
                      answers[d].setTag(AnimalList.tags3[d]);
                      answerTexts[d].setText(AnimalList.tags3[d]);
                      break;
                  }
                  a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);
              }
              break;
      }
  }
  /*
  Set Occupation for Images in Quiz
   */
  private void setOccupation(int i)
  {
    Random random=new Random();
        int k;
        int a,b,c,d;
        a=random.nextInt(4);
        b=random.nextInt(4);
        c =random.nextInt(4);
        d=random.nextInt(4);
        //setting random images
        while (true){
            if(a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a)
            {
                options[a]=(ImageView)findViewById(R.id.drag1);
                options[b]=(ImageView)findViewById(R.id.drag2);
                options[c]=(ImageView)findViewById(R.id.drag3);
                options[d]=(ImageView)findViewById(R.id.drag4);

                answers[a]=findViewById(R.id.answer2);
              answers[b]=findViewById(R.id.answer1);
              answers[c]=findViewById(R.id.answer4);
              answers[d]=findViewById(R.id.answer3);

              answerTexts[a]=(TextView)findViewById(R.id.answerText2);
              answerTexts[b]=(TextView)findViewById(R.id.answerText1);
              answerTexts[c]=(TextView)findViewById(R.id.answerText4);
              answerTexts[d]=(TextView)findViewById(R.id.answerText3);
                break;
            }
            a=random.nextInt(4);
            b=random.nextInt(4);
            c =random.nextInt(4);
            d=random.nextInt(4);
        }
      switch (i){
          case 0:
              for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(OccupationList.occupationList[m]);
                  options[m].setTag(OccupationList.occtags[m]);
              }
              a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a){
                      answers[a].setTag(OccupationList.occtags[a]);
                      answerTexts[a].setText(OccupationList.occtags[a]);
                      answers[b].setTag(OccupationList.occtags[b]);
                      answerTexts[b].setText(OccupationList.occtags[b]);
                      answers[c].setTag(OccupationList.occtags[c]);
                      answerTexts[c].setText(OccupationList.occtags[c]);
                      answers[d].setTag(OccupationList.occtags[d]);
                      answerTexts[d].setText(OccupationList.occtags[d]);
                      break;
                  }
                a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              }
              break;
          case 1:

               for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(OccupationList.occupationList1[m]);
                  options[m].setTag(OccupationList.occtags2[m]);
              }
              a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a){
                      answers[a].setTag(OccupationList.occtags2[a]);
                      answerTexts[a].setText(OccupationList.occtags2[a]);
                      answers[b].setTag(OccupationList.occtags2[b]);
                      answerTexts[b].setText(OccupationList.occtags2[b]);
                      answers[c].setTag(OccupationList.occtags2[c]);
                      answerTexts[c].setText(OccupationList.occtags2[c]);
                      answers[d].setTag(OccupationList.occtags2[d]);
                      answerTexts[d].setText(OccupationList.occtags2[d]);
                      break;
                  }
                   a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);
              }

              break;
          case 2:
                for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(OccupationList.occupationList2[m]);
                  options[m].setTag(OccupationList.occtags3[m]);
              }
              b=random.nextInt(4);
              a=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b && c!=a){
                      Log.i("a", Integer.toString(a));
                      Log.i("b", Integer.toString(b));
                      Log.i("c", Integer.toString(c));
                      Log.i("d", Integer.toString(d));
                      answers[a].setTag(OccupationList.occtags3[a]);
                      answerTexts[a].setText(OccupationList.occtags3[a]);
                      answers[b].setTag(OccupationList.occtags3[b]);
                      answerTexts[b].setText(OccupationList.occtags3[b]);
                      answers[c].setTag(OccupationList.occtags3[c]);
                      answerTexts[c].setText(OccupationList.occtags3[c]);
                      answers[d].setTag(OccupationList.occtags3[d]);
                      answerTexts[d].setText(OccupationList.occtags3[d]);
                      break;
                  }
                  a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);
              }
              break;
      }
  }
/*
    Set Transport Images for Quiz
 */
  private void setTransport(int i)
  {

      Random random=new Random();
        int k;
        int a,b,c,d;
        a=random.nextInt(4);
        b=random.nextInt(4);
        c =random.nextInt(4);
        d=random.nextInt(4);
        //setting random images
        while (true){
            if(a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a)
            {
                options[a]=(ImageView)findViewById(R.id.drag1);
                options[b]=(ImageView)findViewById(R.id.drag2);
                options[c]=(ImageView)findViewById(R.id.drag3);
                options[d]=(ImageView)findViewById(R.id.drag4);

                answers[a]=findViewById(R.id.answer2);
              answers[b]=findViewById(R.id.answer1);
              answers[c]=findViewById(R.id.answer4);
              answers[d]=findViewById(R.id.answer3);

              answerTexts[a]=(TextView)findViewById(R.id.answerText2);
              answerTexts[b]=(TextView)findViewById(R.id.answerText1);
              answerTexts[c]=(TextView)findViewById(R.id.answerText4);
              answerTexts[d]=(TextView)findViewById(R.id.answerText3);
                break;
            }
            a=random.nextInt(4);
            b=random.nextInt(4);
            c =random.nextInt(4);
            d=random.nextInt(4);
        }

      switch (i){
          case 0:
              for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(TransportList.transList[m]);
                  options[m].setTag(TransportList.transtags[m]);
              }
              a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a){
                      answers[a].setTag(TransportList.transtags[a]);
                      answerTexts[a].setText(TransportList.transtags[a]);
                      answers[b].setTag(TransportList.transtags[b]);
                      answerTexts[b].setText(TransportList.transtags[b]);
                      answers[c].setTag(TransportList.transtags[c]);
                      answerTexts[c].setText(TransportList.transtags[c]);
                      answers[d].setTag(TransportList.transtags[d]);
                      answerTexts[d].setText(TransportList.transtags[d]);
                      break;
                  }
                a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              }
              break;
          case 1:

               for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(TransportList.transList1[m]);
                  options[m].setTag(TransportList.transtags2[m]);
              }
              a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a){
                      answers[a].setTag(TransportList.transtags2[a]);
                      answerTexts[a].setText(TransportList.transtags2[a]);
                      answers[b].setTag(TransportList.transtags2[b]);
                      answerTexts[b].setText(TransportList.transtags2[b]);
                      answers[c].setTag(TransportList.transtags2[c]);
                      answerTexts[c].setText(TransportList.transtags2[c]);
                      answers[d].setTag(TransportList.transtags2[d]);
                      answerTexts[d].setText(TransportList.transtags2[d]);
                      break;
                  }
                   a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);
              }

              break;
          case 2:
                for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(TransportList.transList2[m]);
                  options[m].setTag(TransportList.transtags3[m]);
              }
              b=random.nextInt(4);
              a=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b && c!=a){
                      Log.i("a", Integer.toString(a));
                      Log.i("b", Integer.toString(b));
                      Log.i("c", Integer.toString(c));
                      Log.i("d", Integer.toString(d));
                      answers[a].setTag(TransportList.transtags3[a]);
                      answerTexts[a].setText(TransportList.transtags3[a]);
                      answers[b].setTag(TransportList.transtags3[b]);
                      answerTexts[b].setText(TransportList.transtags3[b]);
                      answers[c].setTag(TransportList.transtags3[c]);
                      answerTexts[c].setText(TransportList.transtags3[c]);
                      answers[d].setTag(TransportList.transtags3[d]);
                      answerTexts[d].setText(TransportList.transtags3[d]);
                      break;
                  }
                  a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);
              }
              break;
      }

  }
    /*
    Set Public Places for Images View for quiz
     */
  private void setPlaces(int i)
  {
        Random random=new Random();
        int k;
        int a,b,c,d;
        a=random.nextInt(4);
        b=random.nextInt(4);
        c =random.nextInt(4);
        d=random.nextInt(4);
        //setting random images
        while (true){
            if(a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a)
            {
                options[a]=(ImageView)findViewById(R.id.drag1);
                options[b]=(ImageView)findViewById(R.id.drag2);
                options[c]=(ImageView)findViewById(R.id.drag3);
                options[d]=(ImageView)findViewById(R.id.drag4);

                answers[a]=findViewById(R.id.answer2);
              answers[b]=findViewById(R.id.answer1);
              answers[c]=findViewById(R.id.answer4);
              answers[d]=findViewById(R.id.answer3);

              answerTexts[a]=(TextView)findViewById(R.id.answerText2);
              answerTexts[b]=(TextView)findViewById(R.id.answerText1);
              answerTexts[c]=(TextView)findViewById(R.id.answerText4);
              answerTexts[d]=(TextView)findViewById(R.id.answerText3);
                break;
            }
            a=random.nextInt(4);
            b=random.nextInt(4);
            c =random.nextInt(4);
            d=random.nextInt(4);
        }


      switch (i){
          case 0:
              for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(PlacesList.placesList[m]);
                  options[m].setTag(PlacesList.placetags[m]);
              }
              a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a){
                      answers[a].setTag(PlacesList.placetags[a]);
                      answerTexts[a].setText(PlacesList.placetags[a]);
                      answers[b].setTag(PlacesList.placetags[b]);
                      answerTexts[b].setText(PlacesList.placetags[b]);
                      answers[c].setTag(PlacesList.placetags[c]);
                      answerTexts[c].setText(PlacesList.placetags[c]);
                      answers[d].setTag(PlacesList.placetags[d]);
                      answerTexts[d].setText(PlacesList.placetags[d]);
                      break;
                  }
                a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              }
              break;
          case 1:

               for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(PlacesList.placesList1[m]);
                  options[m].setTag(PlacesList.placetags2[m]);
              }
              a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a){
                      answers[a].setTag(PlacesList.placetags2[a]);
                      answerTexts[a].setText(PlacesList.placetags2[a]);
                      answers[b].setTag(PlacesList.placetags2[b]);
                      answerTexts[b].setText(PlacesList.placetags2[b]);
                      answers[c].setTag(PlacesList.placetags2[c]);
                      answerTexts[c].setText(PlacesList.placetags2[c]);
                      answers[d].setTag(PlacesList.placetags2[d]);
                      answerTexts[d].setText(PlacesList.placetags2[d]);
                      break;
                  }
                  a=random.nextInt(4);
                  b=random.nextInt(4);
                  c=random.nextInt(4);
                  d=random.nextInt(4);
                  }

              break;

      }
  }
    /*
    Images for sports quiz
     */
  private void setSports(int i)
  {
      Random random=new Random();
        int k;
        int a,b,c,d;
        a=random.nextInt(4);
        b=random.nextInt(4);
        c =random.nextInt(4);
        d=random.nextInt(4);
        //setting random images
        while (true){
            if(a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a)
            {
                options[a]=(ImageView)findViewById(R.id.drag1);
                options[b]=(ImageView)findViewById(R.id.drag2);
                options[c]=(ImageView)findViewById(R.id.drag3);
                options[d]=(ImageView)findViewById(R.id.drag4);

                answers[a]=findViewById(R.id.answer2);
              answers[b]=findViewById(R.id.answer1);
              answers[c]=findViewById(R.id.answer4);
              answers[d]=findViewById(R.id.answer3);

              answerTexts[a]=(TextView)findViewById(R.id.answerText2);
              answerTexts[b]=(TextView)findViewById(R.id.answerText1);
              answerTexts[c]=(TextView)findViewById(R.id.answerText4);
              answerTexts[d]=(TextView)findViewById(R.id.answerText3);
                break;
            }
            a=random.nextInt(4);
            b=random.nextInt(4);
            c =random.nextInt(4);
            d=random.nextInt(4);
        }

      switch (i){
          case 0:
              for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(SportList.sport1[m]);
                  options[m].setTag(SportList.sporttag[m]);
              }
              a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a){
                      answers[a].setTag(SportList.sporttag[a]);
                      answerTexts[a].setText(SportList.sporttag[a]);
                      answers[b].setTag(SportList.sporttag[b]);
                      answerTexts[b].setText(SportList.sporttag[b]);
                      answers[c].setTag(SportList.sporttag[c]);
                      answerTexts[c].setText(SportList.sporttag[c]);
                      answers[d].setTag(SportList.sporttag[d]);
                      answerTexts[d].setText(SportList.sporttag[d]);
                      break;
                  }
                a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              }
              break;
          case 1:

               for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(SportList.sport2[m]);
                  options[m].setTag(SportList.sporttag2[m]);
              }
              a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a){
                      answers[a].setTag(SportList.sporttag2[a]);
                      answerTexts[a].setText(SportList.sporttag2[a]);
                      answers[b].setTag(SportList.sporttag2[b]);
                      answerTexts[b].setText(SportList.sporttag2[b]);
                      answers[c].setTag(SportList.sporttag2[c]);
                      answerTexts[c].setText(SportList.sporttag2[c]);
                      answers[d].setTag(SportList.sporttag2[d]);
                      answerTexts[d].setText(SportList.sporttag2[d]);
                      break;
                  }
                   a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);
              }

              break;
          case 2:
                for (int m=0;m<4;m++)
              {
                  options[m].setImageResource(SportList.sport3[m]);
                  options[m].setTag(SportList.sporttag3[m]);
              }
              b=random.nextInt(4);
              a=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);

              while (true){
                  if (a!=b && b!=c && c!=d && d!=a && d!=b && c!=a){
                      Log.i("a", Integer.toString(a));
                      Log.i("b", Integer.toString(b));
                      Log.i("c", Integer.toString(c));
                      Log.i("d", Integer.toString(d));
                      answers[a].setTag(SportList.sporttag3[a]);
                      answerTexts[a].setText(SportList.sporttag3[a]);
                      answers[b].setTag(SportList.sporttag3[b]);
                      answerTexts[b].setText(SportList.sporttag3[b]);
                      answers[c].setTag(SportList.sporttag3[c]);
                      answerTexts[c].setText(SportList.sporttag3[c]);
                      answers[d].setTag(SportList.sporttag3[d]);
                      answerTexts[d].setText(SportList.sporttag3[d]);
                      break;
                  }
                  a=random.nextInt(4);
              b=random.nextInt(4);
              c=random.nextInt(4);
              d=random.nextInt(4);
              }
              break;
      }
  }

  public void imageReset()
  {
         Random random=new Random();
        int a,b,c,d;
        a=random.nextInt(4);
        b=random.nextInt(4);
        c =random.nextInt(4);
        d=random.nextInt(4);
        //setting random images
        while (true){
            if(a!=b && b!=c && c!=d && d!=a && d!=b  && c!=a)
            {
                options[a]=(ImageView)findViewById(R.id.drag1);
                options[b]=(ImageView)findViewById(R.id.drag2);
                options[c]=(ImageView)findViewById(R.id.drag3);
                options[d]=(ImageView)findViewById(R.id.drag4);

                answers[a]=findViewById(R.id.answer2);
              answers[b]=findViewById(R.id.answer1);
              answers[c]=findViewById(R.id.answer4);
              answers[d]=findViewById(R.id.answer3);

              answerTexts[a]=(TextView)findViewById(R.id.answerText2);
              answerTexts[b]=(TextView)findViewById(R.id.answerText1);
              answerTexts[c]=(TextView)findViewById(R.id.answerText4);
              answerTexts[d]=(TextView)findViewById(R.id.answerText3);

              options[a].setImageResource(0);
              options[b].setImageResource(0);
              options[c].setImageResource(0);
              options[d].setImageResource(0);

              answers[a].setImageResource(0);
              answers[b].setImageResource(0);
              answers[c].setImageResource(0);
              answers[d].setImageResource(0);


                break;
            }
            a=random.nextInt(4);
            b=random.nextInt(4);
            c =random.nextInt(4);
            d=random.nextInt(4);
        }
  }

  //custom class for drag listener
    public class MyDragListener implements View.OnDragListener {

      @Override
    public boolean onDrag(View view, DragEvent motionEvent) {
        int k=motionEvent.getAction();
        switch (k)
        {
                 case DragEvent.ACTION_DRAG_STARTED:
                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        View v=(View)motionEvent.getLocalState();
                        ImageView droptarget=(ImageView) view;
                        ImageView option=(ImageView)v;

                        if (droptarget.getTag().toString().equals(option.getTag().toString()))
                        {
                            droptarget.setImageDrawable(option.getDrawable());
                            option.setVisibility(View.INVISIBLE);
                            option.setImageResource(0);
                            Toast.makeText(GameActivity.this, "Correct!!", Toast.LENGTH_SHORT).show();
                            if (drag1.getVisibility()== View.INVISIBLE&
                                drag2.getVisibility()== View.INVISIBLE&
                                drag3.getVisibility()== View.INVISIBLE&
                                drag4.getVisibility()== View.INVISIBLE)
                            {
                                      g1.setVisibility(View.INVISIBLE);
                                      g2.setVisibility(View.INVISIBLE);
                                      cardView.setVisibility(View.VISIBLE);
                                      answer1.setImageDrawable(null);
                                      answer2.setImageDrawable(null);
                                      answer3.setImageDrawable(null);
                                      answer4.setImageDrawable(null);
                            }

                        }
                        else
                        {
                            Toast.makeText(GameActivity.this, "Incorrect Try Again!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:

                        break;
                     default:break;
        }
         return true;
    }



    }
}
