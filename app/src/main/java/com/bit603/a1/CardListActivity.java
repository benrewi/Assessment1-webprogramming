package com.bit603.a1;


import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CardListActivity extends AppCompatActivity {
    private boolean isDevModeActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_list);

        isDevModeActive = getIntent().getBooleanExtra("IS_DEV_MODE", false);

        if (isDevModeActive) {
            applyDeveloperTheme();
        }

        View header = findViewById(R.id.mainHeader);
        if (header != null) {
            ((TextView)header.findViewById(R.id.gameTitle)).setText("Card List");
        }
    }

    private void applyDeveloperTheme() {
        findViewById(R.id.cardListRoot).setBackgroundColor(getColor(R.color.light_grey));
    }
    }

