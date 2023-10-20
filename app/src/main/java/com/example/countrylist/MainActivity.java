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

//        countries.add(new Country("Name 1", "Capital 1", R.drawable.ar_flag));
//        countries.add(new Country("Name 2", "Capital 2", R.drawable.ar_flag));
//        countries.add(new Country("Name 3", "Capital 3", R.drawable.ar_flag));
//        countries.add(new Country("Name 4", "Capital 4", R.drawable.ar_flag));
//        countries.add(new Country("Name 5", "Capital 5", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//        countries.add(new Country("Name 6", "Capital 6", R.drawable.ar_flag));
//
//        RecyclerView recyclerView = findViewById(R.id.country_list);
//
//        CountryRecyclerViewAdapter countryListAdapter = new CountryRecyclerViewAdapter(this, countries);
//        recyclerView.setAdapter(countryListAdapter);
//
//        countryListAdapter.setOnCountryClickListener(new CountryRecyclerViewAdapter.OnCountryClickListener() {
//            @Override
//            public void onClick(int position, Country model) {
//                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                intent.putExtra("country_name", model.name);
//                intent.putExtra("country_capital", model.capital);
//                intent.putExtra("country_flag", model.flagResource);
//                startActivity(intent);
//            }
//        });

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
//        DetailsFragment fragment = (DetailsFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.detailFragment);
//        if (fragment != null)
//            fragment.setSelectedCountry(selectedCountry);

        DetailsFragment detailsFragment = new DetailsFragment();

        Bundle args = new Bundle();
        args.putString(DetailsFragment.ARG_PARAM_NAME, selectedCountry.name);
        args.putString(DetailsFragment.ARG_PARAM_CAPITAL, selectedCountry.capital);
        args.putInt(DetailsFragment.ARG_PARAM_FLAG, selectedCountry.flagResource);
        detailsFragment.setArguments(args);
//        detailsFragment.setSelectedCountry(selectedCountry);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, detailsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}