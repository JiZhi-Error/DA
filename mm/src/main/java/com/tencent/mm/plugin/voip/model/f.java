package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f {
    private char[] GTS = new char[50];
    private int pos;

    public f() {
        AppMethodBeat.i(114845);
        AppMethodBeat.o(114845);
    }

    public final String toString() {
        AppMethodBeat.i(114846);
        String str = new String(this.GTS, 0, this.pos);
        AppMethodBeat.o(114846);
        return str;
    }
}
