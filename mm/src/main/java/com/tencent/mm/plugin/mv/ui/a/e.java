package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0004"}, hxF = {"toLowerSec", "", "toRoundSec", "toUpperSec", "plugin-mv_release"})
public final class e {
    public static final int Tl(int i2) {
        AppMethodBeat.i(257039);
        int ceil = (int) ((float) Math.ceil((double) (((float) i2) / 1000.0f)));
        AppMethodBeat.o(257039);
        return ceil;
    }

    public static final int Tm(int i2) {
        AppMethodBeat.i(257040);
        int floor = (int) ((float) Math.floor((double) (((float) i2) / 1000.0f)));
        AppMethodBeat.o(257040);
        return floor;
    }

    public static final int Tn(int i2) {
        AppMethodBeat.i(257041);
        int rint = (int) ((float) Math.rint((double) (((float) i2) / 1000.0f)));
        AppMethodBeat.o(257041);
        return rint;
    }
}
