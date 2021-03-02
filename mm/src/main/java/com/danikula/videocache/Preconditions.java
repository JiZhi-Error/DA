package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Preconditions {
    public static <T> T checkNotNull(T t) {
        AppMethodBeat.i(183600);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(183600);
            throw nullPointerException;
        }
        AppMethodBeat.o(183600);
        return t;
    }

    public static void checkAllNotNull(Object... objArr) {
        AppMethodBeat.i(223184);
        for (Object obj : objArr) {
            if (obj == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.o(223184);
                throw nullPointerException;
            }
        }
        AppMethodBeat.o(223184);
    }

    public static <T> T checkNotNull(T t, String str) {
        AppMethodBeat.i(223185);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            AppMethodBeat.o(223185);
            throw nullPointerException;
        }
        AppMethodBeat.o(223185);
        return t;
    }

    static void checkArgument(boolean z) {
        AppMethodBeat.i(223186);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(223186);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(223186);
    }

    static void checkArgument(boolean z, String str) {
        AppMethodBeat.i(183601);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
            AppMethodBeat.o(183601);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(183601);
    }
}
