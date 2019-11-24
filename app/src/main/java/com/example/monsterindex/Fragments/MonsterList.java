package com.example.monsterindex.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monsterindex.API.Monster;
import com.example.monsterindex.API.MonsterAPI;
import com.example.monsterindex.API.MonsterResponse;
import com.example.monsterindex.API.ServiceGenerator;
import com.example.monsterindex.Adapters.MonsterListItemAdapter;
import com.example.monsterindex.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonsterList extends Fragment {

    RecyclerView mMonsterList;
    RecyclerView.Adapter mMonsterAdapter;
    ArrayList<Monster> monsters = new ArrayList<Monster>();


    public MonsterList() {
        // Required empty public constructor
    }

    public static MonsterList newInstance() {
        MonsterList fragment = new MonsterList();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GetMonsterData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_monster_list, container, false);
        mMonsterList = rootView.findViewById(R.id.rv);
        mMonsterList.hasFixedSize();
        mMonsterList.setLayoutManager(new LinearLayoutManager(getActivity()));

        mMonsterAdapter = new MonsterListItemAdapter(monsters, rootView.getContext());
        mMonsterList.setAdapter(mMonsterAdapter);
        mMonsterList.setItemAnimator(new DefaultItemAnimator());
        // Inflate the layout for this fragment
        return rootView;
    }

    private void GetMonsterData() {
        for (int i = 1; i < 325; i++) {
            requestMonster(i);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void requestMonster(int monsterID) {
        MonsterAPI monsterApi = ServiceGenerator.getMonsterApi();
        Call<MonsterResponse> call = monsterApi.getMonster(monsterID);
        call.enqueue(new Callback<MonsterResponse>() {
            @Override
            public void onResponse(Call<MonsterResponse> call, Response<MonsterResponse> response) {
                if (response.code() == 200) {
                    Monster monster = response.body().getMonster(); //Updating LiveData

                    monsters.add(monster);
                    mMonsterAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<MonsterResponse> call, Throwable t) {
                Log.i("Retrofit", t.getMessage().toString());

            }
        });
    }
}
