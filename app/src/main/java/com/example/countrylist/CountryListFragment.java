package com.example.countrylist;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CountryListFragment extends Fragment {

    ArrayList<Country> countries = new ArrayList<>();

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public CountryListFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment MainFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static MainFragment newInstance(String param1, String param2) {
//        MainFragment fragment = new MainFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    interface OnFragmentSendDataListener {
        void onSendData(Country data);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        countries.add(new Country("Name 1", "Capital 1", R.drawable.ar_flag));
        countries.add(new Country("Name 2", "Capital 2", R.drawable.ar_flag));
        countries.add(new Country("Name 3", "Capital 3", R.drawable.ar_flag));
        countries.add(new Country("Name 4", "Capital 4", R.drawable.ar_flag));
        countries.add(new Country("Name 5", "Capital 5", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.frag_country_list);

        CountryRecyclerViewAdapter countryListAdapter = new CountryRecyclerViewAdapter(getActivity(), countries);
        recyclerView.setAdapter(countryListAdapter);

        countryListAdapter.setOnCountryClickListener(new CountryRecyclerViewAdapter.OnCountryClickListener() {
            @Override
            public void onClick(int position, Country model) {
                Country selectedCountry = model;
                fragmentSendDataListener.onSendData(selectedCountry);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
}