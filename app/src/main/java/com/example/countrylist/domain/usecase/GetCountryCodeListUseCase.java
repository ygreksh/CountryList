package com.example.countrylist.domain.usecase;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetCountryCodeListUseCase {
    public void execute() {
        Log.d("test", "GetCountryCodeListUseCase" );
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://flagcdn.com/en/codes.json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("test", "GetCountryCodeListUseCase onFailure()");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                HashMap<String, String> responseData = response.body().string();
                Log.d("test", "GetCountryCodeListUseCase onResponse()");
                String responseData = response.body().string();
            }
        });
    }
}
