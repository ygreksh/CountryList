package com.example.countrylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentSendDataListener{
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
    }

    @Override
    public void onSendData(Country selectedCountry) {
        DetailsFragment fragment = (DetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.main_fragment_view);
        if (fragment != null)
            fragment.setSelectedCountry(selectedCountry);
    }
}