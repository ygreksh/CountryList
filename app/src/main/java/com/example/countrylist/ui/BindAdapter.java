package com.example.countrylist.ui;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindAdapter {
    @BindingAdapter("glide:imageUrl")
    public static void loadIcon(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
