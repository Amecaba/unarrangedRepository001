package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

/**
 * Created by YOTARO on 2016/03/06.
 */
public class MethodSetPasts {

    public static void setPasts(View v){
        String internalCalc;
        String internalResult;
        int cycler;
        SharedPreferences mySharedPreference=v.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        cycler=mySharedPreference.getInt("listFlag", 0);
        internalCalc=mySharedPreference.getString("calclist" + cycler, "");
        internalResult=mySharedPreference.getString("resultlist" + cycler, "");

        TextView pastCalc=(TextView)v.getRootView().findViewById(R.id.pastcalc);
        TextView pastView=(TextView)v.getRootView().findViewById(R.id.pastview);
        pastCalc.setText(internalCalc);
        pastView.setText(internalResult);
    }
}
