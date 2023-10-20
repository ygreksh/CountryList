package com.example.countrylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CountryListFragment.OnFragmentSendDataListener{
    ArrayList<Country> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            CountryListFragment countryListFragment = new CountryListFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            countryListFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, countryListFragment).commit();
        }
    }

    @Override
    public void onSendData(Country selectedCountry) {

        DetailsFragment detailsFragment = new DetailsFragment();

        Bundle args = new Bundle();
        args.putString(DetailsFragment.ARG_PARAM_NAME, selectedCountry.name);
        args.putString(DetailsFragment.ARG_PARAM_CAPITAL, selectedCountry.capital);
        args.putString(DetailsFragment.ARG_PARAM_FLAG, selectedCountry.flagUrl);
        detailsFragment.setArguments(args);
//        detailsFragment.setSelectedCountry(selectedCountry);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, detailsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}