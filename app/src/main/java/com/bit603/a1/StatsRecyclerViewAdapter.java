package com.bit603.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StatsRecyclerViewAdapter extends RecyclerView.Adapter<StatsRecyclerViewAdapter.StatViewHolder> {

    private List<String> keys;
    private HashMap<String, String> data;

    public StatsRecyclerViewAdapter(HashMap<String, String> data){
        this.data = data;
        this.keys = new ArrayList<>(data.keySet());
    }

    @NonNull
    @Override
    public StatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.stats_item, parent, false);
        return new StatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatViewHolder holder, int position){
        String key = keys.get(position);
        holder.statLabel.setText(key);
        holder.statValue.setText(data.get(key));
    }

    @Override
    public int getItemCount(){
        return data.size();
    }

    public static class StatViewHolder extends RecyclerView.ViewHolder {
        TextView statLabel;
        TextView statValue;

        public StatViewHolder(@NonNull View itemView) {
            super(itemView);
            statLabel = itemView.findViewById(R.id.statLabel);
            statValue = itemView.findViewById(R.id.statValue);
        }
    }
}
