package com.example.monsterindex.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.ArrayList;

@Entity(tableName = "encounter_table")
public class Encounter {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @TypeConverters({Converters.class})
    private ArrayList<Integer> monsterIndex;

    public Encounter(ArrayList<Integer> monsterIndex) {
        this.monsterIndex = monsterIndex;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public ArrayList<Integer> getMonsterIndex() {
        return monsterIndex;
    }

    public void setMonsterIndex(ArrayList<Integer> monsterIndex) {
        this.monsterIndex = monsterIndex;
    }
}