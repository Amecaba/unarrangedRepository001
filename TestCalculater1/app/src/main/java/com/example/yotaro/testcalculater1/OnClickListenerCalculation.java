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
    ArrayList<Button> mmmButtonList;
    ArrayList<String> methodList=new ArrayList<String>();

    public OnClickListenerCalculation(ArrayList<Button> trandButtonList){
        mmmButtonList=trandButtonList;

        methodList.add("+");
        methodList.add("-");
        methodList.add("×");
        methodList.add("÷");
    }

    public void onClick(View v){
        SharedPreferences firstInt=v.getContext().getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor fIEditor=firstInt.edit();
        SharedPreferences method=v.getContext().getSharedPreferences("myPrefMethod", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor=method.edit();
        SharedPreferences myPrefCompleteFlag=v.getContext().getSharedPreferences("myPrefCompleteFlag", Context.MODE_PRIVATE);
        SharedPreferences.Editor mPCFEditor=myPrefCompleteFlag.edit();
        SharedPreferences myCalcFlag=v.getContext().getSharedPreferences("myPrefCalcFlag", Context.MODE_PRIVATE);
        SharedPreferences.Editor mCFEditor=myCalcFlag.edit();
        SharedPreferences myEqualFlag=v.getContext().getSharedPreferences("myPrefEqualFlag",Context.MODE_PRIVATE);
        SharedPreferences.Editor myEFEditor=myEqualFlag.edit();

        TextView mainTextView=(TextView)v.getRootView().findViewById(R.id.mainview);
        String mainTextViewString=mainTextView.getText().toString();
        TextView methodView=(TextView)v.getRootView().findViewById(R.id.methodview);

        for(int i=0;i<=4;i++){
            if(v==mmmButtonList.get(i)){
                if(firstInt.getFloat("firstFloat",0)==0){
                    float nowFirstFloat=Float.parseFloat(mainTextViewString);
                    fIEditor.putFloat("firstFloat", nowFirstFloat);
                    fIEditor.commit();
                }
                else{
                    if(myCalcFlag.getInt("mCFlag",0)==0) {
                        MethodRun methodRun = new MethodRun();
                        methodRun.runMethod(v);
                        fIEditor.putFloat("firstFloat", Float.parseFloat(methodRun.applyFLoatString));
                        fIEditor.commit();
                        mainTextView.setText(methodRun.applyFLoatString);
                    }
                }

                mEditor.putInt("method", i);
                mEditor.commit();

                mPCFEditor.putInt("mPCFlag", 1);
                mPCFEditor.commit();

                mCFEditor.putInt("mCFlag",1);
                mCFEditor.commit();

                myEFEditor.remove("mEFlag");
                myEFEditor.commit();

                methodView.setText(methodList.get(i));
            }
        }
    }

}
