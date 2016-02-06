package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YOTARO on 2015/12/31.
 */
public class OnClickListenerCalculation implements View.OnClickListener {
    ArrayList<Button> internalButtonList;
    ArrayList<String> internalmethodList=new ArrayList<>();

    public OnClickListenerCalculation(ArrayList<Button> receivedButtonList){
        internalButtonList=receivedButtonList;

        internalmethodList.add("+");
        internalmethodList.add("-");
        internalmethodList.add("×");
        internalmethodList.add("÷");
    }

    public void onClick(View v){
        SharedPreferences mySharedPreference=v.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor mySPEditor=mySharedPreference.edit();

        //mainViewと一緒にmethodViewも取得。
        TextView mainTextView=(TextView)v.getRootView().findViewById(R.id.mainview);
        String mainTextViewString=mainTextView.getText().toString();
        TextView methodView=(TextView)v.getRootView().findViewById(R.id.methodview);

        for(int i=0;i<=4;i++){
            if(v==internalButtonList.get(i)){
                //SharedPreferencesのputがDoubleを扱えないので、Stringのままで処理
                //あと2行目でカンマを除く処理。
                if(mySharedPreference.getString("firstDouble", "default")=="default"){
                    String firstDouble=mainTextViewString.replace(",","");
                    mySPEditor.putString("firstDouble", firstDouble);
                    mySPEditor.commit();
                }
                else{
                    //calculationボタン群が押されているかを判別。mCFlagはcalculationボタン群が押されていたら1
                    //firstDoubleに値があって、calculationボタン群が押されていなかったら、（＝数字→calc→数字と押されていたら）、
                    // 以下の処理で計算実施
                    if(mySharedPreference.getInt("mCFlag",0)==0) {
                        MethodRun methodRun = new MethodRun();
                        methodRun.runMethod(v);
                        mySPEditor.putString("firstDouble", methodRun.returnDoubleString);//←この変数名は修正。
                        mySPEditor.commit();// .commit();
                        mainTextView.setText(methodRun.returnDoubleString);
                    }
                }

                //★ここからって、一遍Editorをcommitしててももう一回putできる？（無理か？）
                //i番目のmethodを保持（単にiを保持）
                mySPEditor.putInt("method", i);
                mySPEditor.putInt("mPCFlag", 1);
                mySPEditor.putInt("mCFlag", 1);
                mySPEditor.remove("mEFlag");
                mySPEditor.commit();

                methodView.setText(internalmethodList.get(i));
            }
        }
        //GT2度押しフラグの解除
        //★あれ、もしかしてここでcommitしておけばほかは全部不要？
        mySPEditor.remove("gTFlag");
        mySPEditor.commit();
    }

}
