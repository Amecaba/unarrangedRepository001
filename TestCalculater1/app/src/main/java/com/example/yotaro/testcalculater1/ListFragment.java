package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    View returnView;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        returnView=inflater.inflate(R.layout.fragment_list, container, false);

        SharedPreferences mySharedPreference=returnView.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        int cycler=mySharedPreference.getInt("listFlag", 0);

        AdView mAdView=(AdView)returnView.findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        TextView calculationFormula1=(TextView)returnView.getRootView().findViewById(R.id.calculationformula1);
        TextView calculationFormula2=(TextView)returnView.getRootView().findViewById(R.id.calculationformula2);
        TextView calculationFormula3=(TextView)returnView.getRootView().findViewById(R.id.calculationformula3);
        TextView calculationFormula4=(TextView)returnView.getRootView().findViewById(R.id.calculationformula4);
        TextView calculationFormula5=(TextView)returnView.getRootView().findViewById(R.id.calculationformula5);
        TextView calculationFormula6=(TextView)returnView.getRootView().findViewById(R.id.calculationformula6);
        TextView calculationFormula7=(TextView)returnView.getRootView().findViewById(R.id.calculationformula7);

        calculationFormula1.setText(mySharedPreference.getString("calclist" + String.valueOf(cycler), ""));
        calculationFormula2.setText(mySharedPreference.getString("calclist"+String.valueOf((cycler-1+7)%7),""));
        calculationFormula3.setText(mySharedPreference.getString("calclist"+String.valueOf((cycler-2+7)%7),""));
        calculationFormula4.setText(mySharedPreference.getString("calclist"+String.valueOf((cycler-3+7)%7),""));
        calculationFormula5.setText(mySharedPreference.getString("calclist"+String.valueOf((cycler-4+7)%7),""));
        calculationFormula6.setText(mySharedPreference.getString("calclist"+String.valueOf((cycler-5+7)%7),""));
        calculationFormula7.setText(mySharedPreference.getString("calclist" + String.valueOf((cycler - 6 + 7) % 7), ""));

        ArrayList<Integer> resultTextViewIdList=new ArrayList<>();
        resultTextViewIdList.add(R.id.calculationresult1);
        resultTextViewIdList.add(R.id.calculationresult2);
        resultTextViewIdList.add(R.id.calculationresult3);
        resultTextViewIdList.add(R.id.calculationresult4);
        resultTextViewIdList.add(R.id.calculationresult5);
        resultTextViewIdList.add(R.id.calculationresult6);
        resultTextViewIdList.add(R.id.calculationresult7);
        ArrayList<TextView> resutlTextViewList=new ArrayList<>();
        for(int i=0;i<=6;i++){
            resutlTextViewList.add((TextView)returnView.getRootView().findViewById(resultTextViewIdList.get(i)));
        }
        for(int i=0;i<=6;i++){
            resutlTextViewList.get(i).setText(mySharedPreference.getString("resultlist" + String.valueOf((cycler - i + 7) % 7), ""));
        }

        //ここでImageBUtton押し下げ時の値渡しのために、resultのみ数列化。
        //onClick時にSharedPreferenceからgetしてもよいかも。
        ArrayList<String> resultList=new ArrayList<>();
        for(int i=0;i<=6;i++){
            resultList.add(resutlTextViewList.get(i).getText().toString());
        }

        ArrayList<Integer> calculationFormulaIdList=new ArrayList<>();
        calculationFormulaIdList.add(R.id.calculationformula1);
        calculationFormulaIdList.add(R.id.calculationformula2);
        calculationFormulaIdList.add(R.id.calculationformula3);
        calculationFormulaIdList.add(R.id.calculationformula4);
        calculationFormulaIdList.add(R.id.calculationformula5);
        calculationFormulaIdList.add(R.id.calculationformula6);
        calculationFormulaIdList.add(R.id.calculationformula7);
        ArrayList<TextView> calclulationFormulaList=new ArrayList<>();
        for(int i=0;i<=6;i++){
            calclulationFormulaList.add((TextView)returnView.getRootView().findViewById(calculationFormulaIdList.get(i)));
        }
        ArrayList<String> calculationFormulaStringList=new ArrayList<>();
        for(TextView b:calclulationFormulaList){
            calculationFormulaStringList.add(b.getText().toString());
        }

        ArrayList<Integer> returnButtonIdList=new ArrayList<>();
        returnButtonIdList.add(R.id.buttonback1);
        returnButtonIdList.add(R.id.buttonback2);
        returnButtonIdList.add(R.id.buttonback3);
        returnButtonIdList.add(R.id.buttonback4);
        returnButtonIdList.add(R.id.buttonback5);
        returnButtonIdList.add(R.id.buttonback6);
        returnButtonIdList.add(R.id.buttonback7);
        ArrayList<ImageButton> returnButtonList=new ArrayList<>();
        for(int i=0;i<=6;i++){
            returnButtonList.add((ImageButton)returnView.getRootView().findViewById(returnButtonIdList.get(i)));
        }
        OnClickListenerReturns onClickListenerReturns=new OnClickListenerReturns(this.getActivity(),returnButtonList,resultList,calculationFormulaStringList);
        for(ImageButton cyclerButton:returnButtonList) {
            cyclerButton.setOnClickListener(onClickListenerReturns);
        }

        return returnView;
    }

    public void reload(){
        SharedPreferences mySharedPreference=returnView.getContext().getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        int cycler=mySharedPreference.getInt("listFlag", 0);


        AdView mAdView=(AdView)returnView.findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        TextView calculationFormula1=(TextView)returnView.getRootView().findViewById(R.id.calculationformula1);
        TextView calculationFormula2=(TextView)returnView.getRootView().findViewById(R.id.calculationformula2);
        TextView calculationFormula3=(TextView)returnView.getRootView().findViewById(R.id.calculationformula3);
        TextView calculationFormula4=(TextView)returnView.getRootView().findViewById(R.id.calculationformula4);
        TextView calculationFormula5=(TextView)returnView.getRootView().findViewById(R.id.calculationformula5);
        TextView calculationFormula6=(TextView)returnView.getRootView().findViewById(R.id.calculationformula6);
        TextView calculationFormula7=(TextView)returnView.getRootView().findViewById(R.id.calculationformula7);

        calculationFormula1.setText(mySharedPreference.getString("calclist" + String.valueOf(cycler), ""));
        calculationFormula2.setText(mySharedPreference.getString("calclist"+String.valueOf((cycler-1+7)%7),""));
        calculationFormula3.setText(mySharedPreference.getString("calclist"+String.valueOf((cycler-2+7)%7),""));
        calculationFormula4.setText(mySharedPreference.getString("calclist"+String.valueOf((cycler-3+7)%7),""));
        calculationFormula5.setText(mySharedPreference.getString("calclist"+String.valueOf((cycler-4+7)%7),""));
        calculationFormula6.setText(mySharedPreference.getString("calclist"+String.valueOf((cycler-5+7)%7),""));
        calculationFormula7.setText(mySharedPreference.getString("calclist" + String.valueOf((cycler - 6 + 7) % 7), ""));

        ArrayList<Integer> resultTextViewIdList=new ArrayList<>();
        resultTextViewIdList.add(R.id.calculationresult1);
        resultTextViewIdList.add(R.id.calculationresult2);
        resultTextViewIdList.add(R.id.calculationresult3);
        resultTextViewIdList.add(R.id.calculationresult4);
        resultTextViewIdList.add(R.id.calculationresult5);
        resultTextViewIdList.add(R.id.calculationresult6);
        resultTextViewIdList.add(R.id.calculationresult7);
        ArrayList<TextView> resutlTextViewList=new ArrayList<>();
        for(int i=0;i<=6;i++){
            resutlTextViewList.add((TextView)returnView.getRootView().findViewById(resultTextViewIdList.get(i)));
        }
        for(int i=0;i<=6;i++){
            resutlTextViewList.get(i).setText(mySharedPreference.getString("resultlist" + String.valueOf((cycler - i + 7) % 7), ""));
        }

        //ここでImageBUtton押し下げ時の値渡しのために、resultのみ数列化。
        //onClick時にSharedPreferenceからgetしてもよいかも。
        ArrayList<String> resultList=new ArrayList<>();
        for(int i=0;i<=6;i++){
            resultList.add(resutlTextViewList.get(i).getText().toString());
        }

        ArrayList<Integer> calculationFormulaIdList=new ArrayList<>();
        calculationFormulaIdList.add(R.id.calculationformula1);
        calculationFormulaIdList.add(R.id.calculationformula2);
        calculationFormulaIdList.add(R.id.calculationformula3);
        calculationFormulaIdList.add(R.id.calculationformula4);
        calculationFormulaIdList.add(R.id.calculationformula5);
        calculationFormulaIdList.add(R.id.calculationformula6);
        calculationFormulaIdList.add(R.id.calculationformula7);
        ArrayList<TextView> calclulationFormulaList=new ArrayList<>();
        for(int i=0;i<=6;i++){
            calclulationFormulaList.add((TextView)returnView.getRootView().findViewById(calculationFormulaIdList.get(i)));
        }
        ArrayList<String> calculationFormulaStringList=new ArrayList<>();
        for(TextView b:calclulationFormulaList){
            calculationFormulaStringList.add(b.getText().toString());
        }

        ArrayList<Integer> returnButtonIdList=new ArrayList<>();
        returnButtonIdList.add(R.id.buttonback1);
        returnButtonIdList.add(R.id.buttonback2);
        returnButtonIdList.add(R.id.buttonback3);
        returnButtonIdList.add(R.id.buttonback4);
        returnButtonIdList.add(R.id.buttonback5);
        returnButtonIdList.add(R.id.buttonback6);
        returnButtonIdList.add(R.id.buttonback7);
        ArrayList<ImageButton> returnButtonList=new ArrayList<>();
        for(int i=0;i<=6;i++){
            returnButtonList.add((ImageButton)returnView.getRootView().findViewById(returnButtonIdList.get(i)));
        }
        OnClickListenerReturns onClickListenerReturns=new OnClickListenerReturns(this.getActivity(),returnButtonList,resultList,calculationFormulaStringList);
        for(ImageButton cyclerButton:returnButtonList) {
            cyclerButton.setOnClickListener(onClickListenerReturns);
        }

    }


    @Override
    public void onResume(){
        super.onResume();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//    }

    @Override
    public void onDetach() {
        super.onDetach();
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
