package com.example.yotaro.testcalculater1;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by YOTARO on 2016/01/09.
 */
public class OnClickListenerCseries implements View.OnClickListener {
    SharedPreferences firstInt;
    ArrayList<Button> mmmmButtonList;

    public OnClickListenerCseries(ArrayList<Button> trandButtonList){
        mmmmButtonList=trandButtonList;
    }

    @Override
    public void onClick(View v){
        MethodClear methodClear=new MethodClear(mmmmButtonList);
        methodClear.clearMethod(v);

    }

}