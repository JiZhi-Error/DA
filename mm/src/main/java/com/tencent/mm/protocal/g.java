package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class g {
    public static void gH(int i2, int i3) {
        AppMethodBeat.i(91309);
        if (i2 >= 0) {
            h.INSTANCE.idkeyStat(320, (long) (i2 + i3), 1, true);
        }
        AppMethodBeat.o(91309);
    }
}
