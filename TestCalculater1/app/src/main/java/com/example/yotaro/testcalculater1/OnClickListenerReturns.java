package com.example.yotaro.testcalculater1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

/**

 * Created by YOTARO on 2016/01/24.
 */
public class OnClickListenerReturns implements View.OnClickListener {
    FragmentActivity innerActivity;
    ArrayList<ImageButton> innerbuttonList;
    ArrayList<String> innerstringList;
    ArrayList<String> innercfstringList;
    String returnString;
    String returnFString;

    public OnClickListenerReturns(FragmentActivity activity,ArrayList<ImageButton> buttonList,ArrayList<String> stringList,ArrayList<String> fsStrignList){
        innerActivity=activity;
        innerbuttonList=buttonList;
        innerstringList=stringList;
        innercfstringList=fsStrignList;
    }

    @Override
    public void onClick(View v){
        for(int i=0;i<=6;i++){
            if(v==innerbuttonList.get(i)){
                returnString=innerstringList.get(i);
                returnFString=innercfstringList.get(i);
            }
        }


        SharedPreferences mySharedPreference=v.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor mySPEditor=mySharedPreference.edit();
        mySPEditor.putString("returnString",returnString);
        mySPEditor.putString("returnFString",returnFString);
        mySPEditor.commit();

        ViewPager myViewPager=(ViewPager)v.getRootView().findViewById(R.id.pager);
        myViewPager.setAdapter(new MainViewPagerAdapter(innerActivity.getSupportFragmentManager()));

        myViewPager.setCurrentItem(0);
        }
    }
