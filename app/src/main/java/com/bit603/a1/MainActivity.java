/**
 * BIT603 Assessment 1

 * Name: Ben Rewi
 * ID: 5124830
 * Created: 22nd March 2026

 * This is the main class. I will add additional description later.
 *

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
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private int devClickCount = 0;
    private int exitClickCount = 0;
    private boolean isDeveloperMode = false;
    public static List<GameCard> cardList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View header = findViewById(R.id.mainHeader);
        View footer = findViewById(R.id.footer);

        TextView appVersionName = footer.findViewById(R.id.appVersionName);
        LinearLayout mainFooter = findViewById(R.id.mainFooter);
        TextView developerModeText = findViewById(R.id.developerModeText);

        View mainLayout = findViewById(R.id.main_layout);
        LinearLayout mainButtons= findViewById(R.id.mainButtons);
        CardView blueHeader = header.findViewById(R.id.blueHeader);

        Button buttonCardList = findViewById(R.id.buttonCardList);
        /*Button buttonCardStatistics = findViewById(R.id.buttonCardStatistics);*/

        TextView title = header.findViewById(R.id.gameTitle);
        TextView gameVersionText = header.findViewById(R.id.gameVersionText);
        TextView developmentWarning = header.findViewById(R.id.developmentWarning);

        title.setText(R.string.card_game_name);
        gameVersionText.setText(R.string.game_version);
        developmentWarning.setText(R.string.development_warning);

        buttonCardList.setOnClickListener(v -> {
            Intent intent = new Intent(this, CardListActivity.class);

            intent.putExtra("IS_DEV_MODE", isDeveloperMode);

            startActivity(intent);
        });

        appVersionName.setOnClickListener(view -> {
            if (!isDeveloperMode) {
                devClickCount++;
                if (devClickCount == 7) {
                    activateDeveloperMode(mainLayout, mainButtons, mainFooter, blueHeader, developerModeText);
                    isDeveloperMode = true;
                    devClickCount = 0;
                    Toast.makeText(this, "Developer Mode Activated", Toast.LENGTH_SHORT).show();

                }
            } else {
                exitClickCount++;
                if (exitClickCount == 7) {
                    recreate();
                    isDeveloperMode = false;
                    exitClickCount = 0;
                    Toast.makeText(this, "Developer Mode Deactivated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void activateDeveloperMode(View mainLayout, LinearLayout buttonGroup, LinearLayout mainFooter, CardView blueHeader, TextView developerModeText) {
        int light_grey = getColor(R.color.light_grey);
        int black = getColor(R.color.black);

        mainLayout.setBackgroundColor(light_grey);
        blueHeader.setCardBackgroundColor(black);
        developerModeText.setText(R.string.developer_mode_text);



        for(int i = 0; i < buttonGroup.getChildCount(); i++){
            View child = buttonGroup.getChildAt(i);
            if (child instanceof Button){
                Button btn = (Button) child;
                btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(black));
            }
        }

        for (int i = 0; i < mainFooter.getChildCount(); i++) {
            View child = mainFooter.getChildAt(i);
            if (child instanceof TextView) {
                TextView tv = (TextView) child;
                tv.setTextColor(black);
            }
        }

    }
}