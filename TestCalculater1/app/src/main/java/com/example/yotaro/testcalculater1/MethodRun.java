package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.ConsumerIrManager;
import android.nfc.tech.TagTechnology;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;


/**
 * Created by YOTARO on 2016/01/02.
 */
public class MethodRun {
    Double firstDouble;
    Double secondDouble;
    Double returnDouble;
//    String applyDoubleStringBC;
    String returnDoubleString;
//    ArrayList<String> methodTypeArray=new ArrayList<>();
//    String methodType;
    int method;

    public MethodRun(){
//        methodTypeArray.add("+");
//        methodTypeArray.add("-");
//        methodTypeArray.add("×");
//        methodTypeArray.add("÷");
    }

    public void runMethod(View v){

        SharedPreferences mySharedPreference=v.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
//        SharedPreferences myPrefMethod=v.getContext().getSharedPreferences("myPrefMethod",Context.MODE_PRIVATE);
//        SharedPreferences myEqualFlag=v.getContext().getSharedPreferences("myPrefEqualFlag",Context.MODE_PRIVATE);
//        SharedPreferences backupFirstFroat=v.getContext().getSharedPreferences("myPrefBackupFirstFloat",Context.MODE_PRIVATE);
//        SharedPreferences backupMethod=v.getContext().getSharedPreferences("myPrefBackupMethod",Context.MODE_PRIVATE);
//        SharedPreferences backupSecondFroat=v.getContext().getSharedPreferences("myPrefBackupSecondFroat",Context.MODE_PRIVATE);

        TextView mainTextView=(TextView)v.getRootView().findViewById(R.id.mainview);

        //必要な変数をSharedPreferenceから取得する。equal連打の場合とそれ以外で分岐。mEFlag==0でそれ以外
        if(mySharedPreference.getInt("mEFlag",0)==0){
            firstDouble=Double.parseDouble(mySharedPreference.getString("firstDouble", "0").replace(",",""));
            method=mySharedPreference.getInt("method", 0);
            secondDouble=Double.parseDouble(mainTextView.getText().toString().replace(",",""));
        }
        else{
            firstDouble=Double.parseDouble(mySharedPreference.getString("firstDoubleToNext", "0").replace(",",""));
            method=mySharedPreference.getInt("methodToNext", 0);
            secondDouble=Double.parseDouble(mySharedPreference.getString("secondDoubleToNext","0"));
        }

        if(method==0){
            returnDouble=firstDouble+secondDouble;
        }
        else if(method==1){
            returnDouble=firstDouble-secondDouble;
        }
        else if(method==2){
            returnDouble=firstDouble*secondDouble;
        }
        else if(method==3){
            returnDouble=firstDouble/secondDouble;
        }

        //0.を落とす処理、いらないような・・・。
//        applyFloatStringBC=String.valueOf(applyFloat);
//        if((applyFloat*10)%10==0){
//            applyFLoatString=applyFloatStringBC.substring(0, applyFloatStringBC.length() - 2);
//        }
//        else{
//            applyFLoatString=applyFloatStringBC;
//        }

        NumberFormat nFmt=NumberFormat.getNumberInstance();
        returnDoubleString=nFmt.format(returnDouble);
        mainTextView.setText(returnDoubleString);

        //リスト用のオブジェクトをインスタンス化（コンストラクタで必要な値をSharedPreferenceに保持）
        new MethodAddList(v,firstDouble,secondDouble,returnDouble,method);
    }

}
