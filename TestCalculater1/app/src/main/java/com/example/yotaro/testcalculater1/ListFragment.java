package com.example.yotaro.testcalculater1;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        View returnView=inflater.inflate(R.layout.fragment_list, container, false);

        SharedPreferences myPrefList=returnView.getContext().getSharedPreferences("list",Context.MODE_PRIVATE);
        int cycler=myPrefList.getInt("flag", 0);

        TextView calculationFormula1=(TextView)returnView.getRootView().findViewById(R.id.calculationformula1);
        TextView calculationFormula2=(TextView)returnView.getRootView().findViewById(R.id.calculationformula2);
        TextView calculationFormula3=(TextView)returnView.getRootView().findViewById(R.id.calculationformula3);
        TextView calculationFormula4=(TextView)returnView.getRootView().findViewById(R.id.calculationformula4);
        TextView calculationFormula5=(TextView)returnView.getRootView().findViewById(R.id.calculationformula5);
        TextView calculationFormula6=(TextView)returnView.getRootView().findViewById(R.id.calculationformula6);
        TextView calculationFormula7=(TextView)returnView.getRootView().findViewById(R.id.calculationformula7);

//        TextView calculationresult1=(TextView)returnView.getRootView().findViewById(R.id.calculationresult1);
//        TextView calculationresult2=(TextView)returnView.getRootView().findViewById(R.id.calculationresult2);
//        TextView calculationresult3=(TextView)returnView.getRootView().findViewById(R.id.calculationresult3);
//        TextView calculationresult4=(TextView)returnView.getRootView().findViewById(R.id.calculationresult4);
//        TextView calculationresult5=(TextView)returnView.getRootView().findViewById(R.id.calculationresult5);
//        TextView calculationresult6=(TextView)returnView.getRootView().findViewById(R.id.calculationresult6);
//        TextView calculationresult7=(TextView)returnView.getRootView().findViewById(R.id.calculationresult7);



        calculationFormula1.setText(myPrefList.getString("calclist"+String.valueOf(cycler),""));
        calculationFormula2.setText(myPrefList.getString("calclist"+String.valueOf((cycler-1+7)%7),""));
        calculationFormula3.setText(myPrefList.getString("calclist"+String.valueOf((cycler-2+7)%7),""));
        calculationFormula4.setText(myPrefList.getString("calclist"+String.valueOf((cycler-3+7)%7),""));
        calculationFormula5.setText(myPrefList.getString("calclist"+String.valueOf((cycler-4+7)%7),""));
        calculationFormula6.setText(myPrefList.getString("calclist"+String.valueOf((cycler-5+7)%7),""));
        calculationFormula7.setText(myPrefList.getString("calclist" + String.valueOf((cycler - 6 + 7) % 7), ""));

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
            resutlTextViewList.get(i).setText(myPrefList.getString("resultlist"+String.valueOf((cycler-i+7)%7),""));
        }

        return returnView;
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
