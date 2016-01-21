package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.ConsumerIrManager;
import android.nfc.tech.TagTechnology;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by YOTARO on 2016/01/02.
 */
public class MethodRun {
    float firstFloat;
    float secondFloat;
    float applyFloat;
    String applyFloatStringBC;
    String applyFLoatString;
    ArrayList<String> methodTypeArray=new ArrayList<String>();
    String methodType;
    int method;

    public MethodRun(){
        methodTypeArray.add("+");
        methodTypeArray.add("-");
        methodTypeArray.add("×");
        methodTypeArray.add("÷");
    }

    public void runMethod(View v){
        SharedPreferences myPref=v.getContext().getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences myPrefMethod=v.getContext().getSharedPreferences("myPrefMethod",Context.MODE_PRIVATE);
        SharedPreferences myEqualFlag=v.getContext().getSharedPreferences("myPrefEqualFlag",Context.MODE_PRIVATE);
        SharedPreferences backupFirstFroat=v.getContext().getSharedPreferences("myPrefBackupFirstFloat",Context.MODE_PRIVATE);
        SharedPreferences backupMethod=v.getContext().getSharedPreferences("myPrefBackupMethod",Context.MODE_PRIVATE);
//        SharedPreferences backupSecondFroat=v.getContext().getSharedPreferences("myPrefBackupSecondFroat",Context.MODE_PRIVATE);

        TextView mainTextView=(TextView)v.getRootView().findViewById(R.id.mainview);


        if(myEqualFlag.getInt("mEFlag",0)==0){
            firstFloat=myPref.getFloat("firstFloat", 0);
            method=myPrefMethod.getInt("method", 0);
            secondFloat=Float.parseFloat(mainTextView.getText().toString());
        }
        else{
            firstFloat=backupFirstFroat.getFloat("mBFF", 0);
            method=backupMethod.getInt("mBM", 0);
            secondFloat=backupFirstFroat.getFloat("mBSF",0);
        }




        if(method==0){
            applyFloat=firstFloat+secondFloat;
        }
        else if(method==1){
            applyFloat=firstFloat-secondFloat;
        }
        else if(method==2){
            applyFloat=firstFloat*secondFloat;
        }
        else if(method==3){
            applyFloat=firstFloat/secondFloat;
        }

        applyFloatStringBC=String.valueOf(applyFloat);
        if((applyFloat*10)%10==0){
            applyFLoatString=applyFloatStringBC.substring(0, applyFloatStringBC.length() - 2);
        }
        else{
            applyFLoatString=applyFloatStringBC;
        }

        MethodAddList methodAddList=new MethodAddList(v,firstFloat,secondFloat,applyFloat,method);

        mainTextView.setText(applyFLoatString);
    }

}
