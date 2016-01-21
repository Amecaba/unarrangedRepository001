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
    TextView mainView;
    SharedPreferences firstInt;
    SharedPreferences secondInt;
    SharedPreferences method;
    SharedPreferences myPrefCompleteFlag;
    ArrayList<Button> mmmmButtonList;

    public MethodClear(ArrayList<Button> trandButtonList){
        mmmmButtonList=trandButtonList;
    }


    public void clearMethod(View v){
        TextView mainView=(TextView)v.getRootView().findViewById(R.id.mainview);
        mainView.setText("0");

        for(int i=0;i<=2;i++){
            if(mmmmButtonList.get(i)==v){
                if(i==0){
                    TextView methodTextView=(TextView)v.getRootView().findViewById(R.id.methodview);
                    methodTextView.setText("");

                    firstInt=v.getContext().getSharedPreferences("myPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor firstIntEditor=firstInt.edit();
                    method=v.getContext().getSharedPreferences("myPrefMethod",Context.MODE_PRIVATE);
                    SharedPreferences.Editor myPrefMethodEditor=method.edit();
                    myPrefCompleteFlag=v.getContext().getSharedPreferences("myPrefCompleteFlag",Context.MODE_PRIVATE);
                    SharedPreferences.Editor myPrefCompleteFlagEditor=myPrefCompleteFlag.edit();
                    SharedPreferences myPrefMemory=v.getContext().getSharedPreferences("memory",Context.MODE_PRIVATE);
                    SharedPreferences.Editor myPrefMemoryEditor=myPrefMemory.edit();

                    firstIntEditor.remove("firstFloat");
                    firstIntEditor.commit();
                    myPrefMethodEditor.remove("method");
                    myPrefMethodEditor.commit();
                    myPrefCompleteFlagEditor.remove("mPCFlag");
                    myPrefCompleteFlagEditor.commit();

                    //ここにプラスしてメモリの削除も記載
                    myPrefMemoryEditor.remove("memory");
                    myPrefMemoryEditor.commit();
                }
                else if(i==1){
                    TextView methodTextView=(TextView)v.getRootView().findViewById(R.id.methodview);
                    methodTextView.setText("");

                    firstInt=v.getContext().getSharedPreferences("myPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor firstIntEditor=firstInt.edit();
                    method=v.getContext().getSharedPreferences("myPrefMethod",Context.MODE_PRIVATE);
                    SharedPreferences.Editor myPrefMethodEditor=method.edit();
                    myPrefCompleteFlag=v.getContext().getSharedPreferences("myPrefCompleteFlag",Context.MODE_PRIVATE);
                    SharedPreferences.Editor myPrefCompleteFlagEditor=myPrefCompleteFlag.edit();

                    firstIntEditor.remove("firstFloat");
                    firstIntEditor.commit();
                    myPrefMethodEditor.remove("method");
                    myPrefMethodEditor.commit();
                    myPrefCompleteFlagEditor.remove("mPCFlag");
                    myPrefCompleteFlagEditor.commit();

                }
            }
        }
    }
}
