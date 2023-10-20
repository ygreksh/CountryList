package com.example.countrylist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM_NAME = "country_name";
    public static final String ARG_PARAM_CAPITAL = "country_capital";
    public static final String ARG_PARAM_FLAG = "country_flag";

//
//    // TODO: Rename and change types of parameters
    private String mParamName;
    private String mParamCapital;
    private int mParamFlag;
    private Country country;
    public DetailsFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment DetalsFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static DetalsFragment newInstance(String param1, String param2) {
//        DetalsFragment fragment = new DetalsFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamName = getArguments().getString(ARG_PARAM_NAME);
            mParamCapital = getArguments().getString(ARG_PARAM_CAPITAL);
            mParamFlag = getArguments().getInt(ARG_PARAM_FLAG);
            Log.d("test", "Details onCreate country: " + mParamName + " " + mParamCapital);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detals, container, false);
//        country = new Country(mParamName, mParamCapital, mParamFlag);
//        setSelectedCountry(country);

        TextView textViewName = view.findViewById(R.id.textview_name);
        TextView textViewCapital = view.findViewById(R.id.textview_capital);
        ImageView imageViewFlag = view.findViewById(R.id.imageview_flag);

        textViewName.setText(mParamName);
        textViewCapital.setText(mParamCapital);
        imageViewFlag.setImageResource(mParamFlag);

        // Inflate the layout for this fragment
        return view;

//        country = new Country(mParamName, mParamCapital, mParamFlag);

//        setSelectedCountry(
//                mParamName,
//                mParamCapital,
//                mParamFlag
//        );
    }

    public void setSelectedCountry(
//            String name, String capital, int flagResource
            Country selectedCountry
    ) {
//        TextView textViewName = getView().findViewById(R.id.textview_name);
//        TextView textViewCapital = getView().findViewById(R.id.textview_capital);
//        ImageView imageViewFlag = getView().findViewById(R.id.imageview_flag);
        TextView textViewName = getActivity().findViewById(R.id.textview_name);
        TextView textViewCapital = getActivity().findViewById(R.id.textview_capital);
        ImageView imageViewFlag = getActivity().findViewById(R.id.imageview_flag);

        if (selectedCountry != null) {
//            textViewName.setText(name);
//            textViewCapital.setText(capital);
//            imageViewFlag.setImageResource(flagResource);
            textViewName.setText(selectedCountry.name);
            textViewCapital.setText(selectedCountry.capital);
            imageViewFlag.setImageResource(selectedCountry.flagResource);
        }
    }
}