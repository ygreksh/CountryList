package com.example.countrylist.ui.details;

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

import com.example.countrylist.databinding.FragmentDetalsBinding;
import com.example.countrylist.model.Country;
import com.example.countrylist.R;

public class DetailsFragment extends Fragment {
    public static final String ARG_PARAM_CODE = "country_code";
    public static final String ARG_PARAM_NAME = "country_name";
    public static final String ARG_PARAM_CAPITAL = "country_capital";
    public static final String ARG_PARAM_FLAG = "country_flag";

    private String mParamCode;
    private String mParamName;
    private String mParamCapital;
    private String mParamFlag;
    private Country country;

    private DetailsFragmentViewModel viewModel;
    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamCode = getArguments().getString(ARG_PARAM_CODE);
            mParamName = getArguments().getString(ARG_PARAM_NAME);
            mParamCapital = getArguments().getString(ARG_PARAM_CAPITAL);
            mParamFlag = getArguments().getString(ARG_PARAM_FLAG);
            Log.d("test", "Details onCreate country: " + mParamName + " " + mParamCapital);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(requireActivity()).get(DetailsFragmentViewModel.class);

        country = new Country(
                mParamCode,
                mParamName,
                mParamCapital,
                mParamFlag
        );

        FragmentDetalsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detals, container, false);
        View view = binding.getRoot();

        viewModel.setMyCountry(country);
        viewModel.getMyCountry().observe(requireActivity(), new Observer<Country>() {
            @Override
            public void onChanged(Country country) {
                if (country != null) {
                    Log.d("test", "DetailsFragment MyCountry onChanged(): " + country.name);
                    binding.setCountry(country);
                } else {
                    Log.d("test", "DetailsFragment MyCountry onChanged(): null");
                    binding.setCountry(new Country("null", "null","null","https://www.generationsforpeace.org/wp-content/uploads/2018/03/empty.jpg"));
                }
            }
        });

//        binding.setCountry(country);

        // Inflate the layout for this fragment
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}