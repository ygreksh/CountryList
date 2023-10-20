package com.example.countrylist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
    private String mParamFlag;
    private Country country;
    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamName = getArguments().getString(ARG_PARAM_NAME);
            mParamCapital = getArguments().getString(ARG_PARAM_CAPITAL);
            mParamFlag = getArguments().getString(ARG_PARAM_FLAG);
            Log.d("test", "Details onCreate country: " + mParamName + " " + mParamCapital);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detals, container, false);

        TextView textViewName = view.findViewById(R.id.textview_name);
        TextView textViewCapital = view.findViewById(R.id.textview_capital);
        ImageView imageViewFlag = view.findViewById(R.id.imageview_flag);

        textViewName.setText(mParamName);
        textViewCapital.setText(mParamCapital);
//        imageViewFlag.setImageResource(mParamFlag);

        Glide.with(this)
                .asBitmap()
                .load(mParamFlag)
                .into(imageViewFlag);

        // Inflate the layout for this fragment
        return view;

    }
}