package com.tencent.mm.ui.widget.cedit.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static void checkArgument(boolean z) {
        AppMethodBeat.i(206125);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(206125);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(206125);
    }

    public static void checkArgument(boolean z, Object obj) {
        AppMethodBeat.i(206126);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
            AppMethodBeat.o(206126);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(206126);
    }

    public static <T> T checkNotNull(T t, Object obj) {
        AppMethodBeat.i(206127);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(String.valueOf(obj));
            AppMethodBeat.o(206127);
            throw nullPointerException;
        }
        AppMethodBeat.o(206127);
        return t;
    }

    public static int aL(int i2) {
        AppMethodBeat.i(206128);
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(206128);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(206128);
        return i2;
    }
}
