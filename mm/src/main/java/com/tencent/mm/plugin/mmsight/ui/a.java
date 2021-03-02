package com.tencent.mm.plugin.mmsight.ui;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements TypeEvaluator {
    private static final ArgbEvaluator sInstance = new ArgbEvaluator();

    static {
        AppMethodBeat.i(94501);
        AppMethodBeat.o(94501);
    }

    public static ArgbEvaluator getInstance() {
        return sInstance;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f2, Object obj, Object obj2) {
        AppMethodBeat.i(94500);
        int intValue = ((Integer) obj).intValue();
        float f3 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & 255)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & 255)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & 255)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & 255)) / 255.0f), 2.2d);
        float pow5 = (float) Math.pow((double) (((float) ((intValue2 >> 8) & 255)) / 255.0f), 2.2d);
        int round = Math.round(((float) Math.pow((double) (pow3 + ((((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d)) - pow3) * f2)), 0.45454545454545453d)) * 255.0f);
        Integer valueOf = Integer.valueOf(round | (Math.round((f3 + (((((float) ((intValue2 >> 24) & 255)) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(((float) Math.pow((double) (pow + ((pow4 - pow) * f2)), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(((float) Math.pow((double) (pow2 + ((pow5 - pow2) * f2)), 0.45454545454545453d)) * 255.0f) << 8));
        AppMethodBeat.o(94500);
        return valueOf;
    }
}
