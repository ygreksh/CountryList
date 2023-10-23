package com.example.countrylist;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.countrylist.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.List;

public class CountryListFragment extends Fragment {

    AppDataBase dataBase;
    List<Country> countries = new ArrayList<>();


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

//        dataBase = App.getINSTANCE().getDataBase();

//        countries = dataBase.countriesDao().getAllCountries();

        dataBase = AppDataBase.getInstance(getContext());
        countries = dataBase.countriesDao().getAllCountries();

        if (countries != null && countries.size() > 0) {
            Log.d("test", "CountryListFrag lodad from DB " +  countries.size() + " countries");
        } else {
            countries.add(new Country("CN","China", "Capital 1", "https://flagsapi.com/CN/flat/64.png"));
            countries.add(new Country("IN","India", "Capital 2", "https://flagsapi.com/IN/flat/64.png"));
            countries.add(new Country("US","USA", "Capital 3", "https://flagsapi.com/US/flat/64.png"));
            countries.add(new Country("ID","Indonesia", "Capital 4", "https://flagsapi.com/ID/flat/64.png"));
            countries.add(new Country("BR","Brazil", "Capital 5", "https://flagsapi.com/BR/flat/64.png"));

            dataBase.countriesDao().insert(new Country("AD","Andorra", "Capital 1", "https://flagsapi.com/AD/flat/64.png"));
            dataBase.countriesDao().insert(new Country("AR","Argentina", "Capital 1", "https://flagsapi.com/AR/flat/64.png"));
            dataBase.countriesDao().insert(new Country("AZ","Azerbaijan", "Capital 1", "https://flagsapi.com/AZ/flat/64.png"));
            dataBase.countriesDao().insert(new Country("BG","Bulgaria", "Capital 1", "https://flagsapi.com/BG/flat/64.png"));


            Log.d("test", "CountryListFrag runtime generated " +  countries.size() + " countries");
        }

//        countries.add(new Country("CN","China", "Capital 1", "https://flagsapi.com/CN/flat/64.png"));
//        countries.add(new Country("IN","India", "Capital 2", "https://flagsapi.com/IN/flat/64.png"));
//        countries.add(new Country("US","USA", "Capital 3", "https://flagsapi.com/US/flat/64.png"));
//        countries.add(new Country("ID","Indonesia", "Capital 4", "https://flagsapi.com/ID/flat/64.png"));
//        countries.add(new Country("BR","Brazil", "Capital 5", "https://flagsapi.com/BR/flat/64.png"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_main, container, false);
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();
        binding.setTitle("My Country List:");

//        RecyclerView recyclerView = view.findViewById(R.id.frag_country_list);

        CountryRecyclerViewAdapter countryListAdapter = new CountryRecyclerViewAdapter(getActivity(), countries);
//        recyclerView.setAdapter(countryListAdapter);

        countryListAdapter.setOnCountryClickListener(new CountryRecyclerViewAdapter.OnCountryClickListener() {
            @Override
            public void onClick(Country model) {
                Country selectedCountry = model;
                fragmentSendDataListener.onSendData(selectedCountry);
            }
        });

        binding.setMyAdapter(countryListAdapter);

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