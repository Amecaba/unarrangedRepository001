package com.example.yotaro.testcalculater1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by YOTARO on 2015/12/20.
 */
public class OnClickListenerNumber implements View.OnClickListener{

    ArrayList<Integer> internalButtonIdList;
    ArrayList<ImageButton> internalButtonList;

    //コンストラクタ
    public OnClickListenerNumber(ArrayList<Integer> receivedButtonIdList, ArrayList<ImageButton> receivedButtonList){
        internalButtonIdList=receivedButtonIdList;
        internalButtonList=receivedButtonList;
    }

    @Override
    public void onClick(View v){

        //mCFlag(calculationボタン群が押された直後か判別するフラグを0に。
        //mEFlag(equalボタンが押された直後か判別するフラグを0に。
        SharedPreferences mySharedPreference = v.getContext().getSharedPreferences("mySharedPreference",Context.MODE_PRIVATE);
        SharedPreferences.Editor mySPEditor=mySharedPreference.edit();
        mySPEditor.remove("mCFlag");
        mySPEditor.remove("mEFlag");
        mySPEditor.remove("gTFlag");
        mySPEditor.commit();

        String mainTextViewString;
        String mainTextViewStringforzero;
        TextView mainTextView=(TextView)v.getRootView().findViewById(R.id.mainview);
        mainTextViewString=mainTextView.getText().toString().replace(",","");
        mainTextViewStringforzero=mainTextView.getText().toString();

        //桁数を12桁で止める。（カンマを.replaceで除いた後で12桁判定
        //✖11桁までしか入らず？？
        if(mainTextViewString.length()<=12) {

            int inputNumber;
            double inputDouble;
            String inputNumberString;
            int mPCFlag;

            mPCFlag=mySharedPreference.getInt("mPCFlag", 0);
            //mPCFlagが1（つまりequalやcalculation押された直後）は、Viewの値を削除する。フラグは0へ。
            if(mPCFlag==1){
                mainTextViewString="";
                SharedPreferences.Editor mSPEditor=mySharedPreference.edit();
                mSPEditor.putInt("mPCFlag", 0);
                mSPEditor.commit();
            }


            for (int i = 0; i < 12; i++) {
                if (v == internalButtonList.get(i)) {
                    //mainViewが0の場合、頭に０がつかないように分岐
                    if(mainTextViewString.equals("0")){
                        mainTextViewString="";
                    }
                    //数字キー
                    if(i==0){
                        if(mainTextViewString==""){
                            mainTextView.setText("0");
                        }
                        else if(mainTextViewString.indexOf(".")==-1){
                            inputDouble=Double.parseDouble(mainTextViewString+"0");
                            mainTextView.setText(Methods.combertDobleToString(inputDouble));
                        }
                        else{
                            mainTextView.setText(mainTextViewStringforzero+"0");
                        }
                    }
                    else if(i>=1&&i<=9) {
                        inputNumber = i;
                        inputNumberString = Integer.toString(inputNumber);
                        //カンマ付加処理。
                        inputDouble=Double.parseDouble(mainTextViewString+inputNumberString);
                        mainTextView.setText(Methods.combertDobleToString(inputDouble));
                    }
                    else if(i==11){
                        //小数点押されたときの処理
                        if(mainTextViewString.equals("")){
                            mainTextView.setText("0.");
                        }
                        else if(mainTextViewString.indexOf(".")!=-1){
                            mainTextView.setText(mainTextViewStringforzero);
                        }
                        else
                        {
                            mainTextView.setText(mainTextViewStringforzero+".");
                        }
                    }
                    else{
                        //000押されたときの処理
                        if(mainTextViewString.equals("")){
                            mainTextView.setText("0");
                        }
                        else if(mainTextViewString.indexOf(".")==-1){
                            inputDouble=Double.parseDouble(mainTextViewString+"000");
                            mainTextView.setText(Methods.combertDobleToString(inputDouble));
                        }
                        else{
                            mainTextView.setText(mainTextViewStringforzero+"000");
                        }
                    }
                }
            }
        }
    }
}
