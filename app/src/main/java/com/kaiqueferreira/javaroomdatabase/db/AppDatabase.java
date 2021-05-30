package com.kaiqueferreira.javaroomdatabase.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kaiqueferreira.javaroomdatabase.model.User;

@Database (entities = {User.class}, version = 1)
public abstract  class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstanceDB(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DB NAME")
            .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

}
