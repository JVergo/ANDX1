package com.example.monsterindex.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EncounterDao {
    @Insert
    void insert(Encounter encounter);

    @Update
    void update(Encounter encounter);

    @Delete
    void delete(Encounter encounter);

    @Query("DELETE FROM encounter_table")
    void deleteAllEncounters();

    @Query("SELECT * FROM encounter_table ORDER BY monsterIndex DESC")
    LiveData<List<Encounter>> getAllEncounters();
}

