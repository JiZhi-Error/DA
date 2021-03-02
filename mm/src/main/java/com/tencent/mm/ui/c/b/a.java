package com.tencent.mm.ui.c.b;

import android.view.animation.BounceInterpolator;

public final class a extends BounceInterpolator {
    public final float getInterpolation(float f2) {
        if (((double) f2) < 0.36363636363636365d) {
            return (float) (((double) f2) * 7.5625d * ((double) f2));
        }
        if (((double) f2) < 0.7272727272727273d) {
            float f3 = (float) (((double) f2) - 0.5454545454545454d);
            return (float) ((((double) f3) * ((double) f3) * 7.5625d) + 0.75d);
        }
        float f4 = (float) (((double) f2) - 0.8181818181818182d);
        return (float) ((((double) f4) * ((double) f4) * 7.5625d) + 0.9375d);
    }
}
