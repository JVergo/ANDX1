package com.example.monsterindex.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monsterindex.API.Monster;
import com.example.monsterindex.Fragments.FragmentController;
import com.example.monsterindex.Fragments.MonsterView;
import com.example.monsterindex.R;

import java.util.ArrayList;

public class MonsterListItemAdapter extends RecyclerView.Adapter<MonsterListItemAdapter.ViewHolder> {
    private ArrayList<Monster> mMonster;
    private Context c;

    public MonsterListItemAdapter(ArrayList<Monster> monsters, Context c){
        mMonster = monsters;
        this.c = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.monster_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(mMonster.get(position).getName());
        holder.str.setText(String.valueOf(mMonster.get(position).getSTR()));
        holder.dex.setText(String.valueOf(mMonster.get(position).getDEX()));
        holder.con.setText(String.valueOf(mMonster.get(position).getCON()));
        holder.INT.setText(String.valueOf(mMonster.get(position).getINT()));
        holder.wis.setText(String.valueOf(mMonster.get(position).getWIS()));
        holder.cha.setText(String.valueOf(mMonster.get(position).getCHA()));
        holder.ac.setText(String.valueOf(mMonster.get(position).getAC()));
        holder.hp.setText(String.valueOf(mMonster.get(position).gethitPoints()));
        holder.base.setOnClickListener(v -> {
            FragmentController.getInstance().setCurMonster(mMonster.get(position));
            FragmentController.getInstance().ChangeFragment(MonsterView.newInstance(position));
        });
        holder.encounterBTN.setOnClickListener(v -> {
            Toast.makeText(c,"Added " + mMonster.get(position).getName() + "to the encounter",Toast.LENGTH_SHORT).show();
            FragmentController.getInstance().AddToEncounter(mMonster.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return mMonster.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, str, dex, con , INT, wis, cha, hp, ac;
        LinearLayout base;
        Button encounterBTN;

        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.monsterName);
            str = itemView.findViewById(R.id.strnum);
            dex = itemView.findViewById(R.id.dexnum);
            con = itemView.findViewById(R.id.connum);
            INT = itemView.findViewById(R.id.intnum);
            wis = itemView.findViewById(R.id.wisnum);
            cha = itemView.findViewById(R.id.chanum);
            hp = itemView.findViewById(R.id.hpNum);
            ac = itemView.findViewById(R.id.acNum);
            base = itemView.findViewById(R.id.baseLayout);
            encounterBTN = itemView.findViewById(R.id.encounterBTN);
        }
    }
}