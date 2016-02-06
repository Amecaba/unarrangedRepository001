package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by YOTARO on 2016/01/16.
 */
public class OnClickListenerMseries implements View.OnClickListener {
    SharedPreferences myPrefMemory;
    ArrayList<Button> internalButtonIdList;

    public OnClickListenerMseries(ArrayList<Button> receivedButtonIdList){
        internalButtonIdList=receivedButtonIdList;
    }

    @Override
    public void onClick(View v){
        double returnMemoryDouble=0;
        TextView mainTextView=(TextView)v.getRootView().findViewById(R.id.mainview);
        double mainTextViewDouble=Double.parseDouble(mainTextView.getText().toString().replace(",",""));
        SharedPreferences mySharedPreference=v.getContext().getSharedPreferences("mySharedPreference",Context.MODE_PRIVATE);
        SharedPreferences.Editor mySPEditor=mySharedPreference.edit();
        double memoryDouble=Double.parseDouble(mySharedPreference.getString("memory","0"));
        String memoryDoubleApply;

        for(int i=0;i<=3;i++){
            if(v==internalButtonIdList.get(i)){
                if(i<=2) {
                    if (i == 0) {
                        mySPEditor.putString("memory",String.valueOf(memoryDouble+mainTextViewDouble));
                    } else if (i == 1) {
                        mySPEditor.putString("memory",String.valueOf(memoryDouble-mainTextViewDouble));
                    } else if (i == 2) {
                        mySPEditor.remove("memory");
                    }
                    mySPEditor.commit();
                }
                else if(i==3){
                    NumberFormat nFmt=NumberFormat.getNumberInstance();
                    memoryDoubleApply=nFmt.format(Double.parseDouble(mySharedPreference.getString("memory","0")));
                    mainTextView.setText(memoryDoubleApply);
                }

            }
        }

        //GT2度押しフラグの解除
        mySPEditor.remove("gTFlag");
        mySPEditor.commit();
    }

}
