package com.example.countrylist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder {
    ImageView imageViewFlag;
    TextView textViewName;
    TextView textViewCapital;
    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewFlag = itemView.findViewById(R.id.flag_imageview);
        textViewName = itemView.findViewById(R.id.name_textview);
    }
}
