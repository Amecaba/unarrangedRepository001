package com.example.yotaro.testcalculater1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by YOTARO on 2015/12/20.
 */
public class OnClickListenerNumber implements View.OnClickListener{
    public String returnString;
    String viewString;
    int buttonNumber;
    View innerView;

    ArrayList<Integer> mmButtonIdList;
    ArrayList<Button> mmButtonList;

    public OnClickListenerNumber(ArrayList<Integer> transButtonIdList, ArrayList<Button> trandButtonList){
        mmButtonIdList=transButtonIdList;
        mmButtonList=trandButtonList;
    }

    @Override
    public void onClick(View v){

        TextView mainTextView=(TextView)v.getRootView().findViewById(R.id.mainview);
        String mainTextViewString;
        mainTextViewString=mainTextView.getText().toString();

        SharedPreferences myCalcFlag=v.getContext().getSharedPreferences("myPrefCalcFlag",Context.MODE_PRIVATE);
        SharedPreferences.Editor mCFEditor=myCalcFlag.edit();
        mCFEditor.remove("mCFlag");
        mCFEditor.commit();

        SharedPreferences myEqualFlag=v.getContext().getSharedPreferences("myPrefEqualFlag",Context.MODE_PRIVATE);
        SharedPreferences.Editor myEFEditor=myEqualFlag.edit();
        myEFEditor.remove("mEFlag");
        myEFEditor.commit();

        if(mainTextViewString.length()<=12) {

            int inputNumber;
            String inputNumberString;
            int mPCFlag;

            SharedPreferences myPrefCompleteFlag=v.getContext().getSharedPreferences("myPrefCompleteFlag",Context.MODE_PRIVATE);
            SharedPreferences.Editor mPCFEditor=myPrefCompleteFlag.edit();
            mPCFlag=myPrefCompleteFlag.getInt("mPCFlag", 0);

            if(mPCFlag==1){
                mainTextViewString="";
                mPCFEditor.putInt("mPCFlag",0);
                mPCFEditor.commit();
            }


            for (int i = 0; i < 12; i++) {
                if (v == mmButtonList.get(i)) {
                    if(mainTextViewString.equals("0")){
                        mainTextViewString="";
                    }
                    if(i<=9) {
                        inputNumber = i;
                        inputNumberString = Integer.toString(inputNumber);
                        mainTextView.setText(mainTextViewString + inputNumberString);
                    }
                    else if(i==11){
                        if(mainTextViewString.equals("")){
                            mainTextView.setText("0.");
                        }
                        else
                        {
                            mainTextView.setText(mainTextViewString+".");
                        }
                    }
                    else{
                        if(mainTextViewString.equals("")){
                            mainTextView.setText("0");
                        }
                        else{mainTextView.setText(mainTextViewString+"000");
                        }
                    }
                }
            }
        }
        //GT2度押しフラグの解除
        SharedPreferences myPrefGrandTotal = v.getContext().getSharedPreferences("grandtotal", Context.MODE_PRIVATE);
        SharedPreferences.Editor myPrefGTEditor=myPrefGrandTotal.edit();
        myPrefGTEditor.remove("key");
        myPrefGTEditor.commit();
    }
}
