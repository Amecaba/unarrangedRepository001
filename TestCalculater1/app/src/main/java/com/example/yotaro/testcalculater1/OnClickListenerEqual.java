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
    float firstFloat;

    @Override
    public void onClick(View v){


        MethodRun methodRun=new MethodRun();
        methodRun.runMethod(v);

        SharedPreferences backupFirstFloat=v.getContext().getSharedPreferences("myPrefBackupFirstFloat",Context.MODE_PRIVATE);
        SharedPreferences.Editor mBFFEdiotor=backupFirstFloat.edit();
        mBFFEdiotor.putFloat("mBFF",Float.parseFloat(methodRun.applyFLoatString));
        mBFFEdiotor.commit();

//        SharedPreferences backupSecondFloat=v.getContext().getSharedPreferences("myPrefBackupSecondFloat",Context.MODE_PRIVATE);
//        SharedPreferences.Editor mBSFEdiotor=backupSecondFloat.edit();
        mBFFEdiotor.putFloat("mBSF",methodRun.secondFloat);
        mBFFEdiotor.commit();

        SharedPreferences backupMethod=v.getContext().getSharedPreferences("myPrefBackupMethod",Context.MODE_PRIVATE);
        SharedPreferences.Editor mBMEditor=backupMethod.edit();
        mBMEditor.putInt("mBM",methodRun.method);
        mBMEditor.commit();

        SharedPreferences firstFloat=v.getContext().getSharedPreferences("myPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor myPrefEditor=firstFloat.edit();
        myPrefEditor.remove("firstFloat");
        myPrefEditor.commit();

        SharedPreferences myCalcFlag=v.getContext().getSharedPreferences("myPrefCalcFlag",Context.MODE_PRIVATE);
        SharedPreferences.Editor mCFEditor=myCalcFlag.edit();
        mCFEditor.remove("mCFlag");
        mCFEditor.commit();

        TextView methodView=(TextView)v.getRootView().findViewById(R.id.methodview);
        methodView.setText("");

        SharedPreferences myEqualFlag=v.getContext().getSharedPreferences("myPrefEqualFlag",Context.MODE_PRIVATE);
        SharedPreferences.Editor myEFEditor=myEqualFlag.edit();
        myEFEditor.putInt("mEFlag",1);
        myEFEditor.commit();

        SharedPreferences myPrefCompleteFlag=v.getContext().getSharedPreferences("myPrefCompleteFlag",Context.MODE_PRIVATE);
        SharedPreferences.Editor mPCFEditor=myPrefCompleteFlag.edit();
        mPCFEditor.putInt("mPCFlag", 1);
        mPCFEditor.commit();

        SharedPreferences myPrefGrandTotal=v.getContext().getSharedPreferences("grandtotal",Context.MODE_PRIVATE);
        SharedPreferences.Editor myPrefGTEditor=myPrefGrandTotal.edit();
        double gtNumber=Double.parseDouble(myPrefGrandTotal.getString("gtnumber", "0"));
        double returnGtNumber=gtNumber+methodRun.applyFloat;
        myPrefGTEditor.putString("gtnumber",String.valueOf(returnGtNumber));
        myPrefGTEditor.remove("key");
        myPrefGTEditor.commit();
    }
}
