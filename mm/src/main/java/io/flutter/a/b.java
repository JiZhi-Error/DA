package io.flutter.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static <T> T checkNotNull(T t) {
        AppMethodBeat.i(9592);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(9592);
            throw nullPointerException;
        }
        AppMethodBeat.o(9592);
        return t;
    }
}
