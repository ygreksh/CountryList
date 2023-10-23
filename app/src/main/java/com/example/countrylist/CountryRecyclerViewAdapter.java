package com.example.countrylist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.countrylist.databinding.CountryItemBinding;

import java.util.List;

public class CountryRecyclerViewAdapter  extends RecyclerView.Adapter<CountryViewHolder> implements CustomClickListener {
    private final LayoutInflater inflater;
//    private Context context;
    private final List<Country> countryList;
//    private OnCountryClickListener onCountryClickListener;

    public CountryRecyclerViewAdapter(Context context, List<Country> countryList) {
//        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.country_item, parent, false);
        CountryItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.country_item, parent, false);
//        View view = binding.getRoot();
        return new CountryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Country country = countryList.get(position);

        holder.bind(country);

        holder.countryItemBinding.setItemClickListener(this);
//        holder.itemView.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                        if (onCountryClickListener != null) {
////                            onCountryClickListener.onClick(position, country);
////                        }
//                        Log.d("test", "onBindViewHolder onClick() country: " + country.name + " " + country.capital);
//                    }
//                }
//        );
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

//    public void setOnCountryClickListener(OnCountryClickListener onClickListener) {
//        this.onCountryClickListener = onClickListener;
//    }

    @Override
    public void itemClicked(Country item) {
//        Country selectedCountry = model;
//        fragmentSendDataListener.onSendData(selectedCountry);
        Log.d("test", "itemClicked() country: " + item.name + " " + item.capital);

    }

//    public interface OnCountryClickListener {
//        void onClick(int position, Country model);
//    }
}
