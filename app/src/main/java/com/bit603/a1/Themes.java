package com.bit603.a1;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.cardview.widget.CardView;

public class Themes {

    public static void applyDeveloperThemeHeader(Context context, View layout, View header) {
        int light_grey = context.getColor(R.color.light_grey);
        int black = context.getColor(R.color.black);
        int white = context.getColor(R.color.white);

        layout.setBackgroundColor(light_grey);
        if (header != null) {

            View mainHeader = header.findViewById(R.id.mainHeader);
            CardView titleCard = header.findViewById(R.id.titleCard);
            TextView gameTitle = header.findViewById(R.id.gameTitle);


            if (mainHeader != null)
                mainHeader.setBackgroundResource(R.drawable.header_background_devmode);
            if (titleCard != null)
                titleCard.setCardBackgroundColor(white);
            if (gameTitle != null)
                gameTitle.setTextColor(black);
        }
    }


            public static void applyDeveloperThemeButtons(Context context, LinearLayout btnGroup){
                int black = context.getColor(R.color.black);

                for (int i = 0; i < btnGroup.getChildCount(); i++) {
                    View child = btnGroup.getChildAt(i);
                    if (child instanceof Button) {
                        Button btn = (Button) child;
                        btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(black));
                    }
                }
            }

            public static void applyDeveloperThemeFooter (Context context, LinearLayout footer){
                int black = context.getColor(R.color.black);
                for (int i = 0; i < footer.getChildCount(); i++) {
                    View child = footer.getChildAt(i);
                    if (child instanceof TextView) {
                        TextView tv = (TextView) child;
                        tv.setTextColor(black);
                    }
                }
                TextView developerModeText = footer.findViewById(R.id.developerModeText);
                if (developerModeText != null) {
                    developerModeText.setText(R.string.developer_mode_text);
                    developerModeText.setTextColor(black);
                }
            }
        }



