package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<String> {

    private  final Activity context;
    private final ArrayList<String> mainTitle;
    private final ArrayList<Integer> imgid;

    public ListAdapter(Activity context, ArrayList<String> mainTitle, ArrayList<Integer> imgid) {
        super(context, R.layout.listitem, mainTitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.mainTitle=mainTitle;
        this.imgid=imgid;

    }

    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View rootView = inflater.inflate(R.layout.listitem,null, true);
        TextView titleText = (TextView) rootView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.icon);

        titleText.setText(mainTitle.get(position));
//        imageView.setImageResource(imgid.get(position));
        return rootView;
    }
}

