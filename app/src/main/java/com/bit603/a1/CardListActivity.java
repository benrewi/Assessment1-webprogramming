package com.bit603.a1;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class CardListActivity extends AppCompatActivity {
    private boolean isDeveloperMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_list);


        isDeveloperMode = getIntent().getBooleanExtra("IS_DEV_MODE", false);

        if (isDeveloperMode) {
            applyDeveloperTheme();
        }

        View header = findViewById(R.id.mainHeader);
        if (header != null) {
            ((TextView) header.findViewById(R.id.gameTitle)).setText(R.string.card_list);
        }

        RecyclerView cardRecyclerView = findViewById(R.id.cardListRecycler);
        cardRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        GameCardScrollerRecyclerViewAdapter adapter = new GameCardScrollerRecyclerViewAdapter(MainActivity.cardList);
        cardRecyclerView.setAdapter(adapter);

    }

    private void applyDeveloperTheme() {
        findViewById(R.id.cardListRoot).setBackgroundColor(getColor(R.color.light_grey));
    }


}

