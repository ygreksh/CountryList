package com.example.countrylist.ui.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countrylist.model.Country;

public class DetailsFragmentViewModel extends ViewModel {
//    private CountryRepository repository;

    private final MutableLiveData<Country> myCountry = new MutableLiveData<>();
    public DetailsFragmentViewModel(
//            CountryRepository repository
//            SavedStateHandle savedStateHandle
    ) {
//        this.repository = repository;
    }

    public MutableLiveData<Country> getMyCountry() {
        return myCountry;
    }

    void setMyCountry (Country country) {
        myCountry.postValue(country);
    }
}
