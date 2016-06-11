package com.example.yotaro.testcalculater1;

import java.text.NumberFormat;

/**
 * Created by YOTARO on 2016/02/12.
 */
public class Methods {
    public static String combertDobleToString(double internalDouble){
        NumberFormat nForm=NumberFormat.getNumberInstance();
        nForm.setMaximumFractionDigits(12);
        nForm.setMinimumFractionDigits(0);

        String internalString=String.valueOf(internalDouble);

        String decisionString=internalString.replace(".","");
        if(decisionString.length()>=12){
            if(internalString.indexOf(".")>0){
                internalString=internalString.substring(0,13);
            }
            else{
                internalString=internalString.substring(0,12);
            }
        }

        internalDouble=Double.parseDouble(internalString);
        String returnString=nForm.format(internalDouble);
        return returnString;
    }

    public static String combertStringToString(String internalString){
        NumberFormat nForm=NumberFormat.getNumberInstance();
        nForm.setMaximumFractionDigits(12);
        nForm.setMinimumFractionDigits(0);

        String decisionString=internalString.replace(".","");
        if(decisionString.length()>=12){
            if(internalString.indexOf(".")>0){
                internalString=internalString.substring(0,13);
            }
            else{
                internalString=internalString.substring(0,12);
            }
        }

        Double internalDouble=Double.parseDouble(internalString);
        String returnString=nForm.format(internalDouble);
        return returnString;
    }
}
