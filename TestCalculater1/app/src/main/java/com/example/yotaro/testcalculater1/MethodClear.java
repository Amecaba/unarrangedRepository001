package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YOTARO on 2016/01/09.
 */
public class MethodClear {
    SharedPreferences firstInt;
    SharedPreferences method;
    SharedPreferences myPrefCompleteFlag;
    ArrayList<Button> internalButtonList;

    public MethodClear(ArrayList<Button> receivedButtonList){
        internalButtonList=receivedButtonList;
    }


    public void clearMethod(View v){
        //Cシリーズ共通のmainView0化処理
        TextView mainView=(TextView)v.getRootView().findViewById(R.id.mainview);
        mainView.setText("0");

        SharedPreferences mySharedPreference=v.getContext().getSharedPreferences("mySharedPreference",Context.MODE_PRIVATE);
        SharedPreferences.Editor mySPEditor=mySharedPreference.edit();

        for(int i=0;i<=2;i++){
            if(internalButtonList.get(i)==v){
                if(i==0){
                    TextView methodTextView=(TextView)v.getRootView().findViewById(R.id.methodview);
                    methodTextView.setText("");

                    mySPEditor.remove("firstDouble");
                    mySPEditor.remove("method");
                    mySPEditor.remove("mPCFlag");
                    mySPEditor.remove("memory");
                    mySPEditor.commit();
                }
                else if(i==1){
                    TextView methodTextView=(TextView)v.getRootView().findViewById(R.id.methodview);
                    methodTextView.setText("");

                    //memory以外はACと一緒
                    mySPEditor.remove("firstDouble");
                    mySPEditor.remove("method");
                    mySPEditor.remove("mPCFlag");
                    mySPEditor.commit();

                }
            }
        }
    }
}
