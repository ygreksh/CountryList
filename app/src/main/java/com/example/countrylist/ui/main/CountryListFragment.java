package com.example.countrylist.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.countrylist.databinding.FragmentMainBinding;
import com.example.countrylist.domain.model.Country;
import com.example.countrylist.R;
import com.example.countrylist.domain.usecase.ShowDetailCountryInfoUseCase;

import java.util.List;

public class CountryListFragment extends Fragment {

//    AppDataBase dataBase;
//    List<Country> countries = new ArrayList<>();

    public CountryListFragmentViewModel viewModel;
    public CountryRecyclerViewAdapter countryListAdapter;
    public FragmentMainBinding binding;

    private ShowDetailCountryInfoUseCase showDetailCountryInfoUseCase = new ShowDetailCountryInfoUseCase();

    public CountryListFragment() {
        // Required empty public constructor
    }

    public interface OnFragmentSendDataListener {
        void onSendData(Country data);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(CountryListFragmentViewModel.class);
        viewModel.setContext(getContext());
        viewModel.getCountriesFromDB();

//        viewModel = new ViewModelProvider(requireActivity()).get();

//        dataBase = AppDataBase.getInstance(getContext());
//        countries = dataBase.countriesDao().getAllCountries();

//        if (countries != null && countries.size() > 0) {
//            Log.d("test", "CountryListFrag lodad from DB " +  countries.size() + " countries");
//        } else {
//            countries.add(new Country("CN","China", "Capital 1", "https://flagsapi.com/CN/flat/64.png"));
//            countries.add(new Country("IN","India", "Capital 2", "https://flagsapi.com/IN/flat/64.png"));
//            countries.add(new Country("US","USA", "Capital 3", "https://flagsapi.com/US/flat/64.png"));
//            countries.add(new Country("ID","Indonesia", "Capital 4", "https://flagsapi.com/ID/flat/64.png"));
//            countries.add(new Country("BR","Brazil", "Capital 5", "https://flagsapi.com/BR/flat/64.png"));
//
//            dataBase.countriesDao().insert(new Country("AD","Andorra", "Capital 1", "https://flagsapi.com/AD/flat/64.png"));
//            dataBase.countriesDao().insert(new Country("AR","Argentina", "Capital 1", "https://flagsapi.com/AR/flat/64.png"));
//            dataBase.countriesDao().insert(new Country("AZ","Azerbaijan", "Capital 1", "https://flagsapi.com/AZ/flat/64.png"));
//            dataBase.countriesDao().insert(new Country("BG","Bulgaria", "Capital 1", "https://flagsapi.com/BG/flat/64.png"));
//
//
//            Log.d("test", "CountryListFrag runtime generated " +  countries.size() + " countries");
//        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_main, container, false);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();
        binding.setTitle("My Country List:");

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getCountryList().observe(requireActivity(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                if (countries != null) {
                    Log.d("test", "CountryListFragment CountryList onChange(): " + countries.size() + " items");
                    countryListAdapter = new CountryRecyclerViewAdapter(getActivity(), countries);
                    countryListAdapter.setOnCountryClickListener(new CountryRecyclerViewAdapter.OnCountryClickListener() {
                        @Override
                        public void onClick(Country model) {
                            Country selectedCountry = model;
//                            fragmentSendDataListener.onSendData(selectedCountry);
                            showDetailCountryInfoUseCase.execute(fragmentSendDataListener, selectedCountry);
                        }
                    });

                    binding.setMyAdapter(countryListAdapter);
                } else {
                    Log.d("test", "CountryListFragment CountryList onChange(): null");
                }
            }
        });
    }
}