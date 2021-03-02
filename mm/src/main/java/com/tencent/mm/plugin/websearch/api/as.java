package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.xwalk.core.XWalkEnvironment;

public final class as {
    public static int zE(int i2) {
        AppMethodBeat.i(161715);
        if (XWalkEnvironment.getUsingCustomContext()) {
            int round = Math.round(a.getDensity(MMApplicationContext.getContext()) * ((float) i2));
            AppMethodBeat.o(161715);
            return round;
        }
        int round2 = Math.round(com.tencent.mm.cc.a.gvp() * ((float) i2));
        AppMethodBeat.o(161715);
        return round2;
    }
}
