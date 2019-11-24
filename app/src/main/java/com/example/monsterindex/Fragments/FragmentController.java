package com.example.monsterindex.Fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.monsterindex.API.Monster;
import com.example.monsterindex.R;

import java.util.ArrayList;

public class FragmentController {
    //Singleton instance for access across the system
    private static FragmentController instance;
    public static  FragmentController getInstance()
    {
        if (instance == null)
        {
            instance = new FragmentController();
        }
        return  instance;
    }

    //Reference to the currently shown fragment.
    Fragment currentFragment;

    //Inorder to work this class needs a FragmentManager. Get this form the MainActivity or where the fragment container is
    private FragmentManager manager;
    public void setManager(FragmentManager manager) {
        this.manager = manager;
    }

    //Persist the chosen monster in order to reduce api calls.
    private Monster curMonster;
    public Monster getCurMonster() {
        return curMonster;
    }
    public void setCurMonster(Monster curMonster) {
        this.curMonster = curMonster;
    }

    private ArrayList<Monster> encounter;

    public ArrayList<Monster> getEncounter() {
        return encounter;
    }
    public void AddToEncounter(Monster m){
        encounter.add(m);
    }

    //Empty constructor. Can be used to initialising of values
    private FragmentController() {
        encounter = new ArrayList<Monster>();
    }

    // Changes the currentFragment with the newFragment unless they are the same class.
    public void ChangeFragment(Fragment newFragment) {
        if(currentFragment == null || newFragment.getClass() != currentFragment.getClass()) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragmentContainer, newFragment);
            transaction.commit();
            currentFragment = newFragment;
        }
    }
}
