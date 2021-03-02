package com.tencent.mm.plugin.multitalk.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o {
    Init,
    Inviting,
    Creating,
    Starting,
    Talking;

    public static o valueOf(String str) {
        AppMethodBeat.i(114732);
        o oVar = (o) Enum.valueOf(o.class, str);
        AppMethodBeat.o(114732);
        return oVar;
    }

    static {
        AppMethodBeat.i(114733);
        AppMethodBeat.o(114733);
    }
}
