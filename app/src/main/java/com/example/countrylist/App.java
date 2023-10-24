package com.example.countrylist;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;
//        dataBase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "database").build();
    }
}
