package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by YOTARO on 2016/01/20.
 */
public class OnClickListenerOthers implements View.OnClickListener {
    @Override
    public void onClick(View v){
        SharedPreferences mySharedPreference = v.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        if(mySharedPreference.getInt("ERRORFlag",0)==0) {

            TextView mainTextView = (TextView) v.getRootView().findViewById(R.id.mainview);
            String mainTextViewString = mainTextView.getText().toString().replace(",", "");
            String returnString = "0";
            double mainTextViewDouble = Double.parseDouble(mainTextViewString);
            double returnMainTextViewDouble;
            SharedPreferences.Editor mySPEditor = mySharedPreference.edit();

            //めんどくさいので、buttonIdList形成しないで、if文で直接R.idを参照
            if (v == v.getRootView().findViewById(R.id.buttonarrow)) {
                if (mainTextView.getText().toString().length() > 1) {
                    int internallength = mainTextViewString.length() - 1;
                    String internalString = mainTextViewString.substring(0, internallength);
                    String internalString2 = Methods.combertStringToString(internalString);
                    mainTextView.setText(internalString2);
//                mainTextView.setText(Methods.combertDobleToString(Double.parseDouble(mainTextViewString.substring(0, mainTextViewString.length() - 1))));
                } else {
                    mainTextView.setText("0");
                }

                //GT2度押しフラグの解除
                mySPEditor.remove("gTFlag");
            } else if (v == v.getRootView().findViewById(R.id.buttonGT) && mySharedPreference.getInt("gTFlag", 0) == 1) {
                mySPEditor.remove("gTDouble");
                mySPEditor.remove("gTFlag");
                mySPEditor.commit();
                //returnstringの小数点以下がないため、小数点除去処理でnull落ちする。
            } else {
                if (v == v.getRootView().findViewById(R.id.buttonGT)) {
                    returnString = mySharedPreference.getString("gTDouble", "0");
                    mySPEditor.putInt("gTFlag", 1);
                }
                if (v == v.getRootView().findViewById(R.id.buttonPM)) {
                    returnMainTextViewDouble = mainTextViewDouble * -1;
                    returnString = String.valueOf(returnMainTextViewDouble);

                    //GT2度押しフラグの解除
                    mySPEditor.remove("gTFlag");
                }
                if (v == v.getRootView().findViewById(R.id.buttonroot)) {
                    returnMainTextViewDouble = Math.sqrt(mainTextViewDouble);
                    returnString = String.valueOf(returnMainTextViewDouble);

                    //GT2度押しフラグの解除
                    mySPEditor.remove("gTFlag");
                }

                mySPEditor.commit();
                mainTextView.setText(Methods.combertDobleToString(Double.parseDouble(returnString)));

            }
        }

    }
}
