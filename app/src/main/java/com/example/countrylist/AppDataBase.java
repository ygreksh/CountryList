package com.example.countrylist;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Country.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase INSTANSE;
    public abstract AppDataBase appDataBase();
    public abstract CountriesDao countriesDao();



    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //
        }
    };
}
