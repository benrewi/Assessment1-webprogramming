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

        GameCardScrollerRecyclerViewAdapter adapter = new GameCardScrollerRecyclerViewAdapter(MainActivity.cardList, isDevMode, card -> {
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
