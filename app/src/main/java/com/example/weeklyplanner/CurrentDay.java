package com.example.weeklyplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CurrentDay extends AppCompatActivity {
ArrayList<String> receivedInfo;
ArrayList<String> receivedRecipies;
ArrayList<Recipe> recipesToBeShown;
String dayToBeChecked;
TextView Day;
ListView currentDayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_day);
        Log.i(String.valueOf(getIntent().getStringArrayListExtra("RecipiesToBeChecked")),"smth");
        receivedInfo = getIntent().getStringArrayListExtra("RecipiesToBeChecked");
        receivedInfo = MainScreen.initialise(receivedInfo);
        receivedRecipies = MainScreen.initialise(receivedRecipies);
        if(receivedInfo.size()>1){
            dayToBeChecked=receivedInfo.get(receivedInfo.size()-1);
            receivedInfo.remove(receivedInfo.size()-1);
        }
        Log.i(dayToBeChecked,"dayToBeChecked");
        Day =findViewById(R.id.Day);
        currentDayList = (findViewById(R.id.dayListView));
        Day.setText(dayToBeChecked);
            receivedRecipies.addAll(receivedInfo);

        Log.i(String.valueOf(receivedInfo),"receivedInfo");
        receivedInfo = MainScreen.initialise(receivedInfo);
        receivedRecipies = MainScreen.initialise(receivedRecipies);
        recipesToBeShown = MainScreen.initialise(recipesToBeShown);
        for(int i=0;i<receivedRecipies.size();i++){
            recipesToBeShown.add(Recipe.toRecipe(receivedRecipies.get(i)));
        }
        currentDayList.setAdapter(new CurrentDayAdapter(this,recipesToBeShown,dayToBeChecked));
    }
}
