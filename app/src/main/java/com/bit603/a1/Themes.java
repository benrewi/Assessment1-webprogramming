/**
 * BIT603 Assessment 1

 * Name: Ben Rewi
 * ID: 5124830
 * Created: 9th April 2026

 * This is the class that provides static methods to apply the developer mode theme across all of the activities.
 * It modifies the background colour and main heading colours, as also button colours. This helps to provide
 * a consistent experience for developer mode across the app, to help users understand they're in developer mode.

 * @author Ben Rewi
 * @version 1.0
 */



package com.bit603.a1;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.cardview.widget.CardView;

public class Themes {

    public static void applyDevThemeHeader(Context context, View layout, View header) {
        int light_grey = context.getColor(R.color.light_grey);
        int black = context.getColor(R.color.black);
        int white = context.getColor(R.color.white);

        layout.setBackgroundColor(light_grey);
        if (header != null) {

            View blueHeader = header.findViewById(R.id.blueHeader);
            CardView titleCard = header.findViewById(R.id.titleCard);
            TextView gameTitle = header.findViewById(R.id.gameTitle);


            if (blueHeader != null)
                blueHeader.setBackgroundResource(R.drawable.header_background_devmode);
            if (titleCard != null)
                titleCard.setCardBackgroundColor(white);
            if (gameTitle != null)
                gameTitle.setTextColor(black);
        }
    }


            public static void applyDevThemeButtons(Context context, LinearLayout btnGroup){
                int black = context.getColor(R.color.black);

                for (int i = 0; i < btnGroup.getChildCount(); i++) {
                    View child = btnGroup.getChildAt(i);
                    if (child instanceof Button) {
                        Button btn = (Button) child;
                        btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(black));
                    }
                }
            }

            public static void applyDevThemeFooter (Context context, LinearLayout footer){
                int black = context.getColor(R.color.black);
                for (int i = 0; i < footer.getChildCount(); i++) {
                    View child = footer.getChildAt(i);
                    if (child instanceof TextView) {
                        TextView tv = (TextView) child;
                        tv.setTextColor(black);
                    }
                }
                TextView devModeText = footer.findViewById(R.id.devModeText);
                if (devModeText != null) {
                    devModeText.setText(R.string.dev_mode_text);
                    devModeText.setTextColor(black);
                }
            }
        }



