package com.bit603.a1;


import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CardListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_list);

        // 1. Get the data from the Intent (default is false)
        isDevModeActive = getIntent().getBooleanExtra("IS_DEV_MODE", false);

        // 2. If it's active, apply the theme immediately
        if (isDevModeActive) {
            applyDeveloperTheme();
        }

        // Setup your header title
        View header = findViewById(R.id.mainHeader);
        if (header != null) {
            ((TextView)header.findViewById(R.id.gameTitle)).setText("Card List");
        }
    }

    private void applyDeveloperTheme() {
        // Find your views in THIS activity and set them to Black/Grey
        // (Just like your activateDeveloperMode method in MainActivity)
        findViewById(R.id.cardListRoot).setBackgroundColor(getColor(R.color.light_grey));
        // etc...
    }
    }
}
