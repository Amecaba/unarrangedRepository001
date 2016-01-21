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

        if(v==v.getRootView().findViewById(R.id.buttonarrow)){
            mainTextView.setText(mainTextViewString.substring(0,mainTextViewString.length()-1));
        }
        else
        {
            if(v==v.getRootView().findViewById(R.id.buttonGT)){
                SharedPreferences myPrefGrandTotal=v.getContext().getSharedPreferences("grandtotal", Context.MODE_PRIVATE);
                SharedPreferences.Editor myPrefGTEditor=myPrefGrandTotal.edit();
                if(myPrefGrandTotal.getInt("key",0)==1){
                    myPrefGTEditor.remove("gtnumber");
                    myPrefGTEditor.remove("key");
                    myPrefGTEditor.commit();
                    returnString=mainTextViewString;//returnstringの小数点以下がないため、小数点除去処理でnull落ちする。
                }
                else {
                    returnString=myPrefGrandTotal.getString("gtnumber", "0");
                    myPrefGTEditor.putInt("key",1);
                    myPrefGTEditor.commit();
                }
            }
            if(v==v.getRootView().findViewById(R.id.buttonPM)){
                returnMainTextViewDouble=mainTextViewDouble*-1;
                returnString=String.valueOf(returnMainTextViewDouble);
            }
            if(v==v.getRootView().findViewById(R.id.buttonroot)){
                returnMainTextViewDouble=Math.sqrt(mainTextViewDouble);
                returnString=String.valueOf(returnMainTextViewDouble);
            }
            if(Double.parseDouble(returnString)%1==0){
                mainTextView.setText(returnString.substring(0,returnString.length()-2));
            }
            else
            {
                mainTextView.setText(returnString);
            }

        }

    }
}
