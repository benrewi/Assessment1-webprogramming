package com.bit603.a1;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

public class Themes {

    public static void applyDeveloperTheme(Context context, View layout, LinearLayout btnGroup, CardView header) {
        int light_grey = context.getColor(R.color.light_grey);
        int black = context.getColor(R.color.black);
        int white = context.getColor(R.color.white);

        layout.setBackgroundColor(light_grey);
        if (header != null) {
            for (int i = 0; i < btnGroup.getChildCount(); i++) {
                View child = btnGroup.getChildAt(i);
                if (child instanceof Button) {
                    Button btn = (Button) child;
                    btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(black));
                }
            }
        }
    }
}
