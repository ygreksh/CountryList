package com.example.countrylist.ui.main;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countrylist.model.Country;
import com.example.countrylist.databinding.CountryItemBinding;

public class CountryViewHolder extends RecyclerView.ViewHolder {
    public CountryItemBinding countryItemBinding;
    public CountryViewHolder(@NonNull CountryItemBinding countryItemBinding) {
        super(countryItemBinding.getRoot());
        this.countryItemBinding = countryItemBinding;
    }

    public void bind(Country country) {
        countryItemBinding.setCountry(country);
    }
}
