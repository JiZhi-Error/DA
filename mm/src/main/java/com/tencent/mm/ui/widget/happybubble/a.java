package com.tencent.mm.ui.widget.happybubble;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    AROUND,
    UP_AND_DOWN,
    LEFT_AND_RIGHT;

    public static a valueOf(String str) {
        AppMethodBeat.i(143523);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(143523);
        return aVar;
    }

    static {
        AppMethodBeat.i(143524);
        AppMethodBeat.o(143524);
    }
}
