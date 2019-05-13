package com.example.weeklyplanner;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class CurrentDayAdapter extends BaseAdapter {
    ArrayList<Recipe> RecipiesForDay;
    LayoutInflater mInflater;
    String day;
    CurrentDayAdapter(Context context, ArrayList<Recipe> RecForDay, String currentDay){
        RecipiesForDay=RecForDay;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        day=currentDay;
        Log.i(String.valueOf(RecipiesForDay),"RecipiesForDay in contructor");
    }
    @Override
    public int getCount() {
        return RecipiesForDay.size();
    }

    @Override
    public Object getItem(int position) {
        return RecipiesForDay.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.current_day_view, null);
        TextView currentDayText = v.findViewById(R.id.current_day_nameText);
        ImageButton deleteRecipeForCurrentDay = v.findViewById(R.id.current_day_delete);
        String name = RecipiesForDay.get(position).getName();
        int mealsInDay = 0;
        String daysThatIsChecked = RecipiesForDay.get(position).getDay();
        Log.i(RecipiesForDay.get(position).getName(),"get Name for position");
        Log.i(day,"day");
        Log.i(RecipiesForDay.get(position).getDay(),"get day");
        if(name!=null&&name!="") {
            if (daysThatIsChecked.equals(day)) {
                mealsInDay++;
            }
        }
        for(int i=0;i<mealsInDay;i++){
            currentDayText.setText(name);
        }
        return v;
    }
}
