package com.bit603.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GameCardScrollerRecyclerViewAdapter extends RecyclerView.Adapter<GameCardScrollerRecyclerViewAdapter.CardViewHolder> {
    List<GameCard> data;

    public GameCardScrollerRecyclerViewAdapter(List <GameCard> data) {
        this.data = data;
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
        holder.cardItemText.setText(data.get(position).getCardID() + " " + data.get(position).getName());
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
/*END*/