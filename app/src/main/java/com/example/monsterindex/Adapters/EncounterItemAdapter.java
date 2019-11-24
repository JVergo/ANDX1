package com.example.monsterindex.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monsterindex.API.Monster;
import com.example.monsterindex.R;

import java.util.ArrayList;
import java.util.List;

public class EncounterItemAdapter extends RecyclerView.Adapter<EncounterItemAdapter.ViewHolder> {
    private ArrayList<Monster> mMonster;

    public EncounterItemAdapter(List<Monster> monsters){
        mMonster = (ArrayList<Monster>) monsters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.encounter_item, parent, false);
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
    }

    @Override
    public int getItemCount() {
        return mMonster.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, str, dex, con , INT, wis, cha, ac;
        EditText hp;

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
        }
    }
}