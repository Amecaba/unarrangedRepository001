package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

import java.io.InterruptedIOException;

/**
 * Created by YOTARO on 2016/01/01.
 */
public class OnClickListenerEqual implements View.OnClickListener {

    @Override
    public void onClick(View v){

        MethodRun methodRun=new MethodRun();
        methodRun.runMethod(v);

        //equal連打の場合の値を保持。
        SharedPreferences mySharedPreference=v.getContext().getSharedPreferences("mySharedPreference",Context.MODE_PRIVATE);
        SharedPreferences.Editor mySPEditor=mySharedPreference.edit();
        mySPEditor.putString("firstDoubleToNext", methodRun.returnDoubleString);
        mySPEditor.putString("secondDoubleToNext", String.valueOf(methodRun.secondDouble));//★ここDoubleに修正だね、たぶん
        mySPEditor.putInt("methodToNext",methodRun.method);
        mySPEditor.remove("firstDouble");

        //mCFlag(calculationボタン群が押された直後かを判別するフラグを0に。
        //mEFlag(equalボタンが押された直後か判別するフラグを1に（押された直後と設定）
        mySPEditor.remove("mCFlag");
        mySPEditor.putInt("mEFlag",1);
        mySPEditor.putInt("mPCFlag",1);

        //GTに計算結果を追加する処理。
        double gTDouble=Double.parseDouble(mySharedPreference.getString("gTDouble", "0").replace(",",""));
        double returnGTDouble=gTDouble+methodRun.returnDouble;
        mySPEditor.putString("gTDouble", String.valueOf(returnGTDouble));
        //GTの連続押し下げ判別フラグを0（連続でない）に。
        mySPEditor.remove("gTFlag");
        mySPEditor.commit();

        //methodViewをクリア。計算結果のmainViewへの表示は、RunMethod側で持っている。
        TextView methodView=(TextView)v.getRootView().findViewById(R.id.methodview);
        methodView.setText("");
    }
}
