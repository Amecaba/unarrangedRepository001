package com.example.yotaro.testcalculater1;

import android.view.View;
import android.widget.TextView;

/**
 * Created by YOTARO on 2016/02/21.
 */
public class OnClickListenerPercent implements View.OnClickListener {
    @Override
    public void onClick(View v){
        TextView mainTextView=(TextView)v.getRootView().findViewById(R.id.mainview);
        double internalDouble=Double.parseDouble(mainTextView.getText().toString().replace(",",""))/100;
        String returnString= Methods.combertDobleToString(internalDouble);
        mainTextView.setText(returnString);
    }
}
