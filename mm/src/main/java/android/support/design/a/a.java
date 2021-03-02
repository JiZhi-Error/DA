package android.support.design.a;

import android.animation.TimeInterpolator;
import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public final class a {
    public static final TimeInterpolator gK = new LinearInterpolator();
    public static final TimeInterpolator gL = new b();
    public static final TimeInterpolator gM = new android.support.v4.view.b.a();
    public static final TimeInterpolator gN = new c();
    public static final TimeInterpolator gO = new DecelerateInterpolator();

    public static float lerp(float f2, float f3, float f4) {
        return ((f3 - f2) * f4) + f2;
    }

    public static int b(int i2, int i3, float f2) {
        return Math.round(((float) (i3 - i2)) * f2) + i2;
    }
}
