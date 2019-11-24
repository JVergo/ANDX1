package com.example.monsterindex.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Encounter.class}, version = 1)
public abstract class EncounterDatabase extends RoomDatabase {

    private static EncounterDatabase instance;
    public abstract EncounterDao EncounterDao();

    public static synchronized EncounterDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    EncounterDatabase.class, "encounter_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

