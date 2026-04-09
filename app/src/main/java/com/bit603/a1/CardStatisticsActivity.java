package com.bit603.a1;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class CardStatisticsActivity extends AppCompatActivity {

    private boolean isDevMode = false;
    private LinkedHashMap<String, String> statsMap = new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.stats_list);

        isDevMode = getIntent().getBooleanExtra("IS_DEV_MODE", false);

        if (isDevMode) {
            applyDevTheme();
        }

        View header = findViewById(R.id.mainHeader);
        if (header != null) {
            ((TextView) header.findViewById(R.id.gameTitle)).setText(R.string.card_statistics);
            ImageButton btnBack = header.findViewById(R.id.btnBack);
            btnBack.setVisibility(View.VISIBLE);
            btnBack.setOnClickListener(v -> finish());
        }



        generateStats();
        RecyclerView statsRecyclerView = findViewById(R.id.statListRecycler);
        statsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        statsRecyclerView.setAdapter(new StatsRecyclerViewAdapter(statsMap));
    }

    private void generateStats() {
        statsMap.clear();

        statsMap.put("Total Cards: ", String.valueOf(calculateTotalCards()));
        statsMap.put("Highest BP: ", String.valueOf(calculateHighestBP()));
        statsMap.put("Lowest BP: ", String.valueOf(calculateLowestBP()));
        statsMap.putAll(calculateElementStats());


        if (isDevMode) {
            statsMap.put("Total Finished: ", String.valueOf(calculateFinished()));
            statsMap.put("Total Unfinished: ", String.valueOf(calculateUnfinished()));
            statsMap.put("Average BP: ", String.format("%.1f",calculateAverageBP()));
            statsMap.put("Longest Name: ", String.valueOf(calculateLongestName()));
            statsMap.put("Longest Effect: ", String.valueOf(calculateEffectDescription()));

            statsMap.putAll(calculateArtistStats());
        }
    }

    private int calculateTotalCards() {
        int count = 0;
        for (GameCard card : MainActivity.cardList) {
            if (!card.getUnfinished()) count++;
        }
        return count;
    }

    private int calculateHighestBP() {
        int highestBP = 0;
        for (GameCard card : MainActivity.cardList) {
            if (!card.getUnfinished() && card.getBattlePower() > highestBP) {
                highestBP = card.getBattlePower();

            }
        }
        return highestBP;
    }

    private int calculateLowestBP() {
        int lowestBP = Integer.MAX_VALUE;
        for (GameCard card : MainActivity.cardList) {
            if (!card.getUnfinished() && card.getBattlePower() < lowestBP) {
                lowestBP = card.getBattlePower();
            }
        }
        return lowestBP;

    }


    private int calculateFinished() {
        int count = 0;
        for (GameCard card : MainActivity.cardList) {
            if (!card.getUnfinished()) count++;
        }
        return count;
    }

    private int calculateUnfinished() {
        int count = 0;
        for (GameCard card : MainActivity.cardList) {
            if (card.getUnfinished()) {
                count++;
            }
        }
        return count;
    }

    private double calculateAverageBP() {
        int totalBP = 0;
        int count = 0;
        for (GameCard card : MainActivity.cardList) {
            if (!card.getUnfinished()) {
                totalBP += card.getBattlePower();
                count++;
            }
        }
        return (double) totalBP / count;
    }

    private int calculateLongestName() {
        int longestNameLen = 0;
        for (GameCard card : MainActivity.cardList) {
            if (card.getName().length() > longestNameLen) {
                longestNameLen = card.getName().length();
            }
        }
        return longestNameLen;
    }

    private int calculateEffectDescription() {
        int longestDescriptionLength = 0;
        for (GameCard card : MainActivity.cardList) {
            if (!card.getUnfinished() || isDevMode) {
                int currentDescriptionLen = card.getEffectDescription().length();
                if (currentDescriptionLen > longestDescriptionLength) {
                    longestDescriptionLength = currentDescriptionLen;
                }
            }
        }
        return longestDescriptionLength;
    }


    private HashMap<String, String> calculateArtistStats() {
        HashMap<String, Integer> artistCounts = new HashMap<>();
        for (GameCard card : MainActivity.cardList) {
            String artistName = card.getArtistName();
            artistCounts.put(artistName, artistCounts.getOrDefault(artistName, 0) + 1);
        }
        LinkedHashMap<String, String> artistStats = new LinkedHashMap<>();
        for (String artist : artistCounts.keySet()) {
            artistStats.put(artist + " Cards: ", String.valueOf(artistCounts.get(artist)));
        }
        return artistStats;
    }


    private LinkedHashMap<String, String> calculateElementStats() {
        LinkedHashMap<String, String> elementStats = new LinkedHashMap<>();
        String[] elementName = {"Neutral", "Earth", "Wind", "Fire", "Water"};
        for (int i = 0; i <= 4; i++) {
            int count = 0;
            for (GameCard card : MainActivity.cardList) {
                if (card.getElement() == i){
                    if(isDevMode || !card.getUnfinished()){
                        count++;
                    }
                }
            }
            if(count > 0) {
                elementStats.put(elementName[i] + " Cards: ", String.valueOf(count));
            }
        }
        return elementStats;
    }

    private void applyDevTheme() {
        View rootLayout = findViewById(R.id.cardListRoot);
        View header = findViewById(R.id.mainHeader);

        Themes.applyDevThemeHeader(this, rootLayout, header);


    }

}




