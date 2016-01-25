package com.example.yotaro.testcalculater1;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by YOTARO on 2016/01/24.
 */
public class OnClickListenerReturns implements View.OnClickListener {
    Activity innerActivity;
    ArrayList<Button> innerbuttonList;
    ArrayList<String> innerstringList;
    public OnClickListenerReturns(Activity activity,ArrayList<Button> buttonList,ArrayList<String> stringList){
        innerActivity=activity;
        innerbuttonList=buttonList;
        innerstringList=stringList;
    }

    @Override
    public void onClick(View v){
        for(int i=0;i<=6;i++){
            if(v==innerbuttonList.get(i)){
                //ここにintent+値渡し実装
            }


        }
        Intent intent=new Intent(innerActivity,MainActivity.class);
        innerActivity.startActivity(intent);
    }
}
