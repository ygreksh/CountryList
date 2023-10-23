package com.example.countrylist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countrylist.databinding.CountryItemBinding;

public class CountryViewHolder extends RecyclerView.ViewHolder {
    public CountryItemBinding binding;
    public CountryViewHolder(@NonNull CountryItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Country country) {
        binding.setCountry(country);
    }
}
