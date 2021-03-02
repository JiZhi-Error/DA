package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class h {
    private static final Random DAg = new Random();

    static {
        AppMethodBeat.i(202361);
        AppMethodBeat.o(202361);
    }

    public static float al(float f2, float f3) {
        AppMethodBeat.i(202360);
        float min = Math.min(f2, f3);
        float max = min + ((Math.max(f2, f3) - min) * DAg.nextFloat());
        AppMethodBeat.o(202360);
        return max;
    }
}
