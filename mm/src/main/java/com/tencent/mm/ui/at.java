package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.SparseIntArray;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class at {
    private static SparseIntArray csc = new SparseIntArray();
    private static float density = -1.0f;
    private static float scale = 0.0f;

    static {
        AppMethodBeat.i(159132);
        AppMethodBeat.o(159132);
    }

    public static int fromDPToPix(Context context, int i2) {
        AppMethodBeat.i(159125);
        int round = Math.round(getDensity(context) * ((float) i2));
        AppMethodBeat.o(159125);
        return round;
    }

    public static int E(Context context, int i2) {
        AppMethodBeat.i(198197);
        int round = Math.round(((float) i2) / getDensity(context));
        AppMethodBeat.o(198197);
        return round;
    }

    public static int aH(Context context, int i2) {
        int i3 = 0;
        AppMethodBeat.i(159126);
        if (context == null) {
            as.e("WeUIResHelper", "get dimension pixel size, resId %d, but context is null".concat(String.valueOf(i2)), new Object[0]);
            AppMethodBeat.o(159126);
        } else {
            i3 = csc.get(i2, 0);
            if (i3 == 0) {
                i3 = context.getResources().getDimensionPixelSize(i2);
                csc.put(i2, i3);
            }
            AppMethodBeat.o(159126);
        }
        return i3;
    }

    public static float getDensity(Context context) {
        AppMethodBeat.i(159127);
        if (context != null && density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        float f2 = density;
        AppMethodBeat.o(159127);
        return f2;
    }

    public static float ez(Context context) {
        AppMethodBeat.i(159128);
        if (scale == 0.0f) {
            if (context == null) {
                scale = 1.0f;
            } else {
                scale = context.getSharedPreferences("com.tencent.mm_preferences", 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        float f2 = scale;
        AppMethodBeat.o(159128);
        return f2;
    }

    public static Drawable aN(Context context, int i2) {
        AppMethodBeat.i(159129);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i2});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(159129);
        return drawable;
    }

    public static int aO(Context context, int i2) {
        AppMethodBeat.i(159130);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        int i3 = typedValue.data;
        AppMethodBeat.o(159130);
        return i3;
    }

    public static ColorStateList jW(Context context) {
        AppMethodBeat.i(159131);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.p7, typedValue, true);
        ColorStateList m = b.m(context, typedValue.resourceId);
        AppMethodBeat.o(159131);
        return m;
    }
}
