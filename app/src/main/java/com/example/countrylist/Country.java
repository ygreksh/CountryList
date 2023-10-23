package com.example.countrylist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "countries")
public class Country {
    @PrimaryKey
    public String code;
    public String name;
    public String capital;
    @ColumnInfo(name = "flag_url")
    public String flagUrl;

    public Country(String code, String name, String capital, String flagUrl) {
        this.code = code;
        this.name = name;
        this.capital = capital;
        this.flagUrl = flagUrl;
    }
    public Country(String name, String capital, String flagUrl) {
        this.name = name;
        this.capital = capital;
        this.flagUrl = flagUrl;
    }
}
