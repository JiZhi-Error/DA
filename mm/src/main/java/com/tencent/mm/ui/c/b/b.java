package com.tencent.mm.ui.c.b;

import android.view.animation.CycleInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends CycleInterpolator {
    public b() {
        super(0.5f);
    }

    public final float getInterpolation(float f2) {
        AppMethodBeat.i(141579);
        float pow = (float) (1.0d - Math.pow((double) ((2.0f * f2) - 1.0f), 2.0d));
        AppMethodBeat.o(141579);
        return pow;
    }
}
