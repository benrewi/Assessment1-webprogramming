package com.bit603.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class GameCardScrollerRecyclerViewAdapter extends RecyclerView.Adapter<GameCardScrollerRecyclerViewAdapter.CardViewHolder> {
    List<GameCard> data;

    public interface OnClickListener{
        void onClick(GameCard card);
    }

    OnClickListener listener;

    public GameCardScrollerRecyclerViewAdapter(List <GameCard> data, boolean isDevMode, OnClickListener listener) {
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