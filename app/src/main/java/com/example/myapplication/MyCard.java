package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * Created by Rishabh on 2/15/2018.
 */

public class MyCard extends ArrayAdapter<MyOptions> {

    ArrayList<MyOptions> options=new ArrayList<>();


    public MyCard(Context context, int resource, ArrayList<MyOptions> options) {
        super(context, resource, options);
        this.options = options;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=convertView;
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=inflater.inflate(R.layout.card_list,null);
        TextView cardText=(TextView)v.findViewById(R.id.cardText);
        CircularImageView imageView=(CircularImageView)v.findViewById(R.id.cardImage);
        imageView.setImageResource(options.get(position).getResid());
        cardText.setText(options.get(position).getOptions());
        return v;
    }
}
