/**
 * BIT603 Assessment 1

 * Name: Ben Rewi
 * ID: 5124830
 * Created: 9th April 2026

 * This is the RecyclerView adapter for the Card List activity. It takes a list of GameCards and displays them in a scrollable list.
 * It also has conditional filtering to show or hide cards based on whether they're finished or unfinished,
 * as unfinished cards should not show in the normal view.


 * @author Ben Rewi
 * @version 1.0
 */


package com.bit603.a1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardListRecyclerViewAdapter extends RecyclerView.Adapter<CardListRecyclerViewAdapter.CardViewHolder> {
    List<GameCard> data;

    public interface OnClickListener{
        void onClick(GameCard card);
    }
    OnClickListener listener;

    public CardListRecyclerViewAdapter(List <GameCard> data, boolean isDevMode, OnClickListener listener) {
        this.listener = listener;
        if (isDevMode){
        this.data = data;
    } else {
            this.data = new ArrayList<>();
            for (GameCard card : data) {
                if (!card.getUnfinished()){
                    this.data.add(card);
                }
                }
            }
        }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull CardViewHolder holder,int position){
        holder.cardItemText.setText(data.get(position).getCardId() + " " + data.get(position).getName());
        holder.itemView.setOnClickListener(v -> listener.onClick(data.get(position)));
        ((androidx.cardview.widget.CardView) holder.itemView).setCardBackgroundColor(Color.parseColor(data.get(position).getFadedElementColour()));
    }

    @Override
    public int getItemCount () {
        return data.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        TextView cardItemText;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardItemText = itemView.findViewById(R.id.cardItemText);
        }

    }
}