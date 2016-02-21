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
    SharedPreferences mySharedPreference;
    String insertString;
    String firstDoubleString;
    String secondDdoubleString;
    String applyDoubleString;
    String methodTypeString;

    public MethodAddList(View v,double receivedFirstDouble,double receivedSecondDouble,double receivedApplyDouble,int method){
        mySharedPreference=v.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor mySPEditor=mySharedPreference.edit();

        ArrayList<String> methodTypeArray=new ArrayList<>();
        methodTypeArray.add("+");
        methodTypeArray.add("-");
        methodTypeArray.add("×");
        methodTypeArray.add("÷");

        //ここからの0落とし処理を、Mehotdsの関数に修正（2016/2/14）
//        if(receivedFirstDouble%1==0){
//            firstDoubleString=String.valueOf(receivedFirstDouble).substring(0,String.valueOf(firstdouble).length()-2);
//        }
//        else
//        {
//            firstdoubleString=String.valueOf(firstdouble);
//        }
//
//        if(seconddouble%1==0){
//            seconddoubleString=String.valueOf(seconddouble).substring(0,String.valueOf(seconddouble).length()-2);
//        }
//        else
//        {
//            seconddoubleString=String.valueOf(seconddouble);
//        }

//        if(applydouble%1==0){
//            applydoubleString=String.valueOf(applydouble).substring(0,String.valueOf(applydouble).length()-2);
//        }
//        else
//        {
//            applydoubleString=String.valueOf(applydouble);
//        }

        firstDoubleString=Methods.combertDobleToString(receivedFirstDouble);
        secondDdoubleString=Methods.combertDobleToString(receivedSecondDouble);
        applyDoubleString=Methods.combertDobleToString(receivedApplyDouble);
        methodTypeString=methodTypeArray.get(method);

        insertString=firstDoubleString+methodTypeString+secondDdoubleString;

        int cycler=mySharedPreference.getInt("listFlag",0);
        int returnCycler;
        if(cycler<6){
            returnCycler=cycler+1;
        }
        else{
            returnCycler=0;
        }
        mySPEditor.putInt("listFlag",returnCycler);

        String calclistName="calclist"+String.valueOf(returnCycler);
        String resultlistName="resultlist"+String.valueOf(returnCycler);
        mySPEditor.putString(calclistName,insertString);
        mySPEditor.putString(resultlistName, applyDoubleString);
        mySPEditor.commit();

        TextView pastCalc=(TextView)v.getRootView().findViewById(R.id.pastcalc);
        TextView pastView=(TextView)v.getRootView().findViewById(R.id.pastview);
        pastCalc.setText(insertString);
        pastView.setText(applyDoubleString);
    }
}
