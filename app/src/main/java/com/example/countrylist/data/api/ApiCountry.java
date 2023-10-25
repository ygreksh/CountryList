package com.example.countrylist.data.api;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCountry {
    String BASE_URL = "https://flagcdn.com/";

    @GET("en/codes.json")
    Call<HashMap<String, String>> getCountries();

}
