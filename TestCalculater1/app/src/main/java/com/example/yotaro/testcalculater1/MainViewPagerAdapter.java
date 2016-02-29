package com.example.yotaro.testcalculater1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by YOTARO on 2016/02/13.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {
    public MainViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i){
        switch(i){
            case 0:
                return new ListFragment();
            default:
                MainFragment internalMainFragment=new MainFragment();
                return internalMainFragment;
        }
    }


    @Override
    public int getCount(){
        return 2;
    }

//    @Override
//    public CharSequence getPageTitle(int i){
//        if(i==0){
//            return "ResultList";
//        }
//        else{
////            return "MainCalculater";
//        }
//    }


}
