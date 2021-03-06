package com.example.yotaro.testcalculater1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    private OnFragmentInteractionListener mListener;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SharedPreferences mySharedPreference=getContext().getSharedPreferences("mySharedPreference",Context.MODE_PRIVATE);
        SharedPreferences.Editor mSPEditor=mySharedPreference.edit();
        mSPEditor.remove("firstDouble");
        mSPEditor.remove("secondDouble");
        mSPEditor.remove("mCFlag");
        mSPEditor.remove("mEFlag");
        mSPEditor.remove("mPCFlag");
        mSPEditor.remove("mTFlag");
        mSPEditor.remove("ERRORFlag");
        mSPEditor.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View returnView=inflater.inflate(R.layout.fragment_main2,container,false);


        ImageButton settingButton=(ImageButton)returnView.findViewById(R.id.settingbutton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity mACA=(AppCompatActivity)v.getContext();
                FragmentManager mFRM=mACA.getSupportFragmentManager();
                mFRM.beginTransaction().replace(R.id.container,new SettingFragment()).commit();
            }
        });

        TextView mainTextView=(TextView)returnView.getRootView().findViewById(R.id.mainview);
        mainTextView.setTypeface(Typeface.createFromAsset(returnView.getContext().getAssets(), "meiryo.ttc"),Typeface.BOLD);

        TextView pastCalcTextView=(TextView)returnView.findViewById(R.id.pastcalc);
        pastCalcTextView.setTypeface(Typeface.createFromAsset(returnView.getContext().getAssets(),"meiryo.ttc"),Typeface.BOLD);

        TextView pastTextView=(TextView)returnView.getRootView().findViewById(R.id.pastview);
//        pastTextView.setTypeface(Typeface.createFromAsset(returnView.getContext().getAssets(),"meiryo.ttc"),Typeface.BOLD);

        SharedPreferences mySharedPreference=returnView.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        if(mySharedPreference.getString("returnString",null)!=null){
            mainTextView.setText(mySharedPreference.getString("returnString","0"));
            pastCalcTextView.setText(mySharedPreference.getString("returnFString","0"));
            pastTextView.setText(mySharedPreference.getString("returnString","0"));

            SharedPreferences.Editor mySPEditor=mySharedPreference.edit();
            mySPEditor.remove("returnString");
            mySPEditor.remove("returnFString");
            mySPEditor.commit();
        }


        ArrayList<Integer> buttonIdListNumber=new ArrayList<Integer>();
        buttonIdListNumber.add(R.id.button0);
        buttonIdListNumber.add(R.id.button1);
        buttonIdListNumber.add(R.id.button2);
        buttonIdListNumber.add(R.id.button3);
        buttonIdListNumber.add(R.id.button4);
        buttonIdListNumber.add(R.id.button5);
        buttonIdListNumber.add(R.id.button6);
        buttonIdListNumber.add(R.id.button7);
        buttonIdListNumber.add(R.id.button8);
        buttonIdListNumber.add(R.id.button9);
        buttonIdListNumber.add(R.id.button000);
        buttonIdListNumber.add(R.id.buttondot);

        ArrayList<ImageButton> buttonListNumber=new ArrayList<>();
        for(int i=0;i<12;i++){
            buttonListNumber.add((ImageButton) returnView.findViewById(buttonIdListNumber.get(i)));
        }

        OnClickListenerNumber onClickListenerNumber=new OnClickListenerNumber(buttonIdListNumber,buttonListNumber);

        for(int i=0;i<12;i++){
            buttonListNumber.get(i).setOnClickListener(onClickListenerNumber);
        }

        //ここからcalculationボタン群
        ArrayList<Integer> buttonIdListCalculation=new ArrayList<Integer>();
        buttonIdListCalculation.add(R.id.buttonplus);
        buttonIdListCalculation.add(R.id.buttonminus);
        buttonIdListCalculation.add(R.id.buttontimes);
        buttonIdListCalculation.add(R.id.buttondevide);

        ArrayList<ImageButton> buttonListCalculation=new ArrayList<>();
        for(int i=0;i<=3;i++){
            buttonListCalculation.add((ImageButton) returnView.findViewById(buttonIdListCalculation.get(i)));
        }

        OnClickListenerCalculation onClickListenerCalculation=new OnClickListenerCalculation(buttonListCalculation);

        for(int i=0;i<=3;i++){
            buttonListCalculation.get(i).setOnClickListener(onClickListenerCalculation);
        }

        ImageButton percentButton=(ImageButton)returnView.getRootView().findViewById(R.id.buttonpercent);
        percentButton.setOnClickListener(new OnClickListenerPercent());

        ImageButton equalButton=(ImageButton)returnView.findViewById(R.id.buttonequal);
        OnClickListenerEqual onClickListenerEqual=new OnClickListenerEqual();
        equalButton.setOnClickListener(onClickListenerEqual);

        ArrayList<Integer> buttonIdListCseries=new ArrayList<Integer>();
        buttonIdListCseries.add(R.id.buttonCA);
        buttonIdListCseries.add(R.id.buttonC);
        buttonIdListCseries.add(R.id.buttonCE);
        ArrayList<ImageButton> buttonListCseries=new ArrayList<>();
        for(int i:buttonIdListCseries){
            buttonListCseries.add((ImageButton) returnView.getRootView().findViewById(i));
        }
        OnClickListenerCseries onClickListenerCseries=new OnClickListenerCseries(buttonListCseries);
        for(ImageButton ibutton:buttonListCseries){
            ibutton.setOnClickListener(onClickListenerCseries);
        }

        ArrayList<Integer> buttonIdListMseries=new ArrayList<Integer>();
        buttonIdListMseries.add(R.id.buttonMP);
        buttonIdListMseries.add(R.id.buttonMM);
        buttonIdListMseries.add(R.id.buttonCM);
        buttonIdListMseries.add(R.id.buttonRM);
        ArrayList<ImageButton> buttonListMseries=new ArrayList<>();
        for(int i=0;i<=3;i++)
        {
            buttonListMseries.add((ImageButton)returnView.getRootView().findViewById(buttonIdListMseries.get(i)));
        }
        OnClickListenerMseries onClickListenerMseries=new OnClickListenerMseries(buttonListMseries);
        for(ImageButton i:buttonListMseries){
            i.setOnClickListener(onClickListenerMseries);
        }

        ArrayList<Integer> othersButtonIdList=new ArrayList<>();
        othersButtonIdList.add(R.id.buttonGT);
        othersButtonIdList.add(R.id.buttonPM);
        othersButtonIdList.add(R.id.buttonroot);
        othersButtonIdList.add(R.id.buttonarrow);
        ArrayList<ImageButton> othersButtonList=new ArrayList<>();
        for(int i=0;i<=3;i++){
            othersButtonList.add((ImageButton)returnView.getRootView().findViewById(othersButtonIdList.get(i)));
        }
        OnClickListenerOthers onClickListenerOthers=new OnClickListenerOthers();
        for(ImageButton cercle:othersButtonList){
            cercle.setOnClickListener(onClickListenerOthers);
        }

        ImageButton setMainButton=(ImageButton)returnView.findViewById(R.id.setmainbutton);
        OnClickListenerOtherFunctions onClickListenerOtherFunctions=new OnClickListenerOtherFunctions();
        setMainButton.setOnClickListener(onClickListenerOtherFunctions);
        return returnView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
