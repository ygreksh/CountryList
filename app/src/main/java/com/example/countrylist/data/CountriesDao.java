package com.example.countrylist.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.countrylist.model.Country;

import java.util.List;

@Dao
public interface CountriesDao {
    @Query("SELECT * FROM countries")
    List<Country> getAllCountries();

    @Query("SELECT * FROM countries WHERE code = :code")
    Country getByCode(String code);

    @Query("SELECT * FROM countries WHERE name = :name")
    List<Country> searchByName(String name);


    @Insert
    void insert(Country country);
    @Update
    void update(Country country);
    @Delete
    void delete(Country country);

}
