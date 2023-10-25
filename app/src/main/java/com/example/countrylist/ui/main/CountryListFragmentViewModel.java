package com.example.countrylist.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countrylist.data.AppDataBase;
import com.example.countrylist.domain.model.Country;

import java.util.List;

@SuppressLint("StaticFieldLeak")
public class CountryListFragmentViewModel extends ViewModel {
    private final MutableLiveData<List<Country>> countryList = new MutableLiveData<>();

    private Context context;
//    public AppDataBase dataBase;
    public CountryListFragmentViewModel() {
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<Country>> getCountryList() {
        return countryList;
    }

    public CountryListFragmentViewModel(Context context) {
        this.context = context;
    }

    public void getCountriesFromDB() {
        AppDataBase dataBase = AppDataBase.getInstance(context);

        List<Country> countries = dataBase.countriesDao().getAllCountries();

        countryList.postValue(countries);
    }
}
