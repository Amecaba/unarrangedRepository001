package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by YOTARO on 2016/01/09.
 */
public class OnClickListenerCseries implements View.OnClickListener {
    ArrayList<Button> internalButtonList;

    public OnClickListenerCseries(ArrayList<Button> receivedButtonList){
        internalButtonList=receivedButtonList;
    }

    @Override
    public void onClick(View v){
        MethodClear methodClear=new MethodClear(internalButtonList);
        methodClear.clearMethod(v);

        //GT2度押しフラグの解除
        SharedPreferences mySharedPreference = v.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor mSPEditor=mySharedPreference.edit();
        mSPEditor.remove("gTFlag");
        mSPEditor.commit();
    }

}
