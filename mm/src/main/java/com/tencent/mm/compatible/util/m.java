package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m {
    public static <T> T checkNotNull(T t) {
        AppMethodBeat.i(155910);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(155910);
            throw nullPointerException;
        }
        AppMethodBeat.o(155910);
        return t;
    }
}
