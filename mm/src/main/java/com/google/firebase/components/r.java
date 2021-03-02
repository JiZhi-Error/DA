package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r {
    public static void b(boolean z, String str) {
        AppMethodBeat.i(4098);
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException(str);
            AppMethodBeat.o(4098);
            throw illegalStateException;
        }
        AppMethodBeat.o(4098);
    }

    public static <T> T zza(T t, String str) {
        AppMethodBeat.i(4097);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            AppMethodBeat.o(4097);
            throw nullPointerException;
        }
        AppMethodBeat.o(4097);
        return t;
    }
}
