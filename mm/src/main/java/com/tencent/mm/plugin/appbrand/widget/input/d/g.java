package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g {
    LEFT,
    RIGHT,
    CENTER;

    public static g valueOf(String str) {
        AppMethodBeat.i(136697);
        g gVar = (g) Enum.valueOf(g.class, str);
        AppMethodBeat.o(136697);
        return gVar;
    }

    static {
        AppMethodBeat.i(136699);
        AppMethodBeat.o(136699);
    }

    public static g agc(String str) {
        AppMethodBeat.i(136698);
        Enum h2 = d.h(str, g.class);
        g gVar = LEFT;
        if (h2 != null) {
            gVar = h2;
        }
        g gVar2 = gVar;
        AppMethodBeat.o(136698);
        return gVar2;
    }
}
