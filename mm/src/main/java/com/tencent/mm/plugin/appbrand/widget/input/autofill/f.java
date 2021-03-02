package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public enum f {
    SCREEN,
    VIEW;

    public static f valueOf(String str) {
        AppMethodBeat.i(136671);
        f fVar = (f) Enum.valueOf(f.class, str);
        AppMethodBeat.o(136671);
        return fVar;
    }

    static {
        AppMethodBeat.i(136672);
        AppMethodBeat.o(136672);
    }
}
