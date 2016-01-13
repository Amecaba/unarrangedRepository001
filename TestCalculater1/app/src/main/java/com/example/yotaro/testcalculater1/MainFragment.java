package com.example.yotaro.testcalculater1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public String viewString;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View returnView=inflater.inflate(R.layout.fragment_main2,container,false);

        int firstInt=0;

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

        ArrayList<Button> buttonListNumber=new ArrayList<Button>();
        for(int i=0;i<12;i++){
            buttonListNumber.add((Button) returnView.findViewById(buttonIdListNumber.get(i)));
        }

        OnClickListenerNumber onClickListenerNumber=new OnClickListenerNumber(buttonIdListNumber,buttonListNumber);

        for(int i=0;i<12;i++){
            buttonListNumber.get(i).setOnClickListener(onClickListenerNumber);
        }

        ArrayList<Integer> buttonIdListCalculation=new ArrayList<Integer>();
        buttonIdListCalculation.add(R.id.buttonplus);
        buttonIdListCalculation.add(R.id.buttonminus);
        buttonIdListCalculation.add(R.id.buttontimes);
        buttonIdListCalculation.add(R.id.buttondevide);
        buttonIdListCalculation.add(R.id.buttonequal);

        ArrayList<Button> buttonListCalculation=new ArrayList<Button>();
        for(int i=0;i<=4;i++){
            buttonListCalculation.add((Button) returnView.findViewById(buttonIdListCalculation.get(i)));
        }

        OnClickListenerCalculation onClickListenerCalculation=new OnClickListenerCalculation(buttonListCalculation);

        for(int i=0;i<=4;i++){
            buttonListCalculation.get(i).setOnClickListener(onClickListenerCalculation);
        }

        Button equalButton=(Button)returnView.findViewById(R.id.buttonequal);
        OnClickListenerEqual onClickListenerEqual=new OnClickListenerEqual();
        equalButton.setOnClickListener(onClickListenerEqual);

        ArrayList<Integer> buttonIdListCseries=new ArrayList<Integer>();
        buttonIdListCseries.add(R.id.buttonCA);
        buttonIdListCseries.add(R.id.buttonC);
        buttonIdListCseries.add(R.id.buttonCE);
        ArrayList<Button> buttonListCseries=new ArrayList<Button>();
        for(int i:buttonIdListCseries){
            buttonListCseries.add((Button) returnView.getRootView().findViewById(i));
        }
        OnClickListenerCseries onClickListenerCseries=new OnClickListenerCseries(buttonListCseries);
        for(Button ibutton:buttonListCseries){
            ibutton.setOnClickListener(onClickListenerCseries);
        }


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
        public void onFragmentInteraction(Uri uri);
    }

}
