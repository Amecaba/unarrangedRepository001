package com.example.yotaro.testcalculater1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;

/**
 * Created by YOTARO on 2016/01/24.
 */
public class OnClickListenerReturns implements View.OnClickListener {
    public OnClickListenerReturns(){

    }

    @Override
    public void onClick(View v){
        Toast.makeText(v.getContext(), "test", Toast.LENGTH_SHORT).show();

    }
}
