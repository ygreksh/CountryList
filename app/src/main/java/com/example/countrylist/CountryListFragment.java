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


    public CountryListFragment() {
        // Required empty public constructor
    }

    interface OnFragmentSendDataListener {
        void onSendData(Country data);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        countries.add(new Country("China", "Capital 1", "https://www.countryflags.com/wp-content/uploads/china-flag-png-large.png"));
        countries.add(new Country("India", "Capital 2", "https://www.countryflags.com/wp-content/uploads/india-flag-png-large.png"));
        countries.add(new Country("USA", "Capital 3", "https://www.countryflags.com/wp-content/uploads/united-states-of-america-flag-png-large.png"));
        countries.add(new Country("Indonesia", "Capital 4", "https://www.countryflags.com/wp-content/uploads/indonesia-flag-png-large.png"));
        countries.add(new Country("Brazil", "Capital 5", "https://www.countryflags.com/wp-content/uploads/brazil-flag-png-large.png"));

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