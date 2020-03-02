package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyExListAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> parent;
    Map<String,List<String>> map;


    public MyExListAdapter(Context context, List<String> parent, Map<String, List<String>> map) {
        this.context = context;
        this.parent = parent;
        this.map = map;
    }

    @Override
    public int getGroupCount() {
        return parent.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return map.get(parent.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parent.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return map.get(parent.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group_parent_title=(String)getGroup(groupPosition);
        if(convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.layout_parent,null);
        }
        TextView txtView=convertView.findViewById(R.id.txt_parent);
        txtView.setText(group_parent_title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String group_child_title=(String)getChild(groupPosition,childPosition);
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.layout_child,null);
        }
        TextView txtView=convertView.findViewById(R.id.txt_child);
        txtView.setText(group_child_title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
