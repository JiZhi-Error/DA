package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ar {
    public static int fj(int i2, int i3) {
        AppMethodBeat.i(159112);
        if (i3 < 0 || i3 > 100) {
            as.e("alphaColor", "alpha must be between 0 and 100", new Object[0]);
            AppMethodBeat.o(159112);
            return i2;
        }
        int i4 = (16777215 & i2) | (((int) ((((double) i3) * 0.01d) * 255.0d)) << 24);
        AppMethodBeat.o(159112);
        return i4;
    }

    public static int v(int i2, int i3) {
        AppMethodBeat.i(159113);
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int kQ = kQ(alpha2, alpha);
        int argb = Color.argb(kQ, c(Color.red(i2), alpha2, Color.red(i3), alpha, kQ), c(Color.green(i2), alpha2, Color.green(i3), alpha, kQ), c(Color.blue(i2), alpha2, Color.blue(i3), alpha, kQ));
        AppMethodBeat.o(159113);
        return argb;
    }

    public static Drawable m(Context context, int i2, int i3) {
        AppMethodBeat.i(159114);
        Drawable drawable = context.getResources().getDrawable(i2);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
        }
        AppMethodBeat.o(159114);
        return drawable;
    }

    public static Drawable e(Drawable drawable, int i2) {
        AppMethodBeat.i(159115);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_ATOP));
        }
        AppMethodBeat.o(159115);
        return drawable;
    }

    public static Drawable c(Drawable drawable, ColorStateList colorStateList) {
        AppMethodBeat.i(159116);
        if (drawable == null) {
            AppMethodBeat.o(159116);
            return null;
        }
        Drawable i2 = a.i(drawable);
        a.a(i2, colorStateList);
        AppMethodBeat.o(159116);
        return i2;
    }

    public static boolean aln(int i2) {
        AppMethodBeat.i(159117);
        if (1.0d - ((((0.299d * ((double) Color.red(i2))) + (0.587d * ((double) Color.green(i2)))) + (0.114d * ((double) Color.blue(i2)))) / 255.0d) >= 0.3d) {
            AppMethodBeat.o(159117);
            return true;
        }
        AppMethodBeat.o(159117);
        return false;
    }

    private static int kQ(int i2, int i3) {
        return 255 - (((255 - i3) * (255 - i2)) / 255);
    }

    private static int c(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((i2 * 255) * i3) + ((i4 * i5) * (255 - i3))) / (i6 * 255);
    }
}
