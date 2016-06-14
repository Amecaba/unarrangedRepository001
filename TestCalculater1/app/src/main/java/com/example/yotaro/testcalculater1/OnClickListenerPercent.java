package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

/**
 * Created by YOTARO on 2016/02/21.
 */
public class OnClickListenerPercent implements View.OnClickListener {
    @Override
    public void onClick(View v){
        SharedPreferences mySharedPreference=v.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        if(mySharedPreference.getInt("ERRORFlag",0)==0) {
            TextView mainTextView = (TextView) v.getRootView().findViewById(R.id.mainview);
            double internalDouble = Double.parseDouble(mainTextView.getText().toString().replace(",", "")) / 100;
            String returnString = Methods.combertDobleToString(internalDouble);
            mainTextView.setText(returnString);
        }
    }
}
