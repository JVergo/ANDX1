package com.example.monsterindex.Fragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.monsterindex.Adapters.EncounterItemAdapter;
import com.example.monsterindex.R;
import com.example.monsterindex.Room.EncounterViewModel;

public class EncounterFragment extends Fragment {

    private EncounterViewModel mViewModel;
    private RecyclerView mEncounterList;
    private RecyclerView.Adapter mEncunterAdapter;

    public static EncounterFragment newInstance() {
        return new EncounterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.encounter_fragment, container, false);
        mEncounterList = rootView.findViewById(R.id.encounterRV);
        mEncounterList.hasFixedSize();

        rootView.findViewById(R.id.saveEncounterBTN).setOnClickListener(v -> {
            mViewModel.SaveEncounter(mEncounterList.getContext());
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EncounterViewModel.class);
        // TODO: Use the ViewModel
        mEncunterAdapter = new EncounterItemAdapter(mViewModel.getMonsters().getValue());
        mEncounterList.setAdapter(mEncunterAdapter);
        mEncounterList.setItemAnimator(new DefaultItemAnimator());
        mEncounterList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
