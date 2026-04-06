package com.bit603.a1;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class CardListActivity extends AppCompatActivity {
    private boolean isDeveloperMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.card_list);




        isDeveloperMode = getIntent().getBooleanExtra("IS_DEV_MODE", false);

        if (isDeveloperMode) {
            applyDeveloperTheme();
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
        GameCardScrollerRecyclerViewAdapter adapter = new GameCardScrollerRecyclerViewAdapter(MainActivity.cardList);
        cardRecyclerView.setAdapter(adapter);

    }

    private void applyDeveloperTheme() {
        View rootLayout = findViewById(R.id.cardListRoot);
        View header = findViewById(R.id.mainHeader);
        View footer = findViewById(R.id.footer);
        LinearLayout mainFooter = footer.findViewById(R.id.mainFooter);

        Themes.applyDeveloperThemeHeader(this, rootLayout, header);
        Themes.applyDeveloperThemeFooter(this, mainFooter);


    }


}

