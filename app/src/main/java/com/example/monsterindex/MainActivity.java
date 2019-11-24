package com.example.monsterindex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.monsterindex.FireBase.FireBase;
import com.example.monsterindex.Fragments.EncounterFragment;
import com.example.monsterindex.Fragments.FragmentController;
import com.example.monsterindex.Fragments.MonsterList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FragmentController.getInstance().setManager(getSupportFragmentManager());
        FragmentController.getInstance().ChangeFragment(new MonsterList());
    }

    @Override
    public boolean onSupportNavigateUp() {
        FragmentController.getInstance().ChangeFragment(new MonsterList());
        return true;
    }

    public void StartFireBase(View v) {
        Intent intent = new Intent(MainActivity.this, FireBase.class);
        startActivity(intent);
    }

    public void OpenEncounter(View v) {
        FragmentController.getInstance().ChangeFragment(new EncounterFragment());
    }

    public void OpenList(View v) {
        FragmentController.getInstance().ChangeFragment(new MonsterList());
    }
}
