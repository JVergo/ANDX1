package com.example.monsterindex.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monsterindex.API.Monster;
import com.example.monsterindex.R;

public class MonsterView extends Fragment {
    Monster mMonster;

    public MonsterView() {
        // Required empty public constructor
    }
    public static MonsterView newInstance(int monsterID) {
        MonsterView fragment = new MonsterView();
        Bundle args = new Bundle();
        args.putInt("monsterID", monsterID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        mMonster = FragmentController.getInstance().getCurMonster();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_monster_view, container, false);
        SetTextOnView((TextView)rootView.findViewById(R.id.viewName), mMonster.getName());
        SetTextOnView((TextView)rootView.findViewById(R.id.viewDetails), mMonster.getSize() + " " + mMonster.getFammily() + ", " + mMonster.getAlligment());
        SetTextOnView((TextView)rootView.findViewById(R.id.viewAC), "Armor Class " + mMonster.getAC());
        SetTextOnView((TextView)rootView.findViewById(R.id.viewHP), "Hit Points " + mMonster.gethitPoints());
        SetTextOnView((TextView)rootView.findViewById(R.id.viewSpeed), "Speed " + mMonster.getspeed());
        SetTextOnView((TextView)rootView.findViewById(R.id.strnum), mMonster.getSTR() + getMod(mMonster.getSTR()));
        SetTextOnView((TextView)rootView.findViewById(R.id.dexnum), mMonster.getDEX()+ getMod(mMonster.getDEX()));
        SetTextOnView((TextView)rootView.findViewById(R.id.connum), mMonster.getCON()+ getMod(mMonster.getCON()));
        SetTextOnView((TextView)rootView.findViewById(R.id.intnum), mMonster.getINT()+ getMod(mMonster.getINT()));
        SetTextOnView((TextView)rootView.findViewById(R.id.wisnum), mMonster.getWIS()+ getMod(mMonster.getWIS()));
        SetTextOnView((TextView)rootView.findViewById(R.id.chanum), mMonster.getCHA()+ getMod(mMonster.getCHA()));
        SetTextOnView((TextView)rootView.findViewById(R.id.viewSkills), mMonster.getSkills());
        SetTextOnView((TextView)rootView.findViewById(R.id.viewSenses), "Senses " + mMonster.getSenses());
        SetTextOnView((TextView)rootView.findViewById(R.id.viewLanguage), "Language " + mMonster.getLanguage());
        SetTextOnView((TextView)rootView.findViewById(R.id.viewChallenge), "Challenge " + mMonster.getCR());
        // Inflate the layout for this fragment
        return rootView;
    }

    private String getMod(int value) {
        String modString = "-";
        int mod = -6;
        for (int i = 0; i <= value; i++) {
            if(i % 2 == 0)
            {
                mod++;
            }
        }
        if(value >= 10)
        {
            modString = "(+" + mod + ")";
        }
        else
        {
            modString = "(" + mod +")";
        }

        return modString;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void SetTextOnView(TextView view, String text)
    {
        view.setText(text);
    }
}
