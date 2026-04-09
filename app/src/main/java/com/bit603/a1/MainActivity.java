/**
 * BIT603 Assessment 1

 * Name: Ben Rewi
 * ID: 5124830
 * Created: 9th April 2026

 * This is the entry point of the card vault
 *This app is currently in development, and displays game and app version information, authors, and a button to activate developer mode.
 * It provides navigation to the card list and card statistics activities, as well as managing the developer mode.
 * Developer mode is activated by selecting the app version 7 times. The developer mode passes the state to other activities via intent.
 *This also hosts the generation of card data that populates the card list throughout the app
 * @author Ben Rewi
 * @version 1.0
 */

package com.bit603.a1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private int devClickCount = 0;
    private int exitClickCount = 0;
    private boolean isDevMode = false;
    public static List<GameCard> cardList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        generateCardData();

        View header = findViewById(R.id.mainHeader);
        View footer = findViewById(R.id.footer);

        TextView appVersionName = footer.findViewById(R.id.appVersionName);
        LinearLayout mainFooter = footer.findViewById(R.id.mainFooter);
        TextView devModeText = footer.findViewById(R.id.devModeText);

        View mainLayout = findViewById(R.id.main_layout);
        LinearLayout mainButtons= findViewById(R.id.mainButtons);

        Button buttonCardList = findViewById(R.id.buttonCardList);
        Button buttonCardStatistics = findViewById(R.id.buttonCardStatistics);

        TextView title = header.findViewById(R.id.gameTitle);
        TextView gameVersionText = header.findViewById(R.id.gameVersionText);

        title.setText(R.string.card_game_name);
        gameVersionText.setText(R.string.game_version);

        buttonCardList.setOnClickListener(v -> {
            Intent intent = new Intent(this, CardListActivity.class);

            intent.putExtra("IS_DEV_MODE", isDevMode);

            startActivity(intent);
        });

        buttonCardStatistics.setOnClickListener(v -> {
            Intent intent = new Intent(this, CardStatisticsActivity.class);
            intent.putExtra("IS_DEV_MODE", isDevMode);
            startActivity(intent);
        });


        appVersionName.setOnClickListener(view -> {
            if (!isDevMode) {
                devClickCount++;
                if (devClickCount == 7) {
                    activateDevMode(mainLayout, mainButtons, mainFooter, header, devModeText);
                    isDevMode = true;
                    devClickCount = 0;
                    Toast.makeText(this, "Developer Mode Activated", Toast.LENGTH_SHORT).show();

                }
            } else {
                exitClickCount++;
                if (exitClickCount == 7) {
                    recreate();
                    isDevMode = false;
                    exitClickCount = 0;
                    Toast.makeText(this, "Developer Mode Deactivated", Toast.LENGTH_SHORT).show();
                    recreate();
                }
            }
        });


    }

    private void activateDevMode(View mainLayout, LinearLayout buttonGroup, LinearLayout mainFooter, View header, TextView devModeText) {
        Themes.applyDevThemeHeader(this, mainLayout, header);
        Themes.applyDevThemeButtons(this, buttonGroup);
        Themes.applyDevThemeFooter(this, mainFooter);
        devModeText.setText(R.string.dev_mode_text);

    }

    private void generateCardData(){
        cardList = new ArrayList<>();

        String[] ids = getResources().getStringArray(R.array.card_idArray);
        String[] names = getResources().getStringArray(R.array.nameArray);
        String[] effects = getResources().getStringArray(R.array.effectArray);
        String[] levels = getResources().getStringArray(R.array.levelArray);
        String[] battlePowers = getResources().getStringArray(R.array.battlePowerArray);
        String[] playCosts = getResources().getStringArray(R.array.playCostArray);
        String[] elements = getResources().getStringArray(R.array.elementArray);
        String[] artists = getResources().getStringArray(R.array.artistArray);
        String[] unfinished = getResources().getStringArray(R.array.unfinishedArray);
        android.content.res.TypedArray cardDetailsImages = getResources().obtainTypedArray(R.array.cardDetailsImagesArray);



        for (int i = 0; i < ids.length; i++) {
            int currentImageID = cardDetailsImages.getResourceId(i, -1);

            GameCard card = new GameCard(
                ids[i],
                names[i],
                effects[i],
                Integer.parseInt(levels[i]),
                Integer.parseInt(battlePowers[i]),
                Integer.parseInt(playCosts[i]),
                elementNameToInt(elements[i]),
                artists[i],
                Boolean.parseBoolean(unfinished[i]),
                    currentImageID
            );
            cardList.add(card);
        }

    }

    private int elementNameToInt (String elementName){
        switch (elementName){
            case "Earth": return 1;
            case "Wind": return 2;
            case "Fire": return 3;
            case "Water": return 4;
            default: return 0;
        }
    }
}