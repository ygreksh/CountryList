package com.example.countrylist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

//        TextView textViewName = findViewById(R.id.textview_name);
//        TextView textViewCapital = findViewById(R.id.textview_capital);
//        ImageView imageViewFlag = findViewById(R.id.imageview_flag);
//
//
//        Country country = null;
//        if (
//
//                getIntent().hasExtra("country_code")
//                && getIntent().hasExtra("country_name")
//                && getIntent().hasExtra("country_capital")
//                && getIntent().hasExtra("country_flag")
//        ) {
//            country = new Country(
//                    getIntent().getStringExtra("country_code"),
//                    getIntent().getStringExtra("country_name"),
//                    getIntent().getStringExtra("country_capital"),
//                    getIntent().getStringExtra("country_flag")
//            );
//        }
//
//        if (country != null) {
//            textViewName.setText(country.name);
//            textViewCapital.setText(country.capital);
//        }
    }
}