package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    NORMAL(0),
    BOLD(1);
    
    public final int style;

    public static c valueOf(String str) {
        AppMethodBeat.i(131526);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(131526);
        return cVar;
    }

    static {
        AppMethodBeat.i(131528);
        AppMethodBeat.o(131528);
    }

    private c(int i2) {
        this.style = i2;
    }

    public static c agb(String str) {
        AppMethodBeat.i(131527);
        Enum h2 = d.h(str, c.class);
        c cVar = NORMAL;
        if (h2 != null) {
            cVar = h2;
        }
        c cVar2 = cVar;
        AppMethodBeat.o(131527);
        return cVar2;
    }
}
