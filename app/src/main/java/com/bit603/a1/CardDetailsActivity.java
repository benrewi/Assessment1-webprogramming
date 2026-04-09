package com.bit603.a1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CardDetailsActivity extends AppCompatActivity {
    private boolean isDevMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.card_details);


        isDevMode = getIntent().getBooleanExtra("IS_DEV_MODE", false);

        String cardId = getIntent().getStringExtra("CARD_ID");

        GameCard selectedCard = null;
        for (GameCard card : MainActivity.cardList) {
            if (card.getCardId().equals(cardId)) {
                selectedCard = card;
                break;
            }
        }

        View header = findViewById(R.id.mainHeader);
        if (header != null) {
            ((TextView) header.findViewById(R.id.gameTitle)).setText(R.string.card_details);
            ImageButton btnBack = header.findViewById(R.id.btnBack);
            btnBack.setVisibility(View.VISIBLE);
            btnBack.setOnClickListener(v -> finish());
        }

        if (isDevMode){
            applyDevTheme();
        }

        if (selectedCard != null){
            populateCard(selectedCard);
        }

    }

    private void populateCard(GameCard card){
        TextView playCostText = findViewById(R.id.playCostText);
        playCostText.setText(String.valueOf(card.getPlayCost()));

        TextView battlePowerText = findViewById(R.id.battlePowerText);
        battlePowerText.setText(String.valueOf("BP " + card.getBattlePower()));

        TextView cardEffectText = findViewById(R.id.cardEffectText);
        cardEffectText.setText(card.getEffectDescription());
        TextView cardLevelText = findViewById(R.id.cardLevelText);
        cardLevelText.setText("LVL. "+ String.valueOf(card.getLevel()));
        TextView cardNameText = findViewById(R.id.cardNameText);
        cardNameText.setText(card.getName());
        TextView cardId = findViewById(R.id.cardId);
        cardId.setText("#" + card.getCardId());
        TextView artistText = findViewById(R.id.txtArtist);
        artistText.setText("Artist: " + card.getArtistName());


        TextView elementText= findViewById(R.id.cardElementText);
        elementText.setText(card.getElementName());
        elementText.setTextColor(Color.parseColor(card.getElementColour()));

        ImageView cardImage = findViewById(R.id.cardImage);
        cardImage.setImageResource(card.getCardDetailsImages());

        elementText.setTextColor(Color.parseColor(card.getElementColour()));
        androidx.cardview.widget.CardView gameCardView = findViewById(R.id.gameCardView);
        View cardDetail = findViewById(R.id.cardDetail);


        cardDetail.setBackgroundColor(Color.parseColor(card.getElementColour()));
        gameCardView.setCardBackgroundColor(Color.parseColor(card.getFadedElementColour()));
        getWindow().getDecorView().setBackgroundColor(Color.parseColor(card.getElementColour()));
    }

    private void applyDevTheme(){
        View rootLayout = findViewById(R.id.cardDetail);
        View header = findViewById(R.id.mainHeader);

        Themes.applyDevThemeHeader(this, rootLayout, header);

    }

}
