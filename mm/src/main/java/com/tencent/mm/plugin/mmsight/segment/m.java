package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class m {
    public static void QP(int i2) {
        AppMethodBeat.i(107687);
        h.INSTANCE.idkeyStat(440, 165, 1, false);
        if (i2 == 1) {
            h.INSTANCE.idkeyStat(440, 166, 1, false);
            AppMethodBeat.o(107687);
        } else if (i2 == 2) {
            h.INSTANCE.idkeyStat(440, 167, 1, false);
            AppMethodBeat.o(107687);
        } else {
            if (i2 == 3) {
                h.INSTANCE.idkeyStat(440, 168, 1, false);
            }
            AppMethodBeat.o(107687);
        }
    }

    public static void QQ(int i2) {
        AppMethodBeat.i(107688);
        h.INSTANCE.idkeyStat(440, 169, 1, false);
        if (i2 == 1) {
            h.INSTANCE.idkeyStat(440, 170, 1, false);
            AppMethodBeat.o(107688);
        } else if (i2 == 2) {
            h.INSTANCE.idkeyStat(440, 171, 1, false);
            AppMethodBeat.o(107688);
        } else {
            if (i2 == 3) {
                h.INSTANCE.idkeyStat(440, 172, 1, false);
            }
            AppMethodBeat.o(107688);
        }
    }

    public static void at(int i2, long j2) {
        AppMethodBeat.i(107689);
        if (i2 == 1) {
            h.INSTANCE.idkeyStat(440, 150, 1, false);
            h.INSTANCE.idkeyStat(440, 151, j2, false);
            AppMethodBeat.o(107689);
        } else if (i2 == 2) {
            h.INSTANCE.idkeyStat(440, 155, 1, false);
            h.INSTANCE.idkeyStat(440, 156, j2, false);
            AppMethodBeat.o(107689);
        } else {
            if (i2 == 3) {
                h.INSTANCE.idkeyStat(440, 159, 1, false);
                h.INSTANCE.idkeyStat(440, 160, j2, false);
            }
            AppMethodBeat.o(107689);
        }
    }
}
