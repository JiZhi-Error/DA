package com.tencent.mm.ui.c.b;

import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends DecelerateInterpolator {
    public final float getInterpolation(float f2) {
        AppMethodBeat.i(141580);
        if (((double) f2) <= 0.5d) {
            float interpolation = super.getInterpolation(2.0f * f2);
            AppMethodBeat.o(141580);
            return interpolation;
        }
        AppMethodBeat.o(141580);
        return 1.0f;
    }
}
