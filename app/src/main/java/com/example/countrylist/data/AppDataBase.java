package com.example.countrylist.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.countrylist.model.Country;

@Database(entities = {Country.class}, version = 1)
public abstract class AppDataBase
        extends RoomDatabase
{
    private static final String DB_NAME = "database";
    private static AppDataBase instance;
    public abstract CountriesDao countriesDao();

    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, DB_NAME).allowMainThreadQueries().build();
        }
        return instance;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //
        }
    };
}