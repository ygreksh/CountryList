package com.example.countrylist;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static App INSTANCE;

    private AppDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;
//        dataBase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "database").build();
    }

    public static App getINSTANCE() {
        return INSTANCE;
    }

    public AppDataBase getDataBase() {
        return dataBase;
    }
}
