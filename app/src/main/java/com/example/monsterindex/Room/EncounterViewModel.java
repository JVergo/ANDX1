package com.example.monsterindex.Room;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.monsterindex.API.Monster;
import com.example.monsterindex.Fragments.FragmentController;

import java.util.ArrayList;
import java.util.List;

public class EncounterViewModel extends AndroidViewModel {
    private EncounterRepository repository;
    private Encounter encounter;

    public EncounterViewModel(Application app) {
        super(app);
        repository = EncounterRepository.getInstance(app);
    }

    private MutableLiveData<List<Monster>> monsters;
    public LiveData<List<Monster>> getMonsters() {
        if (monsters == null) {
            monsters = new MutableLiveData<List<Monster>>();
            loadMonsters();
        }
        return monsters;
    }

    private void loadMonsters() {
        if(FragmentController.getInstance().getEncounter().size() == 0) {
            //List<Encounter> ent = repository.getAllEncounters();
            //int temp = repository.getAllEncounters().size();
            //encounter = repository.getAllEncounters().get(0);
        }
        else {
            monsters.setValue(FragmentController.getInstance().getEncounter());
        }
    }

    public void SaveEncounter(Context c) {
        if(encounter == null) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (Monster m : FragmentController.getInstance().getEncounter()) {
                temp.add(m.getIndex());
            }
            Encounter e = new Encounter(temp);
            repository.insert(e);
            Toast.makeText(c,"Encounter saved",Toast.LENGTH_SHORT).show();
        }
        else
        {
            //repository.update(encounter);
            Toast.makeText(c,"Encounter Updated",Toast.LENGTH_SHORT).show();
        }

    }

}
