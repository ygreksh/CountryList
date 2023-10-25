package com.example.countrylist.domain.usecase;

import android.util.Log;

import com.example.countrylist.domain.model.Country;
import com.example.countrylist.ui.main.CountryListFragment;

public class ShowDetailCountryInfoUseCase {
    public void execute(CountryListFragment.OnFragmentSendDataListener fragmentSendDataListener, Country country) {
        // show details fragment
        Log.d("test", "ShowDetailCountryInfoUseCase : " + country.name);
        fragmentSendDataListener.onSendData(country);
    }
}
