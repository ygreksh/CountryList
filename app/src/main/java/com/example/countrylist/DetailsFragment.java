package com.example.countrylist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

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
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detals, container, false);
    }

    public void setSelectedCountry(Country selectedCountry) {
        TextView textViewName = getView().findViewById(R.id.textview_name);
        TextView textViewCapital = getView().findViewById(R.id.textview_capital);
        ImageView imageViewFlag = getView().findViewById(R.id.imageview_flag);

        if (selectedCountry != null) {
            textViewName.setText(selectedCountry.name);
            textViewCapital.setText(selectedCountry.capital);
            imageViewFlag.setImageResource(selectedCountry.flagResource);
        }
    }
}