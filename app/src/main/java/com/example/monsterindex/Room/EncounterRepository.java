package com.example.monsterindex.Room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EncounterRepository {
    private EncounterDao encounterDao;
    private static EncounterRepository instance;
    private LiveData<List<Encounter>> allEncounters;

    private EncounterRepository(Application application){
        EncounterDatabase database = EncounterDatabase.getInstance(application);
        encounterDao = database.EncounterDao();
        allEncounters = encounterDao.getAllEncounters();
    }

    public static synchronized EncounterRepository getInstance(Application application){
        if(instance == null)
            instance = new EncounterRepository(application);
        return instance;
    }

    public LiveData<List<Encounter>> getAllEncounters(){
        return allEncounters;
    }

    public void insert(Encounter encounter) {
        new InsertEncounterAsync(encounterDao).execute(encounter);
    }

    public void update(Encounter encounter) {
        new updateEncounterAsync(encounterDao).execute(encounter);
    }

    private static class InsertEncounterAsync extends AsyncTask<Encounter,Void,Void> {
        private EncounterDao encounterDao;

        private InsertEncounterAsync(EncounterDao encounterDao) {
            this.encounterDao = encounterDao;
        }

        @Override
        protected Void doInBackground(Encounter... encounter) {
            encounterDao.insert(encounter[0]);
            return null;
        }
    }

    private class updateEncounterAsync extends AsyncTask<Encounter,Void,Void> {
        private EncounterDao encounterDao;

        public updateEncounterAsync(EncounterDao encounterDao) { this.encounterDao = encounterDao; }

        @Override
        protected Void doInBackground(Encounter... encounter) {
            encounterDao.update(encounter[0]);
            return null;
        }
    }
}

