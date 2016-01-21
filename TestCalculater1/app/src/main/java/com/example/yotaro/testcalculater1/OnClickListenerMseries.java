package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YOTARO on 2016/01/16.
 */
public class OnClickListenerMseries implements View.OnClickListener {
    SharedPreferences myPrefMemory;
    TextView mainTextView;
    ArrayList<Button> buttonIdList;

    public OnClickListenerMseries(ArrayList<Button> trandButtonIdList){
        buttonIdList=trandButtonIdList;
    }

    @Override
    public void onClick(View v){
        float returnMemoryFloat=0;
        mainTextView=(TextView)v.getRootView().findViewById(R.id.mainview);
        float mTVFloat=Float.parseFloat(mainTextView.getText().toString());
        myPrefMemory=v.getContext().getSharedPreferences("memory",Context.MODE_PRIVATE);
        SharedPreferences.Editor myPrefMemoryEditor=myPrefMemory.edit();
        float memoryFloat=myPrefMemory.getFloat("memory",0);
        String memoryFloatApply;

        for(int i=0;i<=3;i++){
            if(v==buttonIdList.get(i)){
                if(i<=2) {
                    if (i == 0) {
                        myPrefMemoryEditor.putFloat("memory",memoryFloat+mTVFloat);
                        myPrefMemoryEditor.commit();
                    } else if (i == 1) {
                        myPrefMemoryEditor.putFloat("memory",memoryFloat-mTVFloat);
                        myPrefMemoryEditor.commit();
                    } else if (i == 2) {
                        myPrefMemoryEditor.remove("memory");
                        myPrefMemoryEditor.commit();
                    }
                }
                else if(i==3){
                    if(memoryFloat%1==0){
                        memoryFloatApply=String.valueOf(memoryFloat).substring(0,String.valueOf(memoryFloat).length()-2);
                    }
                    else{
                        memoryFloatApply=String.valueOf(memoryFloat);
                    }
                    mainTextView.setText(memoryFloatApply);
                }

            }
        }
    }

}
