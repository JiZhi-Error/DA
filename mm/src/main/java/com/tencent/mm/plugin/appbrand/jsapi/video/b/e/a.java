package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static void checkArgument(boolean z) {
        AppMethodBeat.i(234832);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(234832);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(234832);
    }

    public static void checkState(boolean z) {
        AppMethodBeat.i(234833);
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(234833);
            throw illegalStateException;
        }
        AppMethodBeat.o(234833);
    }

    public static <T> T checkNotNull(T t) {
        AppMethodBeat.i(234834);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(234834);
            throw nullPointerException;
        }
        AppMethodBeat.o(234834);
        return t;
    }
}
