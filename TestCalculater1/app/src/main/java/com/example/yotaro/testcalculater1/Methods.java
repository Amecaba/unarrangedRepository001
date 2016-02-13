package com.example.yotaro.testcalculater1;

import java.text.NumberFormat;

/**
 * Created by YOTARO on 2016/02/12.
 */
public class Methods {
    public static String combertDobleToString(double internalDouble){
        NumberFormat nForm=NumberFormat.getNumberInstance();
        nForm.setMaximumFractionDigits(12);
        String returnString=nForm.format(internalDouble);
        return returnString;
    }
}
