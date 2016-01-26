package com.example.yotaro.testcalculater1;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by YOTARO on 2016/01/24.
 */
public class OnClickListenerReturns implements View.OnClickListener {
    Activity innerActivity;
    ArrayList<ImageButton> innerbuttonList;
    ArrayList<String> innerstringList;
    public OnClickListenerReturns(Activity activity,ArrayList<ImageButton> buttonList,ArrayList<String> stringList){
        innerActivity=activity;
        innerbuttonList=buttonList;
        innerstringList=stringList;
    }

    @Override
    public void onClick(View v){
        Intent intent=new Intent(innerActivity,MainActivity.class);
        for(int i=0;i<=1;i++){
            if(v==innerbuttonList.get(i)){
                String innerString=innerstringList.get(i);
                intent.putExtra("sendresult",innerString);
            }


        }
        innerActivity.startActivity(intent);
    }
}
