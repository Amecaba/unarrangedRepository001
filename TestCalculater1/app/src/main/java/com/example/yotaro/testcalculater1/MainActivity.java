package com.example.yotaro.testcalculater1;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
//        implements NavigationDrawerFragment.NavigationDrawerCallbacks
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new MainViewPagerAdapter(this.getSupportFragmentManager()));
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==1){
                    FragmentManager fRM=getSupportFragmentManager();
                    List<Fragment> fList=fRM.getFragments();
                    for(Fragment f:fList){
                        if(f instanceof ListFragment){
                            ((ListFragment) f).reload();
                            break;
                        }
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


}
