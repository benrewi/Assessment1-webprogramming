/**
 * BIT603 Assessment 1

 * Name: Ben Rewi
 * ID: 5124830
 * Created: 9th April 2026

 * This displays a scrollable list for the game cards using a RecyclerView. It filters out unfinished cards in normal mode
 * and shows all cards in developer mode. It also allows the user to navigate to the CardDetailsActivity when a card is tapped,
 * which passes the ID and developer mode state via intent.

 * @author Ben Rewi
 * @version 1.0
 */

package com.bit603.a1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedHashMap;


public class CardListActivity extends AppCompatActivity {
    private boolean isDevMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.card_list);



        isDevMode = getIntent().getBooleanExtra("IS_DEV_MODE", false);

        if (isDevMode) {
            applyDevTheme();
        }

        View header = findViewById(R.id.mainHeader);
        if (header != null) {
            ((TextView) header.findViewById(R.id.gameTitle)).setText(R.string.card_list);
            ImageButton btnBack = header.findViewById(R.id.btnBack);
            btnBack.setVisibility(View.VISIBLE);
            btnBack.setOnClickListener(v -> finish());
        }

        RecyclerView cardRecyclerView = findViewById(R.id.cardListRecycler);
        cardRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        CardListRecyclerViewAdapter adapter = new CardListRecyclerViewAdapter(MainActivity.cardList, isDevMode, card -> {
            Intent intent = new Intent(this, CardDetailsActivity.class);
            intent.putExtra("CARD_ID", card.getCardId());
            intent.putExtra("IS_DEV_MODE", isDevMode);
            startActivity(intent);
        });

        cardRecyclerView.setAdapter(adapter);

    }

    private void applyDevTheme() {
        View rootLayout = findViewById(R.id.cardListRoot);
        View header = findViewById(R.id.mainHeader);

        Themes.applyDevThemeHeader(this, rootLayout, header);


    }
}
