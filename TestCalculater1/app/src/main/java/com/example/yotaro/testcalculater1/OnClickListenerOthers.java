package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by YOTARO on 2016/01/20.
 */
public class OnClickListenerOthers implements View.OnClickListener {
    @Override
    public void onClick(View v){
        TextView mainTextView=(TextView)v.getRootView().findViewById(R.id.mainview);
        String mainTextViewString=mainTextView.getText().toString();
        String returnString="0";
        double mainTextViewDouble=Double.parseDouble(mainTextViewString);
        double returnMainTextViewDouble;
        SharedPreferences myPrefGrandTotal = v.getContext().getSharedPreferences("grandtotal", Context.MODE_PRIVATE);

        if(v==v.getRootView().findViewById(R.id.buttonarrow)){
            if(mainTextView.getText().toString().length()>1) {
                mainTextView.setText(mainTextViewString.substring(0, mainTextViewString.length() - 1));
            }

            //GT2度押しフラグの解除
            SharedPreferences.Editor myPrefGTEditor=myPrefGrandTotal.edit();
            myPrefGTEditor.remove("key");
            myPrefGTEditor.commit();
        }
        else if(v==v.getRootView().findViewById(R.id.buttonGT)&&myPrefGrandTotal.getInt("key", 0) == 1) {
            SharedPreferences.Editor myPrefGTEditor = myPrefGrandTotal.edit();
            myPrefGTEditor.remove("gtnumber");
            myPrefGTEditor.remove("key");
            myPrefGTEditor.commit();
                //returnstringの小数点以下がないため、小数点除去処理でnull落ちする。
        }
        else
        {
            if(v==v.getRootView().findViewById(R.id.buttonGT)){
                SharedPreferences.Editor myPrefGTEditor=myPrefGrandTotal.edit();
                returnString=myPrefGrandTotal.getString("gtnumber", "0");
                myPrefGTEditor.putInt("key",1);
                myPrefGTEditor.commit();
            }
            if(v==v.getRootView().findViewById(R.id.buttonPM)){
                returnMainTextViewDouble=mainTextViewDouble*-1;
                returnString=String.valueOf(returnMainTextViewDouble);

                //GT2度押しフラグの解除
                SharedPreferences.Editor myPrefGTEditor=myPrefGrandTotal.edit();
                myPrefGTEditor.remove("key");
                myPrefGTEditor.commit();
            }
            if(v==v.getRootView().findViewById(R.id.buttonroot)){
                returnMainTextViewDouble=Math.sqrt(mainTextViewDouble);
                returnString=String.valueOf(returnMainTextViewDouble);

                //GT2度押しフラグの解除
                SharedPreferences.Editor myPrefGTEditor=myPrefGrandTotal.edit();
                myPrefGTEditor.remove("key");
                myPrefGTEditor.commit();
            }
            if(returnString!="0" && Double.parseDouble(returnString)%1==0){
                mainTextView.setText(returnString.substring(0,returnString.length()-2));
            }
            else
            {
                mainTextView.setText(returnString);
            }

        }

    }
}
