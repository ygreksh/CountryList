package com.example.countrylist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CountryRecyclerViewAdapter  extends RecyclerView.Adapter<CountryViewHolder> {
    private final LayoutInflater inflater;
//    private Context context;
    private final List<Country> countryList;
    private OnCountryClickListener onCountryClickListener;

    public CountryRecyclerViewAdapter(Context context, List<Country> countryList) {
//        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.country_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Country country = countryList.get(position);
//        holder.imageViewFlag.setImageResource(country.flagResource);
        Glide.with(holder.itemView)
                .asBitmap()
                .load(country.flagUrl)
                .into(holder.imageViewFlag);
        holder.textViewName.setText(country.name);
//        holder.textViewCapital.setText(country.capital);

        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onCountryClickListener != null) {
                            onCountryClickListener.onClick(position, country);
                        }
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void setOnCountryClickListener(OnCountryClickListener onClickListener) {
        this.onCountryClickListener = onClickListener;
    }

    public interface OnCountryClickListener {
        void onClick(int position, Country model);
    }
}
