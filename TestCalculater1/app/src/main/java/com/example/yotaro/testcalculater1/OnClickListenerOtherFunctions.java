package com.example.yotaro.testcalculater1;

import android.view.View;
import android.widget.TextView;

/**
 * Created by YOTARO on 2016/04/19.
 */
public class OnClickListenerOtherFunctions implements View.OnClickListener{
    @Override
    public void onClick(View v){
        TextView pastView=(TextView)v.getRootView().findViewById(R.id.pastview);
        TextView mainView=(TextView)v.getRootView().findViewById(R.id.mainview);
        String internalString=pastView.getText().toString();
        mainView.setText(internalString);
    }
}
