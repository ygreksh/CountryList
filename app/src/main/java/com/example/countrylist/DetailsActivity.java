package com.example.countrylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView textViewName = findViewById(R.id.textview_name);
        TextView textViewCapital = findViewById(R.id.textview_capital);
        ImageView imageViewFlag = findViewById(R.id.imageview_flag);


        Country country = null;
        if (
                getIntent().hasExtra("country_name")
                && getIntent().hasExtra("country_capital")
                && getIntent().hasExtra("country_flag")
        ) {
            country = new Country(
                    getIntent().getStringExtra("country_name"),
                    getIntent().getStringExtra("country_capital"),
                    getIntent().getIntExtra("country_flag", R.drawable.ar_flag)
            );
        }

        if (country != null) {
            textViewName.setText(country.name);
            textViewCapital.setText(country.capital);
            imageViewFlag.setImageResource(country.flagResource);
        }
    }
}