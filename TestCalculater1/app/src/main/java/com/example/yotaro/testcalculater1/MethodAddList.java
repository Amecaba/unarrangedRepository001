package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YOTARO on 2016/01/16.
 */
public class MethodAddList {
    SharedPreferences myPrefList;
    String insertString;
    String firstdoubleString;
    String seconddoubleString;
    String applydoubleString;

    public MethodAddList(View v,double firstdouble,double seconddouble,double applydouble,int method){
        myPrefList=v.getContext().getSharedPreferences("list", Context.MODE_PRIVATE);
        SharedPreferences.Editor myPrefListEditor=myPrefList.edit();

        ArrayList<String> methodTypeArray=new ArrayList<>();
        methodTypeArray.add("+");
        methodTypeArray.add("-");
        methodTypeArray.add("×");
        methodTypeArray.add("÷");

        if(firstdouble%1==0){
            firstdoubleString=String.valueOf(firstdouble).substring(0,String.valueOf(firstdouble).length()-2);
        }
        else
        {
            firstdoubleString=String.valueOf(firstdouble);
        }

        if(seconddouble%1==0){
            seconddoubleString=String.valueOf(seconddouble).substring(0,String.valueOf(seconddouble).length()-2);
        }
        else
        {
            seconddoubleString=String.valueOf(seconddouble);
        }
        String methodTypeString=methodTypeArray.get(method);
        if(applydouble%1==0){
            applydoubleString=String.valueOf(applydouble).substring(0,String.valueOf(applydouble).length()-2);
        }
        else
        {
            applydoubleString=String.valueOf(applydouble);
        }

        insertString=firstdoubleString+methodTypeString+seconddoubleString;

        int cycler=myPrefList.getInt("flag",0);
        int returnCycler;
        if(cycler<6){
            returnCycler=cycler+1;
        }
        else{
            returnCycler=0;
        }
        myPrefListEditor.putInt("flag",returnCycler);

        String prefNameCalc="calclist"+String.valueOf(returnCycler);
        String prefNameResult="resultlist"+String.valueOf(returnCycler);
        myPrefListEditor.putString(prefNameCalc,insertString);
        myPrefListEditor.putString(prefNameResult, applydoubleString);
        myPrefListEditor.commit();

        TextView pastCalc=(TextView)v.getRootView().findViewById(R.id.pastcalc);
        TextView pastView=(TextView)v.getRootView().findViewById(R.id.pastview);
        pastCalc.setText(insertString);
        pastView.setText(applydoubleString);
    }
}
